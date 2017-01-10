package util;

import entity.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/2.
 */
public class DBHelp {
    public static void ExecuteUpdate(String sql,Object...pram){
        Connection connection = ConnectionMananger.getConnection();
        QueryRunner runner = new QueryRunner();
        try {
            runner.update(connection,sql,pram);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
           Close(connection);
        }
    }

    public static <T> T ExecuteQuery(String sql, BeanHandler beanHandler,Object...pram){
        Connection connection = ConnectionMananger.getConnection();
        QueryRunner runner = new QueryRunner();
        try {
            return (T) runner.query(connection,sql,beanHandler,pram);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Close(connection);
        }
        return null;
    }

    public static <T> List<T> ExecuteQueryAll(String sql, BeanListHandler beanListHandler,Object...pram){
        Connection connection = ConnectionMananger.getConnection();
        QueryRunner runner = new QueryRunner();
        try {
            return (List<T>) runner.query(connection,sql,beanListHandler,pram);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Close(connection);
        }
        return null;
    }

    public static <T> T ExecuteSingle( String sql, ScalarHandler scalarHandler,Object...param){
        Connection connection = ConnectionMananger.getConnection();
        QueryRunner runner = new QueryRunner();
        ScalarHandler<T> h = scalarHandler;
        try {
            return runner.query(connection,sql,h,param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Close(connection);
        }
        return null;
    }

    public static void Close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
