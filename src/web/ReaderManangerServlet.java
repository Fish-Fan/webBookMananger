package web;

import dao.ReaderDao;
import entity.Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/4.
 */
public class ReaderManangerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReaderDao readerDao = new ReaderDao();
        List<Reader> readerList = readerDao.findAllReader();
        req.setAttribute("readerList",readerList);
        req.getRequestDispatcher("WEB-INF/views/webjsp/readerMananger.jsp").forward(req,resp);

    }
}
