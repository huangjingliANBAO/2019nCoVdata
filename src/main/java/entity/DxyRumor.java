package entity;

/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-02-21
 **/
public class DxyRumor {
    private Integer id;
    private String body;
    private Integer rumorId;
    private String mainSummary;
    private String rumorType;
    private String sourceUrl;
    private String summary;
    private String title;
    private String crawlTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getRumorId() {
        return rumorId;
    }

    public void setRumorId(Integer rumorId) {
        this.rumorId = rumorId;
    }

    public String getMainSummary() {
        return mainSummary;
    }

    public void setMainSummary(String mainSummary) {
        this.mainSummary = mainSummary;
    }

    public String getRumorType() {
        return rumorType;
    }

    public void setRumorType(String rumorType) {
        this.rumorType = rumorType;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(String crawlTime) {
        this.crawlTime = crawlTime;
    }

    @Override
    public String toString() {
        return "DxyRumor{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", rumorId=" + rumorId +
                ", mainSummary='" + mainSummary + '\'' +
                ", rumorType='" + rumorType + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", crawlTime='" + crawlTime + '\'' +
                '}';
    }
}