package ajia.stock;

import ajia.caching.Cachable;

public class StockService {

	@Cachable(cacheStore = "Chart")
	public byte[] getQuoteGraph(String ticker) {
		return ticker.getBytes();
	}
	
}
