import Model.Article;
import Pages.BaseFunctions;
import Pages.MainPageMobile;
import Pages.MainPageWeb;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DelfiArticleCommentCountMatchTest {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(DelfiArticleCommentCountMatchTest.class));
    BaseFunctions baseFunctions = new BaseFunctions();

    public List GetTitlesAndComments(By titles, By commentCounters, By article) {
        List<WebElement> articles = baseFunctions.driver.findElements(article);
        List<Article> firstFiveArticles = new ArrayList<Article>();

        for (int i = 0; i < 5; i++) {
            Article a = new Article();
            WebElement we = articles.get(i);

            a.setTitle(we.findElement(titles).getText());
            LOGGER.info(we.findElement(titles).getText());

            try {
                a.setCommentCount(we.findElement(commentCounters).getText());
            } catch (org.openqa.selenium.NoSuchElementException e){
                a.setCommentCount(null);
                continue;
            }

            LOGGER.info(we.findElement(commentCounters).getText());
            firstFiveArticles.add(a);
        }
        return firstFiveArticles;
    }

    public void compareTitlesAndCommentsTest(List<Article> webArticleList, List<Article>  mobileArticleList ){
        for (int i=0; i<5; i++){
            Assert.assertTrue("Article titles don't match", webArticleList.get(i).getTitle()==mobileArticleList.get(i).getTitle());
            Assert.assertTrue("Number of comments don't match", mobileArticleList.get(i).getCommentCount()==mobileArticleList.get(i).getCommentCount());
        }
    }


    @Test
    public void articleTest() {
        MainPageWeb mainPageWeb = new MainPageWeb(baseFunctions);
        List<Article> webArtcileList = GetTitlesAndComments(mainPageWeb.getArticleTitleWeb(), mainPageWeb.getCommentCountWeb(), mainPageWeb.getARTICLE());

        MainPageMobile mainPageMobile = new MainPageMobile(baseFunctions);
        List<Article> mobileArticleList = GetTitlesAndComments(mainPageMobile.getArticleTitlesMobile(), mainPageMobile.getCommentCounterMobile(), mainPageMobile.getARTICLE());

        compareTitlesAndCommentsTest(webArtcileList, mobileArticleList);
        baseFunctions.driver.quit();
    }


}
