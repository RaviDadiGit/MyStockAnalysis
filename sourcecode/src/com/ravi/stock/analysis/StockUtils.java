package com.ravi.stock.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockUtils {
	public static Map<String, Double> getStockHighPercentage(
			List<Double> stockOpenPrice, List<Double> stockHighPrice,
			List<String> dateList) {
		Map<String, Double> stockGrowthMap = new HashMap<String, Double>();
		for (int i = 0; i <= stockOpenPrice.size() - 1; i++) {
			stockGrowthMap.put(dateList.get(i), stockHighPrice.get(i)
					/ stockOpenPrice.get(i));
		}
		return stockGrowthMap;
	}

	public static Map<String, Double> getStockLowPercentage(
			List<Double> stockOpenPrice, List<Double> stockLowPrice,
			List<String> dateList) {
		Map<String, Double> stockLossMap = new HashMap<String, Double>();
		for (int i = 0; i <= stockOpenPrice.size() - 1; i++) {
			stockLossMap.put(dateList.get(i), stockOpenPrice.get(i)
					/ stockLowPrice.get(i));
		}
		return stockLossMap;
	}

	public static Double getHighestClosingPrice(List<Double> stockClosePrice) {
		List<Double> stockClosePriceDup = new ArrayList<Double>();
		stockClosePriceDup.addAll(stockClosePrice);
		Collections.sort(stockClosePriceDup);
		return stockClosePriceDup.get(stockClosePriceDup.size() - 1);
	}

	public static Double getHighestHighPrice(List<Double> stockHighPrice) {
		List<Double> stockHighPriceDup = new ArrayList<Double>();
		stockHighPriceDup.addAll(stockHighPrice);
		Collections.sort(stockHighPriceDup);
		return stockHighPriceDup.get(stockHighPriceDup.size() - 1);
	}

	public static Double getAverageHighPrice(List<Double> stockHighPrice) {
		Double avhHighValue = 0.0;
		for (Double d : stockHighPrice) {
			avhHighValue = avhHighValue + d;
		}
		return avhHighValue / 7;
	}
	public static Double getProfitOrLossPercentage(Double buyingPrice,Double sellingPrice){		
		
			 //return ((sellingPrice/buyingPrice)*100)-100;
		return sellingPrice-buyingPrice;
		
	}
	public static Double calcFinalPriceOfStock(Double buyingPrice,Double numOfStocks,Double profitOrLoss){
		return (buyingPrice*numOfStocks)+(profitOrLoss*numOfStocks);
	}
}
