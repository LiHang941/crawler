package xyz.lihang.utils.crawler;

/**
 * @author : lihang1329@gmail.com
 * @since : 2018/2/9
 */
public interface Component {
    void handle();
    void tree(StringBuilder stringBuilder);
    void call(Callback callback);
}
