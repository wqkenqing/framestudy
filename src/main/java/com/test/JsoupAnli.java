package com.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
*@className:JsoupAnli
*@author:wqkenqing
*@describe:通过jsoup爬取安理学校新闻稿
*@date:2017/6/6
**/
public class JsoupAnli {
    public void test() throws IOException {
        Document doc = Jsoup.connect("http://news.aust.edu.cn/xxxw.htm").get();
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
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://news.aust.edu.cn/xxxw.htm").get();
        Elements elements = doc.select("a");
        int i = 1;
        for (Element element : elements) {
            String href = element.attr("abs:href");
            if (href.contains("http://news.aust.edu.cn/info/")) {
                doc = Jsoup.connect(href).get();
                System.out.println("-----------the news------");
                String title=doc.getElementsByClass("list-textT").text();
                String time = doc.getElementsByClass("list-infor").text();
                String content = doc.getElementById("vsb_content").text();
                System.out.println("titile:" + title);
                System.out.println("time:" + time);
                System.out.println("content:" + content);
                System.out.println("------------end-----------");
                i++;
            }
        }
        System.out.println("总共有"+i+"篇文章");
    }
}
