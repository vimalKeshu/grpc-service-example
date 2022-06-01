package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.service.WorkerServiceController;
import org.example.worker.WorkerServiceGrpc;

public class AppMain {

    public static void main(String[] args) throws Exception{
        String workerPort = System.getenv("WORKER_SERVICE_PORT");
        int port = 8080;
        if (workerPort!=null) port = Integer.parseInt(workerPort);

        Server server = ServerBuilder
                .forPort(port)
                .addService(new WorkerServiceController()).build();

        server.start();
        server.awaitTermination();
    }
}
