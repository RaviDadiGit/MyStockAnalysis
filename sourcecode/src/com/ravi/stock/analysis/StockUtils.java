package com.ravi.stock.analysis;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockUtils {
public static Map<String, Double> getStockHighPercentage(List<Double> stockOpenPrice,List<Double> stockHighPrice,List<String> dateList){
	Map<String, Double> stockGrowthMap = new HashMap<String, Double>();
	for(int i=0;i<=stockOpenPrice.size()-1;i++){
		stockGrowthMap.put(dateList.get(i), stockHighPrice.get(i)/stockOpenPrice.get(i));
	}
	return stockGrowthMap;
}
public static Map<String, Double> getStockLowPercentage(List<Double> stockOpenPrice,List<Double> stockLowPrice,List<String> dateList){
	Map<String, Double> stockLossMap = new HashMap<String, Double>();
	for(int i=0;i<=stockOpenPrice.size()-1;i++){
		stockLossMap.put(dateList.get(i), stockOpenPrice.get(i)/stockLowPrice.get(i));		
	}
	return stockLossMap;
}
}
