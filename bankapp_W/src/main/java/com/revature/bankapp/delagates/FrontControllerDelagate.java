package com.revature.bankapp.delagates;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface FrontControllerDelagate {
	public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
