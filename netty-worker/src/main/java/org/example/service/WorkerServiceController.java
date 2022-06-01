package org.example.service;

import io.grpc.stub.StreamObserver;
import org.example.component.TaskExecutor;
import org.example.worker.TaskRequest;
import org.example.worker.TaskResponse;
import org.example.worker.WorkerServiceGrpc;

public class WorkerServiceController extends WorkerServiceGrpc.WorkerServiceImplBase {
    @Override
    public void execute(TaskRequest request, StreamObserver<TaskResponse> responseObserver) {
        TaskResponse response = TaskExecutor.execute(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
