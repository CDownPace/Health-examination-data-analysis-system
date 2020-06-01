import request from '@/utils/request'

// 查询体检信息列表
export function listCheckup(query) {
  return request({
    url: '/manager/checkup/list',
    method: 'get',
    params: query
  })
}

// 查询体检信息详细
export function getCheckup(id) {
  return request({
    url: '/manager/checkup/' + id,
    method: 'get'
  })
}

// 新增体检信息
export function addCheckup(data) {
  return request({
    url: '/manager/checkup',
    method: 'post',
    data: data
  })
}

// 修改体检信息
export function updateCheckup(data) {
  return request({
    url: '/manager/checkup',
    method: 'put',
    data: data
  })
}

// 删除体检信息
export function delCheckup(id) {
  return request({
    url: '/manager/checkup/' + id,
    method: 'delete'
  })
}

// 导出体检信息
export function exportCheckup(query) {
  return request({
    url: '/manager/checkup/export',
    method: 'get',
    params: query
  })
}

