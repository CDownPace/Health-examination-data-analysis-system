package com.example.project.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project.manager.mapper.HReportMapper;
import com.example.project.manager.domain.HReport;
import com.example.project.manager.service.IHReportService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author haoxinren
 * @date 2020-03-29
 */
@Service
public class HReportServiceImpl implements IHReportService {
    @Autowired
    private HReportMapper hReportMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public HReport selectHReportById(Long id) {
        return hReportMapper.selectHReportById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param hReport 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<HReport> selectHReportList(HReport hReport) {
        return hReportMapper.selectHReportList(hReport);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param hReport 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertHReport(HReport hReport) {
        return hReportMapper.insertHReport(hReport);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param hReport 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateHReport(HReport hReport) {
        return hReportMapper.updateHReport(hReport);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteHReportByIds(Long[] ids) {
        return hReportMapper.deleteHReportByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteHReportById(Long id) {
        return hReportMapper.deleteHReportById(id);
    }

    /**
     * 查询最近一周的健康情况
     */
    @Override
    public List<HReport> selectRecentWeekHReportList(HReport hReport) {
        return hReportMapper.selectRecentWeekHReportList(hReport);
    }
}
