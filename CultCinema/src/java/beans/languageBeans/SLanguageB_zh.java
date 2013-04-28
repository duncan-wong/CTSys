/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.languageBeans;

/**
 *
 * @author DUNCAN
 */
public class SLanguageB_zh extends beans.accessInterface.LanguageBean{
    //errorMsg
    public String errorRange(){return"超出許可範圍";}
    public String errorEmail(){return"電郵地址錯誤";}
    public String errorPhone(){return"電話號碼錯誤";}
    public String errorCreditCard(){return"信用卡號碼錯誤";}
    public String errorCreditCardSafe(){return"信用卡安全號碼錯誤";}
    public String errorRefund(){return"積分不足";}
    
    //paymentMsg
    public String pMsgPayOne(){return"交易已完成";}
    public String pMsgCancelOne(){return"交易已取消";}
    public String pMsgPayAll(){return"所有交易已完成";}
    public String pMsgCancelAll(){return"所有交易已取消";}
    
    //common
    public String comSignUp(){return"注冊!";}
    public String comLogIn(){return"登入";}
    public String comLogOut(){return"登出";}
    public String comCancel(){return"取消";}
    public String comBack(){return"返回";}
    public String comPurchase(){return"購買";}
    public String comEdit(){return"編輯";}
    public String comSave(){return"儲侟";}
    public String comHKD(){return"HKD";}
    public String comHouse(){return"影院";}
    public String comSeats(){return"座位";}
    public String comLoyaltyPoint(){return"積分";}
    public String comEmail(){return"電郵";}
    public String comScreen(){return"銀幕";}
    public String comOrder(){return"訂購";}
    public String comTotal(){return"合計";}
    
    
    //menu
    public String mCompanyName(){return"Cult Cinema";}
    public String mMovies(){return"電影";}
    public String mHouses(){return"影院";}
    public String mManager(){return"管理";}
    public String mOfficer(){return"職員";}
    public String mLogIn(){return"登入";}
    public String mLogOut(){return"登出";}
    //menu > language option
    public String mLOzh(){return"中";}
    public String mLOen(){return"Eng";}
    
    
    //header
    //header - index
    public String hIndexMainTitle(){return"Cult Cinema";}
    public String hIndexSubTitle(){return"我們有您想要的!";}
    public String hIndexGreetingMsg(){return"請享受你的歡樂時光, ";}
    public String hIndexControlMsg(){return"是會員嗎?";}
    public String hIndexControlBtnLogIn(){return"登入";}
    public String hIndexControlBtnSignUp(){return"注冊!";}
    //header - login
    public String hLoginMainTitle(){return"登入";}
    public String hLoginControlMsg(){return"還没有成為會員嗎? ";}
    public String hLoginControlBtnSignUp(){return"注冊!";}
    //header - movies
    public String hMoviesMainTitle(){return"電影";}
    public String hMoviesControlBtnOnScreen(){return"正在上映";}
    public String hMoviesControlBtnTomorrow(){return"將會上映";}
    //header - Account
    public String hAccountMainTitle(){return"帳戶";}
    public String hAccountControlMsg(){return"您可以在這裡管理您的帳戶";}
    //header - Registration
    public String hAcRegMainTitle(){return"注冊！";}
    //header - houses
    public String hHousesMainTitle(){return"影院";}
    //header - OrderTicket
    public String hOTMainTitle(){return"訂票";}
    public String hOTMainTitleThankYou(){return"謝謝";}
    
    //content
    //content - index
    public String cIndexContentTitle(){return"正在上映";}
    //content - login
    public String cLoginLbUsername(){return"登入名稱";}
    public String cLoginLbPassword(){return"密碼";}
    public String cLoginBtnSubmit(){return"登入";}
    //content - movies
    public String cMoviesLbMovieTitle(){return"電影標題";}
    public String cMoviesLbDirector(){return"導演";}
    public String cMoviesLbLength(){return"片長";}
    public String cMoviesLbDescription(){return"簡介";}
    public String cMoviesBtnOrderTicket(){return"訂票";}
    //content - account
    public String cAccountLbUsername(){return"登入外稱";}
    public String cAccountLbName(){return"姓名";}
    public String cAccountLbTel(){return"電話";}
    public String cAccountLbEmail(){return"電郵地址";}
    public String cAccountLbNewPassword(){return"新密碼";}
    public String cAccountLbNewPasswordRe(){return"確認新密碼";}
    public String cAccountLbPassword(){return"密碼";}
    public String cAccountLbPasswordRe(){return"確認密碼";}
    public String cAccountLbSetPasswordHints(){return "如不用變更密碼，請留空";}
    public String cAccountLbNewPasswordHints(){return "新密碼";}
    public String cAccountLbConfirmPasswordHints(){return "確認新密碼";}
    public String cAccountLbOriginalPasswordHints(){return "原有密碼";}
    //content - registration , use most label of account page
    //content - houses
    public String cHousesLbCapacity(){return"容量";}
    //content - OrderTicket
    public String cOTErrorPaymentTimeout(){return"交易已過時，請再嘗試";}
    public String cOTAreYouMember(){return"你是會員嗎?";}
    public String cOTNonMemberPurchase(){return"非會員訂票";}
    public String cOTUseLoyaltyPoint(){return"使用積分";}
    public String cOTCreditCardNo(){return"信用卡號碼";}
    public String cOTCreditCardSafeNo(){return"信用卡安全碼";}
    public String cOTBtnOtherMovies(){return"其他電影";}
    //content - exclusiveLogin
    public String cELoginLbStatus(){return"你的帳戶已在其他地方登入";}
    public String cELoginLbInstruction(){return"你想登出其他地方的帳戶嗎?";}
    public String cELoginBtnForceOther(){return"登出其他地方的帳戶";}
    public String cELoginBtnLogoutHere(){return"登出這裡";}
}
