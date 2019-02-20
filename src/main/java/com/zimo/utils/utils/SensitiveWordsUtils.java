package com.zimo.utils.utils;

import java.util.Set;

/**
 * @author zi.mo
 * @description
 * @date 2019/2/20,6:15 PM
 */
public class SensitiveWordsUtils {

    public static void main(String args[]){
        SensitiveWordsFilter sensitiveWordsFilter = SensitiveWordsFilter.getInstance(new SensitiveWordsReader());
        Set<String> strings = sensitiveWordsFilter.getSensitiveWords("fuckasgang3qcaocaswqfucawe");

        strings.forEach(s -> {
            System.out.println(s);
        });

        String str = sensitiveWordsFilter.replaceSensitiveWords("fuckasgang3qcaocaswqfucawe","***");
        System.out.println("========");
        Set<String> strings2 = sensitiveWordsFilter.getSensitiveWords(str);

        strings2.forEach(s -> {
            System.out.println(s);
        });



        String str2 = sensitiveWordsFilter.replaceSensitiveWords(str,"***");
        System.out.println("========");
        Set<String> strings3 = sensitiveWordsFilter.getSensitiveWords(str);

        strings2.forEach(s -> {
            System.out.println(s);
        });
    }
}
