package Web.webApplication;
import java.io.FileInputStream;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class reader {

	public ArrayList<String>  MyExcel(int column)throws IOException {
		
		FileInputStream fis = new FileInputStream("/WebApp/src/main/java/TestData/Reader.xlsx");
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		
		XSSFSheet s = wb.getSheet("sheet1");
		
		Iterator<Row> rowIt=s.iterator();
		
		rowIt.next();
		
		ArrayList<String> list=new ArrayList<String>();
		
		while(rowIt.hasNext()) {
			
			list.add(rowIt.next().getCell(column).getStringCellValue());	
		
		}
		
		System.out.println("List ::: "+list);
		return list;
	}


}
