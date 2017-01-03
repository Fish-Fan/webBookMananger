package web;

import dao.BookDao;
import dao.BookTypeDao;
import entity.Book;
import entity.BookType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/2.
 */
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("isbn");
        BookDao bookDao = new BookDao();
        Book book = bookDao.findBookByIsbn(isbn);

        BookTypeDao bookTypeDao = new BookTypeDao();
        List<BookType> bookTypeList = bookTypeDao.findAllBookType();

        req.setAttribute("book",book);
        req.setAttribute("bookTypeList",bookTypeList);

        req.getRequestDispatcher("/WEB-INF/views/webjsp/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String isbn = req.getParameter("isbn");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        Float price = new Float(req.getParameter("price"));
        String category = req.getParameter("bookType");

        Book book = new Book();
        book.setBisbn(isbn);
        book.setBname(name);
        book.setBauthor(author);
        book.setBpublisher(publisher);
        book.setBprice(price);
        book.setBcategory(category);

        BookDao bookDao = new BookDao();
        bookDao.updateBook(book);

        resp.sendRedirect("/list");
    }
}
