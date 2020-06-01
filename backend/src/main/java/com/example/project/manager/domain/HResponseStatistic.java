package com.example.project.manager.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HResponseStatistic {

    private Long userId;
    private String userName;
    private Integer sex;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Integer bloodPressureHigh;
    private Integer bloodPressureLow;
    private Integer bloodSugar;
    private LocalDateTime checkupDate;

    private Double highPressureProbability;
    private Double diabetesProbability;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getBloodPressureHigh() {
        return bloodPressureHigh;
    }

    public void setBloodPressureHigh(Integer bloodPressureHigh) {
        this.bloodPressureHigh = bloodPressureHigh;
    }

    public Integer getBloodPressureLow() {
        return bloodPressureLow;
    }

    public void setBloodPressureLow(Integer bloodPressureLow) {
        this.bloodPressureLow = bloodPressureLow;
    }

    public Integer getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Integer bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public LocalDateTime getCheckupDate() {
        return checkupDate;
    }

    public void setCheckupDate(LocalDateTime checkupDate) {
        this.checkupDate = checkupDate;
    }

    public Double getHighPressureProbability() {
        return highPressureProbability;
    }

    public void setHighPressureProbability(Double highPressureProbability) {
        this.highPressureProbability = highPressureProbability;
    }

    public Double getDiabetesProbability() {
        return diabetesProbability;
    }

    public void setDiabetesProbability(Double diabetesProbability) {
        this.diabetesProbability = diabetesProbability;
    }


}
