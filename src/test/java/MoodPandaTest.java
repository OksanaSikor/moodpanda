import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.DashboardPageService;
import service.FeedGlobalPageService;
import service.LoginPageService;

public class MoodPandaTest extends BaseTest{

    @BeforeClass
    public void setUp() {
        loginPageSteps = new LoginPageService();
        user = new User();
    }

    @Test(description = "Checking rating updates")
    public void checkRatingTest() {
        final int POST_POSITION = 0;
        final String RATING = "5";

        DashboardPageService dashboardPageSteps = loginPageSteps.login(user)
                .clickEditPost()
                .updateRating(POST_POSITION, RATING);
        Boolean SuccessMessageDisplayed = dashboardPageSteps.isSuccessMessageDisplayed();
        dashboardPageSteps.logout();

        Assert.assertTrue(SuccessMessageDisplayed, "smth went wrong");
    }

    @Test(description = "Checking for adding a reply to a message")
    public void checkAddingReplyTest() {
        final int REPLY_POST_POSITION = 0;
        final String REPLY_TEXT = "message reply";

        FeedGlobalPageService feedGlobalPageSteps = loginPageSteps.login(user)
                .addReply(REPLY_POST_POSITION, REPLY_TEXT);
        Boolean SuccessMessageDisplayed = feedGlobalPageSteps.isSuccessMessageDisplayed();
        feedGlobalPageSteps.logout();

        Assert.assertTrue(SuccessMessageDisplayed, "smth went wrong");
    }
}
