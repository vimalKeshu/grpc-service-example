package org.example.storage;

import java.util.Optional;

public interface IStorage<K,V> extends AutoCloseable {
    public void start() throws  Exception;
    public void write(K key,V value) throws Exception;
    public V readByKey(K key) throws Exception;
    public boolean isWarmedUP();
}
