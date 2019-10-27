package top.orange233.litereader.bean;

import org.litepal.crud.LitePalSupport;

public class ShelfBookBean extends LitePalSupport {

    private String title;

    private String author;

    private String readChapter;

    private String latestChapter;

    private String wrapperUrl;

    private long date;

    public ShelfBookBean() {
        this.date = System.currentTimeMillis();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReadChapter() {
        return readChapter;
    }

    public void setReadChapter(String readChapter) {
        this.readChapter = readChapter;
    }

    public String getLatestChapter() {
        return latestChapter;
    }

    public void setLatestChapter(String latestChapter) {
        this.latestChapter = latestChapter;
    }

    public String getWrapperUrl() {
        return wrapperUrl;
    }

    public void setWrapperUrl(String wrapperUrl) {
        this.wrapperUrl = wrapperUrl;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
