package xyz.lihang.utils.crawler;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具
 *
 * @author : lihang1329@gmail.com
 * @since : 2018/2/9
 */
public abstract class Tool {

    private static Logger logger = LoggerFactory.getLogger(Tool.class);


    public static void saveFile(String path, String s) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            IOUtils.write(s, fos);
            fos.flush();
            logger.info("保存文件 -->" + path);
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    public static String get(String url) {
        InputStream inputStream = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            inputStream = conn.getInputStream();
            return IOUtils.toString(inputStream, "GBK");
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static Pattern folderRegex =
            Pattern.compile("<a\\shref=\"((?:linuxconf/download|index)\\.php\\?((?:folder|file))=([a-zA-Z0-9=+/]+))\">((?:(?!>|<).)+)</a>(?:</div></td><td\\swidth=\"100\">([\\d.\\-\\p{Upper}\\s]+)</td>\\s+<td\\swidth=\"125\">(([0-9\\-\\s:]+))</td>)?");

    public static Set<String> urlSet = new HashSet<>();

    public static Set<Component> handleHTML(String html, Folder parentFolder) {
        if (html == null || html.lastIndexOf("Folder specified does not exist. This could be because you manually entered the folder name in the URL or you don't have permission to access this folder") != -1) {
            if (html == null) {
                logger.error("html is null");
            }
            if (parentFolder != null)
                logger.error("folder null path ::" + parentFolder.getPath());
            else
                logger.error("folder null");
            return new HashSet<>();
        }
        Set<Component> set = new HashSet<>();
        Matcher m = folderRegex.matcher(html);
        while (m.find()) {
            try {
                String name = m.group(4);
                String base64 = m.group(3);
                String decoderBase64 = URLDecoder.decode(new String(Base64.getDecoder().decode(base64), "GBK"), "GBK");
                String path = Constant.BASE_URL + m.group(1);
                if (!urlSet.contains(path)) { //url 去重
                    urlSet.add(path);
                    Base base ;
                    if (path.contains("folder")) {
                        base = new Folder(parentFolder);
                    } else {
                        base = new LinuxIDCFile(parentFolder);
                    }
                    set.add(
                            base.setPath(path)
                                    .setBase64(base64)
                                    .setName(name)
                                    .setDecoderBase64(decoderBase64)
                                    .setSize(m.group(5))
                                    .setCreateTime(m.group(6))
                    );
                }
            } catch (Exception e) {
                logger.error(m.group(1) + "::::" + m.group(2) + "::::" + m.group(3) + "::::" + m.group(4) + "::::" + m.group());
                logger.error(e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return set;
    }

}
