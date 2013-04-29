/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accessInterface;

/**
 *
 * @author DUNCAN
 */
public class LanguageBean {
    //errorMsg
    public String errorRange(){return"Out of range";}
    public String errorEmail(){return"Invalid email";}
    public String errorPhone(){return"Invalid phone no.";}
    public String errorCreditCard(){return"Invalid credit card no.";}
    public String errorCreditCardSafe(){return"Invalid credit card safe no.";}
    public String errorRefund(){return"Not enough loyalty point";}
    
    //paymentMsg
    public String pMsgPayOne(){return"The payment is completed";}
    public String pMsgCancelOne(){return"The booking is canceled";}
    public String pMsgPayAll(){return"The payments are completed";}
    public String pMsgCancelAll(){return"The bookings are canceled";}
    
    //common
    public String comSignUp(){return"Sign Up!";}
    public String comLogIn(){return"Log In";}
    public String comLogOut(){return"Log Out";}
    public String comCancel(){return"Cancel";}
    public String comBack(){return"Back";}
    public String comPurchase(){return"Purchase";}
    public String comEdit(){return"Edit";}
    public String comSave(){return"Save";}
    public String comHKD(){return"HKD";}
    public String comHouse(){return"House";}
    public String comSeats(){return"Seats";}
    public String comLoyaltyPoint(){return"Loyalty point";}
    public String comEmail(){return"Email";}
    public String comScreen(){return"Screen";}
    public String comOrder(){return"Order";}
    public String comTotal(){return"Total";}
    public String comSale(){return"Sale";}
    public String comDel(){return"Delete";}
    public String comConfirm(){return"Confirm";}
    public String comMins(){return"mins";}
    public String comUpdate(){return"Update";}
    
    //menu
    public String mCompanyName(){return"Cult Cinema";}
    public String mMovies(){return"Movies";}
    public String mHouses(){return"Houses";}
    public String mManager(){return"Manager";}
    public String mOfficer(){return"Officer";}
    public String mLogIn(){return"Log In";}
    public String mLogOut(){return"Log Out";}
    //menu > language option
    public String mLOzh(){return"中";}
    public String mLOen(){return"Eng";}
    
    
    //header
    //header - index
    public String hIndexMainTitle(){return"Cult Cinema";}
    public String hIndexSubTitle(){return"We got what you want!";}
    public String hIndexGreetingMsg(){return"Enjoy your time, ";}
    public String hIndexControlMsg(){return"Member?";}
    public String hIndexControlBtnLogIn(){return"Log In";}
    public String hIndexControlBtnSignUp(){return"Sign Up!";}
    //header - login
    public String hLoginMainTitle(){return"Log In";}
    public String hLoginControlMsg(){return"Not a member? ";}
    public String hLoginControlBtnSignUp(){return"Sign Up!";}
    //header - movies
    public String hMoviesMainTitle(){return"Movies";}
    public String hMoviesShowMainTitle(){return"Movie Shows";}
    public String hMoviesControlBtnOnScreen(){return"Movie On Screen";}
    public String hMoviesControlBtnTomorrow(){return"Movie Tomorrow";}
    //header - Account
    public String hAccountMainTitle(){return"Account";}
    public String hAccountControlMsg(){return"you may do your account-specific works here";}
    //header - Registration
    public String hAcRegMainTitle(){return"Sign Up";}
    //header - houses
    public String hHousesMainTitle(){return"Houses";}
    public String hHousesStatMainTitle(){return"Houses Statistic";}
    public String hHousesSeatMainTitle(){return"House Seats";}
    //header - OrderTicket
    public String hOTMainTitle(){return"Order ticket";}
    public String hOTMainTitleThankYou(){return"Thank you";}
    
    //content
    //content - index
    public String cIndexContentTitle(){return"Movie On Screen";}
    //content - login
    public String cLoginLbUsername(){return"Username";}
    public String cLoginLbPassword(){return"Password";}
    public String cLoginBtnSubmit(){return"Log In";}
    //content - movies
    public String cMoviesLbMovieTitle(){return"Movie Title";}
    public String cMoviesLbDirector(){return"Director";}
    public String cMoviesLbLength(){return"Length";}
    public String cMoviesLbDescription(){return"Description";}
    public String cMoviesLbOnScreenTime(){return"On Screen Date";}
    public String cMoviesLbPoster(){return"Poster";}
    public String cMoviesShowLbShowTime(){return"Showing Date";}
    public String cMoviesShowLbTicketPrice(){return"Ticket Price";}
    public String cMoviesBtnAddMovie(){return"Add New Movie";}
    public String cMoviesBtnOrderTicket(){return"Order Ticket";}
    public String cMoviesBtnRemove(){return"Remove Movie";}
    public String cMoviesBtnEdit(){return"Edit Movie";}
    public String cMoviesBtnSeeMovieShow(){return"See Movie Show";}
    public String cMoviesShowBtnAddShow(){return"Add Movie Show";}
    //content - account
    public String cAccountLbUsername(){return"Login ID";}
    public String cAccountLbName(){return"Name";}
    public String cAccountLbTel(){return"Tel";}
    public String cAccountLbEmail(){return"Email";}
    public String cAccountLbNewPassword(){return"New Password";}
    public String cAccountLbNewPasswordRe(){return"Confirm New Password";}
    public String cAccountLbPassword(){return"Password";}
    public String cAccountLbPasswordRe(){return"Confirm password";}
    public String cAccountLbSetPasswordHints(){return "Please leave it blank if don't want to change password.";}
    public String cAccountLbNewPasswordHints(){return "New Password";}
    public String cAccountLbConfirmPasswordHints(){return "Confirm Password";}
    public String cAccountLbOriginalPasswordHints(){return "Original Password";}
    //content - registration , use most label of account page
    //content - houses
    public String cHousesLbCapacity(){return"Capacity";}
    public String cHousesLbDisabledSeat(){return"Disabled Seat";}
    public String cHousesLbTotalRow(){return"Total Row";}
    public String cHousesLbName(){return"House Name";}
    public String cHousesLb(){return"House";}
    public String cHousesBtnStatistic(){return"Show House Statistic";}
    public String cHousesBtnRemove(){return"Remove House";}
    public String cHousesBtnRename(){return"Edit House Name";}
    public String cHousesBtnUpdateSeat(){return"Update Seat Status";}
    public String cHousesBtnAddHouse(){return"Add New House";}
    //content - OrderTicket
    public String cOTErrorPaymentTimeout(){return"Your purchase is timed out. Please select again.";}
    public String cOTAreYouMember(){return"Are you a member?";}
    public String cOTNonMemberPurchase(){return"Non-member purchase";}
    public String cOTUseLoyaltyPoint(){return"Use loyalty point";}
    public String cOTCreditCardNo(){return"Credit Card No.";}
    public String cOTCreditCardSafeNo(){return"Credit Card Safe No.";}
    public String cOTBtnOtherMovies(){return"Other movies";}
    //content - exclusiveLogin
    public String cELoginLbStatus(){return"The account is currently logged in at elsewhere.";}
    public String cELoginLbInstruction(){return"Would you like to force others to logout?";}
    public String cELoginBtnForceOther(){return"Force other to logout";}
    public String cELoginBtnLogoutHere(){return"Logout here";}
}
