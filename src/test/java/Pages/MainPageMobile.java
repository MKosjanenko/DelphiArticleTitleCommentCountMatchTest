package Pages;

import org.openqa.selenium.By;

import java.util.List;
import java.util.logging.Logger;

public class MainPageMobile {

    BaseFunctions baseFunctions;
    private static final String MAIN_PAGE_MOBILE_URL = "http://m.delfi.lv/";
    private static final By ARTICLE_TITLES_MOBILE = By.xpath(".//a[contains(@class, 'md-scrollpos')]");
    private static final By COMMENT_COUNTER_MOBILE = By.xpath(".//a[@class='commentCount']");
    private static final By ARTICLE = By.xpath("*//div[starts-with(@class,'md-mosaic-')]");
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MainPageWeb.class));

    public MainPageMobile (BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
        baseFunctions.getUrl(MAIN_PAGE_MOBILE_URL);
        LOGGER.info("Mobile page is loaded");
    }

    public List GetMobileArticleList(){
        return ArticleFlattener.GetTitlesAndComments(ARTICLE_TITLES_MOBILE, COMMENT_COUNTER_MOBILE, ARTICLE);
    };


    public static By getArticleTitlesMobile() {
        return ARTICLE_TITLES_MOBILE;
    }

    public static By getCommentCounterMobile() {
        return COMMENT_COUNTER_MOBILE;
    }

    public static By getARTICLE() {
        return ARTICLE;
    }
}
