package com.concurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.concurrency.customConfiguration.CustomThreadPoolExample;
import com.concurrency.defaultConfiguration.DynamicThreadPoolExample;
import com.concurrency.easyExample.ExecuteConcurrently;

@SpringBootApplication
public class TaskExecutorApplication {

	@Autowired
	private CustomThreadPoolExample ctp;
	@Autowired
	private DynamicThreadPoolExample dtp;
	@Autowired
	private ExecuteConcurrently ec;

	public static void main(String[] args) throws InterruptedException {

		ApplicationContext context = SpringApplication.run(TaskExecutorApplication.class, args);

		/*
		 * The @Autowired annotation isn't effective when you create an instance of
		 * TaskExecutorApplication outside the Spring application context
		 * because Spring doesn't manage the lifecycle and
		 * dependencies of objects created this way.
		 */
		// TaskExecutorApplication application = new TaskExecutorApplication(); ❌
		// application.runTasks(); ❌

		/* Correct way of Creating Object using the Spring application context; ✅ */
		TaskExecutorApplication application = context.getBean(TaskExecutorApplication.class);
		application.runTasks();
	}

	public void runTasks() throws InterruptedException {
		// Custom ThreadPool Configuration
		// ctp.runTasks();

		// Default ThreadPool Configuration
		// dtp.runTasks();

		// Simple Example Easy to understandable
		ec.runTasks();
	}

}

/*
 * ---- The Issue with Creating an Instance Outside the Context: ----
 * 
 * When you create a new TaskExecutorApplication instance using new
 * TaskExecutorApplication(),
 * you're bypassing Spring's bean lifecycle management.
 * This instance isn't part of the application context.
 * Even though the class itself (TaskExecutorApplication) has the @Autowired
 * annotation on the ctp field, it only applies to instances created within the
 * context.
 * The locally created instance doesn't participate in Spring's dependency
 * injection process. Therefore, the ctp field remains uninitialized, leading to
 * the NullPointerException when you try to call ctp.runTasks().
 * 
 */