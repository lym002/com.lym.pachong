package com.lym.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import com.lym.pojo.receiver;
public class poiUtil {
	
		public static void toExcel(List<receiver> list) throws FileNotFoundException, IOException{
			 
	        //新建文档   
	        XSSFWorkbook workBook=new XSSFWorkbook();
	        
	        //创建表
	        XSSFSheet sheet=workBook.createSheet();
	        
	           //合并标的标题
	      		CellRangeAddress cra=new CellRangeAddress(0,1, 0, 6);
	      		sheet.addMergedRegion(cra);
	      		//显示的文本为左上角的内容
	      		Row row2=sheet.createRow(0);
	      		Cell cell=row2.createCell(0);
	      		cell.setCellValue("工作表");
	      		//设置单元格的格式
	      		CellStyle cs=workBook.createCellStyle();
	      		cs.setAlignment(HorizontalAlignment.CENTER);
	      		cs.setVerticalAlignment(VerticalAlignment.CENTER);
	      		cs.setFillBackgroundColor((short) 59);
	      	        cell.setCellStyle(cs);
	      		//表头
	      		Row row=sheet.createRow(2);
	      		
	      		Cell cell11=row.createCell(0);
	      		cell11.setCellValue("标题");
	      		Cell cell22=row.createCell(1);
	      		cell22.setCellValue("作者");
	      		Cell cell33=row.createCell(2);
	      		cell33.setCellValue("用车");
	      		Cell cell44=row.createCell(3);
	      		cell44.setCellValue("回复内容");
	      		Cell cell55=row.createCell(4);
	      		cell55.setCellValue("回复人");
	      		Cell cell66=row.createCell(5);
	      		cell66.setCellValue("阅读量");
	      		Cell cell77=row.createCell(6);
	      		cell77.setCellValue("回复量");
	      	    //表中的数据
	        for(int i=0;i<list.size();i++){
	        //创建行
	        XSSFRow row4=sheet.createRow(i+3);
	  
	        //创建单元格
	        XSSFCell cell1=row4.createCell(0);
	        XSSFCell cell2=row4.createCell(1);
	        XSSFCell cell3=row4.createCell(2);
	        XSSFCell cell4=row4.createCell(3);
	        XSSFCell cell5=row4.createCell(4);
	        XSSFCell cell6=row4.createCell(5);
	        XSSFCell cell7=row4.createCell(6);
	        	//在单元格中写入数据
	        cell1.setCellValue(list.get(i).getTitol());
	        cell2.setCellValue(list.get(i).getProducer());
	        cell3.setCellValue(list.get(i).getType());
	        if(!list.get(i).getReceive().equals("本帖被删")) {
				cell4.setCellValue(list.get(i).getReceive());
			}else{
				XSSFFont xf=workBook.createFont();
				XSSFCellStyle style = workBook.createCellStyle();
				xf.setColor(IndexedColors.RED.index);
				style.setFont(xf);
				cell4.setCellStyle(style);
				cell4.setCellValue(list.get(i).getReceive());
			}
	        cell5.setCellValue(list.get(i).getReProducer());
	        cell6.setCellValue(list.get(i).getReadCount());
	        cell7.setCellValue(list.get(i).getReceiveCount());
	        }
	         //把这个文档写入文件
	        workBook.write(new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\ .xlsx")));
	        System.out.println("写入excel完毕");
	        //关闭流
	        workBook.close();
			
		}
	     
}
