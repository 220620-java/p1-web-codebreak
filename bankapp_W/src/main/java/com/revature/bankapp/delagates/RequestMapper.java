package com.revature.bankapp.delagates;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestMapper {
	private Map<String, FrontControllerDelagate> delagateMap;
	
	{
		delagateMap = new HashMap<>();
		
		//Add each delegate path
		delagateMap.put("users", new UserDelagate());
		delagateMap.put("accounts", new AccountDelegate());
	}
	
	public FrontControllerDelagate map(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if("OPTION".equals(req.getMethod())) {
			return (req1, resp1) -> {};
		}
		
		StringBuilder uriString = new StringBuilder(req.getRequestURI());
		uriString.replace(0, req.getContextPath().length()+1, "");
		
		if(uriString.indexOf("/") != -1) {
			req.setAttribute("path", uriString.substring(uriString.indexOf("/")+1));
			
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
		}
		return delagateMap.get(uriString.toString());
	}

}
