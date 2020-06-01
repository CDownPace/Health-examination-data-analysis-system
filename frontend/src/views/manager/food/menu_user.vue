<template>
  <div class="app-container">
    <!--  推荐食谱  -->
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>菜谱推荐</span>
      </div>
      <div>
        根据您最近一周的健康日报，为您推荐以下菜谱：
      </div>
      <div v-for="f in foodList" :key="f" class="text item" style="margin-top: 25px;">
        {{f}}
      </div>
    </el-card>
  </div>
</template>

<script>
  import { getRecentWeekCheckupByUid } from '@/api/manager/report'
  import { getUid } from '@/utils/auth'

  export default {
    name: 'menu_user',

    data () {
      return {
        recentWeekReport: [],

        foods: {
          // 高血压菜谱
          highPressure: ['凉拌木耳菜', '牡丹花蒸鱼', '枸杞炒芹菜', '明目菊花鸡片', '芹菜水饺', '炒莴笋', '芹菜炒虾仁'],
          // 护肝菜谱
          lever: ['菌香杂粮米糊', '豆腐鲜虾春卷', '腊八粥', '海带豆腐汤', '葡萄橘子汁'],
          // 明目菜谱
          eye: ['胡萝卜排骨粥', '猪肝枸杞面', '枸杞银耳薏米仁甜汤']
        },

        foodList: []
      }
    },

    created () {
      // 从服务器读取近一周的健康日报
      const that = this
      getRecentWeekCheckupByUid(getUid()).then(r => {
        console.log('loaded')
        that.recentWeekReport = r.rows
        // 随机生成菜谱
        that.foodList.length = 0

        that.foodList.push(that.getRandomElementFromArray(that.foods.highPressure))
        that.foodList.push(that.getRandomElementFromArray(that.foods.lever))
        that.foodList.push(that.getRandomElementFromArray(that.foods.eye))

        console.log(that.foodList)
      })
    },

    methods: {
      getRandomElementFromArray(arr) {
        let min = 0
        let max = arr.length - 1
        let idx = Math.floor(Math.random() * (max - min) + min);

        return arr[idx]
      }
    }
  }
</script>

<style scoped>

</style>
