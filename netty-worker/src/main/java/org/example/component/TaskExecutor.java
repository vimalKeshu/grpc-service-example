package org.example.component;

import org.example.worker.TaskRequest;
import org.example.worker.TaskResponse;

public class TaskExecutor {

    public static TaskResponse execute(TaskRequest request){
        String message = request.getMessage();
        long offset = request.getOffset();
        System.out.println("Offset:"+offset+", Message:"+message);
        return TaskResponse
                .newBuilder()
                .setOffset(offset)
                .setStatus("FINISHED")
                .build();
    }
}
