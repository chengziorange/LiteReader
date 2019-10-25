package top.orange233.litereader.model;

import androidx.annotation.NonNull;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import top.orange233.litereader.basemvplib.IModel;
import top.orange233.litereader.bean.FuzzySearchResultBean;
import top.orange233.litereader.bean.SearchHistoryBean;
import top.orange233.litereader.util.Callback;
import top.orange233.litereader.util.ZhuiShuApi;
import top.orange233.litereader.util.ZhuiShuRetrofitSingleton;

public class FuzzySearchModel implements IModel {

    public void requestSearchResult
            (String keyword, int start, int limit,
             Callback<List<FuzzySearchResultBean.BooksBean>, Boolean> callback) {

        insertSearchHistory(keyword);

        ZhuiShuApi.SearchBookService service = ZhuiShuRetrofitSingleton.getApiInstance()
                .create(ZhuiShuApi.SearchBookService.class);
        Call<FuzzySearchResultBean> fsrbCall = service.getSearchResult(keyword, String.valueOf(start), String.valueOf(limit));
        fsrbCall.enqueue(new retrofit2.Callback<FuzzySearchResultBean>() {
            @Override
            public void onResponse(@NonNull Call<FuzzySearchResultBean> call, @NonNull Response<FuzzySearchResultBean> response) {
                callback.onSuccess(response.body().getBooks());
            }

            @Override
            public void onFailure(@NonNull Call<FuzzySearchResultBean> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void insertSearchHistory(String keyword) {
        List<SearchHistoryBean> list = LitePal
                .where("content = ?", keyword)
                .find(SearchHistoryBean.class);
        if (list.isEmpty()) {
            SearchHistoryBean shb = new SearchHistoryBean(keyword);
            shb.save();
        } else {
            SearchHistoryBean shb = list.get(0);
            shb.setDate(System.currentTimeMillis());
            shb.save();
        }

    }

    public void getSearchHistory(Callback<List<SearchHistoryBean>, Boolean> callback) {
        List<SearchHistoryBean> list = LitePal
                .order("date desc")
                .find(SearchHistoryBean.class);
        if (list != null) {
            callback.onSuccess(list);
        } else {
            list = new ArrayList<>();
            callback.onSuccess(list);
        }
    }

    public void cleanSearchHistory(Callback<Boolean, Boolean> callback) {
        List<SearchHistoryBean> list = LitePal.findAll(SearchHistoryBean.class);
        for (SearchHistoryBean shb : list) {
            shb.delete();
        }
        callback.onSuccess(true);
    }
}