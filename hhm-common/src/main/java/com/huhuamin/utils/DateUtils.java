package com.huhuamin.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/22 17:59
 * @Modified By:
 * @Since:
 */
public class DateUtils {

    /**
     * 获取两个时间之间的分钟差
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static double getMinSpace(Date startTime, Date endTime) {
        double tmp = ((double) (endTime.getTime() - startTime.getTime()));
        tmp = tmp / (60 * 1000);
        return tmp;
    }

    public static Date strToDate(String strDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getShortDateStr() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }



    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }


    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        Date date = Date.from(zdt.toInstant());
        return date;

    }
}
