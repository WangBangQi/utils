package com.zimo.utils.utils;

import java.util.Random;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/4/28,9:35 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class UserUtils {

    public static void main(String[] args) {
        int size = 2;

        for (int i = 0 ; i<100000;i++){
            int index = new Random(System.currentTimeMillis()).nextInt(size);
//            if (index == 0 || index == 20)
            System.out.println("index = "+index);
            try {
                Thread.sleep(31);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("完成======================");
    }
}
