package com.example.project.manager.service;

import java.util.List;
import com.example.project.manager.domain.HReport;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author haoxinren
 * @date 2020-03-29
 */
public interface IHReportService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public HReport selectHReportById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param hReport 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<HReport> selectHReportList(HReport hReport);

    /**
     * 新增【请填写功能名称】
     * 
     * @param hReport 【请填写功能名称】
     * @return 结果
     */
    public int insertHReport(HReport hReport);

    /**
     * 修改【请填写功能名称】
     * 
     * @param hReport 【请填写功能名称】
     * @return 结果
     */
    public int updateHReport(HReport hReport);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteHReportByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteHReportById(Long id);

    /**
     * 查询最近一周的健康情况
     */
    public List<HReport> selectRecentWeekHReportList(HReport hReport);
}
