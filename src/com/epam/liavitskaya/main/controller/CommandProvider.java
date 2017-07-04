package com.epam.liavitskaya.main.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.controller.command.impl.AddEditedBook;
import com.epam.liavitskaya.main.controller.command.impl.AddNewBook;
import com.epam.liavitskaya.main.controller.command.impl.DeleteBook;
import com.epam.liavitskaya.main.controller.command.impl.Registration;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllBooks;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllUsers;
import com.epam.liavitskaya.main.controller.command.impl.SignIn;
import com.epam.liavitskaya.main.controller.command.impl.SignOut;
import com.epam.liavitskaya.main.enums.CommandName;

public class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();

	public CommandProvider() {
		repository.put(CommandName.ADD_NEW_BOOK, new AddNewBook());
		repository.put(CommandName.ADD_EDITED_BOOK, new AddEditedBook());
		repository.put(CommandName.REGISTRATION, new Registration());
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.SIGN_OUT, new SignOut());
		repository.put(CommandName.SHOW_ALL_BOOKS, new ShowAllBooks());
		repository.put(CommandName.SHOW_ALL_USERS, new ShowAllUsers());

		repository.put(CommandName.DELETE, new DeleteBook());
		repository.put(CommandName.DELETE, new DeleteBook());
	}

	Command getCommand(CommandName commandName) {
		Command command = null;
		try {
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get("");
		}
		return command;
	}
}
