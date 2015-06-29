package edu.umt.utils;

import java.math.BigInteger;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by tb189431e on 5/10/14.
 */
public class MaskStripper {

    public static BigInteger stripPhoneNumberMask(String phone){
        String cleanString = phone.replaceAll("\\D", "");
        return new BigInteger(cleanString);
    }

    public static BigInteger stripSsnMask(String ssn){
        String cleanString = ssn.replaceAll("\\D", "");
        return new BigInteger(cleanString);
    }

    public static Timestamp prepareDate(String sDate){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");         //EEE MMM dd HH:mm:ss zzz yyyy
        Date date = new Date();
        try {
            date = sdf.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Timestamp(date.getTime());
    }
}
