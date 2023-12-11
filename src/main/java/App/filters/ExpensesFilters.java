package App.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/expenses/add")
public class ExpensesFilters implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext context = servletRequest.getServletContext();
        context.log("[ExpensesFilters] doFilter");

        int freeMoney = (int)context.getAttribute("freeMoney");
        for (var k : servletRequest.getParameterMap().keySet()) {
            if (freeMoney < Integer.parseInt(servletRequest.getParameter(k))) {
                servletResponse.getWriter().println("Not enough money");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
