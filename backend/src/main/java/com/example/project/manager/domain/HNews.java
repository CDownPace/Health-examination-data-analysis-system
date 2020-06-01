package com.example.project.manager.domain;

import com.example.framework.aspectj.lang.annotation.Excel;
import com.example.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 健康新闻对象 h_news
 *
 * @author haoxinren
 * @date 2020-05-04
 */
public class HNews extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 新闻标题
     */
    @Excel(name = "新闻标题")
    private String title;

    /**
     * 新闻内容
     */
    @Excel(name = "新闻内容")
    private String content;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("content", getContent())
                .toString();
    }
}
