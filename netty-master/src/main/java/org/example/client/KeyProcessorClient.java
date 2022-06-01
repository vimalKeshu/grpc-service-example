package org.example.client;

import com.google.common.util.concurrent.ListenableFuture;
import org.example.storage.RocksDBKVStorage;
import org.example.worker.TaskResponse;

import java.util.concurrent.ExecutionException;

public class KeyProcessorClient implements Runnable{
    private ListenableFuture<TaskResponse> response;
    private RocksDBKVStorage db;
    public KeyProcessorClient(ListenableFuture<TaskResponse> response, RocksDBKVStorage db){
        this.response = response;
        this.db = db;
    }

    @Override
    public void run() {
        try {
            TaskResponse taskResponse = response.get();
            System.out.println(taskResponse.getStatus());
            this.db.write(taskResponse.getOffset(), taskResponse.getStatus());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
