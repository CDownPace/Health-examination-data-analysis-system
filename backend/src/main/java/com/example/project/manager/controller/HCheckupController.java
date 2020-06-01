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
import com.example.project.manager.domain.HCheckup;
import com.example.project.manager.service.IHCheckupService;
import com.example.framework.web.controller.BaseController;
import com.example.framework.web.domain.AjaxResult;
import com.example.common.utils.poi.ExcelUtil;
import com.example.framework.web.page.TableDataInfo;

/**
 * 体检信息Controller
 *
 * @author haoxinren
 * @date 2020-03-29
 */
@RestController
@RequestMapping("/manager/checkup")
public class HCheckupController extends BaseController {
    @Autowired
    private IHCheckupService hCheckupService;

    /**
     * 查询体检信息列表
     */
    // @PreAuthorize("@ss.hasPermi('manager:checkup:list')")
    @GetMapping("/list")
    public TableDataInfo list(HCheckup hCheckup) {
        startPage();
        List<HCheckup> list = hCheckupService.selectHCheckupList(hCheckup);
        return getDataTable(list);
    }

    /**
     * 导出体检信息列表
     */
    // @PreAuthorize("@ss.hasPermi('manager:checkup:export')")
    @Log(title = "体检信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HCheckup hCheckup) {
        List<HCheckup> list = hCheckupService.selectHCheckupList(hCheckup);
        ExcelUtil<HCheckup> util = new ExcelUtil<HCheckup>(HCheckup.class);
        return util.exportExcel(list, "checkup");
    }

    /**
     * 获取体检信息详细信息
     */
    // @PreAuthorize("@ss.hasPermi('manager:checkup:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(hCheckupService.selectHCheckupById(id));
    }

    /**
     * 新增体检信息
     */
    // @PreAuthorize("@ss.hasPermi('manager:checkup:add')")
    @Log(title = "体检信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HCheckup hCheckup) {
        return toAjax(hCheckupService.insertHCheckup(hCheckup));
    }

    /**
     * 修改体检信息
     */
    // @PreAuthorize("@ss.hasPermi('manager:checkup:edit')")
    @Log(title = "体检信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HCheckup hCheckup) {
        return toAjax(hCheckupService.updateHCheckup(hCheckup));
    }

    /**
     * 删除体检信息
     */
    // @PreAuthorize("@ss.hasPermi('manager:checkup:remove')")
    @Log(title = "体检信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(hCheckupService.deleteHCheckupByIds(ids));
    }
}
