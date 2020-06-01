package com.example.project.manager.mapper;

import java.util.List;
import com.example.project.manager.domain.HNews;

/**
 * 健康新闻Mapper接口
 * 
 * @author haoxinren
 * @date 2020-05-04
 */
public interface HNewsMapper 
{
    /**
     * 查询健康新闻
     * 
     * @param id 健康新闻ID
     * @return 健康新闻
     */
    public HNews selectHNewsById(Long id);

    /**
     * 查询健康新闻列表
     * 
     * @param hNews 健康新闻
     * @return 健康新闻集合
     */
    public List<HNews> selectHNewsList(HNews hNews);

    /**
     * 新增健康新闻
     * 
     * @param hNews 健康新闻
     * @return 结果
     */
    public int insertHNews(HNews hNews);

    /**
     * 修改健康新闻
     * 
     * @param hNews 健康新闻
     * @return 结果
     */
    public int updateHNews(HNews hNews);

    /**
     * 删除健康新闻
     * 
     * @param id 健康新闻ID
     * @return 结果
     */
    public int deleteHNewsById(Long id);

    /**
     * 批量删除健康新闻
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHNewsByIds(Long[] ids);
}
