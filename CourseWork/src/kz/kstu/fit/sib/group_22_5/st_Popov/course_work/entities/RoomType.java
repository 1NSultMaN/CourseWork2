package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities;

public enum RoomType {
    SUITE("Suite", 300.0, 3),
    DELUXE("Deluxe", 200.0, 2),
    STANDARD("Standard", 100.0, 1);

    private String name;
    private double price;
    private int numberOfBeds;

    RoomType(String name, double price, int numberOfBeds) {
        this.name = name;
        this.price = price;
        this.numberOfBeds = numberOfBeds;
    }

    RoomType() {
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }
}
