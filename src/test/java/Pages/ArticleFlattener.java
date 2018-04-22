package Pages;

import Model.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qa on 4/22/2018.
 */
public class ArticleFlattener {


    public List GetTitlesAndComments(By titles, By commentCounters, By article) {
        List<WebElement> articles = baseFunctions.driver.findElements(article);
        List<Article> firstFiveArticles = new ArrayList<Article>();

        for (int i = 0; i < 5; i++) {
            Article a = new Article();
            WebElement we = articles.get(i);

            a.setTitle(we.getText());
            LOGGER.info(we.getText());

            if (!we.findElements(commentCounters).isEmpty()) {
                a.setCommentCount(we.findElement(commentCounters).getText());
            } else {
                a.setCommentCount(0);
            }

            LOGGER.info(we.findElement(commentCounters).getText());
            firstFiveArticles.add(a);
        }
        return firstFiveArticles;
    }
}
