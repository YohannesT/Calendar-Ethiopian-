package tamru.yohannes.ethiopiancalendar.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import tamru.yohannes.ethiopiancalendar.models.EthiopianDate;

public class EthiopianDateConversion {
    private static final int JdOffset = 1723856;

    //region Private stuff
    public static int GregorianDateToJDN(Date gregorianDate){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(gregorianDate);
        int year = calendar.get(Calendar.YEAR), date = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;// Whoever decided calendar.get(Calendar.MONTH) should return a 0 based index, Fuck you!, you owe me half a day
        int a, y, m;
        a = (14 - month)/12;
        y = year + 4800 - a;
        m = month + 12 * a - 3;

        return date + (153 * m + 2)/5 + 365 * y + y/4 - y / 100 + y /400 - 32045;
    }

    public static Date JDNToGregorianDate(int jdn)
    {
        int year, month, day;

        int r = jdn + 68569;
        int n = 4*r/146097;

        r = r - (146097*n + 3)/4;
        year = 4000*(r + 1)/1461001;
        r = r - 1461*year/4 + 31;
        month = 80*r/2447;
        day = r - 2447*month/80;
        r = month/11;
        month = month + 2 - 12*r;
        year = 100*(n - 49) + year + r;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day); //Again, because the month is a zero based index, one must be subtracted

        return calendar.getTime();
    }

    public static int EthiopianDateToJDN(int year, int month, int day)
    {
        return (JdOffset + 365) + 365 * (year - 1) + year / 4 + 30 * month +
                day - 31;
    }

    public static EthiopianDate JDNToEthiopianDate(int jdn)
    {
        //Formula from Dr. Berhanu Beyene and Manfred Kudlek
        int year, month, day, r, n;

        r = (jdn - JdOffset) % 1461;
        n = r%365 + 365*(r/1460);

        year = 4 * ((jdn - JdOffset) / 1461) + (r / 365) - (r / 1460);
        month = (n/30) + 1;
        day = (n%30) + 1;
        return new EthiopianDate(year, month, day);
    }
//endregion

    //region Public stuff

    public static Date EthiopianDateToGregorianDate(int ethiopianYear, int ethiopianMonth, int ethiopianDate)
    {
        return JDNToGregorianDate(EthiopianDateToJDN(ethiopianYear, ethiopianMonth, ethiopianDate));
    }

    public static EthiopianDate GregorianDateToEthiopianDate(Date gregorianDate)
    {
        return JDNToEthiopianDate(GregorianDateToJDN(gregorianDate));
    }
    //endregion
}