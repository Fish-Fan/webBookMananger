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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class UpdateUserFileServlet extends HttpServlet {
    //上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "avatar";

    //上传配置
    private static final int MEMORY_THRESHOLD = 1024*1024*3;
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;


    private Class<Reader> clazz;



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
        req.setCharacterEncoding("UTF-8");
//        检查是否为多媒体上传
        if(!ServletFileUpload.isMultipartContent(req)){
            System.out.println("表单必须包含 ectype=multipart/form-data");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);

        String uploadPath = req.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;

        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }

        Reader reader = new Reader();
        ReaderDao readerDao = new ReaderDao();
        AccountDao accountDao = new AccountDao();
        String uid = null;
        String filePath = null;
        Map<String,String> map = new HashMap<>();


        try{
            List<FileItem> formItems = upload.parseRequest(req);

            if(formItems != null && formItems.size() > 0){
                for(FileItem item : formItems){
                    if(!item.isFormField()){
                        uid = File.separator + UUID.randomUUID().toString();
                        filePath = uploadPath + uid;
                        File storeFile = new File(filePath);
                        System.out.println(filePath);
                        item.write(storeFile);
                    }
                    else {
//                        String name = item.getFieldName();
//                        String value = new String(item.getString().getBytes("iso8859-1"),"utf-8");
//                        String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
//                        Method[] methods = clazz.getMethods();
//                        for(Method method : methods)
//                        {
//                            if(method.getName().equals(methodName)){
//                                method.invoke(reader,value);
//                            }
//                        }
//                        System.out.println(item.getName());
//                        System.out.println(item.getFieldName() + ":"+ new String(item.getString().getBytes("iso8859-1"),"utf-8"));
//                        System.out.println(reader);
                            map.put(item.getFieldName(),new String(item.getString().getBytes("iso8859-1"),"utf-8"));

                    }
                }
                reader.setRno(map.get("rno"));
                reader.setRname(map.get("rname"));
                reader.setRgender(map.get("rgender"));
                reader.setRspecialty(map.get("rspecialty"));
                reader.setRpassword(map.get("rpassword"));
                reader.setRage(map.get("rage"));
                readerDao.updateReader(reader);

                Account account = accountDao.findAccountByName(map.get("rno"));
                account.setUUID(uid);
                accountDao.updateAccount(account);


                resp.sendRedirect("/readerList?avatarsrc=" + filePath);

            }



        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


//        String rno = req.getParameter("rno");
//        String rname = req.getParameter("rname");
//        String rgender = req.getParameter("rgender");
//        String rage = req.getParameter("rage");
//        String rspecialty = req.getParameter("rspecialty");
//        String rpassword = req.getParameter("rpassword");
//
//        ReaderDao readerDao = new ReaderDao();
//        Reader reader = new Reader();
//        reader.setRno(rno);
//        reader.setRname(rname);
//        reader.setRgender(rgender);
//        reader.setRage(rage);
//        reader.setRspecialty(rspecialty);
//        reader.setRpassword(rpassword);
//
//        System.out.println(reader);
//
//        readerDao.updateReader(reader);
//
//        resp.sendRedirect("/readerList");
    }
}
