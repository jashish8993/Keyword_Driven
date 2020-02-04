package Utility;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Keyword.KeywordDefn;

public class utilities extends BaseClass {
	KeywordDefn key=new KeywordDefn();
	File src;
	FileInputStream fis;
	String fpath=System.getProperty("user.dir") + "\\ashish.xls";
	HSSFWorkbook wb;
	HSSFSheet ws;
	HSSFRow row;
	HSSFCell cell;
	
	
	@Test
	public void  getData() throws  Exception
	{
		String Element;
		String ObjectLocator;
		String Data;
		String Object;
		src=new File(fpath);
		fis=new FileInputStream(src);
		wb=new HSSFWorkbook(fis);
		ws=wb.getSheetAt(0);
		int rowcount=ws.getLastRowNum();
		//int colcount=ws.getRow(rowcount).getLastCellNum();
		int k=0;
		for(int i=0;i<rowcount;i++)
		{
			row=ws.getRow(i+1);
			Element=row.getCell(k+1).toString().trim();
			ObjectLocator=row.getCell(k+2).toString().trim();
			Data=row.getCell(k+3).toString().trim();
			Object=row.getCell(k+4).toString().trim();
			
		//	System.out.println(Element+ "  ---- " +ObjectLocator+ "===" +Data+ "====" + Object);
				
			switch(Element)
			
			{
			case "Navigate"  : 
			{
				//System.out.println(d);
				key.navigate(driver,Data);
	//			logger.info("url is opened");
				break;
			}
			case "InputText" : 
			{
				key.send_keys(driver,ObjectLocator,Data,Object);
				break;
			}
			case "Click" :
			{
				key.click(driver,ObjectLocator,Object);
				break;
			}
			case "Quit" :
			{
				key.quit(driver);
				break;
			}
			case "Select":
			{
				key.Select(driver,Data,ObjectLocator,Object);
				break;
			}
			case "IWait":
			{
				key.IWait(driver, Data);
				break;
			}
			case "Close":
			{
				key.Close(driver);
				break;
			}
			case "Gettext":
			{
				key.gettext(driver,Object,ObjectLocator);
				break;
			}
			case "Submit":
			{
				key.submit(driver,ObjectLocator);
				break;
			}
			case "Forward":
			{
				key.forward(driver);
				break;
			}
			case "Back":
			{
				key.back(driver);
				break;
			}
			case "Title":
			{
				key.Title(driver);
				break;
			}
			case "Currenturl":
			{
				key.curl(driver);
				break;
			}
			case "Radiobutton":
			{
				key.radiob(driver,ObjectLocator);
				break;
			}
			case "Checkbox":
			{
				key.checkbox(driver,ObjectLocator);
				break;
			}
			case "EWait":
			{
				key.Ewait(driver,ObjectLocator,Data,Object);
			}

			default:
			{
				//logger.info("you have entered a incorrect keyword");
			}

			
			
			}
			
		}
		
		
	

	}



}
