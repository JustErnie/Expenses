package App.filters;

import jakarta.servlet.*;

import java.io.IOException;

public class ExpensesFilters implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext context = servletRequest.getServletContext();
        context.log("[ExpensesFilters] doFilter");

        int freeMoney = (int)context.getAttribute("freeMoney");
        for (var k : servletRequest.getParameterMap().keySet()) {
            freeMoney -= Integer.parseInt(servletRequest.getParameter(k));
            if (freeMoney < 0) {
                servletResponse.getWriter().println("Not enough money");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
