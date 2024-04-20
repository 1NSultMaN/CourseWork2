    package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities;

    import java.util.Objects;

    public class DeluxeRoom extends StandardRoom {
        private boolean hasAirConditioning;

        public DeluxeRoom(int number, RoomType type, int numberOfBeds, boolean hasTelevision, String view) {
            super(number, type, numberOfBeds, hasTelevision, view);
        }

        public DeluxeRoom(int number, RoomType type, int numberOfBeds, boolean hasAirConditioning, boolean hasTelevision, String view) {
            super(number, type, numberOfBeds, hasTelevision, view);
            this.hasAirConditioning = hasAirConditioning;
        }

        public boolean hasAirConditioning() {
            return hasAirConditioning;
        }

        @Override
        public String toString() {
            return super.toString() + ", has air conditioning: " + hasAirConditioning;
        }
        @Override
        public DeluxeRoom clone() {
            return (DeluxeRoom) super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DeluxeRoom)) return false;
            if (!super.equals(o)) return false;
            DeluxeRoom that = (DeluxeRoom) o;
            return hasAirConditioning == that.hasAirConditioning;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), hasAirConditioning);
        }

    }