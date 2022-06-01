package org.example;

import com.google.common.util.concurrent.ListenableFuture;
import org.example.client.KeyProcessorClient;
import org.example.service.KeyFetcherFromExternalStorage;
import org.example.storage.RocksDBKVStorage;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.worker.TaskRequest;
import org.example.worker.TaskResponse;
import org.example.worker.WorkerServiceGrpc;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppMain {

    public static void main(String[] args) throws Exception{
        Executor executor = Executors.newWorkStealingPool();

        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("0.0.0.0", 8181)
                .usePlaintext()
                .build();

        RocksDBKVStorage rocksDBKVStorage = new RocksDBKVStorage("/Users/vimal.chaudhari/Documents/rocksdb");
        rocksDBKVStorage.start();
        long count = 0;
        while (true){
              try{
                  //Get the key offset from external storage
                  long keyOffset = count++;
                  String message = "STARTED";

                  //Store the offset and its status
                  rocksDBKVStorage.write(keyOffset, message);

                  //Process offset data
                  WorkerServiceGrpc.WorkerServiceFutureStub
                          workerServiceFutureStub = WorkerServiceGrpc.newFutureStub(managedChannel);
                  TaskRequest request = TaskRequest
                          .newBuilder()
                          .setOffset(keyOffset)
                          .setMessage(message)
                          .build();

                  ListenableFuture<TaskResponse> response = workerServiceFutureStub.execute(request);
                  response.addListener(new KeyProcessorClient(response, rocksDBKVStorage), executor);

              } catch (Exception ex){
                  ex.printStackTrace();
              }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }
}
