package me.felici.crawler;

import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 */
public class App {


    static String USER_AGENT = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.1b2) Gecko/20060823 SeaMonkey/1.1a";

    public static void main(String[] args) {

        new App().start();
    }

    private EntityManager entityManager;

    private String targetUrl = "http://news.163.com";

    private void start() {

        init();
        try {
            Document document = Jsoup.connect(targetUrl).userAgent(USER_AGENT).get();
            save(parse(document));


        } catch (IOException e) {
            //logger.error("there is a io exception when connnec the news home page");
            System.exit(-1);
        }

        parseContent();
    }

    /**
     *
     */
    private void parseContent() {
        List<Page> pageList = entityManager.createQuery("select p from Page  p where p.visited=false ").getResultList();
        for (Page page : pageList) {
            try {
                Document document = Jsoup.connect(page.getUrl()).userAgent(USER_AGENT).get();
                parsePageContent(document, page);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    /**
     * @param document
     * @param page
     */
    private void parsePageContent(Document document, Page page) {
        if (document.getElementsByClass("info").size() > 0) {
            String info = document.getElementsByClass("info").get(0).text();

        }
        if (document.getElementsByClass("summary").size() > 0)
            page.setOutline(document.getElementsByClass("summary").get(0).text());
        page.setContent(document.getElementById("endText").html());
        page.setVisited(true);
        int postCount;
        if (document.getElementsByTag("cDRed tieTotalCount").size() > 0)
            postCount = NumberUtils.toInt(document.getElementsByTag("cDRed tieTotalCount").get(0).text());
        else
            postCount = 0;
        page.setPostCount(postCount);

        entityManager.getTransaction().begin();
        entityManager.persist(page);
        entityManager.getTransaction().commit();
    }

    private void init() {
        entityManager = EmUtils.getEntity();
    }

    /**
     * @param pages
     */
    private void save(List<Page> pages) {

        entityManager.getTransaction().begin();
        for (Page page : pages) {
            if (!checkExist(page.getTitle(), page.getUrl()))
                entityManager.persist(page);
        }
        entityManager.getTransaction().commit();
    }

    /**
     * @param title
     * @param url
     * @return
     */
    private boolean checkExist(String title, String url) {
        List result = entityManager.createQuery("select p from Page  p where p.url=:url and p.title=:title").setParameter("url", url).setParameter("title", title).getResultList();
        if (result == null || result.size() == 0)
            return false;
        return true;
    }

    /**
     * @param document
     */
    private List<Page> parse(Document document) {
        List<Page> pages = new ArrayList<Page>();

        Elements elements = document.getElementsByClass("f14bla");
        for (Element element : elements) {
            Elements hrefs = element.getElementsByTag("a");
            parsePage(hrefs, pages);
        }

        return pages;
    }

    /**
     * @param hrefs
     * @param pages
     * @return
     */
    private void parsePage(Elements hrefs, List<Page> pages) {
        for (Element href : hrefs) {
            Page page = new Page();
            page.setCrawlDate(new Date());
            page.setTitle(href.text());
            page.setUrl(href.attr("href"));
            page.setVisited(false);
            pages.add(page);
        }

    }

}
