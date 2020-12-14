package com.niu.blog.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(
        urlPatterns = {"/*"}
)
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getServletPath();

        if (!url.equals("/login") && !url.equals("/register") &&
                !url.equals("/manageArticle") && !url.equals("/searchArticle") &&
                !url.equals("/searchUser") && !url.equals("/displayArticle") &&
                !url.equals("/displayArticleType") && !url.equals("/manageArticleByUser") &&
                !url.equals("/manageArticleByUserNameAndArticleType") &&
                !url.equals("/manageReply")) {
            HttpSession session = httpRequest.getSession();
            String userName = (String) session.getAttribute("UserName");
            if (userName == null || userName.equals("")) {
                ((HttpServletResponse) response).sendRedirect("login");
                return;
            }
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) {
        // TODO Auto-generated method stub
    }

}
