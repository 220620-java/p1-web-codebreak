package com.revature.bankapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bankapp.models.Account;
import com.revature.bankapp.services.AccountService;
import com.revature.bankapp.services.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccountServlet extends HttpServlet{
	private UserService userServ = new UserService();
	private AccountService accountServ = new AccountService();
	private ObjectMapper objMapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Account> accounts= accountServ.getAllAccounts();
		
		PrintWriter writer = resp.getWriter();
		writer.write(objMapper.writeValueAsString(accounts));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Account account  = objMapper.readValue(req.getInputStream(), Account.class);
		
		accountServ.createAccount(account);
		System.out.println(account);

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Account account = objMapper.readValue(req.getInputStream(), Account.class);
		
		double num = 0;
		accountServ.deposit(account, num);
		System.out.println(account);
	}
}
