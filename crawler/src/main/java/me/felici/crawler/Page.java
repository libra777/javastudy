package me.felici.crawler;

import javax.persistence.*;
import java.util.Date;

/**
 * User: sunqipeng
 * Date: 12-8-16
 */
@Entity
@Table(name = "t_site_news")
public class Page {
    @Id
    @GeneratedValue
    private int id;
    private boolean visited;
    private String url;
    private String content;
    private int postCount;
    private Date crawlDate;
    private String title;
    private String source;
    private Date reportDate;
    private String outline;
    private boolean errorPage;

    public boolean isErrorPage() {
        return errorPage;
    }

    public void setErrorPage(boolean errorPage) {
        this.errorPage = errorPage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCrawlDate() {
        return crawlDate;
    }

    public void setCrawlDate(Date crawlDate) {
        this.crawlDate = crawlDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
