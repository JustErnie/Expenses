package App.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String path = req.getRequestURI().substring(req.getContextPath().length());

        HttpSession session = req.getSession(false);
        if (session != null || path.equals("/") || path.equals("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getWriter().println("Not authorised");
        }
    }
}
