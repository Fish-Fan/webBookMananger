package dao;

import entity.Book;
import entity.BookType;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.DBHelp;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/2.
 */
public class BookTypeDao {
    public void addBookType(BookType bookType){
        String sql = "INSERT INTO bookType(id,book_type) VALUES(?,?)";
        DBHelp.ExecuteUpdate(sql,bookType.getId(),bookType.getBook_type());
    }

    public void updateBookType(BookType bookType){
        String sql = "UPDATE bookType SET book_type = ?";
        DBHelp.ExecuteUpdate(sql,bookType.getBook_type());
    }

    public void deleteBookType(BookType bookType){
        String sql = "DELETE FROM bookType WHERE id = ?";
        DBHelp.ExecuteUpdate(sql,bookType.getId());
    }

    public BookType findBookTypeById(Integer id){
        String sql = "SELECT * FROM booType WHERE id = ?";
        return DBHelp.ExecuteQuery(sql,new BeanHandler(BookType.class),id);
    }

    public BookType findBookTypeByValue(String value){
        String sql = "SELECT * FROM bookType WHERE book_type = ?";
        return DBHelp.ExecuteQuery(sql,new BeanHandler(BookType.class),value);
    }

    public List<BookType> findAllBookType(){
        String sql = "SELECT * FROM bookType";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(BookType.class));
    }
}
