package page;

import org.openqa.selenium.By;
import service.DashboardPageService;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FeedGlobalPage extends BasePage{
    private static final String EDIT_POST_LINK = "//section//aside//a[@href='/dashboard/mydata']";
    private static final String REPLY_POST_LINK = "//a[contains(text(), 'Reply')]";
    private static final String REPLY_FIELD = "//textarea";
    private static final String SEND_REPLY_BUTTON = "//button[contains(text(), 'Send reply')]";

    public DashboardPageService clickEditPostLink(){
        $(By.xpath(EDIT_POST_LINK)).click();
        return new DashboardPageService();
    }

    public FeedGlobalPage clickReply(int postPosition){
        $$(By.xpath(REPLY_POST_LINK)).get(postPosition).click();
        return this;
    }

    public FeedGlobalPage fillInReplyField(String replyText){
        $(By.xpath(REPLY_FIELD)).sendKeys(replyText);
        return this;
    }

    public FeedGlobalPage clickSendReplyButton(){
        $(By.xpath(SEND_REPLY_BUTTON)).click();
        return this;
    }

}
