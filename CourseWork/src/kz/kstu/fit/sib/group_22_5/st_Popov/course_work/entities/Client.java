package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities;

import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.help.Booking;
import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.help.RoomNotAvailableException;

import java.util.Random;
import java.time.LocalDate;

public class Client {
    private String name;
    private int age;
    private String phoneNumber;

    public Client(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Client() {
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Booking createBooking(Hotel hotel, String roomType, int numberOfBeds, LocalDate startDate, LocalDate endDate, boolean isRandom) throws RoomNotAvailableException {
        if (isRandom) {
            roomType = (numberOfBeds % 3 == 0) ? "Suite" : (numberOfBeds % 3 == 1) ? "Deluxe" : "Standard";
            numberOfBeds = (numberOfBeds % 3 == 0) ? 3 : (numberOfBeds % 3 == 1) ? 2 : 1;

            // Генерируем случайную дату в пределах следующих 1-3 месяцев
            long minDay = LocalDate.now().plusMonths(1).toEpochDay();
            long maxDay = LocalDate.now().plusMonths(3).toEpochDay();
            long randomDay = minDay + new Random().nextLong(maxDay - minDay);
            startDate = LocalDate.ofEpochDay(randomDay);
            endDate = startDate.plusDays(new Random().nextInt(10) + 6);
        }
        Room room = hotel.findRoom(roomType, numberOfBeds); // Ищем подходящую комнату в отеле
        if (room != null) {
            // Проверяем, свободна ли комната
            for (Booking booking : hotel.getBookings()) {
                if (booking.getRoom().equals(room) && (booking.getStartDate().isBefore(endDate) && booking.getEndDate().isAfter(startDate))) {
                    throw new RoomNotAvailableException("The room is not available for the selected dates.");
                }
            }
            return new Booking(room, startDate, endDate, this); // Если комната найдена, создаем новый объект Booking и возвращаем его
        } else {
            throw new RoomNotAvailableException("No rooms available that match your requirements.");
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

