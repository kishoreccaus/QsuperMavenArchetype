package com.TestMavenArchetype.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
/*import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;*/
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class Archetype_Generic {
	
	static Workbook wb=null;
	static String sheetname=null;
	
	public static String getPropertyValue(String PropertyName){
		
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(".\\Automation.properties");
		} catch (FileNotFoundException e){
			System.out.println("Properties File not found");
		}
		Properties Prop=new Properties();
		try {
			Prop.load(fis);
		} catch (IOException e) {
			System.out.println("Unable to load the Properties File");
		}
		String PropertyValue=Prop.getProperty(PropertyName);
		
		return PropertyValue;
		
	}
	 public static int getRowsandColumnsCount(String SheetName)
	 {
		 	int rowCount = Archetype_SuperTestng.xlsReader.getRowCount(SheetName);
			int colCount =Archetype_SuperTestng.xlsReader.getColumnCount(SheetName);
			System.out.println("Total No. of Rows are "+rowCount);
			System.out.println("Total No. of Cols are "+colCount);
			return rowCount;
	 }
	 
	 public static String getData(String sheetname,int row_Num, int col_Num)
	 	{	
			DataFormatter formatter = new DataFormatter();
			String Data= formatter.formatCellValue(wb.getSheet(sheetname).getRow(row_Num).getCell(col_Num));
			//String Data = wb.getSheet(sheetname).getRow(row_Num).getCell(col_Num).getStringCellValue();
			return Data;			
		}
	public void enterLog(String S){
		/*Logger log = Logger.getLogger(this.getClass().getSimpleName());
		Properties properties = new Properties();
		properties.put("log4j.rootLogger", "INFO,Console,File");
		properties.put("log4j.appender.Console", "org.apache.log4j.ConsoleAppender");
		properties.put("log4j.appender.Console.layout", "org.apache.log4j.PatternLayout");
		properties.put("log4j.appender.Console.layout.ConversionPattern", "%-4r [%d] [%-5p] [%c %x] - %m%n");
		properties.put("log4j.appender.File", "org.apache.log4j.FileAppender");
		properties.put("log4j.appender.File.file","logs/Guru99_Kalipat.txt");
		properties.put("log4j.appender.File.layout","org.apache.log4j.PatternLayout");
		properties.put("log4j.appender.File.layout.ConversionPattern","%-4r [%d] [%-5p] [%c %x] - %m%n");
		PropertyConfigurator.configure(properties);
		log.info(S);*/
		}
	
	public void captureSS(WebDriver driver,String Message) throws IOException 
	  { 
		  EventFiringWebDriver e1=new EventFiringWebDriver(driver);
		  File f1=e1.getScreenshotAs(OutputType.FILE);
		  //String Class_Name = this.getClass().getSimpleName();
		  String date= new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		  String directoryName =".\\screenshots\\"+date;
		  File theDir = new File(directoryName);
		  
		   // if the directory does not exist, create it
		   if (!theDir.exists())
		   {
			   theDir.mkdir();
		   }

		   File f2=new File(directoryName +"\\"+ Message+".png");
		  /*String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  File f2=new File(".\\screenshot\\"+Class_Name+timeStamp+".png");*/
		  FileUtils.copyFile(f1, f2);
		}
}
