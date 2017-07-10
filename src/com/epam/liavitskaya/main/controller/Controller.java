package com.epam.liavitskaya.main.controller;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.enums.CommandName;

public class Controller {

	private final CommandProvider provider = new CommandProvider();
	private final char paramDelimeter = ' ';

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

		CommandName command = CommandName.valueOf(commandName);
		executionCommand = provider.getCommand(command);

		String response = "";
		response = executionCommand.execute(request);
		return response;
	}
}
