package com.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @className:TestSend
 * @author:wqkenqing
 * @describe:模拟高并发请求
 * @date:2017/6/5
 **/
public class TestSend {
    InputStream in = null;
    String result = "";
    String urlPath = "";//要请求的url
    String method = "";
    String header = "";
    String accept = "*/*";
    String connect = "Keep-Alive";
    String agent = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)";

    //action 1、设置请求，2、发送请求 3、接受响应
    public URLConnection setRequest(String urlp, String connect, String accept, String agent) throws IOException {
        URL url = new URL(urlPath);
        URLConnection connection = url.openConnection();
        // 设置通用的请求属性
        connection.setRequestProperty("accept", accept);

        connection.setRequestProperty("connection", connect);

        connection.setRequestProperty("user-agent", agent);
        return connection;
    }

    public URLConnection sendRequst(URLConnection connection) throws IOException {
        connection.connect();
        return connection;
    }

    public void recieveReponse(URLConnection connection) throws IOException {
        in = connection.getInputStream();
        Document document = Jsoup.parse(in, "UTF-8","");
       Elements elements= document.getElementsByClass("post-lists-body");
        System.out.println(elements);
//        System.out.println(document.body());

//        System.out.println(result);
    }

    public static String stream2String(InputStream in, String charset) {
        StringBuffer sb = new StringBuffer();
        try {
            Reader r = new InputStreamReader(in, charset);
            int length = 0;
            for (char[] c = new char[1024]; (length = r.read(c)) != -1; ) {
                sb.append(c, 0, length);
            }
            r.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        TestSend testSend = new TestSend();
        testSend.urlPath = "http://www.wqkenqing.ren";

        URLConnection connection = testSend.setRequest(testSend.urlPath, testSend.connect, testSend.accept, testSend.agent);
        connection = testSend.sendRequst(connection);

        testSend.recieveReponse(connection);


    }


}
