package dao;

import entity.Book;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.DBHelp;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/2.
 */
public class BookDao {
    public void addBook(Book book){
        String sql = "INSERT INTO book(bisbn,bname,bauthor,bpublisher,bprice,bcategory) VALUES(?,?,?,?,?,?)";
        DBHelp.ExecuteUpdate(sql,book.getBisbn(),book.getBname(),book.getBauthor(),book.getBpublisher(),book.getBprice(),book.getBcategory());
    }

    public void updateBook(Book book){
        String sql = "UPDATE book SET bname = ?,bauthor = ?,bpublisher = ?,bprice = ?,bcategory = ?,bnum = ? WHERE bisbn = ?";
        DBHelp.ExecuteUpdate(sql,book.getBname(),book.getBauthor(),book.getBpublisher(),book.getBprice(),book.getBcategory(),book.getBnum(),book.getBisbn());
    }


    public void deleteBook(String isbn){
        String sql = "DELETE FROM book WHERE bisbn = ?";
        DBHelp.ExecuteUpdate(sql,isbn);
    }

    public Book findBookByIsbn(String isbn){
        String sql = "SELECT * FROM book WHERE bisbn = ?";
        return DBHelp.ExecuteQuery(sql,new BeanHandler(Book.class),isbn);
    }

    public Book findBookByName(String name){
        String sql = "SELECT * FROM book WHERE name = ?";
        return DBHelp.ExecuteQuery(sql,new BeanHandler(Book.class),name);
    }

    public Integer findBookNumByIsbn(String isbn){
        String sql = "SELECT bnum FROM book WHERE bisbn = ?";
        return DBHelp.ExecuteQuery(sql,new BeanHandler(Book.class),isbn);
    }

    public List<Book> findAllBook(){
        String sql = "SELECT * FROM book";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(Book.class));
    }

    public List<Book> findBookByLike(String name){
        String sql = "SELECT * FROM book WHERE bname LIKE CONCAT('%',?,'%')";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(Book.class),name);
    }
}
