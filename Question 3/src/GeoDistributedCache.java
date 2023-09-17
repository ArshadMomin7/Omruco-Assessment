import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GeoDistributedCache<K, V> {
    private Map<K, CacheEntry<V>> cache;
    private long defaultExpirationTime; // in milliseconds

    public GeoDistributedCache(long defaultExpirationTime) {
        this.cache = new ConcurrentHashMap<>();
        this.defaultExpirationTime = defaultExpirationTime;
    }

    public void put(K key, V value) {
        put(key, value, defaultExpirationTime);
    }

    public void put(K key, V value, long expirationTime) {
        CacheEntry<V> entry = new CacheEntry<>(value, System.currentTimeMillis() + expirationTime);
        cache.put(key, entry);
    }

    public V get(K key) {
        CacheEntry<V> entry = cache.get(key);
        if (entry != null && !entry.isExpired()) {
            return entry.getValue();
        }
        return null;
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public void clearExpired() {
        cache.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }

    public static void main(String[] args) {
        GeoDistributedCache<String, String> cache = new GeoDistributedCache<>(60000); // 60 seconds expiration

        cache.put("key1", "value1");
        cache.put("key2", "value2", 30000); // 30 seconds expiration

        System.out.println(cache.get("key1")); // Output: value1
        System.out.println(cache.get("key2")); // Output: value2

        // Wait for some time to let cache entries expire
        try {
            Thread.sleep(40000); // Sleep for 40 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(cache.get("key1")); // Output: null (expired)
        System.out.println(cache.get("key2")); // Output: null (expired)
    }
}