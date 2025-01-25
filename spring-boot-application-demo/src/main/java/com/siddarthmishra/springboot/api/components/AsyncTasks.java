package com.siddarthmishra.springboot.api.components;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTasks {

	@Async("myAsyncPoolTaskExecutor")
	public void sendEmail(String emailId) {
		long t1 = System.currentTimeMillis();
		System.out.println("Sending email notification to " + emailId);
		System.out.println("Thread Name: " + Thread.currentThread().getName());
		try {
			// send email logic
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Failed to send email notification to " + emailId);
			e.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Sending an email took " + (t2 - t1) + " ms");
	}
}