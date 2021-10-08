package com.lincheng.study.common.utils;

import org.springframework.aop.scope.ScopedProxyUtils;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @description: 日期工具类
 * @author: linCheng
 * @create: 2021-10-08 17:25
 **/
public class DateUtils {

    private static String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    private static String YYYYMMDD = "yyyy-MM-dd";

    private static String YYYYMM = "yyyy-MM";


    /**
     * @Description: Date To String
     * @author: linCheng
     * @Date: 2021/10/8 20:39
     * @param: date
     * @param: pattern
     * @Return: java.lang.String
     */
    public static String dateToString(Date date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        return formatter.format(localDateTime);
    }


    /**
     * @Description: String To Date
     * @author: linCheng
     * @Date: 2021/10/8 20:38
     * @param: date
     * @param: pattern
     * @Return: java.util.Date
     */
    public static Date stringToDate(String date, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description: Date To LocalDate
     * @author: linCheng
     * @Date: 2021/10/8 20:39
     * @param: date
     * @Return: java.time.LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }


    /**
     * @Description: LocalDate To Date
     * @author: linCheng
     * @Date: 2021/10/8 20:40
     * @param: localDate
     * @Return: java.util.Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }


    /**
     * @Description:  Date to LocalTime
     * @author: linCheng
     * @Date: 2021/10/8 20:41
     * @param: date
     * @Return: java.time.LocalTime
     */
    public static LocalTime dateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        LocalTime localTime = instant.atZone(ZoneId.systemDefault()).toLocalTime();
        return localTime;
    }


    /**
     * @Description: LocalTime To Date
     * @author: linCheng
     * @Date: 2021/10/8 20:41
     * @param: localTime
     * @Return: java.util.Date
     */
    public static Date localTimeToDate(LocalTime localTime) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }


    /**
     * @Description: Date To LocalDateTime
     * @author: linCheng
     * @Date: 2021/10/8 20:36
     * @param: date
     * @Return: java.time.LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }


    /**
     * @Description: LocalDateTime To Date
     * @author: linCheng
     * @Date: 2021/10/8 20:36
     * @param: date
     * @Return: java.time.LocalDateTime
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * @Description: 传入时间后几天
     * @author: linCheng
     * @Date: 2021/10/8 21:27
     * @param: date
     * @param: after
     * @Return: java.util.Date
     */
    public static Date afterXDateTime(Date date, Long after) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusDays(after);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description: 传入时间前几天
     * @author: linCheng
     * @Date: 2021/10/8 21:27
     * @param: date
     * @param: before
     * @Return: java.util.Date
     */
    public static Date beforeXDateTime(Date date, Long before) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.minusDays(before);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * @Description: 获取当前时间之后的某一天的最小时间
     * @author: linCheng 
     * @Date: 2021/10/8 20:47
     * @param: date
     * @param: after
     * @Return: java.util.Date
     */
    public static Date afterXDateTimeMIN(Date date, Long after) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusDays(after);
        localDateTime = localDateTime.with(LocalTime.MIN);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description: 获取当前时间之后的某一天的最大时间
     * @author: linCheng 
     * @Date: 2021/10/8 20:48
     * @param: date
     * @param: after
     * @Return: java.util.Date
     */
    public static Date afterXDateTimeMAX(Date date, Long after) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusDays(after);
        localDateTime = localDateTime.with(LocalTime.MAX);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description: 获取当前时间之前的某一天的最小时间
     * @author: linCheng
     * @Date: 2021/10/8 20:48
     * @param: date
     * @param: before
     * @Return: java.util.Date
     */
    public static Date beforeXDateTimeMIN(Date date, Long before) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.minusDays(before);
        localDateTime = localDateTime.with(LocalTime.MIN);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * @Description: 获取当前时间之前的某一天的最大时间
     * @author: linCheng
     * @Date: 2021/10/8 20:48
     * @param: date
     * @param: before
     * @Return: java.util.Date
     */
    public static Date beforeXDateTimeMAX(Date date, Long before) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.minusDays(before);
        localDateTime = localDateTime.with(LocalTime.MAX);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * @Description: 获取传入时间月份的最后一天
     * @author: linCheng
     * @Date: 2021/10/8 21:08
     * @param: date
     * @Return: java.util.Date
     */
    public static Date currentDayOfMonthLastDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description: 获取传入时间月份的第一天
     * @author: linCheng
     * @Date: 2021/10/8 21:01
     * @param: date
     * @Return: java.util.Date
     */
    public static Date currentDayOfMonthFirstDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description: 传入时间前几个月的1号0点 00:00:00
     * @author: linCheng
     * @Date: 2021/10/8 21:00
     * @param: date
     * @param: month
     * @Return: java.util.Date
     */
    public static Date beforeXDayOfMonthMIN(Date date, Long month) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.minusMonths(month);
        localDateTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description: 传入时间后几个月的最后一天23：59：59
     * @author: linCheng
     * @Date: 2021/10/8 20:53
     * @param: date
     * @param: month
     * @Return: java.util.Date
     */
    public static Date beforeXDayOfMonthMAX(Date date, Long month) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.minusMonths(month);
        localDateTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        return localDateTimeToDate(localDateTime);
    }




    /**
     * @Description: 传入时间前几个月的1号0点 00:00:00
     * @author: linCheng
     * @Date: 2021/10/8 21:00
     * @param: date
     * @param: month
     * @Return: java.util.Date
     */
    public static Date afterXDayOfMonthMIN(Date date, Long month) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusMonths(month);
        localDateTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description: 传入时间后几个月的最后一天23：59：59
     * @author: linCheng
     * @Date: 2021/10/8 20:53
     * @param: date
     * @param: month
     * @Return: java.util.Date
     */
    public static Date afterXDayOfMonthMAX(Date date, Long month) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusMonths(month);
        localDateTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description: 传入时间的前几个月的时间
     * @author: linCheng
     * @Date: 2021/10/8 20:56
     * @param: date
     * @param: month
     * @Return: java.util.Date
     */
    public static Date beforeXDayOfMonth(Date date, Long month) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.minusMonths(month);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description:  传入时间的后几个月的时间
     * @author: linCheng
     * @Date: 2021/10/8 20:54
     * @param: date
     * @param: month
     * @Return: java.util.Date
     */
    public static Date afterXDayOfMonth(Date date, Long month) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusMonths(month);
        return localDateTimeToDate(localDateTime);
    }


    /**
     * @Description: 两个日期相差多少个月
     * @author: linCheng
     * @Date: 2021/10/8 20:52
     * @param: date1
     * @param: date2
     * @Return: java.lang.Long
     */
    public static Long getUntilMonth(Date date1, Date date2) {
        LocalDate localDate1 = dateToLocalDate(date1);
        LocalDate localDate2 = dateToLocalDate(date2);
        return ChronoUnit.MONTHS.between(localDate1, localDate2);
    }


    /**
     * @Description: 两个日期相差多少天
     * @author: linCheng
     * @Date: 2021/10/8 20:52
     * @param: date1
     * @param: date2
     * @Return: java.lang.Long
     */
    public static Long getUntilDay(Date date1, Date date2) {
        LocalDate localDate1 = dateToLocalDate(date1);
        LocalDate localDate2 = dateToLocalDate(date2);
        return ChronoUnit.DAYS.between(localDate1, localDate2);
    }


    /**
     * @Description: 两个日期相差多少小时
     * @author: linCheng
     * @Date: 2021/10/8 20:51
     * @param: date1
     * @param: date2
     * @Return: java.lang.Long
     */
    public static Long getUntilHours(Date date1, Date date2) {
        LocalDateTime localDate1 = dateToLocalDateTime(date1);
        LocalDateTime localDate2 = dateToLocalDateTime(date2);
        Long senonds = Duration.between(localDate1, localDate2).get(ChronoUnit.SECONDS);
        return senonds / 3600;
    }


    /**
     * @Description:  两个日期相差多少小时 double 约等于
     * @author: linCheng
     * @Date: 2021/10/8 20:51
     * @param: date1
     * @param: date2
     * @Return: double
     */
    public static double getUntilHoursByDouble(Date date1, Date date2) {
        LocalDateTime localDate1 = dateToLocalDateTime(date1);
        LocalDateTime localDate2 = dateToLocalDateTime(date2);
        Long seconds = Duration.between(localDate1, localDate2).get(ChronoUnit.SECONDS);
        BigDecimal secondss = BigDecimal.valueOf(seconds);
        BigDecimal hours = secondss.divide(BigDecimal.valueOf(3600), 2, BigDecimal.ROUND_HALF_UP);
        return hours.doubleValue();
    }


    /**
     * @Description: 两个日期相差多少秒
     * @author: linCheng
     * @Date: 2021/10/8 20:50
     * @param: date1
     * @param: date2
     * @Return: java.lang.Long
     */
    public static Long getUntilSecond(Date date1, Date date2) {
        LocalDateTime localDate1 = dateToLocalDateTime(date1);
        LocalDateTime localDate2 = dateToLocalDateTime(date2);
        return Duration.between(localDate1, localDate2).get(ChronoUnit.SECONDS);
    }


    /**
     * @Description:  当前时间23：59：59
     * @author: linCheng
     * @Date: 2021/10/8 21:21
     * @param: null
     * @Return:
     */
    public static Date currentMax(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.with(LocalTime.MAX);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * @Description: 当前时间00:00:00
     * @author: linCheng
     * @Date: 2021/10/8 21:21
     * @param: date
     * @Return: java.util.Date
     */
    public static Date currentMin(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.with(LocalTime.MIN);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }




}
