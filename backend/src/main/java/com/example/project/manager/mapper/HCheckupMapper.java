package com.example.project.manager.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project.manager.domain.HCheckup;
import com.example.project.manager.domain.HResponseStatistic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 体检信息Mapper接口
 *
 * @author haoxinren
 * @date 2020-03-29
 */
@Repository
public interface HCheckupMapper extends BaseMapper<HCheckup> {
    /**
     * 查询体检信息
     *
     * @param id 体检信息ID
     * @return 体检信息
     */
    public HCheckup selectHCheckupById(Long id);

    /**
     * 查询体检信息列表
     *
     * @param hCheckup 体检信息
     * @return 体检信息集合
     */
    public List<HCheckup> selectHCheckupList(HCheckup hCheckup);

    /**
     * 新增体检信息
     *
     * @param hCheckup 体检信息
     * @return 结果
     */
    public int insertHCheckup(HCheckup hCheckup);

    /**
     * 修改体检信息
     *
     * @param hCheckup 体检信息
     * @return 结果
     */
    public int updateHCheckup(HCheckup hCheckup);

    /**
     * 删除体检信息
     *
     * @param id 体检信息ID
     * @return 结果
     */
    public int deleteHCheckupById(Long id);

    /**
     * 批量删除体检信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHCheckupByIds(Long[] ids);

    /**
     * 获取最新一天的数据进行概率预测
     */
    public List<HResponseStatistic> getStatistic(@Param("userId") Long userId);
}
