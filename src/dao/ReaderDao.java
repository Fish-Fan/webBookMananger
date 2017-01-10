package dao;

import com.sun.org.apache.regexp.internal.RE;
import entity.Reader;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.DBHelp;
import web.ListServlet;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/4.
 */
public class ReaderDao {
    public void addReader(Reader reader){
        String sql = "INSERT INTO reader(rno,rname,rgender,rage,rspecialty,rpassword,ruuid) VALUES(?,?,?,?,?,?,?)";
        DBHelp.ExecuteUpdate(sql,reader.getRno(),reader.getRname(),reader.getRgender(),reader.getRage(),reader.getRspecialty(),reader.getRpassword(),reader.getRuuid());
    }

    public void updateReader(Reader reader){
        String sql = "UPDATE reader SET rname = ?,rgender = ?,rage = ?,rspecialty = ?,rpassword = ? ,ruuid = ?,rBorrowCount = ?,rBorrowFine = ? WHERE rno = ?";
        DBHelp.ExecuteUpdate(sql,reader.getRname(),reader.getRgender(),reader.getRage(),reader.getRspecialty(),reader.getRpassword(),reader.getRuuid(),reader.getrBorrowCount(),reader.getrBorrowFine(),reader.getRno());
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

    public Double findSumFineByRno(String rno){
        String sql = "SELECT rBorrowCount FROM borrow WHERE rno = ?";
        return DBHelp.ExecuteSingle(sql,new ScalarHandler(),rno);
    }

    public Double findBorrowCountByRno(String rno){
        String sql = "SELECT rBorrowFine FROM borrow WHERE rno = ?";
        return DBHelp.ExecuteSingle(sql,new ScalarHandler(),rno);
    }
}
