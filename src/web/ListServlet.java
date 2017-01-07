package web;

import dao.BookDao;
import entity.Account;
import entity.Book;
import entity.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/2.
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchValue = req.getParameter("searchValue");
        BookDao bookDao = new BookDao();
        List<Book> bookList = null;
        Account account = null;

        HttpSession session = req.getSession();

        account = (Account) session.getAttribute("account");

        if(account == null){
            resp.sendRedirect("index.jsp");
        }

        if(searchValue == null || "".equals(searchValue)){

            bookList = bookDao.findAllBook();
        }
        else {
            bookList = bookDao.findBookByLike(searchValue);
        }




        req.setAttribute("account",account);
        req.setAttribute("bookList",bookList);
        req.setAttribute("searchValue",searchValue);

        req.getRequestDispatcher("/WEB-INF/views/webjsp/list.jsp").forward(req,resp);
    }
}
