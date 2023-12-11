package App;

import App.model.Transaction;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(value = "/summary", initParams = {@WebInitParam(name = "rent", value = "30")}, loadOnStartup = 0)
public class SummaryServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        context.log("[SummaryServlet] init");

        int salary = Integer.parseInt(context.getInitParameter("salary"));
        int rent = Integer.parseInt(config.getInitParameter("rent"));

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction("salary", salary));
        transactionList.add(new Transaction("rent", rent * -1));

        context.setAttribute("transactionList", transactionList);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        context.log("[SummaryServlet] doGet");

        req.getRequestDispatcher("/details").include(req, resp);
    }
}
