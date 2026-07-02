package org.example.test.time;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Time {
    public static void main(String[] args) {

        // 일단 Date와 Calendar은 잘 사용하지 않음

        /*
        1. Date (JDK 1)
        포맷팅을 위해 java.text.SimpleDateFormat를 사용함
        대부분의 메소드가 Deprecated
         */
        Date date = new Date();
        System.out.println("date.getTime() : " + date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("date.getTime() formatted by SimpleDateFormat : " + sdf.format(date));

        System.out.println("==============================================================================");

        /*
        2. Calendar (JDK 1.1)
        Date의 한계점을 보완한 버전
        Calendar클래스는 인터페이스로 정의된 추상클래스이다.
        인스턴스를 생성하려면 Calendar가 가지고 있는 클래스 메소드 getInstnace()를 사용
         */
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar.getTime() :  " + calendar.getTime());
        System.out.println("calendar.get(Calendar.YEAR) : " + calendar.get(Calendar.YEAR));
        System.out.println("calendar.get(Calendar.MONTH) : " + calendar.get(Calendar.MONTH )); // 월은 0부터 시작함... 도대체 왜...
        System.out.println("calendar.get(Calendar.DAY_OF_MONTH) : " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("calendar.get(Calendar.HOUR) : " + calendar.get(Calendar.HOUR));
        System.out.println("calendar.get(Calendar.MINUTE) : " + calendar.get(Calendar.MINUTE));
        System.out.println("calendar.get(Calendar.SECOND) : " + calendar.get(Calendar.SECOND));
        System.out.println("calendar.get(Calendar.MILLISECOND) : " + calendar.get(Calendar.MILLISECOND));

        System.out.println("==============================================================================");

        // java.time 패키지

        /*
        LocalDate
        생년월일, 특정 기념일 등 시간 정보가 필요 없을 때 사용
         */
        LocalDate curDate = LocalDate.now(); // 2020-08-30
        System.out.println("localDate : " + curDate);

        LocalDate targetDate = LocalDate.of(2020, 8, 30); // 2020-08-30
        System.out.println("targetDate.getYear() : " + targetDate.getYear());
        System.out.println("targetDate.getMonth() : " + targetDate.getMonth());
        System.out.println("targetDate.getDayOfYear() : " + targetDate.getDayOfYear());
        System.out.println("targetDate.getDayOfMonth() : " + targetDate.getDayOfMonth());
        System.out.println("targetDate.getDayOfWeek() : " + targetDate.getDayOfWeek());

        System.out.println("==============================================================================");

        /*
        LocalTime
        알람 시간, 영업 시작/종료 시간 등 날짜 정보가 필요 없을 때 사용
         */
        LocalTime  localTime = LocalTime.now();
        System.out.println("localTime : " + localTime);

        System.out.println("==============================================================================");

        /*
        LocalDateTime
        날짜와 시간을 모두 가짐
        주의점: 시간대(Timezone) 정보가 없음
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime : " + localDateTime);

        LocalDateTime birth = LocalDateTime.of(2000, 3, 20, 0, 0);
        System.out.println("현재 나이 : " + ChronoUnit.YEARS.between(birth, localDateTime));


        System.out.println("==============================================================================");

        /*
        ZonedDateTime
        LocalDateTime에 시간대(Time Zone) 정보가 포함된 클래스
         */
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime : " + zonedDateTime);

        System.out.println("===============================================================================");

        /*
        OffsetDateTime
        LocalDateTime에 UTC와의 시차(Offset) 정보가 포함된 클래스입니다.
         */
        OffsetDateTime offsetDateTime =  OffsetDateTime.now();
        System.out.println("offsetDateTime : " + offsetDateTime);

        System.out.println("===============================================================================");

        /*
        Instant
        기계적인 시간 표현을 위한 클래스
        1970년 1월 1일 0시 0분 0초(UTC)를 기준으로 얼마나 시간이 흘렀는지를 나노초 단위로 표현
        타임스탬프를 찍거나, 프로그램 내부에서 시간을 계산하고 비교하는 등 기계 친화적인 작업에 사용
         */
        Instant  instant = Instant.now();
        System.out.println("instant : " + instant);

        System.out.println("===============================================================================");

        /*
        Duration
        Duration은 시, 분, 초, 나노초 단위의 시간 간격을 나타냅니다.
        주로 두 시간(또는 날짜+시간) 사이의 차이를 계산할 때 사용합니다.
         */
        LocalTime startTime = LocalTime.of(9, 30, 0);  // 오전 9시 30분
        LocalTime endTime = LocalTime.of(11, 0, 15); // 오전 11시 0분 15초

        Duration duration2 = Duration.between(startTime, endTime);

        System.out.println("전체 초: " + duration2.getSeconds() + "초");
        System.out.println("시간 단위로 변환: " + duration2.toHours() + "시간");
        System.out.println("분 단위로 변환: " + duration2.toMinutes() + "분");
        System.out.println("ISO-8601 형식: " + duration2); // PT1H30M15S

        System.out.println("===============================================================================");

        /*
        Period
        Period는 년, 월, 일 단위의 날짜 간격을 나타냅니다.
        주로 두 날짜 사이의 차이를 계산할 때 사용됩니다.
         */
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 3, 15);
        Period period = Period.between(startDate, endDate);

        System.out.println("날짜 간격: " + period.getYears() + "년 "
                + period.getMonths() + "개월 "
                + period.getDays() + "일");

        System.out.println("전체 개월 수: " + period.toTotalMonths() + "개월");
        System.out.println("ISO-8601 형식: " + period); // P2Y2M14D

        System.out.println("===============================================================================");

        /*
        ZoneId
        ZoneId는 "Asia/Seoul"처럼 지역의 시간 규칙(서머타임 등)을 포함하는 시간대를 나타냅니다.
         */
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println("시스템 기본 시간대: " + defaultZone);

        // 특정 지역의 ZoneId 객체 생성
        ZoneId seoulZone = ZoneId.of("Asia/Seoul");
        ZoneId newYorkZone = ZoneId.of("America/New_York");

        // 현재 시각을 각 시간대에 맞춰서 출력
        ZonedDateTime seoulTime = ZonedDateTime.now(seoulZone);
        ZonedDateTime newYorkTime = ZonedDateTime.now(newYorkZone);

        System.out.println("서울 현재 시각: " + seoulTime);
        System.out.println("뉴욕 현재 시각: " + newYorkTime);

        System.out.println("===============================================================================");

        /*
        ZoneOffset: 시차 (Offset)
        ZoneOffset은 UTC(협정 세계시)와의 단순한 시간 차이(+09:00 등)만을 나타냅니다.
         */
        // UTC와의 시간 차이(+9시간)를 나타내는 ZoneOffset 객체 생성
        ZoneOffset koreanOffset = ZoneOffset.of("+09:00");
        System.out.println("한국 시차: " + koreanOffset);

        // 시간대 정보가 없는 LocalDateTime 생성
        LocalDateTime localDateTime1 = LocalDateTime.now();

        // LocalDateTime에 Offset 정보를 붙여 OffsetDateTime 생성
        OffsetDateTime offsetDateTime1 = localDateTime.atOffset(koreanOffset);

        System.out.println("Local 시간: " + localDateTime1);
        System.out.println("Offset 적용된 시간: " + offsetDateTime1);

        System.out.println("===============================================================================");
    }
}



