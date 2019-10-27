package top.orange233.litereader.util;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import top.orange233.litereader.bean.BookSourceBean;
import top.orange233.litereader.bean.ChapterListBean;
import top.orange233.litereader.bean.ChapterResultBean;
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

    interface BookSourceService {
        @GET("atoc?view=summary&book={bookId}")
        Call<List<BookSourceBean>> getBookSource(
                @Path("bookId") String bookId);
    }

    interface ChapterListService {
        @GET("{sourceId}?view=chapters")
        Call<ChapterListBean> getChapterList(
                @Path("sourceId") String sourceId);
    }

    interface ChapterService {
        @GET("chapter/{encodedUrl}")
        Call<ChapterResultBean> getChapterResult(
                @Path("encodedUrl") String encodedUrl);
    }
}
