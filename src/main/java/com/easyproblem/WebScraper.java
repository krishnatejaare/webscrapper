//package com.easyproblem;
//
//public class WebScraper {
//
//  private static final String DEFAULT_URL = "https://newyork.craigslist.org/";
//  private WebClient client;
//
//  /**
//   * Default Constructor
//   */
//  public WebScraper() {
//    client = new WebClient();
//    client.getOptions().setCssEnabled(false);
//    client.getOptions().setJavaScriptEnabled(false);
//  }
//
//  /**
//   * The only method implemented in this class, to scrape web content from the craigslist
//   *
//   * @param keyword - the keyword you want to search
//   * @return A list of Item that has found. A zero size list is return if nothing is found. Null if any exception (e.g. no connectivity)
//   */
//  public List<Item> scrape(String keyword) {
//
//    try {
//      String searchUrl = DEFAULT_URL + "search/sss?sort=rel&query=" + URLEncoder.encode(keyword, "UTF-8");
//      HtmlPage page = client.getPage(searchUrl);
//
//
//      List<?> items = (List<?>) page.getByXPath("//li[@class='result-row']");
//
//      Vector<Item> result = new Vector<Item>();
//
//      for (int i = 0; i < items.size(); i++) {
//        HtmlElement htmlItem = (HtmlElement) items.get(i);
//        HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem.getFirstByXPath(".//p[@class='result-info']/a"));
//        HtmlElement spanPrice = ((HtmlElement) htmlItem.getFirstByXPath(".//a/span[@class='result-price']"));
//
//        // It is possible that an item doesn't have any price, we set the price to 0.0
//        // in this case
//        String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText();
//
//        Item item = new Item();
//        item.setTitle(itemAnchor.asText());
//        item.setUrl(DEFAULT_URL + itemAnchor.getHrefAttribute());
//
//        item.setPrice(new Double(itemPrice.replace("$", "")));
//
//        result.add(item);
//      }
//      client.close();
//      return result;
//    } catch (Exception e) {
//      System.out.println(e);
//    }
//    return null;
//  }
//
//}
