package xyz.lihang.utils.crawler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author : lihang1329@gmail.com
 * @since : 2018/2/9
 */
public class Folder extends Base {

    private Collection<Component> componentList;

    public Folder(Folder parentFolder) {
        super(parentFolder);
    }

    @Override
    public void handle() {
        String s = Tool.get(path);
        logger.info("get  文件夹:::" + super.toString());
        this.componentList = Tool.handleHTML(s, this);
        for (Component component : componentList) {
            component.handle();
            logger.info(component.toString());
        }
    }

    @Override
    public void call(Callback callback) {
        if (callback!=null)
            callback.invok(this);

        for (Component component : componentList) {
            component.call(callback);
        }
    }

    @Override
    public void tree(StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder();
        for (Folder f = parentFolder; f != null; f = f.parentFolder) {
            sb.append(Constant.TAB_STR);
        }


        if (componentList == null || componentList.size() == 0) {
            stringBuilder
                    .append(sb.toString())
                    .append("+ ")
                    .append( name )
                    .append(Constant.TAB_STR )
                    .append( path )
                    .append( Constant.TAB_STR )
                    .append(size )
                    .append(Constant.TAB_STR )
                    .append(createTime)
                    .append("\n\r");
            return;
        } else {
            stringBuilder
                    .append(sb.toString())
                    .append("\\ ")
                    .append( name )
                    .append(Constant.TAB_STR )
                    .append( path )
                    .append( Constant.TAB_STR )
                    .append(size )
                    .append(Constant.TAB_STR )
                    .append(createTime)
                    .append("\n\r");
        }
        List<Component> temp = new ArrayList<>(componentList);
        //自反性，传递性，对称性 a>b b>c a>c
        temp.sort((Component o1, Component o2) -> {
            if (o1 instanceof Folder && o2 instanceof LinuxIDCFile) {
                return -1;
            } else if (o1 instanceof LinuxIDCFile && o2 instanceof Folder) {
                return 1;
            } else {
                return 0;
            }
        });
        for (Component component : temp) {
            component.tree(stringBuilder);
        }
    }
}