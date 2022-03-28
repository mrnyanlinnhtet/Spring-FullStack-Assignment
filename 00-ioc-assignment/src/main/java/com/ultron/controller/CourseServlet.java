package com.ultron.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;

import com.ultron.listener.SpringContainerManager;
import com.ultron.model.CourseModel;

@WebServlet(urlPatterns = { "/", "courses", "course-edit", "course-save" })
public class CourseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CourseModel model;

	@Override
	public void init() throws ServletException {
              
		var contex = getServletContext().getAttribute(SpringContainerManager.SPRING_CONTEX);

		if (null != contex && contex instanceof BeanFactory factory) {
			System.out.println(factory.getBean("message"));
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var page = switch (req.getServletPath()) {

		case "/course-edit" -> "/course-edit.jsp";

		default -> {
			
			// Load Data
			yield "/index.jsp";
		}

		};

		// Navigation Process
		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
	}

}
