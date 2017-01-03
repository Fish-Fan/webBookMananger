package web;

import dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yanfeng-mac on 2017/1/2.
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        String isbn = req.getParameter("isbn");
        if(isbn == null || "".equals(isbn)){
            resp.sendError(404);
        }
        else {
            bookDao.deleteBook(isbn);
            resp.sendRedirect("/list");
        }
    }
}
