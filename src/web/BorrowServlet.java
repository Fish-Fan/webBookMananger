package web;

import dao.BookDao;
import dao.BorrowDao;
import dao.CurrentBorrowDao;
import entity.Account;
import entity.Book;
import entity.Borrow;
import entity.CurrentBorrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/4.
 */
@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String rno = req.getParameter("rno");
        String bisbn = req.getParameter("bisbn");
        String bname = req.getParameter("bname");
        String backbisbn = req.getParameter("backbisbn");
        Calendar calendar = Calendar.getInstance();
        String startdate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE);

        BorrowDao borrowDao = new BorrowDao();
        Borrow borrow = new Borrow();


        borrow.setRno(rno);
        borrow.setBisbn(bisbn);
        borrow.setStartdate(startdate);
        borrow.setBname(bname);


        borrowDao.addBorrow(borrow);
        borrowDao.deleteBorrow(rno,backbisbn);


        resp.sendRedirect("/readerList");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        String rno = account.getUsername();
        Calendar calendar = Calendar.getInstance();
        String startdate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE);


        CurrentBorrowDao currentBorrowDao = new CurrentBorrowDao();
        BorrowDao borrowDao = new BorrowDao();

        //按rno删除currentBorrow表中的数据,将删除的数据插入到borrow表中
        List<CurrentBorrow> currentBorrowList = currentBorrowDao.findCurrentBorrowByRno(rno);
        for(CurrentBorrow currentBorrow : currentBorrowList)
        {
            Integer bnum = currentBorrow.getBnum();
            for(int i = 0;i < bnum;i++)
            {
                Borrow borrow = new Borrow();
                borrow.setRno(currentBorrow.getRno());
                borrow.setBisbn(currentBorrow.getBisbn());
                borrow.setBname(currentBorrow.getBname());
                borrow.setStartdate(startdate);

                borrowDao.addBorrow(borrow);
                currentBorrowDao.deleteCurrentBorrow(rno);



            }
        }

        resp.sendRedirect("/readerList?success=1");


    }
}
