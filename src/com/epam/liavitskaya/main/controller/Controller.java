package com.epam.liavitskaya.main.controller;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.epam.liavitskaya.main.controller.command.Command;

public class Controller implements Runnable {

	private Queue<String> requests = new ConcurrentLinkedQueue<String>();

	private final CommandProvider provider = new CommandProvider();
	private final char paramDelimeter = ' ';
	private static Controller instance;

	private Controller() {
	}

	public Controller(Queue<String> requests) {
		this.requests = requests;
	}

	public static Controller getInstance() {
		if (null == instance) {
			instance = new Controller();
		}
		return instance;
	}

	public String executeTask(String request) {

		String commandName = "";

		if (request.isEmpty() || request != null) {
			if (request.contains(" ")) {
				commandName = request.substring(0, request.indexOf(paramDelimeter));
			} else {
				commandName = request.substring(0, request.length());
			}
		}

		Command executionCommand;

		executionCommand = provider.getCommand(commandName);

		String response = "";
		response = executionCommand.execute(request);
		return response;
	}

	@Override
	public void run() {
		String request;
		while ((request = requests.poll()) != null) {
			String response = executeTask(request);
			System.out.println(response);
			System.out.println(Thread.currentThread().getName() + "  : " + Thread.currentThread().getId());
		}

	}
}
