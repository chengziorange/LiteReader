package top.orange233.litereader.bean;

import java.util.List;

public class FuzzySearchResultBean {

    /**
     * books : [{"_id":"59a7bbfde8270aca6e486a3f","hasCp":true,"title":"加盟传化随想录","aliases":"","cat":"人文社科","author":"李盈善","site":"zhuishuvip","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2073278%2F2073278_5d99d3abe3a14d64baec0b5f6be69d0e_default_cover.png%2F","shortIntro":"书籍是人类文明的编年史,是人类历史的载体,是人类理性和智慧的结晶。一个人的阅读史,便是一个人的心灵史和精神成长史。书籍是抚育杰出人才的珍贵乳汁,是支撑伟大心灵的富贵血脉,是铸就高贵灵魂的丰富给养。读书,应该成为一种生活态度、一种存在方式、一种审美情趣、一种精神追求、一种生命寄托、一种人生境界。","lastChapter":"无","retentionRatio":33.55,"banned":0,"allowMonthly":false,"latelyFollower":897,"wordCount":10449107,"contentType":"epub","superscript":"","sizetype":-1,"highlight":{"title":["随","想","录"]}},{"_id":"5d5cf8f83657ea4f6642538e","hasCp":true,"title":"魔冢随录","aliases":"","cat":"玄幻","author":"弥初","site":"zhuishuvip","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F3390335%2F3390335_08c24212c277495fa75b75b1d30ab704.jpg%2F","shortIntro":"契魔，天地灵气在特殊机缘下形成的\u201c种子\u201d，乃一种纯能量体，其形态万千，功能各异，形成的条件也是千奇百怪。名山名水久经蕴育，暴风雷电顺势而生，极寒酷热的极端环境，甚至育于妖兽体内。\n　　契魔各不相同，但它们的共性是，能与修士相结合，寄于源海之内，在灵力的饲喂之下为修士所用，二者休戚与共，一起成长。\n    倒霉的褚烈，资质半残，没有契魔，唯一的亲人又是个坑蒙拐骗、吃喝嫖赌的无良老头，不甘平庸的他该如何才能创造奇迹？","lastChapter":"第五十章 一波未平","retentionRatio":37.72,"banned":0,"allowMonthly":true,"latelyFollower":911,"wordCount":175661,"contentType":"txt","superscript":"","sizetype":-1,"highlight":{"title":["随","录"]}}]
     * total : 29
     * ok : true
     */

    private int total;
    private boolean ok;
    private List<BooksBean> books;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public class BooksBean {
        /**
         * _id : 59a7bbfde8270aca6e486a3f
         * hasCp : true
         * title : 加盟传化随想录
         * aliases :
         * cat : 人文社科
         * author : 李盈善
         * site : zhuishuvip
         * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2073278%2F2073278_5d99d3abe3a14d64baec0b5f6be69d0e_default_cover.png%2F
         * shortIntro : 书籍是人类文明的编年史,是人类历史的载体,是人类理性和智慧的结晶。一个人的阅读史,便是一个人的心灵史和精神成长史。书籍是抚育杰出人才的珍贵乳汁,是支撑伟大心灵的富贵血脉,是铸就高贵灵魂的丰富给养。读书,应该成为一种生活态度、一种存在方式、一种审美情趣、一种精神追求、一种生命寄托、一种人生境界。
         * lastChapter : 无
         * retentionRatio : 33.55
         * banned : 0
         * allowMonthly : false
         * latelyFollower : 897
         * wordCount : 10449107
         * contentType : epub
         * superscript :
         * sizetype : -1
         * highlight : {"title":["随","想","录"]}
         */

        private String _id;
        private boolean hasCp;
        private String title;
        private String aliases;
        private String cat;
        private String author;
        private String site;
        private String cover;
        private String shortIntro;
        private String lastChapter;
        private double retentionRatio;
        private int banned;
        private boolean allowMonthly;
        private int latelyFollower;
        private int wordCount;
        private String contentType;
        private String superscript;
        private int sizetype;
        private HighlightBean highlight;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public boolean isHasCp() {
            return hasCp;
        }

        public void setHasCp(boolean hasCp) {
            this.hasCp = hasCp;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAliases() {
            return aliases;
        }

        public void setAliases(String aliases) {
            this.aliases = aliases;
        }

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getShortIntro() {
            return shortIntro;
        }

        public void setShortIntro(String shortIntro) {
            this.shortIntro = shortIntro;
        }

        public String getLastChapter() {
            return lastChapter;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }

        public double getRetentionRatio() {
            return retentionRatio;
        }

        public void setRetentionRatio(double retentionRatio) {
            this.retentionRatio = retentionRatio;
        }

        public int getBanned() {
            return banned;
        }

        public void setBanned(int banned) {
            this.banned = banned;
        }

        public boolean isAllowMonthly() {
            return allowMonthly;
        }

        public void setAllowMonthly(boolean allowMonthly) {
            this.allowMonthly = allowMonthly;
        }

        public int getLatelyFollower() {
            return latelyFollower;
        }

        public void setLatelyFollower(int latelyFollower) {
            this.latelyFollower = latelyFollower;
        }

        public int getWordCount() {
            return wordCount;
        }

        public void setWordCount(int wordCount) {
            this.wordCount = wordCount;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getSuperscript() {
            return superscript;
        }

        public void setSuperscript(String superscript) {
            this.superscript = superscript;
        }

        public int getSizetype() {
            return sizetype;
        }

        public void setSizetype(int sizetype) {
            this.sizetype = sizetype;
        }

        public HighlightBean getHighlight() {
            return highlight;
        }

        public void setHighlight(HighlightBean highlight) {
            this.highlight = highlight;
        }

        public class HighlightBean {
            private List<String> title;

            public List<String> getTitle() {
                return title;
            }

            public void setTitle(List<String> title) {
                this.title = title;
            }
        }
    }
}
