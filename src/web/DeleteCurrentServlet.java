package web;

import dao.BookDao;
import dao.CurrentBorrowDao;
import entity.Account;
import entity.Book;
import entity.CurrentBorrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yanfeng-mac on 2017/1/5.
 */
@WebServlet("/deleteCurrent")
public class DeleteCurrentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");

        String rno = account.getUsername();
        String rebisbn = req.getParameter("rebisbn");

        BookDao bookDao = new BookDao();
        CurrentBorrowDao currentBorrowDao = new CurrentBorrowDao();


        //更新book表中数量
        Book book = bookDao.findBookByIsbn(rebisbn);
        Integer num = book.getBnum();
        num++;
        book.setBnum(num);
        bookDao.updateBook(book);

        //更新currentBorrow表中的数量
        CurrentBorrow currentBorrow = currentBorrowDao.findCurrentBorrow(rno,rebisbn);
        Integer bnum = currentBorrow.getBnum();
        if(bnum == 1){
            currentBorrowDao.deleteCurrentBorrow(rno,rebisbn);
        }
        else {
            bnum--;
            currentBorrow.setBnum(bnum);
            currentBorrowDao.updateCurrentBorrow(currentBorrow);
        }

        resp.sendRedirect("/readerList");
    }
}
