package com.example.java8to11.date_time_eight;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {
    public static void main(String[] args) {

        /* 기계용 */
        Instant instant = Instant.now();
        System.out.println("instant = " + instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 기준시 UTC, GMT


        ZoneId zone = ZoneId.systemDefault();
        System.out.println("zone = " + zone); // Asia/Seoul
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println("zonedDateTime = " + zonedDateTime);

        /* 인류용 */
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime birthday = LocalDateTime.of(1993, Month.MARCH, 31, 0, 0, 0);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKorea = " + nowInKorea);

        /* 기간 표현 */

        /* Period 인간용 */
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = LocalDate.of(2022, Month.MARCH, 31);

        Period between = Period.between(today, nextBirthday);
        System.out.println(between.getMonths() + "-"+ between.getDays()); // 30일 이상은 표시가 안됨


        System.out.println(ChronoUnit.DAYS.between(today, nextBirthday)); // 181

        Period until = today.until(nextBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        /* Duration 기계용 */
        Instant now1 = Instant.now();
        Instant plus = now1.plus(10, ChronoUnit.SECONDS);

        Duration duration = Duration.between(now1, plus);
        System.out.println(duration.getSeconds()); // 10

        /* DateTimeFormatter */
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println(now.format(dateTimeFormatter)); // yyyy-mm-dd

        LocalDate date = LocalDate.parse("07/15/1982", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(date);

        /* Legacy Api 지원 */
        Date date1 = new Date();
        Instant newInstant = date1.toInstant();
        Date newDate = Date.from(newInstant);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(dateTime);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
    }
}
