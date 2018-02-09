package xyz.lihang.utils.crawler;

import java.io.File;

/**
 * @author : lihang1329@gmail.com
 * @since : 2018/2/9
 */
public abstract class Constant {

    public static String ROOT_DIRECTORY = "./crawler";

    public static String BASE_URL = "http://linux.linuxidc.com/";

    public static String TAB_STR = "      ";

    static {
        File file = new File(ROOT_DIRECTORY);
        if(!file.exists())
            file.mkdirs();
    }

}
