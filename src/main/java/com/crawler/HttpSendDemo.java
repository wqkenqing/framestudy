package com.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.json.JSONObject;

/**
 * Created by wqkenqing on 2017/6/1.
 */
public class HttpSendDemo extends BreadthCrawler {

    /**
     * 构造一个基于伯克利DB的爬虫
     * 伯克利DB文件夹为crawlPath，crawlPath中维护了历史URL等信息
     * 不同任务不要使用相同的crawlPath
     * 两个使用相同crawlPath的爬虫并行爬取会产生错误
     *
     * @param crawlPath 伯克利DB使用的文件夹
     * @param autoParse 是否根据设置的正则自动探测新URL
     */
    public HttpSendDemo(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        addSeed(new CrawlDatum("http://www.wqkenqing.ren").meta("method","get"));
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String jsonStr = page.html();
        JSONObject json = new JSONObject(jsonStr);
        System.out.println("JSON信息：" + json);
    }

    public static void main(String[] args) {
        HttpSendDemo httpSendDemo = new HttpSendDemo("hsend", true);
        try {
            httpSendDemo.start(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
