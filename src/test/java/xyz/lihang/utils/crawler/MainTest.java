package xyz.lihang.utils.crawler;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : lihang1329@gmail.com
 * @since : 2018/2/9
 */
public class MainTest {

    private static Logger logger = LoggerFactory.getLogger(MainTest.class);

    @Test
    public void initTest()throws Exception{
        Main.main(null);
    }

    private static String ss = "<a\\shref=\"((?:linuxconf/download|index)\\.php\\?((?:folder|file))=([a-zA-Z0-9=+/]+))\">((?:(?!>|<).)+)</a>" +
            "(?:</div></td><td\\swidth=\"100\">([\\d.\\-\\p{Upper}\\s]+)</td>\\s+<td\\swidth=\"125\">(([0-9\\-\\s:]+))</td>)?";
    private static Pattern folderRegex =
            Pattern.compile(ss);


    @Test
    public void regTest(){
        logger.info(ss);
        String s = Tool.get("http://linux.linuxidc.com/index.php");
        logger.info(s);
        Matcher matcher = folderRegex.matcher(s);

        while (matcher.find()){
            logger.info("=====================");
            for(int i=0;i<matcher.groupCount();i++){
                logger.info(matcher.group(i));
            }
            logger.info("=====================");
        }
    }
    
    @Test
    public void dbTest(){
        String s = Tool.get("http://linux.linuxidc.com/index.php");
        Set<Component> components = Tool.handleHTML(s, null);
        for (Component component : components) {
            DBUtils.save((Base) component);
        }
    }

    @Test
    public void saveFile(){
        Tool.saveFile(Constant.ROOT_DIRECTORY + File.separator + "1.txt","sadadas");
    }

}
