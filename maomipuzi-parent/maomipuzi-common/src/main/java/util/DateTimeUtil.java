package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-29 14:36
 **/
public class DateTimeUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);

    public static final String PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DAY = "yyyy-MM-dd";
    public static final String PATTERN_COMPACT = "yyyyMMdd";
    public static final String PATTERN_DAY_SLASH = "yyyy/MM/dd";
    public static final String PATTERN_MONTH_SLASH = "yyyy/MM";

    public static String formatDate(Date date) {
        return formatDateByPattern(date, PATTERN_DEFAULT);
    }


    /**
     * 转换为自己需要的格式
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDateByPattern(Date date, String pattern) {
        if (date == null) throw new IllegalArgumentException("date is null");
        if (pattern == null) throw new IllegalArgumentException("pattern is null");
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * 字符串转为Date
     *
     * @param date"yyyy-MM-dd"
     * @return
     */
    public static Date parseStringToDate(String date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sm = new SimpleDateFormat(format);
        try {
            return sm.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * cst 格式
     * @param day
     * @param days
     * @return
     */
    static public Date backDays(Date day, int days) {
        final long oneDayInMillis = 24 * 60 * 60 * 1000;
        return new Date(day.getTime() / oneDayInMillis * oneDayInMillis - (days - 1) * oneDayInMillis-8*60 * 60 * 1000);
    }

    /**
     * cst 格式
     * @param day
     * @return
     */
    static public Date getEndOfADay(Date day) {
        final long oneDayInMillis = 24 * 60 * 60 * 1000;
        return new Date((day.getTime() / oneDayInMillis + 1) * oneDayInMillis - 1-8*60 * 60 * 1000);
    }

    /**
     * 获得可以正常显示的时间
     * yyyy-MM-dd HH:mm:ss
     * @param time
     * @return
     */
    public static String normalizeTime(long time) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return sm.format(date);
    }

    public static String normalizeTime(Timestamp timestamp) {
        if (timestamp == null) {
            return "";
        }
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sm.format(date);
    }

    /**
     * 获得可以正常显示的时间
     *
     * @param date"yyyy-MM-dd"
     * @return
     */
    public static String parseDateTime(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sm = new SimpleDateFormat(format);
        return sm.format(date);
    }

    /**
     * Date类型转换Timestamp
     *
     * @param date
     * @return
     */
    public static Timestamp toTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * Date类型转换sql Date
     *
     * @param date
     * @return
     */
    public static java.sql.Date toSqlDate(Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }
}
