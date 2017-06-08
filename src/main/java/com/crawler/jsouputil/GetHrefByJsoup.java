package com.crawler.jsouputil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
*@className:GetHrefByJsoup
*@author:wqkenqing
*@describe:通过jsoup获取url
*@date:2017/6/7
**/
public class GetHrefByJsoup {
    public static void main(String[] args) {
        Document doc=null;
        String filename = "lagou";
        try {
             doc= Jsoup.connect("https://www.lagou.com/gongsi/j60152.html").get();
            Element element = doc.getElementById("posfilterlist_container");
            System.out.println(element);
            Elements elements = doc.getElementsByTag("li");
            System.out.println(elements);
        } catch (Exception e) {
            System.out.println("this is exception" + e);
        }

    }
}
