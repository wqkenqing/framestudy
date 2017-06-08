package com.test;

import com.common.EmailProduct;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @className:JsoupAbout
 * @author:wqkenqing
 * @describe:尝试搂取about云
 * @date:2017/6/8
 **/
public class JsoupAbout {
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        String path1 = "/Users/wqkenqing/Desktop/aboutyun_index.txt";
        String indexString = getIndex();
        String guideContent = getGuide();
        String receiver = "wangkuiqing@mocentre.com";
        String desc = "测试";

        EmailProduct email = new EmailProduct(receiver, desc, indexString, path1);
        email.start();
        System.out.println("------邮件发送成功------");
//        String path1 = "/Users/wqkenqing/Desktop/aboutyun_index.txt";
//        String path2 = "/Users/wqkenqing/Desktop/aboutyun_guide.txt";
//        fileproduct(indexString,path1);
//        fileproduct(guideContent,path2);
//        System.out.println("输出完成");

    }

    public static String getIndex() throws IOException {
        StringBuffer sb = new StringBuffer();
        Document doc = Jsoup.connect("http://www.aboutyun.com").get();
        Elements elements = doc.getElementsByClass("nge_thread");
        for (Element element : elements) {
            Elements elements_a = element.select("a");
            for (Element e : elements_a) {
                String href = e.attr("href");
                String name = e.text();
                sb.append(name);
                sb.append("\t");
                sb.append(href);
                sb.append("\n");
            }
            System.out.println();
        }
        return sb.toString();
    }

    public static String getGuide() throws IOException {
        //最后结果应为map
        StringBuffer guideBuffer = new StringBuffer();
        Document doc = Jsoup.connect("http://www.aboutyun.com/forum.php?mod=guide&view=hot&page=1").get();
        Elements elements = doc.select("a");
        List<String> hrefList = new ArrayList<String>();
        Set<String> annameList = new TreeSet<String>();
        Map<String, Object> hrefMap = new HashMap<String, Object>();
        JSONObject jsonObj = null;
        for (Element e : elements) {

            String file_name = e.getElementsByClass("xst").text();
            if (!StringUtil.isBlank(file_name)) {
                String href = e.getElementsByClass("xst").attr("href");
                guideBuffer.append(file_name);
                guideBuffer.append("\t");
                guideBuffer.append(href);
                guideBuffer.append("\n");
            }
        }
        return guideBuffer.toString();
    }

    public static void fileproduct(String allhref, String path) throws FileNotFoundException {

        OutputStream out = new FileOutputStream(path);
        try {
            out.write(allhref.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
