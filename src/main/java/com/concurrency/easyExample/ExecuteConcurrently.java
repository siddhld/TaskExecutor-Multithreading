package com.concurrency.easyExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ExecuteConcurrently {

     @Autowired
     private TaskExecutor taskExecutor;

     public void runTasks() {

          // ASYNC Task - 1
          taskExecutor.execute(() -> {
               for (int i = 1; i <= 5; i++) {
                    System.out.println("Sleeping " + i);
                    try {
                         Thread.sleep(1000);
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               }
          });

          // ASYNC Task - 2
          taskExecutor.execute(() -> {
               for (int i = 1; i <= 5; i++) {
                    System.out.println("Dreaming " + i);
                    try {
                         Thread.sleep(1000);
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               }
          });

          // ASYNC Task - 3
          taskExecutor.execute(() -> {
               for (int i = 1; i <= 5; i++) {
                    System.out.println("Running in dream " + i);
                    try {
                         Thread.sleep(1000);
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               }
          });

          // ASYNC Task - 4
          taskExecutor.execute(() -> {
               for (int i = 1; i <= 5; i++) {
                    System.out.println("Crashed in dream " + i);
                    try {
                         Thread.sleep(1000);
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               }
          });
     }

}

// The above all four tasks are running at the same time.

// If you want to perform multiple operations concurrently you can use
// TaskExecutor.
// Using TaskExecutor to execute multiple operations will improve performance