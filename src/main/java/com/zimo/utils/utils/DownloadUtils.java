package com.zimo.utils.utils;

import java.util.Objects;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/10,9:20 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class DownloadUtils {

    public static void main(String args[]){

        String regex = "^http://jianshu.com/shouye/[A-Za-z0-9]{2,60}";

        System.out.println(Objects.equals(3L,3));
        System.out.println(Objects.equals(3,3));
        System.out.println(Objects.equals("1",3));
        System.out.println(Objects.equals("a",3));
        System.out.println(Objects.equals(null,3));
        System.out.println(Objects.equals(1,null));
        System.out.println(Objects.equals(null,null));
        System.out.println(Objects.equals("a","a"));
        System.out.println(Objects.equals(new Thread(),3));
    }
}
