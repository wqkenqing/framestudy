package com.test;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * Created by wqkenqing on 2017/6/6.
 */
public class JsoupStudy {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.wqkenqing.ren").get();
        Elements ahrefs = doc.select("a");

        for (Element element : ahrefs) {
            //取提的是a标签中的href值
            String href = element.attr("abs:href");
            if (href.contains("http://www.wqkenqing.ren/article") && !href.contains("comment")) {
                doc = Jsoup.connect(href).get();
                element = doc.getElementById("post-content").getElementsByTag("p").get(1);
                System.out.println("---------以下是" + href + "的内容--------");
                System.out.println(element.text());
                System.out.println("----------------------------------------");
            }
        }


    }

}
