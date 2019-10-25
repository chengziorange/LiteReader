package top.orange233.litereader.bean;

import org.litepal.crud.LitePalSupport;

public class SearchHistoryBean extends LitePalSupport {

    private long date;

    private String content;

    public SearchHistoryBean(String content) {
        this.content = content;
        this.date = System.currentTimeMillis();
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
