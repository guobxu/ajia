package ajia.main;

import ajia.stock.StockService;

public class Main {

	public static void main(String[] args) {
		StockService service = new StockService();
		service.getQuoteGraph("GOOG");
		service.getQuoteGraph("GOOG");
		service.getQuoteGraph("YHOO");
		service.getQuoteGraph("YHOO");
		service.getQuoteGraph("GOOG");
	}
	
}
