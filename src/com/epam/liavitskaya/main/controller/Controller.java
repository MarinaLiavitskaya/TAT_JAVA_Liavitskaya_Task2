package com.epam.liavitskaya.main.controller;

import com.epam.liavitskaya.main.controller.command.Command;

public class Controller {

	private final CommandProvider provider = new CommandProvider();
	private final char paramDelimeter = ' ';
	private static Controller instance;
	

	private Controller() {
		super();
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

}
