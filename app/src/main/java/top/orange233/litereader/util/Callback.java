package top.orange233.litereader.util;

/**
 * @param <K> 当操作成功时回调所传的参
 * @param <V> 当操作失败时回调所传的参
 * @author charles
 */
public interface Callback<K, V> {

    void onSuccess(K data);

    void onFail(V data);
}
