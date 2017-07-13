package com.epam.liavitskaya.main.server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.liavitskaya.main.controller.Controller;

public class Server {

	Queue<String> requests = new ConcurrentLinkedQueue<String>();

	public void startServer(String request) {
		
		String[] split = request.split(",");

		for (int i = 0; i < split.length; i++) {
			requests.add(split[i]);
		}

		ExecutorService pool = Executors.newFixedThreadPool(4);
		for (int id = 0; id <= requests.size(); id++) {
			Runnable worker = new Controller(requests);
			pool.execute(worker);
		}
		pool.shutdown();

	}

}
