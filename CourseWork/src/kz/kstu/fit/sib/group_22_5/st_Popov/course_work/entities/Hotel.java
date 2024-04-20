package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities;

import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.actions.Searchable;
import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.help.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Hotel  {
    private String name;
    private List<Room> rooms;
    private List<Booking> bookings;
    private List<Client> clients;

    public Hotel() {
    }

    public Hotel(String name, List<Room> rooms, List<Client> clients) {
        this.name = name;
        this.rooms = rooms;
        this.bookings = new ArrayList<>();
        this.clients = clients;
    }

    public String getName() {
        return this.name;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public List<Client> getClients() {
        return this.clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }
    public Room findRoom(String roomType, int numberOfBeds) {
        for (Room room : rooms) {
            if (room.getType().getName().equals(roomType) && room.getNumberOfBeds() == numberOfBeds) {
                return room;
            }
        }
        return null;
    }

}
