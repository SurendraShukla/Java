package me.surendra.event;

import java.io.Serializable;

public class VideoAdUploadRequestEvent implements Serializable, WithID  {

    private static final long serialVersionUID = 1L;
    public static final String VIDEO_AD_UPLOAD_VIDEO_REQUEST = "Video Ad - Upload Video Request";

    private final String batchId;
    private final String webId;
    private final String url;
    private final String template;
    private final String id;

    VideoAdUploadRequestEvent(final String batchId, final String webId, final String template, final String url) {
        this.batchId = batchId;
        this.webId = webId;
        this.url = url;
        this.template = template;
        id = LoggerUtils.format("batchId [{0}], webId [{1}], template [{2}], url [{3}]", batchId, webId, template, url);
    }

    public static VideoAdUploadRequestEvent create(final String batchId, final String webId, final String template, final String url) {
        return new VideoAdUploadRequestEvent(batchId, webId, template, url);
    }

    public String getBatchId() {
        return batchId;
    }

    public String getWebId() {
        return webId;
    }

    public String getUrl() {
        return url;
    }

    public String getTemplate() {
        return template;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


