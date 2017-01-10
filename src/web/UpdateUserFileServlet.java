package web;

import dao.AccountDao;
import dao.ReaderDao;
import entity.Account;
import entity.Reader;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yanfeng-mac on 2017/1/9.
 */
@WebServlet("/updateUserFile")
@MultipartConfig(fileSizeThreshold = 1024*1024*3,
        maxFileSize = 1024*1024*40,
        maxRequestSize = 1024*1024*50
)
public class UpdateUserFileServlet extends HttpServlet {
    //上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "avatar";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");

        String username = account.getUsername();

        ReaderDao readerDao = new ReaderDao();
        Reader reader = readerDao.findReaderByRno(username);


        req.setAttribute("user",reader);
        req.getRequestDispatcher("/WEB-INF/views/webjsp/userFile.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uploadPath = req.getServletContext().getRealPath("");
        String savaPath = uploadPath + File.separator + UPLOAD_DIRECTORY;

        File fileSavaDir = new File(savaPath);
        if(!fileSavaDir.exists()){
            fileSavaDir.mkdir();
        }

        String uuid = null;

        for(Part part : req.getParts()){
            String header = part.getHeader("content-disposition");
            if(header.contains("filename")){
                uuid = UUID.randomUUID().toString();
                String fileName = uuid;
                part.write(savaPath + File.separator + fileName);
            }
        }



        ReaderDao readerDao = new ReaderDao();
        AccountDao accountDao = new AccountDao();
        HttpSession session = req.getSession();
        Reader reader = new Reader();
        Account account = (Account) session.getAttribute("account");


        String rno = req.getParameter("rno");
        String rname = req.getParameter("rname");
        String rgender = req.getParameter("rgender");
        String rage = req.getParameter("rage");
        String rspecialty = req.getParameter("rspecialty");
        String rpassword = req.getParameter("rpassword");


        reader.setRno(rno);
        reader.setRname(rname);
        reader.setRgender(rgender);
        reader.setRspecialty(rspecialty);
        reader.setRpassword(rpassword);
        reader.setRage(rage);
        reader.setRuuid(uuid);
        account.setUUID(uuid);


        accountDao.updateAccount(account);
        readerDao.updateReader(reader);






        resp.sendRedirect("/readerList");

    }
}
