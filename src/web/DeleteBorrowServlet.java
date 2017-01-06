package web;

import dao.BorrowDao;
import entity.Borrow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/6.
 */
public class DeleteBorrowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rno = req.getParameter("rno");
        String bisbn = req.getParameter("bisbn");

        BorrowDao borrowDao = new BorrowDao();
        borrowDao.deleteBorrow(rno,bisbn);

        resp.sendRedirect("/allBorrows");
    }
}
