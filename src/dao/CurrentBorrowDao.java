package dao;

import entity.CurrentBorrow;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.DBHelp;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/5.
 */
public class CurrentBorrowDao {
    public void addCurrentBorrow(CurrentBorrow currentBorrow){
        String sql = "INSERT INTO currentBorrow(rno,bisbn,bname) VALUES(?,?,?)";
        DBHelp.ExecuteUpdate(sql,currentBorrow.getRno(),currentBorrow.getBisbn(),currentBorrow.getBname());
    }

    public void updateCurrentBorrow(CurrentBorrow currentBorrow){
        String sql = "UPDATE currentBorrow SET bnum = ? WHERE rno = ? AND bisbn = ?";
        DBHelp.ExecuteUpdate(sql,currentBorrow.getBnum(),currentBorrow.getRno(),currentBorrow.getBisbn());
    }

    public void deleteCurrentBorrow(String rno,String bisbn){
        String sql = "DELETE FROM currentBorrow WHERE rno = ? AND bisbn = ?";
        DBHelp.ExecuteUpdate(sql,rno,bisbn);
    }

    public void deleteCurrentBorrow(String rno){
        String sql = "DELETE FROM currentBorrow WHERE rno = ?";
        DBHelp.ExecuteUpdate(sql,rno);
    }

    public CurrentBorrow findCurrentBorrow(String rno,String bisbn){
        String sql = "SELECT * FROM currentBorrow WHERE rno = ? AND bisbn = ?";
        return DBHelp.ExecuteQuery(sql,new BeanHandler(CurrentBorrow.class),rno,bisbn);
    }

    public List<CurrentBorrow> findCurrentBorrowByRno(String rno){
        String sql = "SELECT * FROM currentBorrow WHERE rno = ?";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(CurrentBorrow.class),rno);
    }
}
