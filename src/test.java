import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String stringDate = "8/8/2022";
        LocalDate date1 = LocalDate.of(2022, 8, 8);
        LocalDate date2 = LocalDate.of(2022, 8, 10);

        ArrayList<Flight> flights;
        ArrayList<Room> rooms;

        Reservation res = new Ticket(flights.get(0), "Evan", "Scales",
        rooms.get(0), "1A", "7:00 AM", "37B", "Evan Scales",
        0);
    }
}