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

@WebServlet("/income/add")
public class IncomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        context.log("[IncomeServlet] doGet");
        List<Transaction> transactionList = (List<Transaction>) context.getAttribute("transactionList");

        for (var set : req.getParameterMap().keySet()) {
            int value = Integer.parseInt(req.getParameter(set));
            transactionList.add(new Transaction(set, value));
        }
        resp.getWriter().println("Incomes were added");
        resp.sendRedirect("/summary");
    }
}
