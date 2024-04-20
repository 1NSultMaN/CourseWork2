package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public  class Room implements Cloneable, Comparable<Room> {
    private int number;
    private RoomType type;
    private double price;
    private int numberOfBeds;

    public Room() {
    }

    public Room(int number, RoomType type, int numberOfBeds) {
        this.number = number;
        this.type = type;
        this.price = type.getPrice();
        this.numberOfBeds = numberOfBeds;
    }

    public static void sortByNumber(List<Room> rooms) {
        Collections.sort(rooms);
    }

    public void setType(RoomType type) {
        if (type == RoomType.STANDARD || type == RoomType.DELUXE || type == RoomType.SUITE) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid room type");
        }
    }

    public static void sortByPrice(List<Room> rooms) {
        Collections.sort(rooms, new Room.PriceComparator());
    }
    public int getNumber() {
        return this.number;
    }

    public RoomType getType() {
        return this.type;
    }

    public double getPrice() {
        return this.price;
    }

    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return number == room.number &&
                Double.compare(room.price, price) == 0 &&
                numberOfBeds == room.numberOfBeds &&
                Objects.equals(type, room.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type, price, numberOfBeds);
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    @Override
    public Room clone() throws CloneNotSupportedException {
        try {
            return (Room) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneNotSupportedException("This room cannot be cloned.");
        }
    }

    @Override
    public int compareTo(Room other) {
        return Integer.compare(this.number, other.number);
    }

    public static class PriceComparator implements Comparator<Room> {
        @Override
        public int compare(Room room1, Room room2) {
            return Double.compare(room1.price, room2.price);
        }
    }
}
