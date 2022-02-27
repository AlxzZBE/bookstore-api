package com.alex.bookstore.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){

        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }

}
