package org.example.storage;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

public class RocksDBKVStorage implements IStorage<Long, String>{
    private static final Logger logger = LoggerFactory.getLogger(RocksDBKVStorage.class);
    private RocksDB rocksDB;
    private final String dbDir;

    public RocksDBKVStorage(String dbDir){
        this.dbDir = dbDir;
    }

    @Override
    public void start() throws  Exception{
        RocksDB.loadLibrary();
        Options config = new Options();
        config.setCreateIfMissing(true);
        this.rocksDB = RocksDB.open(config,dbDir+System.getProperty("file.separator")+"db_"+System.currentTimeMillis());
    }

    @Override
    public void write(Long key,String value) throws Exception{
        assert key != null: "Opps !! Found null key.";
        assert value != null: "Opps !! Found null value.";
        assert !value.isEmpty(): "Opps !! Found empty value.";
        this.rocksDB.put(longToBytes(key), value.getBytes());
    }

    @Override
    public String readByKey(Long key) throws Exception{
        assert key != null: "Opps !! Found null key.";

        byte[] val = this.rocksDB.get(longToBytes(key));
        if (val == null) return null;
        return new String(val);
    }

    @Override
    public void close() {
        if(this.rocksDB != null) this.rocksDB.close();
    }

    @Override
    public boolean isWarmedUP(){
        return this.rocksDB != null;
    }

    @Override
    public String toString(){
        return "RocksDBCache";
    }

    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }

    public static long bytesToLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(bytes);
        buffer.flip();//need flip
        return buffer.getLong();
    }
}
