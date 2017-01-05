package web;

import dao.BookDao;
import dao.CurrentBorrowDao;
import entity.Account;
import entity.Book;
import entity.CurrentBorrow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yanfeng-mac on 2017/1/5.
 */
public class CurrentBorrowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");

        String rno = account.getUsername();
        String bname = req.getParameter("bname");
        String bisbn = req.getParameter("bisbn");

        BookDao bookDao = new BookDao();
        CurrentBorrowDao currentBorrowDao = new CurrentBorrowDao();
        CurrentBorrow currentBorrow = currentBorrowDao.findCurrentBorrow(rno,bisbn);


        //更新book表中的数量
        Book book = bookDao.findBookByIsbn(bisbn);
        Integer num = book.getBnum();
        num--;
        book.setBnum(num);
        bookDao.updateBook(book);

        //向currentBorrow表中插入数据
        if(currentBorrow == null){
            currentBorrow = new CurrentBorrow();
            currentBorrow.setRno(rno);
            currentBorrow.setBisbn(bisbn);
            currentBorrow.setBname(bname);

            currentBorrowDao.addCurrentBorrow(currentBorrow);
        }
        else {
            Integer bnum = currentBorrow.getBnum();
            bnum++;
            currentBorrow.setRno(rno);
            currentBorrow.setBisbn(bisbn);
            currentBorrow.setBnum(bnum);
            currentBorrowDao.updateCurrentBorrow(currentBorrow);
        }


        resp.sendRedirect("/readerList");
    }
}
