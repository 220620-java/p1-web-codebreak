package com.revature.bankapp.servlets;

import java.io.IOException;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.bankapp.delagates.FrontControllerDelagate;
import com.revature.bankapp.delagates.RequestMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends DefaultServlet{
	private RequestMapper mapper = new RequestMapper();
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		FrontControllerDelagate delagate = mapper.map(req, resp);
		
		if(delagate != null) {
			delagate.handle(req, resp);
		}
		else {
			resp.sendError(404);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}


}
