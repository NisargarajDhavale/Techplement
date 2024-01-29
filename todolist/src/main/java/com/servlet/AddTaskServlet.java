package com.servlet;

import com.helper.FactoryProvider;
import com.taskDAO.TaskDAO;
import com.todolist.Task;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddTaskServlet() {
        super();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            String description = req.getParameter("description");

            Task task = new Task(description, false);

            Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();

            s.save(task);

            tx.commit();
            s.close();

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<h1>Task Added Successfully</h1>");

            List<Task> tasks = new TaskDAO(FactoryProvider.getFactory()).getAllTasks();
            req.setAttribute("tasks", tasks);
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}