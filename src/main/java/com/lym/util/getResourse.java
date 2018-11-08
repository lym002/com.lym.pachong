package com.lym.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class getResourse {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://club.autohome.com.cn/bbs/thread/530176a04deed6fd/73786027-1.html###")
				.timeout(60000).get();

		Elements table = doc.select(".conmain");
		Elements tbody = table.select(".clearfix");
		// 遍历用户
		/*
		  List<String>userList=new ArrayList<String>(); for (int i = 0; i < 18;
		  i++) { Elements tuser=tbody.select(".txtcenter").select("a").eq(i);
		  String str=tuser.toString(); userList.add(str); }
		 
		*/
		/*  List<String>userList=new ArrayList<String>(); 
		  for (int i1 = 0; i1<21; i1++) { 
			  //String choose=tbody.select(".txtcenter").select("div.lv_card").select("span").eq(i1).text();
			  boolean choose=doc.select(".identity").eq(i1).contains("关禁闭");
			  String tuser=tbody.select(".txtcenter").select(".fw").select("a.c01439a").eq(i1).attr(
					  "title");
			 System.out.println(choose);
			  System.out.println(tuser);
		  userList.add(tuser);
		  
		  } for (String string : userList) {
		  
		  //System.out.println(string);
		  
		  }*/
		String treceive = tbody.select(".conright").select(".w740").eq(19).text();
		System.out.println(treceive);
		// 遍历回复内容
		List<String> receiveList = new ArrayList<String>();
		for (int i = 0; i < 21; i++) {
			String treceive1 = tbody.select(".w740").eq(i).text();
			String str =tbody.select(".w740").eq(i).text();
			
			receiveList.add(str);
			
			//System.out.println(str);
		}
		Elements ttitle = table.select(".qa-maxtitle");
		Elements treadcount = doc.select(".consnav").select(".fr").select("#x-views");
		Elements treceivercount = doc.select(".consnav").select(".fr").select("#x-replys");

	}
}
