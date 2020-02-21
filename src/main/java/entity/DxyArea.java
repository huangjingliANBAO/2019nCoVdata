package entity;

/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-02-20
 **/

public class DxyArea {
    private Integer id;
    private String provinceName;
    private String provinceEnglishName;
    private String cityName;
    private String cityEnglishName;
    private Integer provinceConfirmedCount;
    private Integer provinceSuspectedCount;
    private Integer provinceCuredCount;
    private Integer provinceDeadCount;
    private Integer cityConfirmedCount;
    private Integer citySuspectedCount;
    private Integer cityCuredCount;
    private Integer cityDeadCount;
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceEnglishName() {
        return provinceEnglishName;
    }

    public void setProvinceEnglishName(String provinceEnglishName) {
        this.provinceEnglishName = provinceEnglishName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityEnglishName() {
        return cityEnglishName;
    }

    public void setCityEnglishName(String cityEnglishName) {
        this.cityEnglishName = cityEnglishName;
    }

    public Integer getProvinceConfirmedCount() {
        return provinceConfirmedCount;
    }

    public void setProvinceConfirmedCount(Integer provinceConfirmedCount) {
        this.provinceConfirmedCount = provinceConfirmedCount;
    }

    public Integer getProvinceSuspectedCount() {
        return provinceSuspectedCount;
    }

    public void setProvinceSuspectedCount(Integer provinceSuspectedCount) {
        this.provinceSuspectedCount = provinceSuspectedCount;
    }

    public Integer getProvinceCuredCount() {
        return provinceCuredCount;
    }

    public void setProvinceCuredCount(Integer provinceCuredCount) {
        this.provinceCuredCount = provinceCuredCount;
    }

    public Integer getProvinceDeadCount() {
        return provinceDeadCount;
    }

    public void setProvinceDeadCount(Integer provinceDeadCount) {
        this.provinceDeadCount = provinceDeadCount;
    }

    public Integer getCityConfirmedCount() {
        return cityConfirmedCount;
    }

    public void setCityConfirmedCount(Integer cityConfirmedCount) {
        this.cityConfirmedCount = cityConfirmedCount;
    }

    public Integer getCitySuspectedCount() {
        return citySuspectedCount;
    }

    public void setCitySuspectedCount(Integer citySuspectedCount) {
        this.citySuspectedCount = citySuspectedCount;
    }

    public Integer getCityCuredCount() {
        return cityCuredCount;
    }

    public void setCityCuredCount(Integer cityCuredCount) {
        this.cityCuredCount = cityCuredCount;
    }

    public Integer getCityDeadCount() {
        return cityDeadCount;
    }

    public void setCityDeadCount(Integer cityDeadCount) {
        this.cityDeadCount = cityDeadCount;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Dxyarea{" +
                "id=" + id +
                ", provinceName='" + provinceName + '\'' +
                ", provinceEnglishName='" + provinceEnglishName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityEnglishName='" + cityEnglishName + '\'' +
                ", provinceConfirmedCount=" + provinceConfirmedCount +
                ", provinceSuspectedCount=" + provinceSuspectedCount +
                ", provinceCuredCount=" + provinceCuredCount +
                ", provinceDeadCount=" + provinceDeadCount +
                ", cityConfirmedCount=" + cityConfirmedCount +
                ", citySuspectedCount=" + citySuspectedCount +
                ", cityCuredCount=" + cityCuredCount +
                ", cityDeadCount=" + cityDeadCount +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}