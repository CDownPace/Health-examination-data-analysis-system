package com.example.project.manager.service;

import java.util.List;
import com.example.project.manager.domain.HCheckup;

/**
 * 体检信息Service接口
 * 
 * @author haoxinren
 * @date 2020-03-29
 */
public interface IHCheckupService 
{
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
     * 批量删除体检信息
     * 
     * @param ids 需要删除的体检信息ID
     * @return 结果
     */
    public int deleteHCheckupByIds(Long[] ids);

    /**
     * 删除体检信息信息
     * 
     * @param id 体检信息ID
     * @return 结果
     */
    public int deleteHCheckupById(Long id);
}
