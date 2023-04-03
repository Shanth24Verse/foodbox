package com.foodbox.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.foodbox.model.Item;



public class Helper {
	public static boolean checkExelFormat(MultipartFile file) {
		String contentType = file.getContentType();
		if(contentType=="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") {
			return true;
		}
		else
			return true;
	}
	
	
	//Converts excel to list of items
	 public static List<Item> convertExcelToListOfProducts(InputStream is){
		 List<Item> list = new ArrayList<Item>();
		 try {
			 
			@SuppressWarnings("resource")
			XSSFWorkbook workbook= new XSSFWorkbook(is);
			XSSFSheet sheet= workbook.getSheet("Sheet1");
			
			int rowNumber=0;
			Iterator<Row> iterator = sheet.iterator();
			while(iterator.hasNext()) {
				Row row = iterator.next();
				if(rowNumber==0)
				{
					rowNumber++;
					continue;
				}
				
				Iterator<Cell> cells = row.iterator();
				int cid=0;
				Item pdt =new Item();
				
				while(cells.hasNext()) {
					Cell cell = cells.next();
					
					switch(cid)
					{
					case 0:
						pdt.setName(cell.getStringCellValue());
						break;
					
					case 1:
						pdt.setPrice(cell.getNumericCellValue());
						break;
					case 2:
						pdt.setUrl(cell.getStringCellValue());
						break;
					case 3:
						pdt.setQuantity((int)cell.getNumericCellValue());
						break;
					case 4:
						pdt.setCatagory(cell.getStringCellValue());
						break;
					default :
						break;
					}
					cid++;
				}
				list.add(pdt);
				
			}
			
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return list;
	 }
	
}
