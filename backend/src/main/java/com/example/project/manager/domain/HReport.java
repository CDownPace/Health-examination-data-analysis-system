package com.example.project.manager.domain;

import com.example.framework.aspectj.lang.annotation.Excel;
import com.example.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【请填写功能名称】对象 h_report
 *
 * @author haoxinren
 * @date 2020-03-29
 */
public class HReport extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long uid;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String smoke;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sleep;


    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long bloodPressureHigh;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long bloodPressureLow;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String alcohol;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
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

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getSmoke() {
        return smoke;
    }

    public String getDiary() {
        return diary;
    }

    public void setDiary(String diary) {
        this.diary = diary;
    }

    private String diary;

    public void setSleep(String sleep) {
        this.sleep = sleep;
    }

    public String getSleep() {
        return sleep;
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

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getAlcohol() {
        return alcohol;
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
                .append("smoke", getSmoke())
                .append("sleep", getSleep())
                .append("bloodPressureHigh", getBloodPressureHigh())
                .append("bloodPressureLow", getBloodPressureLow())
                .append("alcohol", getAlcohol())
                .append("date", getDate())
                .toString();
    }
}
