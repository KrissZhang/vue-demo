package com.self.vuebackend.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCache {

    private static CacheManager cacheManager;

    static {
        cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");
    }

    private static Cache getCacheForName(String cacheName){
        return cacheManager.getCache(cacheName);
    }

    public static void putCache(String cacheName, String key, Object value){
        Cache cache = getCacheForName(cacheName);
        Element element = new Element(key, value);
        cache.put(element);
    }

    public static Object getCacheValue(String cacheName, String key){
        Cache cache = getCacheForName(cacheName);
        Element element = cache.get(key);
        return element.getObjectValue();
    }

}
