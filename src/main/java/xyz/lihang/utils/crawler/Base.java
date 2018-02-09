package xyz.lihang.utils.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : lihang1329@gmail.com
 * @since : 2018/2/9
 */
public abstract class Base implements Component {

    protected static Logger logger = LoggerFactory.getLogger(Component.class);

    protected String path;
    protected String name;
    protected String base64;
    protected String decoderBase64;
    protected String size ;
    protected String createTime;

    protected Folder parentFolder = null;

    public Base(Folder parentFolder) {
        this.parentFolder = parentFolder;
    }

    public String getPath() {
        return path;
    }

    public Base setPath(String path) {
        this.path = path;
        return this;
    }

    public String getName() {
        return name;
    }

    public Base setName(String name) {
        this.name = name;
        return this;
    }

    public String getBase64() {
        return base64;
    }

    public Base setBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    public String getDecoderBase64() {
        return decoderBase64;
    }

    public Base setDecoderBase64(String decoderBase64) {
        this.decoderBase64 = decoderBase64;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Base setSize(String size) {
        this.size = size;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Base setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "Base{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", base64='" + base64 + '\'' +
                ", decoderBase64='" + decoderBase64 + '\'' +
                '}';
    }
}