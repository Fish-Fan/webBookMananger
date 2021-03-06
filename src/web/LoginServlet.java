package web;

import dao.AccountDao;
import dao.ReaderDao;
import entity.Account;
import entity.Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;


/**
 * Created by yanfeng-mac on 2017/1/2.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AccountDao accountDao = new AccountDao();
        Account account = accountDao.findAccountByName(username);



        if(account != null && account.getPassword().equals(password)){
            HttpSession session = req.getSession();
            session.setAttribute("account",account);
            if(account.getRoot() == 1){
                resp.sendRedirect("/list");
            }
            else {
                resp.sendRedirect("/readerList");
            }

        }
        else {
            resp.sendRedirect("/index.jsp?error=1");
        }


    }
}
