package com.concurrency.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class Config {

     @Bean()
	public TaskExecutor threadPoolTaskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}
     
     ////// Using custom configuration
     // @Bean
     // public TaskExecutor taskExecutor() {
     //      ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
     //      executor.setCorePoolSize(4); // Set initial number of threads
     //      executor.setMaxPoolSize(10); // Set maximum number of threads
     //      executor.setQueueCapacity(25); // Set queue size for waiting tasks
     //      executor.setThreadNamePrefix("custom-thread"); // Set thread name prefix
     //      executor.initialize(); // Initialize the thread pool
     //      return executor;
     // }

     ////// Using default configuration
     // @Bean
     // public TaskExecutor taskExecutor() {
     // return new ThreadPoolTaskExecutor();
     // }
}
