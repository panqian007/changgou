package com.changgou.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil1 {
    public static final SimpleDateFormat minFormatter = new SimpleDateFormat("yyyyMMddHHmm");
    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    /**
     * 隐藏构造函数.
     */
    protected DateUtil1() {
    }

    public static String timeMapFormat(Date timeMap, String format){

//        Date date = new Date(timeMap);

        return new SimpleDateFormat(format).format(timeMap);
    }

    public static Date getNow() {
        return new Date();
    }

    /**
     * 字符串转换为日期
     *
     * @param date
     * @param formatter 如"yyyy-MM-dd hh:mm:ss"
     * @return
     */
    public static Date parse(String date, String formatter) {
        SimpleDateFormat format = new SimpleDateFormat(formatter);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param formatter 如"yyyy-MM-dd hh:mm:ss"
     * @return
     */
    public static String format(Date date, String formatter) {
        if(null == date) return "";
        SimpleDateFormat format = new SimpleDateFormat(formatter);
        return format.format(date);
    }

//    public static Date parseDate(String date){
//        if(StringUtils.isEmpty(date)){
//            return null;
//        }
//        try {
//            if (date.charAt(4) == '-') {
//                return DateUtil.parse(date, "yyyy-MM-dd");
//            }
//            if (date.charAt(4) == '/') {
//                return DateUtil.parse(date, "yyyy/MM/dd");
//            }
//        }catch (Exception e){
//
//        }
//        return null;
//    }


    public static long convertDayToMillisecond(Integer cycleTime) {
        return cycleTime.longValue() * 24 * 60 * 60 * 1000;
    }

    public static Date getNextDay() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getNow());
        calendar.add(Calendar.DAY_OF_MONTH,1);
        return calendar.getTime();
    }
}
