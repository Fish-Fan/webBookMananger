package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by yanfeng-mac on 2017/1/9.
 */
@WebServlet("/avatar")
public class downloadAvatarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("key");
        String fileName = uuid;
//        String path = "/Users/yanfeng-mac/Documents/avatar/";
        String path = "/Users/yanfeng-mac/IdeaProjects/webBookMananger/out/artifacts/webBookMananger_war_exploded//avatar/";

        File file = new File(path+fileName);
        if(file.exists()){
            FileInputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = resp.getOutputStream();

            int len = -1;
            byte[] buffer= new byte[1024];
            while((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer,0,len);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } else {
            resp.sendError(404,"图片不存在");
        }
    }
}
