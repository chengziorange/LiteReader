package top.orange233.litereader.bean;

public class BookSourceBean {
    /**
     * _id : 5b978d46af630f0dda040e59
     * name : 优质书源
     * lastChapter : 正文 第七百四十三章 大结局
     * source : zhuishuvip
     * link : http://vip.zhuishushenqi.com/toc/5b978d46af630f0dda040e59
     * isCharge : false
     * chaptersCount : 739
     * updated : 2019-10-07T08:40:12.028Z
     * starting : true
     * host : vip.zhuishushenqi.com
     */

    private String _id;
    private String name;
    private String lastChapter;
    private String source;
    private String link;
    private boolean isCharge;
    private int chaptersCount;
    private String updated;
    private boolean starting;
    private String host;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isIsCharge() {
        return isCharge;
    }

    public void setIsCharge(boolean isCharge) {
        this.isCharge = isCharge;
    }

    public int getChaptersCount() {
        return chaptersCount;
    }

    public void setChaptersCount(int chaptersCount) {
        this.chaptersCount = chaptersCount;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(boolean starting) {
        this.starting = starting;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
