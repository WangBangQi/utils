package com.zimo.utils.utils;

import java.util.*;

/**
 * @author zi.mo
 * @description
 * @date 2019/2/20,6:12 PM
 */
public class SensitiveWordsReader {

    public Set<String> readSensitiveWords(){
        Set<String> lines = new HashSet<>();
        lines.add("fuck");
        lines.add("cao");
        lines.add("1");
        lines.add("a");
        lines.add("c");
        return lines;
    }
}
