package App;

import App.model.Expense;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ExpensesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        context.log("[ExpensesServlet] doGet");
        List<Expense> expensesList = (List<Expense>)context.getAttribute("expenseList");

        int freeMoney = (int)context.getAttribute("freeMoney");

        for (var k : req.getParameterMap().keySet()) {
            int value = Integer.parseInt(req.getParameter(k));
            freeMoney -= value;
            expensesList.add(new Expense(k, value));
        }

        context.setAttribute("freeMoney", freeMoney);
        resp.getWriter().println("Expenses were added");
    }
}
