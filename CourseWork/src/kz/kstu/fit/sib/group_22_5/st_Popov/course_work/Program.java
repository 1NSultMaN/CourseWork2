package kz.kstu.fit.sib.group_22_5.st_Popov.course_work;

import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.actions.DemoClass;
import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities.*;
import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.factory.Factory;
import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.help.*;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Создаем отель
        //Hotel hotel = Factory.createHotel();
        String clientsFilePath = "src/main/resources/clients.txt";
        Hotel hotel = Factory.createHotel(clientsFilePath);
        // Создаем экземпляр Reporter
        Reporter reporter = new Reporter();
        // Создаем администратора
        Admin admin = new Admin("Admin");

        // Вызываем методы для выполнения операций
        admin.cloneAndModifyRoom(hotel, reporter);
        Room.sortByPrice(hotel.getRooms());
        reporter.report(hotel);
        //admin.processBookings(hotel, reporter);
        admin.processBookingsFromFile(hotel, reporter); // Используем новый метод
        // Демонстрация сериализации и десериализации
        DemoClass.demoSerialization("demo.bin", reporter);
        // Выполняем поиск клиента
        admin.searchClient(hotel.getClients());
    }
}
