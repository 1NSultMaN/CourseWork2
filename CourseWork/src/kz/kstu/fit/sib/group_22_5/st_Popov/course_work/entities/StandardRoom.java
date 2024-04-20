package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities;

import java.util.Objects;

public class StandardRoom extends Room {
    private boolean hasTelevision;
    private String view;

    public StandardRoom(int number, RoomType type, int numberOfBeds) {
        super(number, type, numberOfBeds);
    }

    public StandardRoom(int number, RoomType type, int numberOfBeds, boolean hasTelevision, String view) {
        super(number, type, numberOfBeds);
        this.hasTelevision = hasTelevision;
        this.view = view;
    }

    public boolean hasTelevision() {
        return hasTelevision;
    }

    public String getView() {
        return view;
    }

    @Override
    public String toString() {
        return super.toString() + ", has television: " + hasTelevision + ", view: " + view;
    }

    @Override
    public StandardRoom clone() {
        try {
            return (StandardRoom) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Не должно случиться
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardRoom)) return false;
        if (!super.equals(o)) return false;
        StandardRoom that = (StandardRoom) o;
        return hasTelevision == that.hasTelevision &&
                Objects.equals(view, that.view);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasTelevision, view);
    }
}
