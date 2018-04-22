import Model.Article;
import Pages.BaseFunctions;
import Pages.MainPageMobile;
import Pages.MainPageWeb;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class DelfiArticleCommentCountMatchTest {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(DelfiArticleCommentCountMatchTest.class));
    BaseFunctions baseFunctions = new BaseFunctions();

    @Test

    public void compareTitlesAndCommentsTest(List<Article> webArticleList, List<Article>  mobileArticleList ){
        MainPageWeb mainPageWeb = new MainPageWeb(baseFunctions);
        MainPageMobile mainPageMobile = new MainPageMobile(baseFunctions);
        compareTitlesAndCommentsTest(mainPageWeb.GetWebArticleList(), mainPageMobile.GetMobileArticleList());

        for (int i=0; i<5; i++){
            //Change to AssertEquals
            Assert.assertTrue("Article titles don't match", webArticleList.get(i).getTitle().equals(mobileArticleList.get(i).getTitle()));
            Assert.assertTrue("Number of comments don't match", mobileArticleList.get(i).getCommentCount().equals(mobileArticleList.get(i).getCommentCount()));
        }
    }
}
