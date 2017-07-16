package com.epam.liavitskaya.main.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.epam.liavitskaya.main.controller.Controller;

public class ExecutionProvider implements Callable<String> {

	private Queue<String> requests = new ConcurrentLinkedQueue<String>();

	public ExecutionProvider(Queue<String> requests) {
		this.requests = requests;
	}
	
	
	@Override
	public String call() {

		String request;		
		String response = null;

		while ((request = requests.poll()) != null) {
			response = Controller.getInstance().executeTask(request);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Current working thread : 	 " + Thread.currentThread().getName() + "   :   "
					+ Thread.currentThread().getId() + "  " +response);
		}
		return response;
	}
	

	/*@Override
	public List<String> call() {

		String request;
		List<String> responseList = new ArrayList<>();
		String response;

		while ((request = requests.poll()) != null) {
			response = Controller.getInstance().executeTask(request);
			responseList.add(response);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Current working thread : 	 " + Thread.currentThread().getName() + "   :   "
					+ Thread.currentThread().getId() + "  " + responseList);
		}
		return responseList;
	}*/

}
