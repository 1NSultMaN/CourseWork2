package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.help;

import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.actions.Searchable;
import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities.*;
import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin implements Searchable {
    private String name;
    private List<Client> clients;

    public Admin(String name) {
        this.name = name;
        this.clients = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public Admin() {
    }

    public void processRequest(Hotel hotel, Booking booking) {
        for (Room room : hotel.getRooms()) {
            if (room.getType().equals(booking.getRoom().getType()) && room.getNumberOfBeds() == booking.getRoom().getNumberOfBeds()) {
                hotel.getBookings().add(booking);
                System.out.println("Booking successfully created for date: " + booking.getStartDate());
                return;
            }
        }
        System.out.println("Sorry, there are no rooms available that match your requirements.");
    }

    public void cloneAndModifyRoom(Hotel hotel, Reporter reporter) {
        // Получаем первую комнату в отеле
        Room originalRoom = hotel.getRooms().get(0);
        SuiteRoom suite = null;

        try {
            // Создаем копию комнаты
            Room clonedRoom = originalRoom.clone();

            // Выводим информацию об оригинальной комнате
            reporter.report("Original room: " + originalRoom);

            // Выводим информацию о клонированной комнате
            reporter.report("Cloned room: " + clonedRoom);

            // Если клонированная комната является SuiteRoom, меняем ее тип на Deluxe
            if (clonedRoom instanceof SuiteRoom) {
                suite = (SuiteRoom) clonedRoom;
                suite.setType(RoomType.DELUXE); // Изменяем тип комнаты
            }
        } catch (CloneNotSupportedException e) {
            reporter.report("Failed to clone the room: " + e.getMessage());
        }

        // Выводим информацию о комнате после изменения
        if (suite != null) {
            reporter.report("Modified room (changed type from Suite to Deluxe): " + suite);
        }

        // Добавляем клонированную комнату в список комнат отеля
        hotel.addRoom(suite);
    }

    public Invoice createInvoice(Booking booking) {
        return new Invoice(booking);
    }

    public void processBookings(Hotel hotel, Reporter reporter) {
        // Создаем клиентов и добавляем их в отель
        for (int i = 0; i < 10; i++) {
            Client client = Factory.createRandomClient();
            hotel.addClient(client);

            // Клиент создает заявку на бронирование
            Booking booking = null;
            try {
                booking = client.createBooking(hotel, null, i, null, null, true);
            } catch (RoomNotAvailableException e) {
                System.out.println(e.getMessage());
            }

            if (booking != null) {
                // Администратор обрабатывает запрос на бронирование
                processRequest(hotel, booking);

                // Администратор создает счет для бронирования
                Invoice invoice = createInvoice(booking);

                // Выводим информацию о счете, клиенте, который сделал бронирование, и детали бронирования
                reporter.report(invoice);
                reporter.report(client);
                reporter.report(booking);
            }
        }
    }

    public void processBookingsFromFile(Hotel hotel, Reporter reporter) {
        // Используем клиентов, которые были прочитаны из файла при создании отеля
        for (Client client : hotel.getClients()) {
            // Клиент создает заявку на бронирование
            Booking booking = null;
            try {
                booking = client.createBooking(hotel, null, 0, null, null, true);
            } catch (RoomNotAvailableException e) {
                System.out.println(e.getMessage());
            }

            if (booking != null) {
                // Администратор обрабатывает запрос на бронирование
                processRequest(hotel, booking);

                // Администратор создает счет для бронирования
                Invoice invoice = createInvoice(booking);

                // Выводим информацию о счете, клиенте, который сделал бронирование, и детали бронирования
                reporter.report(invoice);
                reporter.report(client);
                reporter.report(booking);
            }
        }
    }

    public void searchClient(List<Client> clients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the client: ");
        String clientName = scanner.nextLine();
        boolean found = search(clientName, clients);
        System.out.println("Is " + clientName + " in the hotel? " + (found ? "Yes" : "No"));
    }
    @Override
    public boolean search(String clientName, List<Client> clients) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(clientName)) {
                return true;
            }
        }
        return false;
    }


}
