import com.MyCalendar.CalendarNavigationView;

import java.awt.*;

public class Calendar {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               new CalendarNavigationView();
            }
        });
    }
}
