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

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();

        int freeMoney = 0;
        resp.getWriter().println("Transactions: ");
        for (Transaction transaction : (List<Transaction>)context.getAttribute("transactionList")) {
            resp.getWriter().format("%s: %s\n", transaction.getName(), transaction.getValue());
            freeMoney += transaction.getValue();
        }

        context.setAttribute("freeMoney", freeMoney);
        resp.getWriter().println("Free Money: " + freeMoney);
    }
}
