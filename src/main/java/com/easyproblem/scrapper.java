package com.easyproblem;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class scrapper {
  private static final String baseUrl = "https://www.airbnb.com/s/Sunnyvale--CA--United-States/homes?federated_search_session_id=b47a863a-1705-4de0-94f0-87e5376d9456&refinement_paths%5B%5D=%2Fhomes&query=Sunnyvale%2C%20CA%2C%20United%20States&place_id=ChIJO13QqUW2j4ARosN83Sb7jXY&search_type=section_navigation";
  private static final String userAgentString = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.106 Safari/537.36";
  public static void main(String[]args) {
    WebClient client = new WebClient();
    client.getOptions().setJavaScriptEnabled(false);
    client.getOptions().setCssEnabled(false);
    client.getOptions().setUseInsecureSSL(true);
    try {
      HtmlPage page = client.getPage(baseUrl);
          List<HtmlAnchor>ress=(ArrayList)page.getByXPath("//a[@class='_i24ijs']");
          for(HtmlAnchor a:ress){
            System.out.println("Name is---- "+ a.getAttribute("aria-label"));
            System.out.println("link is---- "+ a.getHrefAttribute());
            System.out.println("**************");
            final Document pag = Jsoup.connect("https://www.airbnb.com"+a.getHrefAttribute()).userAgent(userAgentString).get();
            for(Element searchResult: pag.select("div._1gw6tte")) {
              System.out.println(searchResult.text());
              System.out.println(searchResult.select("a[href]"));
            }

            //List<HtmlDivision>sAnch=(ArrayList)pag.getByXPath("//div[@class='_1gw6tte']");
            int counter=1;
//            for(HtmlDivision aa:sAnch){
//              System.out.println(aa.getByXPath("//div[@class='_qmqoh4']"));
////              if(aa.getByXPath("//div[@class='_qmqoh4']").size()>0) {
////                System.out.println("counter"+counter);
////                //System.out.println(aa.getByXPath("//div[@class='_qmqoh4']"));
////              };
////              counter++;
//            }
            break;
          }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
