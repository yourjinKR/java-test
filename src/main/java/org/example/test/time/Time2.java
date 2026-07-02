package org.example.test.time;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Time2 {

}

class LocalDateEx {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 12, 15);
        LocalDate now = LocalDate.now();

        int year = date.getYear();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        System.out.println(dayOfWeek); // MONDAY
    }
}

class LocalTimeEx {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(14, 30);
        LocalTime now = LocalTime.now();

        int hour = time.getHour();
        System.out.println(hour); // 14
    }
}

class LocalDateTimeEx {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2025, 12, 15, 9, 0);
        LocalDateTime now = LocalDateTime.now();

        System.out.println(dateTime); // 2025-12-15T09:00
    }
}

class ZonedDateTimeEx {
    public static void main(String[] args) {
        ZonedDateTime seoulTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));

        System.out.println(seoulTime); // 2025-12-15T09:26:49.688150500+09:00[Asia/Seoul]
    }
}

class InstantEx {
    public static void main(String[] args) {
        Instant now = Instant.now();
        long epochSecond = now.getEpochSecond();

        System.out.println(now); // 2025-12-15T00:40:24.064130800Z
    }
}

class PeriodEx {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2025, 1, 1);
        LocalDate end = LocalDate.of(2025, 12, 31);

        Period period = Period.between(start, end);
        int days = period.getDays();

        System.out.println(days); // 30
    }
}

class DurationEx {
    public static void main(String[] args) {
        LocalTime t1 = LocalTime.of(10, 0);
        LocalTime t2 = LocalTime.of(12, 30);

        Duration duration = Duration.between(t1, t2);
        long minutes = duration.toMinutes();

        System.out.println(minutes); // 150
    }
}

class DateFormatEx {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String formatted = LocalDateTime.now().format(formatter);
        LocalDateTime parsed = LocalDateTime.parse("2025-12-15 09:00", formatter);

        System.out.println(formatted); // 2025-12-15 10:00
        System.out.println(parsed); // 2025-12-15T09:00
    }
}

