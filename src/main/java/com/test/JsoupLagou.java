package com.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
*@className:JsoupLagou
*@author:wqkenqing
*@describe:尝试爬取拉勾网的内容
*@date:2017/6/6
**/
public class JsoupLagou {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.lagou.com").get();
        Elements elements = doc.select("a");
        List<String> gongsiList = new ArrayList<String>();
        List<String> jobList = new ArrayList<String>();
        for (Element element : elements) {
            String href = element.attr("abs:href");
            if (href.contains("gongsi")) {
                gongsiList.add(href);
            } else if (href.contains("job")) {
                jobList.add(href);
            }
        }
        System.out.println("共计" + gongsiList.size() + "家公司");
        System.out.println("共计" + jobList.size() + "份工作");
        System.out.println(gongsiList);
        System.out.println(jobList);

    }
}
