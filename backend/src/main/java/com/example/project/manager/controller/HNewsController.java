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
import com.example.project.manager.domain.HNews;
import com.example.project.manager.service.IHNewsService;
import com.example.framework.web.controller.BaseController;
import com.example.framework.web.domain.AjaxResult;
import com.example.common.utils.poi.ExcelUtil;
import com.example.framework.web.page.TableDataInfo;

/**
 * 健康新闻Controller
 *
 * @author haoxinren
 * @date 2020-05-04
 */
@RestController
@RequestMapping("/manager/news")
public class HNewsController extends BaseController {
    @Autowired
    private IHNewsService hNewsService;

    /**
     * 查询健康新闻列表
     */
    // @PreAuthorize("@ss.hasPermi('manager:news:list')")
    @GetMapping("/list")
    public TableDataInfo list(HNews hNews) {
        startPage();
        List<HNews> list = hNewsService.selectHNewsList(hNews);
        return getDataTable(list);
    }

    /**
     * 导出健康新闻列表
     */
    // @PreAuthorize("@ss.hasPermi('manager:news:export')")
    @Log(title = "健康新闻", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HNews hNews) {
        List<HNews> list = hNewsService.selectHNewsList(hNews);
        ExcelUtil<HNews> util = new ExcelUtil<HNews>(HNews.class);
        return util.exportExcel(list, "news");
    }

    /**
     * 获取健康新闻详细信息
     */
    // @PreAuthorize("@ss.hasPermi('manager:news:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(hNewsService.selectHNewsById(id));
    }

    /**
     * 新增健康新闻
     */
    // @PreAuthorize("@ss.hasPermi('manager:news:add')")
    @Log(title = "健康新闻", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HNews hNews) {
        return toAjax(hNewsService.insertHNews(hNews));
    }

    /**
     * 修改健康新闻
     */
    // @PreAuthorize("@ss.hasPermi('manager:news:edit')")
    @Log(title = "健康新闻", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HNews hNews) {
        return toAjax(hNewsService.updateHNews(hNews));
    }

    /**
     * 删除健康新闻
     */
    // @PreAuthorize("@ss.hasPermi('manager:news:remove')")
    @Log(title = "健康新闻", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(hNewsService.deleteHNewsByIds(ids));
    }
}
