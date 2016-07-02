package com.gaurav.karaf.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gaurav.karaf.model.Karaf;
import com.gaurav.karaf.model.KarafService;


/*feature:repo-add mvn:com.gaurav.karaf/gaurav-karaf-features/0.0.1-SNAPSHOT/xml
feature:install example-karaflist-persistence example-karaflist-ui
*/

public class DoingServlet extends HttpServlet {
	KarafService karafService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String taskId = req.getParameter("taskId");
		PrintWriter writer = resp.getWriter();
		if (taskId != null && taskId.length() > 0) {
			showTask(writer, taskId);
		} else {
			showTaskList(writer);
		}
	}

	private void showTaskList(PrintWriter writer) {
		writer.println("<h1>Tasks</h1>");
		Collection<Karaf> tasks = karafService.getKarafs();
		for (Karaf task : tasks) {
			writer.println("<a href=\"?taskId=" + task.getId() + "\">"
					+ task.getTitle() + "</a><BR/>");
		}
	}

	private void showTask(PrintWriter writer, String taskId) {
	    SimpleDateFormat sdf = new SimpleDateFormat();
		Karaf task = karafService.getKaraf(taskId);
		if (task != null) {
			writer.println("<h1>Task " + task.getTitle() + " </h1>");
			if (task.getDueDate() != null) {
			    writer.println("Due date: " + sdf.format(task.getDueDate()) + "<br/>");
			}
			writer.println(task.getDescription());
		} else {
			writer.println("Task with id " + taskId + " not found");
		}

	}
	
	public void setKarafService(KarafService taskService) {
		this.karafService = taskService;
	}

}
