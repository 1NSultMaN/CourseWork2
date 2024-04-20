package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.help;

import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities.Client;
import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities.Room;
import java.time.LocalDate;

public class Booking {
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private Client client;
    private String status;

    public Booking(Room room, LocalDate startDate, LocalDate endDate, Client client) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.status = "Pending";
    }

    public Booking() {
    }

    public Room getRoom() {
        return this.room;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public Client getClient() {
        return this.client;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
