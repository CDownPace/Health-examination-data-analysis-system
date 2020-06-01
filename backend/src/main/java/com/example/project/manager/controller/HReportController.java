package com.example.project.manager.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.framework.aspectj.lang.annotation.Log;
import com.example.framework.aspectj.lang.enums.BusinessType;
import com.example.project.manager.domain.HReport;
import com.example.project.manager.service.IHReportService;
import com.example.framework.web.controller.BaseController;
import com.example.framework.web.domain.AjaxResult;
import com.example.common.utils.poi.ExcelUtil;
import com.example.framework.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author haoxinren
 * @date 2020-03-29
 */
@RestController
@RequestMapping("/manager/report")
public class HReportController extends BaseController {
    @Autowired
    private IHReportService hReportService;

    /**
     * 查询【请填写功能名称】列表
     */
    // @PreAuthorize("@ss.hasPermi('manager:report:list')")
    @GetMapping("/list")
    public TableDataInfo list(HReport hReport) {
        startPage();
        List<HReport> list = hReportService.selectHReportList(hReport);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    // @PreAuthorize("@ss.hasPermi('manager:report:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HReport hReport) {
        List<HReport> list = hReportService.selectHReportList(hReport);
        ExcelUtil<HReport> util = new ExcelUtil<HReport>(HReport.class);
        return util.exportExcel(list, "report");
    }

    /**
     * 导出【请填写功能名称】列表
     */
    // @PreAuthorize("@ss.hasPermi('manager:report:recent')")
    @Log(title = "【查询最近一周健康日记】", businessType = BusinessType.EXPORT)
    @GetMapping("/recent")
    public TableDataInfo recentWeekData(HReport hReport) {
        startPage();
        List<HReport> list = hReportService.selectRecentWeekHReportList(hReport);
        return getDataTable(list);
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    // @PreAuthorize("@ss.hasPermi('manager:report:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(hReportService.selectHReportById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    // @PreAuthorize("@ss.hasPermi('manager:report:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HReport hReport) {
        return toAjax(hReportService.insertHReport(hReport));
    }

    /**
     * 修改【请填写功能名称】
     */
    // @PreAuthorize("@ss.hasPermi('manager:report:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HReport hReport) {
        return toAjax(hReportService.updateHReport(hReport));
    }

    /**
     * 删除【请填写功能名称】
     */
    // @PreAuthorize("@ss.hasPermi('manager:report:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(hReportService.deleteHReportByIds(ids));
    }
}
