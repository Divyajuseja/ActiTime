package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelib {

	
		/**
		 * this method is generic method used to read data frome property file
		 * @param Keys
		 * @return
		 * @throws IOException
		 */
		public String readDataFrompropertyFile(String Key) throws IOException {
			FileInputStream fis =new FileInputStream(".Testdata/commondata1.property");
			Properties p =new Properties();
			p.load(fis);
			String data =p.getProperty(Key);
			return data;
			
			
		}
		
		/**
		 * this method is generic method used to read data from excel file
		 * @param sheet
		 * @param Row
		 * @param cell
		 * @return
		 * @throws IOException
		 * @throws InvalidFormatException 
		 */
		public String readDataFromExcelFile(String sheet,int Row,int cell) throws IOException, InvalidFormatException {
			FileInputStream fis =new FileInputStream(".Testdata/TestDataStudent.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String data = wb.getSheet(sheet).getRow(Row).getCell(cell).getStringCellValue();
			return data;
		
		}
	}
	
	


