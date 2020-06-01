import request from '@/utils/request'

export function listStatisticLeader(userId) {
    return request({
        url: '/manager/statistic/list',
        method: 'get',
        params: userId
    })
}