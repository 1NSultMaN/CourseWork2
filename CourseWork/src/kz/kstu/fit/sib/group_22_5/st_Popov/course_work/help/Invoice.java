package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.help;

import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities.*;

import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Invoice {
    private Booking booking;
    private double amount;

    public Invoice() {
    }

    public Invoice(Booking booking) {
        this.booking = booking;
        this.amount = calculateAmount();
    }

    public double calculateAmount() {
        long days = ChronoUnit.DAYS.between(this.booking.getStartDate(), this.booking.getEndDate());
        Room room = this.booking.getRoom();
        double basePrice = getBasePrice(room, days);

        if (room.getType() == RoomType.STANDARD) {
            return basePrice;
        } else if (room.getType() == RoomType.DELUXE) {
            // Допустим, для DeluxeRoom есть дополнительная плата за услуги
            double serviceCharge = 50.0;
            return basePrice + (serviceCharge * days);
        } else if (room.getType() == RoomType.SUITE) {
            // Допустим, для SuiteRoom есть дополнительная плата за премиум-услуги
            double premiumServiceCharge = 100.0;
            return basePrice + (premiumServiceCharge * days);
        } else {
            // Для всех остальных типов комнат просто умножаем цену на количество дней
            return basePrice;
        }
    }

    private double getBasePrice(Room room, long days) {
        double basePrice = room.getPrice() * days;

        // Добавляем скидку для длительного пребывания
        if (days > 14) {
            basePrice *= 0.85; // Скидка 15%
        }
       else if (days > 7) {
            basePrice *= 0.9; // Скидка 10%
        }

        // Добавляем скидку в зависимости от времени года
        Month month = this.booking.getStartDate().getMonth();
        if (month == Month.DECEMBER || month == Month.JANUARY || month == Month.FEBRUARY) {
            basePrice *= 0.8; // Зимняя скидка 20%
        } else if (month == Month.JUNE || month == Month.JULY || month == Month.AUGUST) {
            basePrice *= 1.2; // Летняя наценка 20%
        }
        return basePrice;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public double getAmount() {
        return this.amount;
    }
}

