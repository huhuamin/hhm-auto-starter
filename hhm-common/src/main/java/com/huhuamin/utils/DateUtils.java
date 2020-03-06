package com.huhuamin.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
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

}
