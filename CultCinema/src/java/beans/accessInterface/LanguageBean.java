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
    public final String mCompanyName = "Cult Cinema";
    public final String mMovies = "Movies";
    public final String mHouses = "Houses";
    public final String mManager = "Manager";
    public final String mLogIn = "Log In";
    public final String mLogOut = "Log Out";
    //menu > language option
    public final String mLOzh = "中";
    public final String mLOen = "Eng";
    
    
    //header
    //header - index
    public final String hIndexMainTitle = "Cult Cinema";
    public final String hIndexSubTitle = "We got what you want!";
    public final String hIndexGreetingMsg = "Enjoy your time, ";
    public final String hIndexControlMsg = "Member?";
    public final String hIndexControlBtnLogIn = "Log In";
    public final String hIndexControlBtnSignUp = "Sign Up!";
    //header - login
    public final String hLoginMainTitle = "Log In";
    public final String hLoginControlMsg = "Not a member? ";
    public final String hLoginControlBtnSignUp = "Sign Up!";
    //header - movies
    public final String hMoviesMainTitle = "Movies";
    public final String hMoviesControlBtnOnScreen = "Movie On Screen";
    public final String hMoviesControlBtnTomorrow = "Movie Tomorrow";
    //header - Account
    public final String hAccountMainTitle = "Account";
    public final String hAccountControlMsg = "you may do your account-specific works here";
    
    
    
    //content
    //content - index
    public final String cIndexContentTitle = "Movie On Screen";
    //content - login
    public final String cLoginLbUsername = "Username";
    public final String cLoginLbPassword = "Password";
    public final String cLoginBtnSubmit = "Log In";
    //content - movies
    public final String cMoviesLbMovieTitle = "MovieTitle";
    public final String cMoviesLbAuthor = "Author";
    public final String cMoviesLbLength = "Length";
    public final String cMoviesLbDescription = "Description";
    public final String cMoviesBtnOrderTicket = "Order Ticket";
    //content - account
    public final String cAccountLbUsername = "Username";
    
    public String getcIndexContentTitle(){
        return this.cIndexContentTitle;
    }
    
}
