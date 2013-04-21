/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sql;

/**
 *
 * @author A
 */
public abstract class UserSQL {
	// 1 search		account_id
	// 2 search		role
	// 3 search		login_id
	// 4 search		login_pw
	// 5 search		user_name
	// 6 search		user_phone
	// 7 search		user_email
	public static final String
			s7 = "{ call show_User(?,?,?,?,?,?,?) }";
//---------------------------------------------------------------------------
    // 0 output     -1 if have error
    // 1 input      role
    // 2 input      login_id
    // 3 input      login_pw
    // 4 input      user_name
    // 5 input      user_phone
    // 6 input      user_email
    public static final String
            i6 = "{ ? = call insert_User(?,?,?,?,?,?) }";
//---------------------------------------------------------------------------
    // 0 output     -1 if have error
    // 1 input      account_id
    // 2 input      login_pw
    // 3 input      user_name
    // 4 input      user_phone
    // 5 input      user_email
    public static final String
            u5 = "{ ? = call update_User(?,?,?,?,?) }";
//---------------------------------------------------------------------------
    // 0 output     -1 if have error
    // 1 input      account_id
    public static final String
            d1 = "{ ? = call delete_User(?) }";
//---------------------------------------------------------------------------
    // 1 input      account_id
    public static final String
            s1_Loyalty = "{ call show_UserLoyalty(?) }";
}
