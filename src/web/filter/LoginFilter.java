package web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yanfeng-mac on 2017/1/7.
 */
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        System.out.println(url);

        if(url.startsWith("/img/") || url.startsWith("/css/") || url.startsWith("/js/") || "/".equals(url) || url.startsWith("/index.jsp") || "notFountError.jsp".equals(url) || "/login".equals(url)){
            filterChain.doFilter(request,response);
        }
        else {
            HttpSession session = request.getSession();
            if(session.getAttribute("account") != null){
                filterChain.doFilter(request,response);
            }
            else {
                response.sendRedirect("/index.jsp?state=1");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
