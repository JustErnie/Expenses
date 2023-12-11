package App;

import App.model.Transaction;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/expenses/add")
public class ExpensesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        context.log("[ExpensesServlet] doGet");
        List<Transaction> transactionList = (List<Transaction>)context.getAttribute("transactionList");

        for (var k : req.getParameterMap().keySet()) {
            int value = Integer.parseInt(req.getParameter(k));
            transactionList.add(new Transaction(k, value * -1));
        }
        resp.getWriter().println("Expenses were added");
        resp.sendRedirect("/summary");
    }
}
