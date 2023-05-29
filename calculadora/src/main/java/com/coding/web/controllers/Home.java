package com.coding.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coding.web.models.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Calculator> calculatorList = (ArrayList<Calculator>) session.getAttribute("lista");
		if(calculatorList != null ) {
			//ArrayList<Calculator> calculatorList = (ArrayList<Calculator>) session.getAttribute("lista");
			session.setAttribute("lista",calculatorList);
			request.setAttribute("lista", calculatorList);
		}else {
			ArrayList<Calculator> calculatorLista =  new ArrayList<Calculator>();
			session.setAttribute("lista",calculatorLista);
			request.setAttribute("lista", calculatorLista);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Index.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession();
    	String userNumber = request.getParameter("pressed")+"=";
    	ArrayList<Object> list = new ArrayList<>();

		
		
		try {
			String number = "";
			for (int i = 0; i < userNumber.length(); i++) {
				if(isNumeric(String.valueOf(userNumber.charAt(i)) )) {
					number = number + String.valueOf(userNumber.charAt(i));
				}else {
					list.add( Double.valueOf(Integer.parseInt(number)));
					number = "";
					list.add(String.valueOf(userNumber.charAt(i)));
				}
	        }
			while (list.size() > 2) {
				Double result = 0.0;
				for (int i = 0; i < list.size()-1; i++) {
					if(list.get(i).equals("/") ){
						 result = Math.floor(Double.valueOf((Double)list.get(i-1))/ Double.valueOf((Double)list.get(i+1)));
						 list.set(i-1, result);
						 result = 0.0;
						 list.remove(i);
						 list.remove(i);
					}
				}
				for (int i = 0; i < list.size()-1; i++) {
					if(list.get(i).equals("*") ){
						 result = Math.floor(Double.valueOf((Double)list.get(i-1))* Double.valueOf((Double)list.get(i+1)));
						 list.set(i-1, result);
						 result = 0.0;
						 list.remove(i);
						 list.remove(i);
					}
				}
					for (int i = 0; i < list.size()-1; i++) {
						if(list.get(i).equals("+") ){
							 result = Math.floor(Double.valueOf((Double)list.get(i-1))+ Double.valueOf((Double)list.get(i+1)));
							 list.set(i-1, result);
							 result = 0.0;
							 list.remove(i);
							 list.remove(i);
						}
					}
					for (int i = 0; i < list.size()-1; i++) {
						if(list.get(i).equals("-") ){
							 result = Math.floor(Double.valueOf((Double)list.get(i-1))- Double.valueOf((Double)list.get(i+1)));
							 list.set(i-1, result);
							 result = 0.0;
							 list.remove(i);
							 list.remove(i);
						}
					}
				}
				ArrayList<Calculator> calculatorList = (ArrayList<Calculator>) session.getAttribute("lista");
				Calculator calc = new Calculator();
				calc.setResult((int)Math.floor(Double.valueOf((Double)list.get(0))));
				
				if(calculatorList != null ) {
					calculatorList.add(calc);
					session.setAttribute("lista",calculatorList);
	
				}else {
					ArrayList<Calculator> calculatorLista =  new ArrayList<Calculator>();
					calculatorLista.add(calc);
					session.setAttribute("lista",calculatorLista);
				}
		    } catch (Exception e) {
		      System.out.println("Something went wrong.");
		    }

		
		//String lista = (String) session.getAttribute("lista");

    	response.sendRedirect("Home");
	}
	Pattern reg = Pattern.compile("-?\\d+(\\.\\d+)?");

	public boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return reg.matcher(strNum).matches();
	}
	
}
