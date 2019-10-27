package top.orange233.litereader.model;

import top.orange233.litereader.basemvplib.IModel;
import top.orange233.litereader.bean.FuzzySearchResultBean;
import top.orange233.litereader.bean.ShelfBookBean;
import top.orange233.litereader.util.ZhuiShuRetrofitSingleton;

public class ShelfModel implements IModel {

    public void addToShelf(FuzzySearchResultBean.BooksBean booksBean) {
        ShelfBookBean shelfBookBean = new ShelfBookBean();
        shelfBookBean.setTitle(booksBean.getTitle());
        shelfBookBean.setAuthor(booksBean.getAuthor());
        shelfBookBean.setLatestChapter(booksBean.getLastChapter());

        // 获取章节列表
        // TODO
    }
}
