package dao;

import com.sun.org.apache.regexp.internal.RE;
import entity.Reader;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.DBHelp;
import web.ListServlet;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/4.
 */
public class ReaderDao {
    public void addReader(Reader reader){
        String sql = "INSERT INTO reader(rno,rname,rgender,rage,rspecialty,rpassword) VALUES(?,?,?,?,?,?)";
        DBHelp.ExecuteUpdate(sql,reader.getRno(),reader.getRname(),reader.getRgender(),reader.getRage(),reader.getRspecilty(),reader.getRpassword());
    }

    public void updateReader(Reader reader){
        String sql = "UPDATE reader SET rname = ?,rgender = ?,rage = ?,rspecialty,rpassword = ?";
        DBHelp.ExecuteUpdate(sql,reader.getRname(),reader.getRgender(),reader.getRage(),reader.getRspecilty(),reader.getRpassword());
    }

    public void deleteReader(String rno){
        String sql = "DELETE FROM reader WHERE rno = ?";
        DBHelp.ExecuteUpdate(sql,rno);
    }

    public Reader findReaderByRno(String rno){
        String sql = "SELECT * FROM reader WHERE rno = ?";
        return DBHelp.ExecuteQuery(sql,new BeanHandler(Reader.class),rno);
    }

    public Reader findReaderByRname(String rname){
        String sql = "SELECT * FROM reader WHERE rname = ?";
        return DBHelp.ExecuteQuery(sql,new BeanHandler(Reader.class),rname);
    }

    public List<Reader> findAllReader(){
        String sql = "SELECT * FROM reader";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(Reader.class));
    }

    public List<Reader> findReaderByLike(String rname){
        String sql = "SELECT * FROM reader WHERE rname LIKE CONCAT('%',?,'%')";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(Reader.class),rname);
    }
}
