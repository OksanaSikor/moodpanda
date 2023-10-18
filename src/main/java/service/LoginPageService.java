package service;

import model.User;
import page.LoginPage;

public class LoginPageService extends LoginPage {

    LoginPage loginPage = new LoginPage();

    public FeedGlobalPageService login(User user){
        loginPage.openLoginPage()
                .enterEmail(user.getUserEmail())
                .enterPassword(user.getUserPassword())
                .clickLoginButton();
        return new FeedGlobalPageService();
    }
}
