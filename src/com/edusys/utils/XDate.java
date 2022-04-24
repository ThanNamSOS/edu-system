package com.edusys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {

    public static Date now() {
        return new Date();
    }
    public static void main(String[] args) {
        System.out.println(now());
    }
}
