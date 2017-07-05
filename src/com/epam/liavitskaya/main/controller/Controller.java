package com.epam.liavitskaya.main.controller;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.enums.CommandName;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	private final char paramDelimeter = ' ';

	public String executeTask(String request) {

		String substring = request.substring(0, request.indexOf(paramDelimeter));
		System.out.println(substring);
		Command executionCommand;

		CommandName command = CommandName.valueOf(substring);
		System.out.println(command);
		executionCommand = provider.getCommand(command);
		String response = null;
		response = executionCommand.execute(request);
		return response;
	}
}
