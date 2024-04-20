package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities;

import java.util.Objects;

public class SuiteRoom extends DeluxeRoom {
    private boolean hasBalcony;
    private boolean hasMiniBar;

    public SuiteRoom(int number, RoomType type, int numberOfBeds, boolean hasAirConditioning, boolean hasTelevision, String view) {
        super(number, type, numberOfBeds, hasAirConditioning, hasTelevision, view);
    }

    public SuiteRoom(int number, RoomType type, int numberOfBeds, boolean hasAirConditioning, boolean hasTelevision, String view, boolean hasBalcony, boolean hasMiniBar) {
        super(number, type, numberOfBeds, hasAirConditioning, hasTelevision, view);
        this.hasBalcony = hasBalcony;
        this.hasMiniBar = hasMiniBar;
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }

    public boolean hasMiniBar() {
        return hasMiniBar;
    }

    @Override
    public String toString() {
        return super.toString() + ", has balcony: " + hasBalcony + ", has mini bar: " + hasMiniBar;
    }

    @Override
    public SuiteRoom clone() {
        return (SuiteRoom) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuiteRoom)) return false;
        if (!super.equals(o)) return false;
        SuiteRoom that = (SuiteRoom) o;
        return hasBalcony == that.hasBalcony &&
                hasMiniBar == that.hasMiniBar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasBalcony, hasMiniBar);
    }

}
