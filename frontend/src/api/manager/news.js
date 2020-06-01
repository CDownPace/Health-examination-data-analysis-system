import request from '@/utils/request'

// 查询健康新闻列表
export function listNews(query) {
  return request({
    url: '/manager/news/list',
    method: 'get',
    params: query
  })
}

// 查询健康新闻详细
export function getNews(id) {
  return request({
    url: '/manager/news/' + id,
    method: 'get'
  })
}

// 新增健康新闻
export function addNews(data) {
  return request({
    url: '/manager/news',
    method: 'post',
    data: data
  })
}

// 修改健康新闻
export function updateNews(data) {
  return request({
    url: '/manager/news',
    method: 'put',
    data: data
  })
}

// 删除健康新闻
export function delNews(id) {
  return request({
    url: '/manager/news/' + id,
    method: 'delete'
  })
}

// 导出健康新闻
export function exportNews(query) {
  return request({
    url: '/manager/news/export',
    method: 'get',
    params: query
  })
}