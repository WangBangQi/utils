package cn.zimo.wbq.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtils {
    private static final String PHONE_REGEX = "^1[0-9]{10}$"; //手机号码
    private static final Pattern PHONE_P = Pattern.compile(PHONE_REGEX);
    private static final String PWD_REGEX = "[a-zA-Z0-9]{6,20}";
    private static final Pattern PWD_P = Pattern.compile(PWD_REGEX);
    private static final String NICK_NAME_REGEX = "";
    private static final Pattern NICK_NAME_P = Pattern.compile(NICK_NAME_REGEX);

    public static void checkPhone(String phoneNum){
        if (phoneNum!=null || phoneNum.length()==11) {
            Matcher m = PHONE_P.matcher(phoneNum);
            if (m.matches()) return;
        }
//        抛出手机号码格式错误
    }

    public static void checkPassword(String password){
        if (password!=null) {
            Matcher m = PWD_P.matcher(password);
            if (m.matches()) return;
        }
//        抛出密码格式错误
    }

    private static int getStrLength(String value){
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        for (int i = 0; i < value.length(); i++) {
            String temp = value.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 2;
            } else {
                valueLength += 1;
            }
        }
        return valueLength;
    }



    public static boolean version(String value){
        String str = "^[1-9]\\.[\\d]\\.[\\d]";
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches())return true;
        return false;
    }

    public static void main(String args[]){
        System.out.println(version("4.5.6"));
        System.out.println(version("0.5.6"));
        System.out.println(version("4.5."));
        System.out.println(version("1..6"));
        System.out.println(version("0.0.0"));
    }
}
