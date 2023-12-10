package App;

import App.model.Expense;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SummaryServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        context.log("[SummaryServlet] init");

        int salary = Integer.parseInt(context.getInitParameter("salary"));
        int rent = Integer.parseInt(config.getInitParameter("rent"));

        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(new Expense("rent", rent));


        context.setAttribute("freeMoney", salary - rent);
        context.setAttribute("expenseList", expenseList);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        context.log("[SummaryServlet] doGet");

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.getWriter().println("Not authorised");
            return;
        }

        req.getRequestDispatcher("/details").include(req, resp);
        resp.getWriter().println("Free money: " + context.getAttribute("freeMoney"));
    }
}
