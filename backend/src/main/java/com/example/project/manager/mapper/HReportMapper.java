package com.example.project.manager.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project.manager.domain.HReport;
import org.springframework.stereotype.Repository;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author haoxinren
 * @date 2020-03-29
 */
@Repository
public interface HReportMapper extends BaseMapper<HReport> {
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
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteHReportById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHReportByIds(Long[] ids);

    /**
     * 查询最近一周的健康情况
     */
    public List<HReport> selectRecentWeekHReportList(HReport hReport);
}
