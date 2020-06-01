package com.example.project.manager.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project.manager.mapper.HCheckupMapper;
import com.example.project.manager.domain.HCheckup;
import com.example.project.manager.service.IHCheckupService;

/**
 * 体检信息Service业务层处理
 * 
 * @author haoxinren
 * @date 2020-03-29
 */
@Service
public class HCheckupServiceImpl implements IHCheckupService 
{
    @Autowired
    private HCheckupMapper hCheckupMapper;

    /**
     * 查询体检信息
     * 
     * @param id 体检信息ID
     * @return 体检信息
     */
    @Override
    public HCheckup selectHCheckupById(Long id)
    {
        return hCheckupMapper.selectHCheckupById(id);
    }

    /**
     * 查询体检信息列表
     * 
     * @param hCheckup 体检信息
     * @return 体检信息
     */
    @Override
    public List<HCheckup> selectHCheckupList(HCheckup hCheckup)
    {
        return hCheckupMapper.selectHCheckupList(hCheckup);
    }

    /**
     * 新增体检信息
     * 
     * @param hCheckup 体检信息
     * @return 结果
     */
    @Override
    public int insertHCheckup(HCheckup hCheckup)
    {
        return hCheckupMapper.insertHCheckup(hCheckup);
    }

    /**
     * 修改体检信息
     * 
     * @param hCheckup 体检信息
     * @return 结果
     */
    @Override
    public int updateHCheckup(HCheckup hCheckup)
    {
        return hCheckupMapper.updateHCheckup(hCheckup);
    }

    /**
     * 批量删除体检信息
     * 
     * @param ids 需要删除的体检信息ID
     * @return 结果
     */
    @Override
    public int deleteHCheckupByIds(Long[] ids)
    {
        return hCheckupMapper.deleteHCheckupByIds(ids);
    }

    /**
     * 删除体检信息信息
     * 
     * @param id 体检信息ID
     * @return 结果
     */
    @Override
    public int deleteHCheckupById(Long id)
    {
        return hCheckupMapper.deleteHCheckupById(id);
    }
}
