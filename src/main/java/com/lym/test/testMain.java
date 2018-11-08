package com.lym.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class testMain {
	public static void main(String[] args) throws IOException, InterruptedException {
		String urlStr="https://club.autohome.com.cn/bbs/thread/c3f9d0c916883655/75745008-1.html";
		Document doc=Jsoup.connect(urlStr).postDataCharset("utf-8").get();
		String tMaxTitle=doc.select(".maxtitle").html().toString();
		System.out.println(tMaxTitle);
		
	}
}
