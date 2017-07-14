package com.epam.liavitskaya.main.server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.epam.liavitskaya.main.controller.Controller;

public class RequestProvider implements Runnable {
	
	private Queue<String> requests = new ConcurrentLinkedQueue<String>();	
	
	public RequestProvider(Queue<String> requests) {		
		this.requests = requests;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		
		String request;
		while ((request = requests.poll()) != null) {
			String response = Controller.getInstance().executeTask(request);
			try {
				Thread.currentThread().sleep(3000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.println("Current working thread : 	 " + Thread.currentThread().getName() + "  : " + Thread.currentThread().getId() + response);			
		}
	}

}
