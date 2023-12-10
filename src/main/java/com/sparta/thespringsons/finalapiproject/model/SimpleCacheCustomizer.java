package com.sparta.thespringsons.finalapiproject.model;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class SimpleCacheCustomizer
        implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        String[] cacheTables = {"AllEmbeddedMovies", "AllMovies"};
        cacheManager.setCacheNames(Arrays.asList(cacheTables));
    }
}
