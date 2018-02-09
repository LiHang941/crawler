package xyz.lihang.utils.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * @author : lihang1329@gmail.com
 * @since : 2018/2/8
 */
public class Main {

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Folder f = new Folder(null);

        f.setPath(Constant.BASE_URL).setName("").setDecoderBase64("").setBase64("")
                .handle();

        //生成文件树到本地文件
        StringBuilder stringBuilder = new StringBuilder()
                .append("# 符号说明").append("\n\r")
                .append("# \\ 目录,+空目录 ").append("\n\r")
                .append("# │── 文件").append("\n\r");
        f.tree(stringBuilder);
        Tool.saveFile(Constant.ROOT_DIRECTORY + File.separator + "dir.txt", stringBuilder.toString());


        //入库
//        f.call((x) ->
//            DBUtils.save((Base) x)
//        );
//        DBUtils.closeConnection();

        logger.info("timeout :: " + (new Date().getTime() - startTime));
    }
}
