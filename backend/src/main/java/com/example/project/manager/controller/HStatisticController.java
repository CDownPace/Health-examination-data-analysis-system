package com.example.project.manager.controller;

import com.example.framework.web.controller.BaseController;
import com.example.framework.web.page.TableDataInfo;
import com.example.project.manager.algorithm.LinearRegression;
import com.example.project.manager.domain.HCheckup;
import com.example.project.manager.domain.HResponseStatistic;
import com.example.project.manager.mapper.HCheckupMapper;
import com.example.project.system.domain.SysUser;
import com.example.project.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager/statistic")
public class HStatisticController extends BaseController {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private HCheckupMapper hCheckupMapper;

    /**
     * 按最近一周体检情况，统计员工患病概率
     */
    // @PreAuthorize("@ss.hasPermi('manager:checkup:list')")
    @GetMapping("/list")
    public TableDataInfo list(Long userId) {
        startPage();

        List<HResponseStatistic> results = hCheckupMapper.getStatistic(userId);

        for (int i = 0; i < results.size(); i++) {
            HResponseStatistic hrs = LinearRegression.setProbilities(results.get(i));
            results.set(i, hrs);
        }

        return getDataTable(results);
    }

}
