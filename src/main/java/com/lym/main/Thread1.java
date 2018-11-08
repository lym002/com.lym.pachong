package com.lym.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.lym.pojo.receiver;
import com.lym.util.poiUtil;

public class Thread1 extends Thread{
	private String urlStr;
	public Thread1(String urlStr){
		this.urlStr=urlStr;
	}
	private static int dnamicpage;
	public void run(){
		String urlSub=urlStr.substring(0, urlStr.length()-6);
		String urlStr1=urlStr.substring(urlStr.length()-6);
		String urlStr2=urlStr1.substring(0,urlStr1.length()-5);
		dnamicpage=Integer.valueOf(urlStr2);
		List<receiver> list = null;
   try {
	list = getInfor
		//替换引号内的网址
	  (urlStr,
		//替换最大页数	  
		dnamicpage+2,urlSub);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   try {
	poiUtil.toExcel(list);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
//可以指定网址，并且按照需求爬取前多少页的数据
public static List<receiver> getInfor(String url,int maxPage,String urlSub) throws InterruptedException, IOException{
   List<receiver> proList=new ArrayList<receiver>();
   for(int i=dnamicpage+1;i<=maxPage+1;i++){
	Document doc=Jsoup.connect(url).get();
	//Document doc = Jsoup.parse("utf-8", url);
	Elements table=doc.select(".conmain");
	Elements tbody=table.select(".clearfix");
	
	//遍历用户
	List<String>userList=new ArrayList<String>();
	//遍历回复内容
	List<String>receiveList=new ArrayList<String>();
	for (int i1 = 0; i1 <22; i1++) {
		//用户
		String tuser=tbody.select(".txtcenter").select("a.c01439a").eq(i1).attr("title");
		tbody.select(".txtcenter").select("a.c01439a").eq(i1).attr("title");
		userList.add(tuser);
		//内容
		boolean choose = tbody.select(".rconten").eq(i1).text().contains("本楼已被管理员删除");
		String treceive=tbody.select(".conright").select(".w740").eq(i1).text();
		if(choose){
			receiveList.add("本帖被删");
		}
		receiveList.add(treceive);
	}
	
	
	Elements ttitle=table.select(".qa-maxtitle");
	Elements treadcount=doc.select(".consnav").select(".fr").select("#x-views");
	Elements treceivercount=doc.select(".consnav").select(".fr").select("#x-replys");
	
	for(int i1=0;i1<22;i1++){
		receiver product=new receiver();
		product.setTitol(ttitle.html().toString());
		product.setProducer(userList.get(i1).toString());
		product.setType("macan");
		product.setReceive(receiveList.get(i1).toString());
		product.setReProducer(userList.get(i1).toString());
		product.setReadCount(treadcount.html().toString());
		product.setReceiveCount(treceivercount.html().toString());
		proList.add(product);
	}
	
	System.out.println(receiveList+"="+i);
	
   url=urlSub+i+".html";
   }
   System.out.println("爬取前"+maxPage+"成功");
   return proList; 
	}
}
