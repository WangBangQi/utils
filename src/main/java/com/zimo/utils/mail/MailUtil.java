package com.zimo.utils.mail;

public class MailUtil {

    private static Mail getMail(){
        return Mail163.getInstance();
    }

    public static void send(String toMail){
        Mail mail = getMail();
        mail.setTitle("测试工具");

//        String content = "<!DOCTYPE HTML>\n" +
//                "<html>\n" +
//                "<head>\n" +
//                "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n" +
//                "<meta name=\"robots\" content=\"noindex,nofollow\">\n" +
//                "<!-- <meta http-equiv=\"refresh\" content=\"0;url=424178.php\"> -->\n" +
//                "<title>梦之光芒/Monyer——Monyer's Game(第4关)</title>\n" +
//                "<script type=\"3d2f9d1b767b4179ae8462d5-text/javascript\">\n" +
//                "    eval(function(p,a,c,k,e,d){e=function(c){return c.toString(36)};if(!''.replace(/^/,String)){while(c--)d[c.toString(a)]=k[c]||c.toString(a);k=[function(e){return d[e]}];e=function(){return'\\\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\\\b'+e(c)+'\\\\b','g'),k[c]);return p}('a=\"e\";d c(){b(9.8(\\'7\\').6==a){5.4.3=a+\".2\"}1{0(\"密码错误\")}}',15,15,'alert|else|php|href|location|window|value|txt|getElementById|document||if|check|function|3bhe'.split('|'),0,{}))\n" +
//                "</script>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "<div align=\"center\">\n" +
//                "    <p>欢迎您来到第4关</p>\n" +
//                "    <p>请输入密码进入第5关：\n" +
//                "        <input type=\"text\" id=\"txt\" value=\"\">\n" +
//                "        <input type=\"button\" onClick=\"check()\" value=\"提交\">\n" +
//                "    </p>\n" +
//                "</div>\n" +
//                "<script src=\"https://ajax.cloudflare.com/cdn-cgi/scripts/2448a7bd/cloudflare-static/rocket-loader.min.js\" data-cf-nonce=\"3d2f9d1b767b4179ae8462d5-\" defer=\"\"></script></body>\n" +
//                "<script type=\"3d2f9d1b767b4179ae8462d5-text/javascript\">\n" +
//                "    eval(\"\\141\\75\\141\\56\\164\\157\\125\\160\\160\\145\\162\\103\\141\\163\\145\\50\\51\\53\\61\\73\");\n" +
//                "</script>\n" +
//                "</html>";
        String content = "测试";
        mail.sendText(toMail,content);
    }

    public static void main(String args[]){
        MailUtil.send("1597176979@qq.com");
    }
}
