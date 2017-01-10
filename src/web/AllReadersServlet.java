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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanfeng-mac on 2017/1/10.
 */
@WebServlet("/allReaders")
public class AllReadersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BorrowDao borrowDao = new BorrowDao();
        ReaderDao readerDao = new ReaderDao();
        List<Reader> readerList = readerDao.findAllReader();


        req.setAttribute("readerList",readerList);


        req.getRequestDispatcher("WEB-INF/views/webjsp/allReaders.jsp").forward(req,resp);
    }
}
