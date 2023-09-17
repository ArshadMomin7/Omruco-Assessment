import java.util.*;
import java.util.concurrent.*;

class CacheEntry<V> {
    private V value;
    private long expirationTime;

    CacheEntry(V value, long expirationTime) {
        this.value = value;
        this.expirationTime = expirationTime;
    }

    V getValue() {
        return value;
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expirationTime;
    }
}
