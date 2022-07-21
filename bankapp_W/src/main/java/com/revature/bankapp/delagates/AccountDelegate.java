package com.revature.bankapp.delagates;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.bankapp.exceptions.UsernameAlreadyExistsException;
import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.User;
import com.revature.bankapp.models.dtos.AccountDTO;
import com.revature.bankapp.models.dtos.UserDTO;
import com.revature.bankapp.services.AccountService;
import com.revature.bankapp.services.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccountDelegate implements FrontControllerDelagate{
	private ObjectMapper objMapper = new ObjectMapper();
	private UserService userServ = new UserService();
	private AccountService accountServ = new AccountService();

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();

		switch (method) {
		case "GET":
			get(req, resp);
			break;
		case "POST":
			post(req, resp);
			break;
		case "PUT":
			put(req, resp);
			break;
		case "DELETE":
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			break;
		default:
		}
		
	}
	private void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String path = (String) req.getAttribute("path");
		if (path==null || "".equals(path)) {
			resp.sendError(403, "Access to all accounts is forbidden.");
		} else {
			try {
				int id = Integer.valueOf(path);
				Account account = accountServ.getAllAccounts(user);
				if (account!=null) {
					AccountDTO accountResp = new AccountDTO(account);
					resp.getWriter().write(objMapper.writeValueAsString(accountResp));
				} else {
					resp.sendError(404, "Account with that ID not found.");
				}
			} catch (NumberFormatException e) {
				resp.sendError(400, e.getMessage());
			}
		}

	}
	private void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = (String) req.getAttribute("path");
		if (path==null || "".equals(path)) {
			try {
				Account account;
				account = objMapper.readValue(req.getInputStream(), Account.class);

				if (account==null) throw new RuntimeException();
				
					account = accountServ.createAccount(account);
					
					AccountDTO accountResp = new AccountDTO(account);
					resp.getWriter().write(objMapper.writeValueAsString(accountResp));
					
			} catch (MismatchedInputException | RuntimeException e) {
				resp.sendError(400, "The request body was empty.");
			}
		} else {
			resp.sendError(400, "Cannot POST to this URI. Try sending the request to /users.");
		}
	}
	private void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String path = (String) req.getAttribute("path");
		if (path==null || "".equals(path)) {
			resp.sendError(400, "Cannot PUT to this URI. Try sending the request to .");
		} else {
			try {
				int id = Integer.valueOf(path);
				Account account = accountServ.accountDetail(account, user);
				if (account!=null) {
					account = objMapper.readValue(req.getInputStream(), Account.class);
					
					try {
						if (account==null) throw new RuntimeException();
						if (account.getId()==id) {
							account = accountServ.deposit(account, num);
							resp.getWriter().write(objMapper.writeValueAsString(account));
						} else {
							resp.sendError(409, "The ID in the URI did not match the ID in the body.");
						}
					} catch (MismatchedInputException | RuntimeException e) {
						resp.sendError(400, "The request body was empty.");
					}
				} else {
					resp.sendError(404, "Account with that ID not found.");
				}
			} catch (NumberFormatException e) {
				resp.sendError(400, e.getMessage());
			}
		}
	}

	}


