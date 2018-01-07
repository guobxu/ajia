package ajia.caching;

import com.opensymphony.oscache.base.Cache;
import com.opensymphony.oscache.base.NeedsRefreshException;

public aspect CacheMonitoring {

	pointcut cacheRetrieval(String key) : call(* Cache.getFromCache(String))
			&& args(key);
	
	after(Object key) returning(Object val) : cacheRetrieval(key) {
		System.out.println("Cache hit. Key: " + key + " Value: " + val);
	}
	
	
	after(Object key) throwing(NeedsRefreshException ex) : cacheRetrieval(key) {
		System.out.println("Cache miss. Key: " +  key);
	}
}
