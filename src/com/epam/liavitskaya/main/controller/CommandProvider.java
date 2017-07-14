package com.epam.liavitskaya.main.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.controller.command.impl.AddBook;
import com.epam.liavitskaya.main.controller.command.impl.CancelOrder;
import com.epam.liavitskaya.main.controller.command.impl.ChangeRole;
import com.epam.liavitskaya.main.controller.command.impl.ChangeStatus;
import com.epam.liavitskaya.main.controller.command.impl.EditBook;
import com.epam.liavitskaya.main.controller.command.impl.EditBookDescription;
import com.epam.liavitskaya.main.controller.command.impl.EditProfile;
import com.epam.liavitskaya.main.controller.command.impl.MakeAdminUser;
import com.epam.liavitskaya.main.controller.command.impl.OrderBook;
import com.epam.liavitskaya.main.controller.command.impl.Registration;
import com.epam.liavitskaya.main.controller.command.impl.ReviewProfile;
import com.epam.liavitskaya.main.controller.command.impl.ReviewProfileById;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllAvailableBooks;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllBooks;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllUsers;
import com.epam.liavitskaya.main.controller.command.impl.SignIn;
import com.epam.liavitskaya.main.controller.command.impl.SignOut;
import com.epam.liavitskaya.main.controller.command.impl.WriteOffBook;
import com.epam.liavitskaya.main.controller.command.impl.WrongRequest;
import com.epam.liavitskaya.main.enumeration.CommandName;

public class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();

	public CommandProvider() {

		repository.put(CommandName.REGISTRATION, new Registration());
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.SIGN_OUT, new SignOut());
		repository.put(CommandName.REVIEW_PROFILE, new ReviewProfile());
		repository.put(CommandName.REVIEW_PROFILE_ID, new ReviewProfileById());
		repository.put(CommandName.EDIT_PROFILE, new EditProfile());
		repository.put(CommandName.CHANGE_STATUS, new ChangeStatus());
		repository.put(CommandName.CHANGE_ROLE, new ChangeRole());
		repository.put(CommandName.MAKE_ADMIN_USER, new MakeAdminUser());
		repository.put(CommandName.ADD_BOOK, new AddBook());
		repository.put(CommandName.EDIT_BOOK, new EditBook());
		repository.put(CommandName.EDIT_BOOK_DESCRIPTION, new EditBookDescription());
		repository.put(CommandName.WRITE_OFF_BOOK, new WriteOffBook());
		repository.put(CommandName.SHOW_ALL_BOOKS, new ShowAllBooks());
		repository.put(CommandName.SHOW_ALL_AVAILABLE_BOOKS, new ShowAllAvailableBooks());
		repository.put(CommandName.SHOW_ALL_USERS, new ShowAllUsers());
		repository.put(CommandName.ORDER_BOOK, new OrderBook());
		repository.put(CommandName.CANCEL_ORDER, new CancelOrder());		
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}

	Command getCommand(String commandName) {
		
		Command command = null;
		try {
			command = repository.get(CommandName.valueOf(commandName));
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
