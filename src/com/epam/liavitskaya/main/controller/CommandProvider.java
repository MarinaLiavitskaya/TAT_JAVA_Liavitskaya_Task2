package com.epam.liavitskaya.main.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.controller.command.impl.AddEditedBook;
import com.epam.liavitskaya.main.controller.command.impl.AddNewBook;
import com.epam.liavitskaya.main.controller.command.impl.AwayBook;
import com.epam.liavitskaya.main.controller.command.impl.BanUser;
import com.epam.liavitskaya.main.controller.command.impl.DeleteBook;
import com.epam.liavitskaya.main.controller.command.impl.DeleteUser;
import com.epam.liavitskaya.main.controller.command.impl.EditBook;
import com.epam.liavitskaya.main.controller.command.impl.EditProfile;
import com.epam.liavitskaya.main.controller.command.impl.OrderBook;
import com.epam.liavitskaya.main.controller.command.impl.Registration;
import com.epam.liavitskaya.main.controller.command.impl.ReviewProfile;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllBooks;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllUsers;
import com.epam.liavitskaya.main.controller.command.impl.SignIn;
import com.epam.liavitskaya.main.controller.command.impl.SignOut;
import com.epam.liavitskaya.main.enums.CommandName;

public class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();

	public CommandProvider() {		
		repository.put(CommandName.REGISTRATION, new Registration());
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.SIGN_OUT, new SignOut());
		repository.put(CommandName.REVIEW_PROFILE, new ReviewProfile());
		repository.put(CommandName.EDIT_PROFILE, new EditProfile());
		repository.put(CommandName.ADD_NEW_BOOK, new AddNewBook());
		repository.put(CommandName.ADD_EDITED_BOOK, new AddEditedBook());
		repository.put(CommandName.EDIT_BOOK, new EditBook());
		repository.put(CommandName.AWAY_BOOK, new AwayBook());
		repository.put(CommandName.SHOW_ALL_BOOKS, new ShowAllBooks());
		repository.put(CommandName.SHOW_ALL_USERS, new ShowAllUsers());
		repository.put(CommandName.ORDER_BOOK, new OrderBook());
		repository.put(CommandName.BAN_USER, new BanUser());
		repository.put(CommandName.DELETE_USER, new DeleteUser());
		repository.put(CommandName.DELETE_BOOK, new DeleteBook());
	}

	Command getCommand(CommandName commandName) {
		Command command = null;
		try {
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
