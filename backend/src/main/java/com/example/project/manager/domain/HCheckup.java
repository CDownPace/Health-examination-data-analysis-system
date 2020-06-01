package com.example.project.manager.domain;

import com.example.framework.aspectj.lang.annotation.Excel;
import com.example.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 体检信息对象 h_checkup
 *
 * @author haoxinren
 * @date 2020-03-29
 */
public class HCheckup extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 体检id
     */
    private Long id;

    /**
     * uid
     */
    @Excel(name = "uid")
    private Long uid;

    /**
     * 身高
     */
    @Excel(name = "身高")
    private Long height;

    /**
     * 体重
     */
    @Excel(name = "体重")
    private Long weight;

    /**
     * 高压
     */
    @Excel(name = "高压")
    private Long bloodPressureHigh;

    /**
     * 低压
     */
    @Excel(name = "低压")
    private Long bloodPressureLow;

    /**
     * 血糖
     */
    @Excel(name = "血糖")
    private Float bloodSugar;

    /**
     * 体检时间
     */
    @Excel(name = "体检时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getHeight() {
        return height;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getWeight() {
        return weight;
    }

    public void setBloodPressureHigh(Long bloodPressureHigh) {
        this.bloodPressureHigh = bloodPressureHigh;
    }

    public Long getBloodPressureHigh() {
        return bloodPressureHigh;
    }

    public void setBloodPressureLow(Long bloodPressureLow) {
        this.bloodPressureLow = bloodPressureLow;
    }

    public Long getBloodPressureLow() {
        return bloodPressureLow;
    }

    public void setBloodSugar(Float bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public Float getBloodSugar() {
        return bloodSugar;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("uid", getUid())
                .append("height", getHeight())
                .append("weight", getWeight())
                .append("bloodPressureHigh", getBloodPressureHigh())
                .append("bloodPressureLow", getBloodPressureLow())
                .append("bloodSugar", getBloodSugar())
                .append("date", getDate())
                .toString();
    }
}
