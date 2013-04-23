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
    //menu
    public String mCompanyName(){return"Cult Cinema";}
    public String mMovies(){return"電影";}
    public String mHouses(){return"影院";}
    public String mManager(){return"管理";}
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
    
}
