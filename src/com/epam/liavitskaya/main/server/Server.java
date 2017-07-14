package com.epam.liavitskaya.main.server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	private Queue<String> requestsServer = new ConcurrentLinkedQueue<String>();

	public void syntheticinitServer(String request) {

		for (int i = 0; i < 10; i++) {
			requestsServer.add(request);
		}
		startServer(requestsServer);
	}

	public void initServer(String request) {

		requestsServer.add(request);
		startServer(requestsServer);

	}

	public void startServer(Queue<String> requests) {
		System.out.println(requests);
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for (int id = 0; id <= requests.size(); id++) {
			Runnable worker = new RequestProvider(requests);
			try {
				Thread.currentThread().sleep(2000); // main thread stops
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pool.execute(worker);
		}
		pool.shutdown();

	}

}
