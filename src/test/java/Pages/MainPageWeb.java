package Pages;

import org.openqa.selenium.By;

import java.util.logging.Logger;

public class MainPageWeb {

    BaseFunctions baseFunctions;
    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv/";
    private static final By ARTICLE = By.className("top2012-big");
    private static final By ARTICLE_TITLE_WEB = By.xpath(".//a[contains(@class, 'top2012-title')]");
    private static final By COMMENT_COUNT_WEB = By.xpath(".//a[@class='comment-count']");
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MainPageWeb.class));

    public MainPageWeb(BaseFunctions baseFunctions){
        this.baseFunctions = baseFunctions;
        baseFunctions.getUrl(MAIN_PAGE_WEB_URL);
        LOGGER.info("Home page is loaded");
    }

    public static By getARTICLE() {
        return ARTICLE;
    }

    public static By getArticleTitleWeb() {
        return ARTICLE_TITLE_WEB;
    }

    public static By getCommentCountWeb() {
        return COMMENT_COUNT_WEB;
    }

}
