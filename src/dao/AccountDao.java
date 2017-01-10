package dao;

import entity.Account;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.DBHelp;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/1/2.
 */
public class AccountDao {
    public void addAccount(Account account){
        String sql = "INSERT INTO account(username,password) VALUES(?,?)";
        DBHelp.ExecuteUpdate(sql,account.getUsername(),account.getPassword());
    }

    public void updateAccount(Account account){
        String sql = "UPDATE account SET username = ?,password = ?,UUID = ? WHERE id = ?";
        DBHelp.ExecuteUpdate(sql,account.getUsername(),account.getPassword(),account.getUUID(),account.getId());
    }

    public void deleteAccount(Integer id){
        String sql = "DELETE FROM account WHERE id = ?";
        DBHelp.ExecuteUpdate(sql,id);
    }

    public Account findAccountById(Integer id){
        String sql = "SELECT * FROM account WHERE id = ?";
        return DBHelp.ExecuteQuery(sql,new BeanHandler(Account.class),id);
    }

    public Account findAccountByName(String name){
        String sql = "SELECT * FROM account WHERE username = ?";
        return DBHelp.ExecuteQuery(sql,new BeanHandler(Account.class),name);
    }

    public List<Account> findAllAccount(){
        String sql = "SELECT * FROM account";
        return DBHelp.ExecuteQueryAll(sql,new BeanListHandler(Account.class));
    }
}
