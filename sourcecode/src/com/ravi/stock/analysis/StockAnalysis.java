package com.ravi.stock.analysis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class StockAnalysis {

	public static void main(String[] args) {
		String excelFilePath = "D:\\stocks\\INFY.NS.xls";
		FileInputStream inputStream;
		Workbook workbook = null;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));
			workbook = new HSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();
			
			List<String> dateList = new ArrayList<String>();
			List<Double> stockOpenPrice = new ArrayList<Double>();
			List<Double> stockClosePrice = new ArrayList<Double>();
			List<Double> stockHighPrice = new ArrayList<Double>();
			List<Double> stockLowPrice = new ArrayList<Double>();
			List<Double> stockVolume = new ArrayList<Double>();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if (nextRow.getRowNum() != 0) {
					Iterator<Cell> cellIterator = nextRow.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getColumnIndex()) {
						case 0:
							dateList.add(cell.getStringCellValue());
							break;
						case 1:
							stockOpenPrice.add(cell.getNumericCellValue());
							break;
						case 2:
							stockHighPrice.add(cell.getNumericCellValue());
							break;
						case 3:
							stockLowPrice.add(cell.getNumericCellValue());
							break;
						case 4:
							stockClosePrice.add(cell.getNumericCellValue());
							break;
						case 6:
							stockVolume.add(cell.getNumericCellValue());
							break;
						}
					}
				}
			}
//			System.out.println(dateList);
//			System.out.println(stockOpenPrice);
//			System.out.println(stockHighPrice);
//			System.out.println(stockLowPrice);
//			System.out.println(stockClosePrice);
//			System.out.println(stockVolume);
			System.out.println(StockUtils.getStockHighPercentage(stockOpenPrice, stockHighPrice,dateList));
			System.out.println(StockUtils.getStockLowPercentage(stockOpenPrice, stockLowPrice,dateList));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
