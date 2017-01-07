package web;

import dao.BookDao;
import dao.BorrowDao;
import dao.CurrentBorrowDao;
import dao.ReaderDao;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/4.
 */
@WebServlet("/readerList")
public class ReaderListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchValue = req.getParameter("searchValue");
        BookDao bookDao = new BookDao();
        List<Book> bookList = null;
        Account account = null;


        HttpSession session = req.getSession();
        account = (Account) session.getAttribute("account");

        ReaderDao readerDao = new ReaderDao();
        Reader reader = readerDao.findReaderByRno(account.getUsername());
        String rno = reader.getRno();

        if(account == null){
            resp.sendRedirect("/index.jsp");
            return;
        }

        if(searchValue == null || "".equals(searchValue)){

            bookList = bookDao.findAllBook();
        }
        else {
            bookList = bookDao.findBookByLike(searchValue);
        }

        BorrowDao borrowDao = new BorrowDao();
        CurrentBorrowDao currentBorrowDao = new CurrentBorrowDao();

        List<CurrentBorrow> currentBorrows = currentBorrowDao.findCurrentBorrowByRno(rno);
        List<Borrow> borrowList = borrowDao.findBorrowByRno(rno);

        req.setAttribute("currentBorrows",currentBorrows);
        req.setAttribute("borrowList",borrowList);
        req.setAttribute("reader",reader);
        req.setAttribute("bookList",bookList);
        req.setAttribute("searchValue",searchValue);

        req.getRequestDispatcher("/WEB-INF/views/webjsp/readerList.jsp").forward(req,resp);
    }
}
