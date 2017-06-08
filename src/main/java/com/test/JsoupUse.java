package com.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * @className:JsoupUse
 * @author:wqkenqing
 * @describe:针对csdn的一个实站
 * @date:2017/6/6
 **/
public class JsoupUse {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://blog.csdn.net/qq_30353203").get();
        Elements elements = doc.select("a");
        int i = 1;
        for (Element element : elements) {
            String href = element.attr("abs:href");
            if (href.contains("http://blog.csdn.net/qq_30353203/article/details") && !href.contains("comment")) {
                doc = Jsoup.connect(href).get();

                System.out.println("------------this is njl's blog--------------");
                System.out.println(doc.getElementById("article_content").text());
                System.out.println();
                System.out.println("--------------------------------------------");
                i++;
            }
        }
        System.out.println("njl'blog 总共"+i+"篇博客");
    }

}