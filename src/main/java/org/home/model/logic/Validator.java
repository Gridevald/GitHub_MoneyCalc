package org.home.model.logic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean checkEmail(String email) {
        Matcher matcher = Pattern.compile("[\\p{Punct}\\w]+@[\\w][-\\w]{0,61}[\\w].[\\w]{2,10}")
                .matcher(email.toLowerCase());
        return matcher.matches();
    }

    public boolean checkPassword(String password) {
        Matcher matcher = Pattern.compile("[\\w\\p{Punct}]{6,255}").matcher(password);
        return matcher.matches();
    }

    public boolean checkValue(String value) {
        Matcher matcher = Pattern.compile("[0-9]+([.,][0-9]{1,2})?").matcher(value);
        return matcher.matches();
    }

    public boolean checkValueZero(double value) {
        return value == 0;
    }

    public boolean checkDescription(String description) {
        return description.trim().length() > 0;
    }

    public boolean checkDate(String date) {
        return date.length() > 0;
        //TODO check for min and max year
    }

    public double prepareNumber(String value, String sign) {
        double d = Double.valueOf(value.replace(",", "."));
        if (sign.equals("-")) {
            d = d * -1;
        }
        return d;
    }

    public Calendar getDate(String date) {
        String[] dateParts = date.split("-");
        int year = Integer.valueOf(dateParts[0]);
        int month = Integer.valueOf(dateParts[1]) - 1;
        int day = Integer.valueOf(dateParts[2]);
        return new GregorianCalendar(year, month, day);
    }
}
