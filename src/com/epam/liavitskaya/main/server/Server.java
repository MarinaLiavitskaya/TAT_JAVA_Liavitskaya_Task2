package com.epam.liavitskaya.main.server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.liavitskaya.main.controller.Controller;

public class Server {

	Queue<String> requestsServer = new ConcurrentLinkedQueue<String>();

	public void initServer(String request) {

		for (int i = 0; i < 8; i++) {
			requestsServer.add(request);
		}
		startServer(requestsServer);
	}

	public void startServer(Queue<String> requests) {

		ExecutorService pool = Executors.newFixedThreadPool(6);
		for (int id = 0; id <= requests.size(); id++) {
			Runnable worker = Controller.getInstance(requests);
			pool.execute(worker);
		}
		pool.shutdown();

	}

	// public void startServer(String request) {
	//
	// String[] split = request.split(",");
	//
	// for (int i = 0; i < split.length; i++) {
	// requests.add(split[i]);
	// }
	//
	// ExecutorService pool = Executors.newFixedThreadPool(4);
	// for (int id = 0; id <= requests.size(); id++) {
	// Runnable worker = Controller.getInstance(requests);
	// pool.execute(worker);
	// }
	// pool.shutdown();
	//
	// }

}
