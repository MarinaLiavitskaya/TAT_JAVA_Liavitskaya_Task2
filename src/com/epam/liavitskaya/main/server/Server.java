package com.epam.liavitskaya.main.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {

	private static Queue<String> requestsServer = new ConcurrentLinkedQueue<String>();
	static int i = 0;
	static List<String> futureList = new ArrayList<>();

//	public static void initServer(String request) {
//		System.out.println(request);
//
//		requestsServer.add(request);
//		i++;
//		if (i == 5) {
//			startServer(request);
//		}
//	}

	public static String startServer(String req) {		
		requestsServer.add(req);
		String string = null;	
		i++;
		if (i == 5) {
			startServer(req);
		
		Future<String> submit = null;
		ExecutorService executorService = Executors.newFixedThreadPool(3); // ThreadPoolExecutor
																// executor																			// =
																			// (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
		try {
			for (int id = 0; id <= requestsServer.size(); id++) {
			Callable<String> worker = new ExecutionProvider(requestsServer);
			submit = executorService.submit(worker);
			}
			string = submit.get();
			futureList.add(string);

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
		for (String str : futureList) {
			System.out.println("*********************   " + str);
		}
		}
		return string;
	}

	// public static List<String> startServer(Queue<String> requestsQueue) {
	//
	// Future<List<String>> submit = null;
	// ExecutorService executorService = Executors.newFixedThreadPool(3);
	// // ThreadPoolExecutor executor = (ThreadPoolExecutor)
	// // Executors.newFixedThreadPool(2);
	// try {
	// for (int id = 0; id <= requestsServer.size(); id++) {
	// Callable<List<String>> worker = new ExecutionProvider(requestsQueue);
	//
	// submit = executorService.submit(worker);
	// }
	// if (submit.isDone()) {
	// futureList = submit.get();
	// }
	// } catch (InterruptedException | ExecutionException e) {
	// e.printStackTrace();
	// }
	// executorService.shutdown();
	//
	// for (String str : futureList) {
	// System.out.println("********************* " + str);
	// }
	// return futureList;
	// }
}
