package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	String filepath = "./TestData/Excel1.xlsx";
	
	FileInputStream f;
	FileOutputStream fout;
	Workbook wb;
	Sheet sh;
	CellStyle style;
	public ExcelData() throws IOException {
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
	}
	
	public int total_rows(int sheetindex) {
		sh = wb.getSheetAt(sheetindex);
		return sh.getLastRowNum()+1;
	}
	
	public int total_columns(int sheetindex) {
		sh = wb.getSheetAt(sheetindex);
		Row r = sh.getRow(0);
		return r.getLastCellNum();
	}
	
	public String read_cell(int row, int cell, int sheetindex) {
		sh = wb.getSheetAt(sheetindex);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		return c.getStringCellValue();
	}
	
	public void set_cell(int row,int cell,String actual, int sheetindex) throws IOException {
		sh = wb.getSheetAt(sheetindex);
		Row r = sh.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(actual);
		fout = new FileOutputStream(filepath);
		wb.write(fout);
	}
	
	public void set_cell_fillcolor_Green(int row,int cell, int sheetindex) throws IOException {
		sh = wb.getSheetAt(sheetindex);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		c.setCellStyle(style);
		fout = new FileOutputStream(filepath);
		wb.write(fout);
	}
	
	public void set_cell_fillcolor_Red(int row,int cell, int sheetindex) throws IOException {
		sh = wb.getSheetAt(sheetindex);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		c.setCellStyle(style);
		fout = new FileOutputStream(filepath);
		wb.write(fout);
	}
	
	public void file_close() throws IOException {
		wb.close();
		f.close();
	}

}