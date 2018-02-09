package xyz.lihang.utils.crawler;

/**
 * @author : lihang1329@gmail.com
 * @since : 2018/2/9
 */
public class LinuxIDCFile extends Base {

    public LinuxIDCFile(Folder parentFolder) {
        super(parentFolder);
    }

    @Override
    public void handle() {
        logger.info("文件::" + this.toString());
    }

    @Override
    public void call(Callback callback) {
        if (callback!=null)
            callback.invok(this);
    }

    @Override
    public void tree(StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder();
        for (Folder temp = parentFolder; temp != null; temp = temp.parentFolder) {
            sb.append(Constant.TAB_STR);
        }
        sb.append(Constant.TAB_STR);
        stringBuilder.append(sb.toString() + "│── " + name + Constant.TAB_STR + path + Constant.TAB_STR + size + Constant.TAB_STR + createTime);
        stringBuilder.append("\n\r");
    }



}

