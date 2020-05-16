package com.meyoustu.liangchengj.website.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Liangcheng Juves
 * Created at 2020/05/16 17:50
 */
public final class DateUtil {
    private DateUtil() {
    }


    private static DateUtil dateUtil;

    private static DateUtil getInstance() {
        if (dateUtil == null) {
            synchronized (DateUtil.class) {
                dateUtil = (dateUtil == null) ?
                        new DateUtil() :
                        dateUtil;
            }
        }
        return dateUtil;
    }


    private String text;

    public static DateUtil format(String text) {
        getInstance().text = text;
        return getInstance();
    }

    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(
            () -> new SimpleDateFormat(getInstance().text)
    );

    @Override
    public String toString() {
        return getInstance().df.get().format(new Date());
    }
}
