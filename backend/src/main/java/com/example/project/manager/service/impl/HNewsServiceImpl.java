package com.example.project.manager.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project.manager.mapper.HNewsMapper;
import com.example.project.manager.domain.HNews;
import com.example.project.manager.service.IHNewsService;

/**
 * 健康新闻Service业务层处理
 * 
 * @author haoxinren
 * @date 2020-05-04
 */
@Service
public class HNewsServiceImpl implements IHNewsService 
{
    @Autowired
    private HNewsMapper hNewsMapper;

    /**
     * 查询健康新闻
     * 
     * @param id 健康新闻ID
     * @return 健康新闻
     */
    @Override
    public HNews selectHNewsById(Long id)
    {
        return hNewsMapper.selectHNewsById(id);
    }

    /**
     * 查询健康新闻列表
     * 
     * @param hNews 健康新闻
     * @return 健康新闻
     */
    @Override
    public List<HNews> selectHNewsList(HNews hNews)
    {
        return hNewsMapper.selectHNewsList(hNews);
    }

    /**
     * 新增健康新闻
     * 
     * @param hNews 健康新闻
     * @return 结果
     */
    @Override
    public int insertHNews(HNews hNews)
    {
        return hNewsMapper.insertHNews(hNews);
    }

    /**
     * 修改健康新闻
     * 
     * @param hNews 健康新闻
     * @return 结果
     */
    @Override
    public int updateHNews(HNews hNews)
    {
        return hNewsMapper.updateHNews(hNews);
    }

    /**
     * 批量删除健康新闻
     * 
     * @param ids 需要删除的健康新闻ID
     * @return 结果
     */
    @Override
    public int deleteHNewsByIds(Long[] ids)
    {
        return hNewsMapper.deleteHNewsByIds(ids);
    }

    /**
     * 删除健康新闻信息
     * 
     * @param id 健康新闻ID
     * @return 结果
     */
    @Override
    public int deleteHNewsById(Long id)
    {
        return hNewsMapper.deleteHNewsById(id);
    }
}
