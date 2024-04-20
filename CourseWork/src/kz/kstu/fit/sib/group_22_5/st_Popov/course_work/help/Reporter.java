package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.help;

import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities.Client;
import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities.Hotel;
import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities.Room;

import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Reporter {

    public void report(Hotel hotel) {
        report("Hotel Name: " + hotel.getName());
        report("Rooms:");
        for (Room room : hotel.getRooms()) {
            report(room);
        }

        // Используем Reporter для вывода информации о клиентах
        report("Clients:");
        for (Client client : hotel.getClients()) {
            report(client);
        }
    }

        public void report(String info) {
            System.out.println(info);
        }

        public void report(Room room) {
            System.out.println(room);
        }

        public void report(Client client) {
            System.out.println(client);
        }

        public void report(Booking booking) {
            System.out.println("Booking duration: " + ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate()) + " days");
        }

    public void report(Invoice invoice) {
        System.out.println("Invoice for booking: " + invoice.getAmount());
        boolean isPaid = new Random().nextBoolean();
        System.out.println("Is the invoice paid? " + (isPaid ? "Yes" : "No"));
    }
}

