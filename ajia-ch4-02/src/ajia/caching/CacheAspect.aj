package ajia.caching;

import com.opensymphony.oscache.base.Cache;
import com.opensymphony.oscache.base.NeedsRefreshException;

public aspect CacheAspect {

	private Cache cache = new Cache(true, true, false);
	
	public pointcut cachedAccess(Object arg, Cachable cachable) : execution(@Cachable * *(*)) 
			&& args(arg) && @annotation(cachable);
	
	Object around(Object arg, Cachable cachable) : cachedAccess(arg, cachable) {
		if(arg == null) {
			return proceed(arg, cachable);
		}
		
		String key = cachable.cacheStore() + ":" + arg;
		Object cachedVal = null;
		try {
			cachedVal = cache.getFromCache(key);
		} catch(NeedsRefreshException ex) {
			cachedVal = proceed(arg, cachable);
			cache.putInCache(key, cachedVal);
		}
		
		return cachedVal;
	}
}
