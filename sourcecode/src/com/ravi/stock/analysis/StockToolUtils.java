package com.ravi.stock.analysis;

import java.util.ArrayList;
import java.util.List;

public class StockToolUtils {
public static List<Double> getProfitOrLossAtUserSelectDateAndFrequency(List<String> dateList,List<Double> stockHighPrice,List<Double> stockClosePrice,int frequency,String date){
	int tradeIndex=getTradeIndex(dateList, date);
	int iterator=0;
	List<Double> highestClosingPrices =  new ArrayList<Double>();
	for( iterator=tradeIndex;iterator<=dateList.size()-1;){
		iterator = iterator + frequency;
		if(iterator<dateList.size()){
		highestClosingPrices.add(StockUtils.getHighestClosingPrice(stockClosePrice.subList(tradeIndex, iterator)));
		}		
		tradeIndex=iterator;
	}
	return highestClosingPrices;
}
public static int getTradeIndex(List<String> dateList,String date){
	int tradeIndex=0;
	for(int i=0;i<=dateList.size()-1;i++){
		if(dateList.get(i).equalsIgnoreCase(date)){
			tradeIndex=i;
		}
	}
	return tradeIndex;
}
public static Double getBuyPrice(List<String> dateList,String date,List<Double> stockHighPrice){
	return stockHighPrice.get(getTradeIndex(dateList, date));
}
}
