package dao;

import entity.Borrow;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.DBHelp;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/4.
 */
public class BorrowDao {
    public void addBorrow(Borrow borrow){
        String sql = "INSERT INTO borrow(rno,bisbn,bname,startdate) VALUES(?,?,?,?)";
        DBHelp.ExecuteUpdate(sql,borrow.getRno(),borrow.getBisbn(),borrow.getBname(),borrow.getStartdate());
    }

    public void updateBorrow(Borrow borrow){
        String sql = "UPDATE borrow SET startdate = ?,enddate = ?,fine = ?,ispay = ? WHERE rno = ? AND bisbn = ?";
        DBHelp.ExecuteUpdate(sql,borrow.getStartdate(),borrow.getEnddate(),borrow.getFine(),borrow.getIspay(),borrow.getRno(),borrow.getBisbn());
    }

    public void deleteBorrow(String rno,String bisbn){
        String sql = "DELETE FROM borrow WHERE rno = ? AND bisbn = ?";
        DBHelp.ExecuteUpdate(sql,rno,bisbn);
    }

    public List<Borrow> findBorrowByRnoBisbn(String rno,String bisbn){
        String sql = "SELECT * FROM borrow WHERE rno = ? AND bisbn = ?";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(Borrow.class),rno,bisbn);
    }

    public List<Borrow> findAllBorrow(){
        String sql = "SELECT * FROM borrow";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(Borrow.class));
    }

    public List<Borrow> findBorrowByLike(String rno,String bisbn){
        String sql = "SELECT * FROM borrow WHERE rno LIKE CONCAT('%',?,'%') AND bisbn LIKE CONCAT('%',?,'%')";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(Borrow.class),rno,bisbn);
    }

    public List<Borrow> findBorrowByRnoNotPay(String rno){
        String sql = "SELECT * FROM borrow WHERE rno = ? AND ispay = 0";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(Borrow.class),rno);
    }

    public List<Borrow> findBorrowByRno(String rno){
        String sql = "SELECT * FROM borrow WHERE rno = ?";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(Borrow.class),rno);
    }
}
