package web;

import dao.BorrowDao;
import entity.Borrow;

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
@WebServlet("/allBorrows")
public class AllBorrowsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BorrowDao borrowDao = new BorrowDao();
        List<Borrow> borrowList = borrowDao.findAllBorrow();

        req.setAttribute("borrowList",borrowList);
        req.getRequestDispatcher("/WEB-INF/views/webjsp/allBorrows.jsp").forward(req,resp);
    }
}
