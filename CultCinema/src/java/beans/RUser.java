/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.*;
import beans.sql.UserSQL;
import beans.sqlColumnName.UserColumn;
import common.jdbc.DBconnect;
import common.jdbc.hash.Hash;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author DUNCAN
 */
public class RUser extends UpdatableBean{
    private String account_id;
    private String role;
    private String login_id;
    private String login_pw;
    private String user_name;
    private String user_phone;
    private String user_email;
//-----------------------------------------------------------------------------
    public RUser() {
        super();
        account_id = null;
        role = null;
        login_id = null;
        login_pw = null;
        user_name = null;
        user_phone = null;
        user_email = null;
    }
    public RUser(String login_id) {
        this();
        this.login_id = login_id;
    }
//-----------------------------------------------------------------------------
    public boolean checkPassword(String pw) {
        if (Hash.encrypt("md5", pw).equals(login_pw)) {
            return true;
        }
        else {
            return false;
        }
    }
//-----------------------------------------------------------------------------
    public String getAccountID() {
        return get(UserColumn.ACCOUNT_ID);
    }
    public String getRole() {
        return get(UserColumn.ROLE);
    }
    public String getLoginID() {
        return get(UserColumn.LOGIN_ID);
    }
    public String getLoginPW() {
        return get(UserColumn.LOGIN_PW);
    }
    public String getUserName() {
        return get(UserColumn.USER_NAME);
    }
    public String getUserPhone() {
        return get(UserColumn.USER_PHONE);
    }
    public String getUserEmail() {
        return get(UserColumn.USER_EMAIL);
    }
    private String get(String id) {
        if (id.equals(UserColumn.ACCOUNT_ID)) {
            return account_id;
        }
        else if (id.equals(UserColumn.ROLE)) {
            return role;
        }
        else if (id.equals(UserColumn.LOGIN_ID)) {
            return login_id;
        }
        else if (id.equals(UserColumn.LOGIN_PW)) {
            return login_pw;
        }
        else if (id.equals(UserColumn.USER_NAME)) {
            return user_name;
        }
        else if (id.equals(UserColumn.USER_PHONE)) {
            return user_phone;
        }
        else if (id.equals(UserColumn.USER_EMAIL)) {
            return user_email;
        }
        return "";
    }
    public boolean getIsManager(){
        return this.role.equals(common.RolesConfig.Manager);
    }
    
    public String getLoyalty() {
        String loyalty = "";
        try {
            DBconnect db;
            db = new DBconnect(UserSQL.s1_Loyalty);
            db.setXxx(1, account_id);
            db.executeQuery();
            if (db.queryHasNext()) {
                loyalty = db.getXxx("loyalty");
            }
            db.disconnect();
        } catch (NamingException ex) {
            Logger.getLogger(RUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loyalty;
    }
    
    public int getLoyalty_int(){
        String loyalty = this.getLoyalty();
        if (loyalty != null && !loyalty.equals("") ){
            return Integer.parseInt(loyalty);
        }
        return 0;
    }
//----------------------------------------------------------------------------
    public void setAccountID(String in) {
        set(UserColumn.ACCOUNT_ID, in);
    }
    public void setRole(String in) {
        set(UserColumn.ROLE, in);
    }
    public void setLoginID(String in) {
        set(UserColumn.LOGIN_ID, in);
    }
    public void setLoginPW(String in) {
        set(UserColumn.LOGIN_PW, in);
    }
    public void setUserName(String in) {
        set(UserColumn.USER_NAME, in);
    }
    public void setUserPhone(String in) {
        set(UserColumn.USER_PHONE, in);
    }
    public void setUserEmail(String in) {
        set(UserColumn.USER_EMAIL, in);
    }
    private void set(String id, String in) {
        if (id.equals(UserColumn.ACCOUNT_ID)) {
            this.account_id = in;
        }
        else if (id.equals(UserColumn.ROLE)) {
            this.role = in;
        }
        else if (id.equals(UserColumn.LOGIN_ID)) {
            this.login_id = in;
        }
        else if (id.equals(UserColumn.LOGIN_PW)) {
            this.login_pw = Hash.encrypt("md5", in);
        }
        else if (id.equals(UserColumn.USER_NAME)) {
            this.user_name = in;
        }
        else if (id.equals(UserColumn.USER_PHONE)) {
            this.user_phone = in;
        }
        else if (id.equals(UserColumn.USER_EMAIL)) {
            this.user_email = in;
        }
        this.setChangedTrue();
    }
//----------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        super.fetchDBData();
        try {
            DBconnect db = new DBconnect(UserSQL.s7);
            db.setXxx(1, account_id);
            db.setXxx(2, role);
            db.setXxx(3, login_id);
            db.setXxx(4, login_pw);
            db.setXxx(5, user_name);
            db.setXxx(6, user_phone);
            db.setXxx(7, user_email);
            db.executeQuery();
            if (db.queryHasNext()) {
                account_id = db.getXxx(UserColumn.ACCOUNT_ID);
                role = db.getXxx(UserColumn.ROLE);
                login_id = db.getXxx(UserColumn.LOGIN_ID);
                login_pw = db.getXxx(UserColumn.LOGIN_PW);
                user_name = db.getXxx(UserColumn.USER_NAME);
                user_phone = db.getXxx(UserColumn.USER_PHONE);
                user_email = db.getXxx(UserColumn.USER_EMAIL);
            }
            db.disconnect();
            return true;
        } catch (NamingException ex) {
            Logger.getLogger(beans.RUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(beans.RUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            super.afterInternalChange();
        }
        return false;
    }

    @Override
    public boolean commitChange() {
        super.commitChange();
        if (this.isNew()) {
            return commitInsert();
        }
        return commitUpdate();
    }
    public boolean commitInsert() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(UserSQL.i6);
            db.setResult();
            db.setXxx(2, role);
            db.setXxx(3, login_id);
            db.setXxx(4, login_pw);
            db.setXxx(5, user_name);
            db.setXxx(6, user_phone);
            db.setXxx(7, user_email);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean commitDelete() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(UserSQL.d1);
            db.setResult();
            db.setXxx(2, account_id);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RUser.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    public boolean commitUpdate() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(UserSQL.u5);
            db.setResult();
            db.setXxx(2, account_id);
            db.setXxx(3, login_pw);
            db.setXxx(4, user_name);
            db.setXxx(5, user_phone);
            db.setXxx(6, user_email);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(RUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
