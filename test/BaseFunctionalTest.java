import com.gargoylesoftware.htmlunit.BrowserVersion;
import net.sourceforge.jwebunit.htmlunit.HtmlUnitTestingEngineImpl;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import play.mvc.Router;
import play.test.FunctionalTest;

public abstract class BaseFunctionalTest extends FunctionalTest
{
   protected WebTester wt;
   protected BrowserVersion defaultBrowserVersion = BrowserVersion.INTERNET_EXPLORER_8;

   @Before
   public void before()
   {
      wt = new WebTester();
      wt.getTestContext().setUserAgent(defaultBrowserVersion.getUserAgent());
      if (wt.getTestingEngine() instanceof HtmlUnitTestingEngineImpl)
      {
         ((HtmlUnitTestingEngineImpl) wt.getTestingEngine()).setDefaultBrowserVersion(defaultBrowserVersion);
      }
      wt.setBaseUrl(getRouteAbsolute("Application.index"));
      wt.getTestingEngine().setIgnoreFailingStatusCodes(false);
   }
   protected String getRouteAbsolute(String action)
   {
      Router.ActionDefinition route = Router.reverse(action);
      route.absolute();
      return route.url;
   }
   protected String getRoute(String action)
   {
      return Router.reverse(action).url;
   }
}