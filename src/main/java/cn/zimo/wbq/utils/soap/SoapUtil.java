package cn.zimo.wbq.utils.soap;


import com.sun.xml.internal.messaging.saaj.soap.ver1_2.SOAPMessageFactory1_2Impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @author zi.mo
 * @description
 * @createTime 2019/8/14,11:56 AM
 */
public class SoapUtil {

    private static final Logger log = LoggerFactory.getLogger(SoapUtil.class);

//    /**
//     * SOAP 构造工厂
//     */
//    private static SOAPConnectionFactory soapConnectionFactory;
//
//    /**
//     * SOAP 连接
//     */
//    private static SOAPConnection soapConnection;
//

//
//    static {
//        try {
//            soapConnectionFactory = SOAPConnectionFactory.newInstance();
//            soapConnection = soapConnectionFactory.createConnection();
//        } catch (SOAPException e) {
//            log.error("初始化 soapConnectionFactory 异常,",e);
//            e.printStackTrace();
//        }
//    }


    //测试环境地址
    public static String INVOICE_WS_URL = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";

    public static void main(String args[])throws Exception{

        //SOAP连接工厂
        SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
        //创建连接
        SOAPConnection connection = factory.createConnection();
        //请求地址
        URL url = new URL(INVOICE_WS_URL);
        //执行请求
        SOAPMessage soapResponse = connection.call(createSOAPMessage(),url);
        //打印请求

        // Process the SOAP Response
        printSOAPResponse(soapResponse);

        connection.close();
    }


    private static SOAPMessage createSOAPMessage()throws Exception{

        MessageFactory messageFactory = SOAPMessageFactory1_2Impl.newInstance();

        SOAPMessage soapMessage = messageFactory.createMessage();

        String serverURI = "http://WebXml.com.cn/";

        //请求头,让服务端知道为一个 SOAP 请求
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "getWeatherbyCityName");

        SOAPPart soapPart = soapMessage.getSOAPPart();
        // SOAP Envelope

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("example", serverURI);

        SOAPBody soapBody = envelope.getBody();

        SOAPElement soapElement = soapBody.addChildElement("getWeatherbyCityName");
        SOAPElement soapElement1 = soapElement.addChildElement("theCityName");
        soapElement1.addTextNode("58457");


        //保存所有的改变
        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }


    /**
     * Method used to print the SOAP Response
     */
    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }


    private static void test()throws Exception{
        String sid = "SID值";
        String content = "报文内容,jOSN格式";
        String tranSeq = "UUID";
        String tranReqDate = "2018-04-24";
        StringBuffer stringBuffer = testWebService(sid, content, tranSeq, tranReqDate);

        // 打印HTTP响应数据
        System.out.println(stringBuffer);
    }

    // 调用WS
    private static StringBuffer testWebService(String sid, String content, String tranSeq, String tranReqDate) throws Exception {
        //拼接请求报文
        String sendMsg = appendXmlContext(sid, content, tranSeq, tranReqDate);
        // 开启HTTP连接ַ
        InputStreamReader isr = null;
        BufferedReader inReader = null;
        StringBuffer result = null;
        OutputStream outObject = null;
        try {
            URL url = new URL(INVOICE_WS_URL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            // 设置HTTP请求相关信息
            httpConn.setRequestProperty("Content-Length",
                    String.valueOf(sendMsg.getBytes().length));
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            httpConn.setRequestProperty("SOAPAction","http://WebXml.com.cn/getWeatherbyCityName");
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);

            // 进行HTTP请求
            outObject = httpConn.getOutputStream();
            outObject.write(sendMsg.getBytes());

            if (200 != (httpConn.getResponseCode())) {
                throw new Exception("HTTP Request is not success, Response code is " + httpConn.getResponseCode());
            }
            // 获取HTTP响应数据
            isr = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            inReader = new BufferedReader(isr);
            result = new StringBuffer();
            String inputLine;
            while ((inputLine = inReader.readLine()) != null) {
                result.append(inputLine);
            }
            return result;

        } catch (IOException e) {
            throw e;
        } finally {
            // 关闭输入流
            if (inReader != null) {
                inReader.close();
            }
            if (isr != null) {
                isr.close();
            }
            // 关闭输出流
            if (outObject != null) {
                outObject.close();
            }
        }

    }

    //拼接请求报文
    private static String appendXmlContext(String sid, String content, String tranSeq, String tranReqDate) {
        // 构建请求报文

        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
                "                 xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "    <soap12:Body>\n" +
                "        <getWeatherbyCityName xmlns=\"http://WebXml.com.cn/\">\n" +
                "            <theCityName>58457</theCityName>\n" +
                "        </getWeatherbyCityName>\n" +
                "    </soap12:Body>\n" +
                "</soap12:Envelope>";


//        StringBuffer stringBuffer = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:com=\"http://com.foresee.top.service/\">\n" +
//                "  <soapenv:Body>\n" +
//                "    <ns1:doService xmlns:ns1=\"http://cn.gov.chinatax.gt3nf.nfzcpt.service/\">\n" +
//                "      <reqXml><![CDATA[<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "<tiripPackage xmlns:xsi=\"http://www.w3.org/2001/XMLSchema\" version=\"1.0\" xsi:type=\"tiripPackage\">\n" +
//                "  <sessionId/>\n" +
//                "  <service>\n" +
//                "    <sid>" + sid + "</sid>\n" +
//                "    <version>1.0</version>\n" +
//                "    <tranSeq>+" + tranSeq + "</tranSeq>\n" +
//                "    <tranReqDate>" + tranReqDate + "</tranReqDate>\n" +
//                "  </service>\n" +
//                "  <bizContent>\n" +
//                "    <content>" + content + "</content>\n" +
//                "    <paramList>\n" +
//                "      <param>\n" +
//                "        <name>docType</name>\n" +
//                "        <value>json</value>\n" +
//                "      </param>\n" +
//                "      <param>\n" +
//                "        <name>className</name>\n" +
//                "        <value>GGG</value>\n" +
//                "      </param>\n" +
//                "    </paramList>\n" +
//                "  </bizContent>\n" +
//                "</tiripPackage>\n" +
//                "]]></reqXml>\n" +
//                "    </ns1:doService>\n" +
//                "  </soapenv:Body>\n" +
//                "</soapenv:Envelope>");
//        return stringBuffer.toString();
    }




}
