package com.concurrency.customConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;
import com.concurrency.Utils.TaskProcessingService;

@Component
public class CustomThreadPoolExample {

     @Autowired
     private TaskProcessingService taskService;

     @Autowired
     private TaskExecutor taskExecutor;

     public void runTasks() throws InterruptedException {
          // Submit 10 tasks for processing
          for (int i = 0; i < 10; i++) {
               int taskId = i + 1;
               taskExecutor.execute(() -> {
                    try {
                         taskService.processTask(taskId);
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               });
               Thread.sleep(1000); // Simulate some delay between task submissions
          }
     }

}
