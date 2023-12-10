package App;

import App.model.Expense;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();

        resp.getWriter().println("Expenses: ");
        for (Expense expense : (List<Expense>)context.getAttribute("expenseList")) {
            resp.getWriter().format("%s(%s)\n", expense.getName(), expense.getValue());
        }
    }
}
