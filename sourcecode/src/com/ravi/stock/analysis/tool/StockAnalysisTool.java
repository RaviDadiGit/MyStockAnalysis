package com.ravi.stock.analysis.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class StockAnalysisTool {
	static StringBuilder filePath = new StringBuilder("D:\\stocks\\");
	public static void main(String[] args) {
		System.out.println("Enter your stock name");
		Scanner sc = new Scanner(System.in);
		String stockName = sc.next();		
		String excelFilePath = getStockPath(stockName);
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
			List<Double> numOfStocks = new ArrayList<Double>();
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
						case 7:
							numOfStocks.add(cell.getNumericCellValue());
						}
					}
				}
			}
			System.out.println(getLastFiveDaysLowPricesOfStock(stockLowPrice));
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
	public static List<Double> getLastFiveDaysLowPricesOfStock(List<Double> stockLowPrice){
		List<Double> lastFiveDaysLowPrices =  new ArrayList<Double>();
	for(int i=stockLowPrice.size()-1;i>=stockLowPrice.size()-5;i--){
		lastFiveDaysLowPrices.add(stockLowPrice.get(i));
	}
		return lastFiveDaysLowPrices;
	}
	static String getStockPath(String stockName){
		if(stockName.equalsIgnoreCase("infy")){
			filePath.append("INFY.NS .xls");
		}
		return filePath.toString();
	}
	
}
