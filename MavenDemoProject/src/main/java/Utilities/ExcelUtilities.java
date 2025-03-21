package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;   //dependency (classes and Interfaces ) no direct run libraries provided by JDK so using thirdparty libraries Apache POI(excel read write /word read write/powerpoint read write)
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constant.Constants;

public class ExcelUtilities {

static FileInputStream f;
static XSSFWorkbook wb; //provided by apache poi
static XSSFSheet sh; //provided by apache poi

public static String getStringData(int i, int j, String sheet) throws IOException {
		String filepath = Constants.TESTDATAFILE;  //to read string data
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}
public static String getIntegerData(int i, int j, String sheet) throws IOException {
		String filepath = Constants.TESTDATAFILE; //to read integer data
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int x = (int) c.getNumericCellValue();
		return String.valueOf(x);
	}
}
