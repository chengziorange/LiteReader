package top.orange233.litereader.presenter.contract;

import java.util.List;

import top.orange233.litereader.basemvplib.IView;
import top.orange233.litereader.bean.FuzzySearchResultBean;
import top.orange233.litereader.bean.SearchHistoryBean;

public interface SearchBookContract {

    interface View extends IView {

        void showFuzzySearchResult(List<FuzzySearchResultBean.BooksBean> list);

        void updateSearchHistory(List<SearchHistoryBean> list);

        void cleanSearchHistory();
    }

    interface Presenter {

        void fuzzySearchBook(String keyword, int start, int limit);

        void getSearchHistory();

        void cleanSearchHistory();
    }
}
