package Pages;

import Model.Article;
import org.openqa.selenium.By;

import java.util.List;
import java.util.logging.Logger;

public class MainPageWeb {

    BaseFunctions baseFunctions;
    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv/";
    private static final By ARTICLE = By.xpath(".//h3[contains(@class, 'top2012-title')]");
    private static final By ARTICLE_TITLE_WEB = By.xpath(".//a[contains(@class, 'top2012-title')]");
    private static final By COMMENT_COUNT_WEB = By.xpath(".//a[@class='comment-count']");
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MainPageWeb.class));

    public MainPageWeb(BaseFunctions baseFunctions){
        this.baseFunctions = baseFunctions;
        baseFunctions.getUrl(MAIN_PAGE_WEB_URL);
        LOGGER.info("Home page is loaded");
    }

    MainPageWeb mainPageWeb = new MainPageWeb(baseFunctions);

    public List GetWebArticleList(){
        return ArticleFlattener.GetTitlesAndComments(ARTICLE_TITLE_WEB, COMMENT_COUNT_WEB, ARTICLE);
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
