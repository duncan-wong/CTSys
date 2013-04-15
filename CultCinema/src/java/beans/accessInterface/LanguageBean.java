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
    //menu
    public String mCompanyName(){return"Cult Cinema";}
    public String mMovies(){return"Movies";}
    public String mHouses(){return"Houses";}
    public String mManager(){return"Manager";}
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
    public String hMoviesControlBtnOnScreen(){return"Movie On Screen";}
    public String hMoviesControlBtnTomorrow(){return"Movie Tomorrow";}
    //header - Account
    public String hAccountMainTitle(){return"Account";}
    public String hAccountControlMsg(){return"you may do your account-specific works here";}
    
    
    
    //content
    //content - index
    public String cIndexContentTitle(){return"Movie On Screen";}
    //content - login
    public String cLoginLbUsername(){return"Username";}
    public String cLoginLbPassword(){return"Password";}
    public String cLoginBtnSubmit(){return"Log In";}
    //content - movies
    public String cMoviesLbMovieTitle(){return"MovieTitle";}
    public String cMoviesLbAuthor(){return"Author";}
    public String cMoviesLbLength(){return"Length";}
    public String cMoviesLbDescription(){return"Description";}
    public String cMoviesBtnOrderTicket(){return"Order Ticket";}
    //content - account
    public String cAccountLbUsername(){return"Username";}
    
}
