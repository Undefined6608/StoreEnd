package com.store.storeend.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ParameterTools {
    public static Boolean isRegularization(String regular,String value){
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
