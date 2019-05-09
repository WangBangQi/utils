package com.zimo.utils.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {


    public void test(){
        Double a,b,c,d,e,f,g;
        a = 3.14;
        b = a * 2;
        c = a + b;
        d = c / b + a;
        e = c - d * b + a;
        f = e + d /c -b * a;
        g = f * e - d + c * b + a;
        a = g * g;
        a = Math.floor(a);
        System.out.println("a=="+a);
    }

    public void test3(){
    }


    public void test2(){
        try {
            URL url = new URL("http://monyer.com/game/game1/424178.php");
            String str = getURLSource(url);
            System.out.println("str=={}"+str);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void test4(){
        String str = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDG/ebQSBqDI7rvqm8z019CATyE+/WLfsaCLyrdVk61/hI5iob3TLNSfbTDoESrey2mcOw4S2G0M0hkp56VCExvJRteuMP7oOLYpg1ICCvJoduqMJ4JvI3Za4bCD931MpyPcUjSnAyeSfhmcub30rNHew242XV1i5IAP4wCyqdxPtKFRt4xJ/ufi6FxB69y2Hn2t6uD8wqa2mlSri9bKfW8nqss7GsADUKvvMZA1+p2aaT4u2AQQpDtNWLAxwUntjOiiYLFK9CkQJVqkOL1A0uFGf5q5ZWPpgqWTPh8/xJ/jCGLP0vDva26l2OtoXWDfLmDCLE3ouTCBIBD4jzhYr7AgMBAAECggEAJf2Tc3BQn3jS167STDKunQtfYoQ3/MnXXENlC5zOqjA3ioTH/67FDZqySCbw9UwvCvfEIXtCzAR+bbkSraFH9nA/KXZc9E1jAbmyD25/7Z7ZMUTW50T4T+oXcDVXSti+yyP1oz/nqNC2gHUcSkX3IfH0hwYjCxA5BcYqwUFggX4jswAX4jE/flClnAkMkLM+Op77l6H8jbZ6PcsHp68zX9gQsowA+CjHguhh98W4MSW4aRiUOhHVgg9TaD0WNqquHnE4METAmUFuMx7oGyiK7ho9phg0mXwH3Syq0R1oxbJLX0Km0plqQsJr4XXzR1nq8Hxuc8Ne1GJjiMP6jlsmAQKBgQDs9mt7f6xQA4qYVZc3P/sm3Ugdaenx9qDbcd2ovzctWE7GdJI8SSREvLelu+G4LpgrpJF/sX31Zc+C5DaWNPUYxbmnLhDm0suXPXeo+yYGG7yI+3PV7XIz575usxfs821IEySlXTxLJdacB+a5Ui0uGIP8QKkRZkKqnaDIWWMqQKBgQDW+oqhPFhw/ZvFuV6TSOamxjwKXHdxUnaMGpjAvP9H4IPQtP55A1VtYtkTMgsCOHge9qUrYUZf76dNB/KdpYONuggQQo59XzX2QHT7nZQukKFKnaRZ8mizVwihpVl/D2pnZZb2RxnCLmcCYqTlwgO5DhYgPt7L+PLLh4yDzw/dAwKBgQDjq5LzUmTFb9GesUWF/rApredoK4LM0lkhQ72MP+cBS4fC1/lRudbvSCxvLseuaIbJ05CYjcO5bc9lfolLMGM+QYJESjlEQ5WFUy2sHwV30KnwHhMjztrKuKi+ufoYzVGMgB7yC4UTH0vASdAj673iXPFi7aYjHPeA5uz86n5+GQKBgHmkXKrtNXIB3pGb2Srn1jNJ+hE2zxMdQRz3s7Vje+NU4+FFeLRKsZzqkL/u0hHYmAeVMlKAgUypk3Xf6GVRkUWxnPxuXKgOJr+HK2pweLd8ePd6idOneZz4w1aL9D8UHvYQosIJ60ZX8UuFO58SD/83PEfUq0apP+Dwew7eLDC3AoGBAJJxMWTzawMQc6M8kCy6N9rCkHc6WKenpTcyfA9Ne+zaKF2uPvZUuiVtjg+dF94qYSoq1HEOYBLZ0kRX/s4vJ/sEJflBxsjFxaK6eZ8o1A8LEiJg2MNtJIB4+h5Vq5SkGuyr4t6cuEyt93NeszRLrLavMO+GGgFCVmw9MoV51Rux";
        System.out.println("str.length="+str.length());
        String str1 = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDG/ebQSBqDI7rv" +
                "qm8z019CATyE+/WLfsaCLyrdVk61/hI5iob3TLNSfbTDoESrey2mcOw4S2G0M0hk" +
                "p56VCExvJRteuMP7oOLYpg1ICCvJoduqMJ4JvI3Za4bCD931MpyPcUjSnAyeSfh+" +
                "mcub30rNHew242XV1i5IAP4wCyqdxPtKFRt4xJ/ufi6FxB69y2Hn2t6uD8wqa2ml" +
                "Sri9bKfW8nqss7GsADUKvvMZA1+p2aaT4u2AQQpDtNWLAxwUntjOiiYLFK9CkQJV" +
                "qkOL1A0uFGf5q5ZWPpgqWTPh8/xJ/jCGLP0vDva26l2OtoXWDfLmDCLE3ouTCBIB" +
                "D4jzhYr7AgMBAAECggEAJf2Tc3BQn3jS167STDKunQtfYoQ3/MnXXENlC5zOqjA3" +
                "ioTH/67FDZqySCbw9UwvCvfEIXtCzAR+bbkSraFH9nA/KXZc9E1jAbmyD25/7Z7Z" +
                "MUTW50T4T+oXcDVXSti+yyP1oz/nqNC2gHUcSkX3IfH0hwYjCxA5BcYqwUFggX4j" +
                "swAX4jE/flClnAkMkLM+Op77l6H8jbZ6PcsHp68zX9gQsowA+CjHguhh98W4MSW4" +
                "aRiUOhHVgg9TaD0WNqquHnE4METAmUFuMx7oGyiK7ho9phg0mXwH3Syq0R1oxbJL" +
                "X0Km0plqQsJr4XXzR1nq8Hxuc8Ne1GJjiMP6jlsmAQKBgQDs9mt7f6xQA4qYVZcg" +
                "3P/sm3Ugdaenx9qDbcd2ovzctWE7GdJI8SSREvLelu+G4LpgrpJF/sX31Zc+C5Da" +
                "WNPUYxbmnLhDm0suXPXeo+yYGG7yI+3PV7XIz575usxfs821IEySlXTxLJdacB+a" +
                "5Ui0uGIP8QKkRZkKqnaDIWWMqQKBgQDW+oqhPFhw/ZvFuV6TSOamxjwKXHdxUnaM" +
                "GpjAvP9H4IPQtP55A1VtYtkTMgsCOHge9qUrYUZf76dNB/KdpYONuggQQo59XzX2" +
                "QHT7nZQukKFKnaRZ8mizVwihpVl/D2pnZZb2RxnCLmcCYqTlwgO5DhYgPt7L+PLL" +
                "h4yDzw/dAwKBgQDjq5LzUmTFb9GesUWF/rApredoK4LM0lkhQ72MP+cBS4fC1/lR" +
                "udbvSCxvLseuaIbJ05CYjcO5bc9lfolLMGM+QYJESjlEQ5WFUy2sHwV30KnwHhMj" +
                "ztrKuKi+ufoYzVGMgB7yC4UTH0vASdAj673iXPFi7aYjHPeA5uz86n5+GQKBgHmk" +
                "XKrtNXIB3pGb2Srn1jNJ+hE2zxMdQRz3s7Vje+NU4+FFeLRKsZzqkL/u0hHYmAeV" +
                "MlKAgUypk3Xf6GVRkUWxnPxuXKgOJr+HK2pweLd8ePd6idOneZz4w1aL9D8UHvYQ" +
                "osIJ60ZX8UuFO58SD/83PEfUq0apP+Dwew7eLDC3AoGBAJJxMWTzawMQc6M8kCy6" +
                "N9rCkHc6WKenpTcyfA9Ne+zaKF2uPvZUuiVtjg+dF94qYSoq1HEOYBLZ0kRX/s4v" +
                "J/sEJflBxsjFxaK6eZ8o1A8LEiJg2MNtJIB4+h5Vq5SkGuyr4t6cuEyt93NeszRL" +
                "rLavMO+GGgFCVmw9MoV51Rux";
        System.out.println("str1.length= "+str1.length());

    }
    public  void test5()throws Exception{
        String s = "Ã§Â\u009FÂ¥Ã©Â±Â¼Ã¤Â¹Â\u008BÃ¤Â";
        System.out.println("str="+new String(s.getBytes(),"UTF-8"));
    }

    public void test6()throws Exception{
        String arrStr = "a,b,c,,,d,";
        String[] arr = arrStr.split(",");
        System.out.println(arr.length);
    }

    public void test7()throws Exception{
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if("2".equals(temp)){
                a.remove(temp);
            }
        }
        a.size();
    }

    public static String getURLSource(URL url) throws Exception    {
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(5 * 1000);
        InputStream inStream =  conn.getInputStream();  //通过输入流获取html二进制数据
        byte[] data = readInputStream(inStream);        //把二进制数据转化为byte字节数据
        String htmlSource = new String(data);
        return htmlSource;
    }
    /** *//**
     * 把二进制流转化为byte字节数组
     * @param instream
     * @return byte[]
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream instream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[]  buffer = new byte[1204];
        int len = 0;
        while ((len = instream.read(buffer)) != -1){
            outStream.write(buffer,0,len);
        }
        instream.close();
        return outStream.toByteArray();
    }




    public static void main (String args[]){
        try {
            TestUtils t = new TestUtils();
//        t.test();
//        t.test2();
//          t.test4();
//            t.test5();
            t.test7();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
