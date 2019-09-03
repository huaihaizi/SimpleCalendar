package com.simple.calendar.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {

    /**
     * TODO:获取日期为周几
     * 1,周天
     * 2,周一
     * 3,周二
     * 4,周三
     * 5,周四
     * 6,周五
     * 7,周六
     *
     * @acthor weiang
     * 2019-09-03 10:25
     */
    //  String pTime = "2012-03-12";
    public static int getWeek(String pTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 根据 年、月 获取对应的月份 的 天数
     */
    public static Map<String, String> getMonthAndYearByString(String pTime) {
        Map<String, String> map = new HashMap<String, String>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH)+1;
            map.put("year", year + "");
            Log.d("hhh", "---------year---:"+year);
            map.put("month", month + "");
            return map;
        } catch (ParseException e) {
            e.printStackTrace();
            return map;
        }
    }


    /**
     * 根据 年、月 获取对应的月份 的 天数
     */
    public static int getDaysByYearMonth(String pTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(pTime);
            int year = date.getYear();
            int month = date.getMonth() + 1;
            Log.d("date", "---------year---:" + year + "--------month-->:" + month);
            Calendar a = Calendar.getInstance();
            a.setTime(date);
            a.set(Calendar.YEAR, year);
            a.set(Calendar.MONTH, month - 1);
            a.set(Calendar.DATE, 1);
            a.roll(Calendar.DATE, -1);
            int maxDate = a.get(Calendar.DATE);
            return maxDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * TODO:月的天数
     *
     * @acthor weiang
     * 2019-09-03 10:42
     */
    public static int getMonthOfDay(int year, int month) {
        int day = 0;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            day = 29;
        } else {
            day = 28;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return day;
            default:
        }
        return 0;
    }


}
