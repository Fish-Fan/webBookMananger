package web;

import dao.BookDao;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/2.
 */
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchValue = req.getParameter("searchValue");
        BookDao bookDao = new BookDao();
        List<Book> bookList = null;

        if(searchValue == null || "".equals(searchValue)){

            bookList = bookDao.findAllBook();
        }
        else {
            bookList = bookDao.findBookByLike(searchValue);
        }


        System.out.println(bookList);



        req.setAttribute("bookList",bookList);
        req.setAttribute("searchValue",searchValue);

        req.getRequestDispatcher("/WEB-INF/views/webjsp/list.jsp").forward(req,resp);
    }
}
