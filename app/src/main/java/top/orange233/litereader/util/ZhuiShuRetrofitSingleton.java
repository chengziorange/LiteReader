package top.orange233.litereader.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZhuiShuRetrofitSingleton {

    private static final Retrofit API_INSTANCE = new Retrofit.Builder()
            .baseUrl("https://api.zhuishushenqi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final Retrofit PIC_INSTANCE = new Retrofit.Builder()
            .baseUrl("https://statics.zhuishushenqi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final Retrofit TEXT_INSTANCE = new Retrofit.Builder()
            .baseUrl("https://novel.juhe.im/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Retrofit getApiInstance() {
        return API_INSTANCE;
    }

    public static Retrofit getPicInstance() {
        return PIC_INSTANCE;
    }

    public static Retrofit getTextInstance() {
        return TEXT_INSTANCE;
    }
}
