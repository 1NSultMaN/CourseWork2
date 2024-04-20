    package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.factory;

    import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities.*;

    import java.io.IOException;
    import java.nio.file.*;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Random;
    import java.util.stream.Stream;

    public class Factory {
        private static final Random RANDOM = new Random();
        private static final List<String> NAMES = Arrays.asList("Sasha", "Dasha", "Pasha", "Jonny", "Andrey", "Ali", "Garik", "Emma", "Liam", "Olivia", "Noah", "Ava", "Isabella", "Sophia", "Mia", "Charlotte", "Amelia");

        //Создаем клиентов
        public static Client createRandomClient() {
            String name = NAMES.get(RANDOM.nextInt(NAMES.size()));
            int age = 18 + RANDOM.nextInt(50); // Генерируем случайный возраст от 18 до 67
            String phoneNumber = generateRandomPhoneNumber();

            return new Client(name, age, phoneNumber);
        }

        private static String generateRandomPhoneNumber() {
            StringBuilder sb = new StringBuilder();

            // Генерируем 10-значный номер телефона
            for (int i = 0; i < 10; i++) {
                sb.append(RANDOM.nextInt(10));
            }

            return sb.toString();
        }

        //Создаем гостиницу рандомно
         public static Hotel createHotel() {
            List<Room> rooms = new ArrayList<>();

            for(int i = 1; i <= 10; ++i) {
                Room room;
                if (i < 3) {
                    room = new SuiteRoom(i, RoomType.SUITE, 3, true, true, "Sea view", true, true);
                }
                else if (i < 6) {
                    room = new DeluxeRoom(i, RoomType.DELUXE, 2, true, true, "Garden view");
                } else {
                    room = new StandardRoom(i, RoomType.STANDARD, 1, true, "Street view");
                }

                rooms.add(room);
            }

            List<Client> clients = new ArrayList<>();

            return new Hotel("Paradise", rooms, clients);
        }

        // Метод, который читает данные клиентов из файла
        public static Hotel createHotel(String clientsFilePath) {
            List<Room> rooms = new ArrayList<>();

            for(int i = 1; i <= 10; ++i) {
                Room room;
                if (i < 3) {
                    room = new SuiteRoom(i, RoomType.SUITE, 3, true, true, "Sea view", true, true);
                }
                else if (i < 6) {
                    room = new DeluxeRoom(i, RoomType.DELUXE, 2, true, true, "Garden view");
                } else {
                    room = new StandardRoom(i, RoomType.STANDARD, 1, true, "Street view");
                }

                rooms.add(room);
            }

            List<Client> clients = new ArrayList<>();

            // Читаем данные из файла
            Path path = Paths.get(clientsFilePath);
            try (Stream<String> lines = Files.lines(path)) {
                lines.forEach(line -> {
                    String[] parts = line.split(","); // Разделяем строку по запятой
                    if (parts.length >= 3) {
                        String name = parts[0].trim();
                        int age = Integer.parseInt(parts[1].trim());
                        String phoneNumber = parts[2].trim();
                        clients.add(new Client(name, age, phoneNumber));
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new Hotel("Paradise", rooms, clients);
        }
    }

