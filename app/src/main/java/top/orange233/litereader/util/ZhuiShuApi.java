package top.orange233.litereader.util;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import top.orange233.litereader.bean.FuzzySearchResultBean;

public interface ZhuiShuApi {

    interface SearchBookService {
        /**
         * @param query 搜索关键字
         * @param start 返回结果起始位置
         * @param limit 返回结果数量限制
         */
        @GET("book/fuzzy-search")
        Call<FuzzySearchResultBean> getSearchResult(
                @Query("query") String query,
                @Query("start") String start,
                @Query("limit") String limit);
    }
}
