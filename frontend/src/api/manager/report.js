import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listReport(query) {
  return request({
    url: '/manager/report/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】列表
export function listReportByUid(query, uid) {
  return request({
    url: '/manager/report/list',
    method: 'get',
    params: {...query, uid}
  })
}

// 查询【请填写功能名称】详细
export function getReport(id) {
  return request({
    url: '/manager/report/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addReport(data) {
  return request({
    url: '/manager/report',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateReport(data) {
  return request({
    url: '/manager/report',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delReport(id) {
  return request({
    url: '/manager/report/' + id,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportReport(query) {
  return request({
    url: '/manager/report/export',
    method: 'get',
    params: query
  })
}

export function getRecentWeekCheckupByUid(uid) {
  return request({
    url: '/manager/report/recent',
    method: 'get',
    params: { uid }
  })
}
