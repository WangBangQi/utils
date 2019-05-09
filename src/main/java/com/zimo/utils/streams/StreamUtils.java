package com.zimo.utils.streams;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/4/25,2:01 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class StreamUtils {

    public static void main(String args[]){
        List<String> strings = Arrays.asList("a1","a2","a3","a4","a5","45");
        strings .stream() //创建流
                .filter(s -> s.startsWith("a")) //过滤
                .map(String::toUpperCase)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                })
                .forEach(System.out::println);

        List<Integer> list = Arrays.asList(2,4,1,727,null,613,1361);

        list.stream()
                .filter(e -> e != null)
                .filter(e -> e > 5)
                .mapToDouble(Integer::doubleValue)
                .forEach(System.out::println);
    }
}
