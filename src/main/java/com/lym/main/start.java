package com.lym.main;
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.lym.pojo.receiver;
import com.lym.util.poiUtil;
 
/**  作者：lym 
*    日期：2018年10月24日 下午7:11:20
*/

public class start {
       public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
       Thread1 thread1=new Thread1("https://club.autohome.com.cn/bbs/thread/1748254267dea261/66728314-1.html");
       thread1.start();
       }
}
