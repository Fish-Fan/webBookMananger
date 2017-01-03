package web;

import dao.AccountDao;
import entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yanfeng-mac on 2017/1/2.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AccountDao accountDao = new AccountDao();
        Account account = accountDao.findAccountByName(username);

        if(account != null && account.getPassword().equals(password)){
            resp.sendRedirect("/list");
        }
        else {
            resp.sendRedirect("/index.jsp?error=1");
        }

    }
}
