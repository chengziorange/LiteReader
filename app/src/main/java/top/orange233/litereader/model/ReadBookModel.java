package top.orange233.litereader.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import top.orange233.litereader.basemvplib.IModel;
import top.orange233.litereader.bean.BookSourceBean;
import top.orange233.litereader.bean.ChapterListBean;
import top.orange233.litereader.bean.ChapterResultBean;
import top.orange233.litereader.util.ZhuiShuApi;
import top.orange233.litereader.util.ZhuiShuRetrofitSingleton;

public class ReadBookModel implements IModel {

    public void saveChapterContentAsFile(String bookId) {

        ZhuiShuApi.BookSourceService service = ZhuiShuRetrofitSingleton.getApiInstance()
                .create(ZhuiShuApi.BookSourceService.class);
        Call<List<BookSourceBean>> bsbCall = service.getBookSource(bookId);
        bsbCall.enqueue(new retrofit2.Callback<List<BookSourceBean>>() {
            @Override
            public void onResponse(Call<List<BookSourceBean>> call, Response<List<BookSourceBean>> response) {
                for (BookSourceBean bookSource : response.body()) {
                    if ("优质书源".equals(bookSource.getName())) {
                        getChapterList(bookSource);
                        break;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<BookSourceBean>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getChapterList(BookSourceBean bookSourceBean) {
        ZhuiShuApi.ChapterListService service = ZhuiShuRetrofitSingleton.getApiInstance()
                .create(ZhuiShuApi.ChapterListService.class);
        Call<ChapterListBean> clbCall = service.getChapterList(bookSourceBean.get_id());
        clbCall.enqueue(new Callback<ChapterListBean>() {
            @Override
            public void onResponse(Call<ChapterListBean> call, Response<ChapterListBean> response) {
                try {
                    URLEncoder.encode(response.body().getChapters().get(0).getLink(), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ChapterListBean> call, Throwable t) {

            }
        });
    }

    private void getChapterContent(String encodedUrl) {
        ZhuiShuApi.ChapterService service=ZhuiShuRetrofitSingleton.getApiInstance()
                .create(ZhuiShuApi.ChapterService.class);
        Call<ChapterResultBean> crbCall =service.getChapterResult(encodedUrl);
        crbCall.enqueue(new Callback<ChapterResultBean>() {
            @Override
            public void onResponse(Call<ChapterResultBean> call, Response<ChapterResultBean> response) {
                response.body().getChapter().getCpContent();
            }

            @Override
            public void onFailure(Call<ChapterResultBean> call, Throwable t) {

            }
        });
    }
}
