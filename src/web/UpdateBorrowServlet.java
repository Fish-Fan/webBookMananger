package web;

import dao.BorrowDao;
import dao.ReaderDao;
import entity.Borrow;
import entity.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/6.
 */
@WebServlet("/updateBorrow")
public class UpdateBorrowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rno = req.getParameter("rno");
        String bisbn = req.getParameter("bisbn");

        BorrowDao borrowDao = new BorrowDao();
        List<Borrow> borrowList = borrowDao.findBorrowByRnoBisbn(rno,bisbn);

        Borrow borrow = borrowList.get(0);

        req.setAttribute("borrow",borrow);
        req.getRequestDispatcher("WEB-INF/views/webjsp/updateBorrow.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReaderDao readerDao = new ReaderDao();
        BorrowDao borrowDao = new BorrowDao();

        String rno = req.getParameter("rno");
        String bisbn = req.getParameter("bisbn");
        String bname = req.getParameter("bname");
        String startdate = req.getParameter("startdate");
        String enddate = req.getParameter("enddate");
        Float fine = new Float(req.getParameter("fine"));
        Integer ispay = new Integer(req.getParameter("ispay"));

        Borrow borrow = new Borrow();
        borrow.setRno(rno);
        borrow.setBisbn(bisbn);
        borrow.setBname(bname);
        borrow.setStartdate(startdate);
        borrow.setEnddate(enddate);
        borrow.setFine(fine);
        borrow.setIspay(ispay);

        Reader reader = readerDao.findReaderByRno(rno);

        Double fines = reader.getrBorrowFine() + new Double(fine);
        reader.setrBorrowFine(fines);

        readerDao.updateReader(reader);
        borrowDao.updateBorrow(borrow);

        resp.sendRedirect("/allBorrows");
    }
}
