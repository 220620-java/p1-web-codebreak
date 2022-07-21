package com.revature.bankapp.servlets;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bankapp.exceptions.UsernameAlreadyExistsException;
import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.User;
import com.revature.bankapp.services.AccountService;
import com.revature.bankapp.services.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet{
	private UserService userServ = new UserService();
	private AccountService accountServ = new AccountService();
	private ObjectMapper objMapper = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		User user = objMapper.readValue(req.getInputStream(), User.class);
		
		try {
			userServ.registerUser(user);
		} catch (UsernameAlreadyExistsException e) {
			e.printStackTrace();
		}
		System.out.println(user);
		
	}

}
