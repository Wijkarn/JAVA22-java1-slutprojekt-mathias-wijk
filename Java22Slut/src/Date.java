import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Date {
    private String weekDay[] = new String[7];
    private LocalDate date;

    Date(LocalDate date) {
        this.date = date;
        weekDay[0] = "Monday";
        weekDay[1] = "Tuesday";
        weekDay[2] = "Wednesday";
        weekDay[3] = "Thursday";
        weekDay[4] = "Friday";
        weekDay[5] = "Saturday";
        weekDay[6] = "Sunday";
    }
    public String printDate(int day) {

        TemporalField field = WeekFields.of(Locale.FRANCE).dayOfWeek();
        LocalDate dayOfWeek = this.date.with(field,day+1);
        String product = dayOfWeek.toString() + " " + weekDay[day] ;

        return product;
    }

    public String checkDate(int day) {
        TemporalField field = WeekFields.of(Locale.FRANCE).dayOfWeek();
        LocalDate weekday = this.date.with(field,day+1);
        String product = weekday.toString();

        return product;
    }

    public String dateToday() {
        String product = date.toString();
        return product;
    }
}