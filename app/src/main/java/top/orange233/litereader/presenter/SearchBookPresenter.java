package top.orange233.litereader.presenter;

import java.util.List;

import top.orange233.litereader.basemvplib.BasePresenter;
import top.orange233.litereader.bean.FuzzySearchResultBean;
import top.orange233.litereader.bean.SearchHistoryBean;
import top.orange233.litereader.model.FuzzySearchModel;
import top.orange233.litereader.presenter.contract.SearchBookContract;
import top.orange233.litereader.util.Callback;

public class SearchBookPresenter extends BasePresenter<SearchBookContract.View> implements SearchBookContract.Presenter {

    private final FuzzySearchModel fuzzySearchModel;

    public SearchBookPresenter() {
        this.fuzzySearchModel = new FuzzySearchModel();
    }

    // 通知 M 进行模糊搜索
    @Override
    public void fuzzySearchBook(String keyword, int start, int limit) {
        if (isViewAttached()) {
            fuzzySearchModel.requestSearchResult(keyword, start, limit, new Callback<List<FuzzySearchResultBean.BooksBean>, Boolean>() {
                @Override
                public void onSuccess(List<FuzzySearchResultBean.BooksBean> data) {
                    // 通知 V 显示搜索结果
                    mView.showFuzzySearchResult(data);
                }

                @Override
                public void onFail(Boolean data) {
                    new Throwable().printStackTrace();
                }
            });
        } else {
            new Throwable().printStackTrace();
        }
    }

    // 通知 M 获取搜索历史
    @Override
    public void getSearchHistory() {
        fuzzySearchModel.getSearchHistory(new Callback<List<SearchHistoryBean>, Boolean>() {
            @Override
            public void onSuccess(List<SearchHistoryBean> data) {
                // 通知 V 更新搜索历史
                mView.updateSearchHistory(data);
            }

            @Override
            public void onFail(Boolean data) {
                new Throwable().printStackTrace();
            }
        });
    }

    @Override
    public void cleanSearchHistory() {
        fuzzySearchModel.cleanSearchHistory(new Callback<Boolean, Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                mView.cleanSearchHistory();
            }

            @Override
            public void onFail(Boolean data) {
                new Throwable().printStackTrace();
            }
        });
    }
}
