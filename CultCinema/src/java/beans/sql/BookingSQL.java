/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sql;

/**
 *
 * @author A
 */
public abstract class BookingSQL {
    // - return		booking_id
    // 1 input		account_id
    public static final String
            i1 = "{ ? = call insert_Booking(?) }";
//-----------------------------------------------------------------------------
	// 1 search		account_id
	// 2 search		date : the record after this date ( Default : today )
	// 3 seatch		days before : the record after the "day MINUS days before"
	// 4 search		booking_id
	// 5 search		refund_status
	public static final String
			s0 = "{ call show_PersonalBooking }",
			s1 = "{ call show_PersonalBooking(?) }",
			s2 = "{ call show_PersonalBooking(?,?) }",
			s3 = "{ call show_PersonalBooking(?,?,?) }",
			s4 = "{ call show_PersonalBooking(?,?,?,?) }",
			s5 = "{ call show_PersonalBooking(?,?,?,?,?) }";
}
