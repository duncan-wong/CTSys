/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accessInterface;

/**
 *
 * @author A
 */
public abstract class BookingPaymentStatus {
    public static final String Loyalty_Paid = "Loyalty Paid";
    public static final String Payment_Complete = "Payment Complete";
    public static final String Payment_Incomplete = "Payment Incomplete";
    public static final String Payment_Cancel = "Payment Cancel";
    public static final String Payment_Timeout = "Payment Timeout";
    public static final String Payment_Deferred = "Payment Deferred";
    public static final String Refund_Pending = "Refund Pending";
    public static final String Refund_Accepted = "Refund Accepted";
    public static final String Refund_Declined = "Refund Decliend";
}
