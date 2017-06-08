package com.spider;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HttpClient;

import java.io.*;

/**
 * @className:SpiderDemo
 * @author:wqkenqing
 * @describe:爬虫demo
 * @date:2017/5/31
 **/
public class SpiderDemo {
    private static HttpClient httpClient = new HttpClient();

    public static boolean downloadPage(String path) throws Exception {
        // 定义输入输出流
        InputStream input = null;
        OutputStream output = null;
        // 得到 post 方法
        GetMethod getMethod = new GetMethod(path);
        // 执行，返回状态码
        int statusCode = httpClient.executeMethod(getMethod);
        // 针对状态码进行处理
        // 简单起见，只处理返回值为 200 的状态码
        if (statusCode == HttpStatus.SC_OK) {
            input = getMethod.getResponseBodyAsStream();
            // 通过对URL的得到文件名
            String filename = path.substring(path.lastIndexOf('/') + 1)
                    + ".html";
            // 获得文件输出流
            System.out.println(filename);
            output = new FileOutputStream(filename);
            // 输出到文件
            int tempByte = -1;
            while ((tempByte = input.read()) > 0) {
                output.write(tempByte);
            }
            // 关闭输入流
            if (input != null) {
                input.close();
            }
            // 关闭输出流
            if (output != null) {
                output.close();
            }
            return true;
        }
        return false;
    }

    public static void analysisNet(String path) throws IOException {
        InputStream fin = null;
        FileOutputStream fout = null;
        GetMethod getMethod = new GetMethod(path);
        int statusCode = httpClient.executeMethod(getMethod);
        if (statusCode == 200) {
            fin = getMethod.getResponseBodyAsStream();

            String networkContent=stream2String(fin, "utf-8");
            System.out.println(networkContent);
        }
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
//        try {
//            System.out.println("------------testing-------");
//            // 抓取百度首页，输出
//            SpiderDemo.downloadPage("http://www.wqkenqing.ren");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        analysisNet("http://www.wqkenqing.ren");

        System.out.println("end");
    }
}
