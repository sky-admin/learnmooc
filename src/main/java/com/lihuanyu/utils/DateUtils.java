package com.lihuanyu.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Explorer on 2016/5/4.
 */
public class DateUtils {

    /**
     * 是否是同一天
     */
    public static boolean sameDay(Date dateA,Date dateB){
        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(dateA);

        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(dateB);

        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
                && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
                &&  calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH);
    }
}
