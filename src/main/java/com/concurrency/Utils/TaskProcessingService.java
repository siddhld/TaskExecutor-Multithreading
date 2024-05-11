package com.concurrency.Utils;

import org.springframework.stereotype.Component;

@Component
public class TaskProcessingService {
     public void processTask(int taskId) throws InterruptedException {

          System.out.println("Starting task: " + taskId);

          // Simulate some processing time (replace with your actual task logic)
          Thread.sleep(2000); // Simulate 2 seconds of work

          System.out.println("Finished task: " + taskId);
     }
}
