<template>
  <div class="app-container">
    <el-card v-for="(n, idx) in newsList" :key="idx" style="margin-top: 20px; margin-bottom: 20px;">
      <div slot="header" class="clearfix">
        <div slot="extra">
          <!--  -->
          <el-button style="float: right; padding: 3px 0" type="text" @click="onFavorite(n)">收藏</el-button>
        </div>
        <span>{{ n.title }}</span>

      </div>

      <!-- <el-row style="margin-bottom: 10px;">
        <el-tag>{{ parseTime(n.date, '{y}-{m}-{d}') }}</el-tag>
      </el-row> -->

      <el-row>
        <el-col :span="18">
          {{ n.content }}
        </el-col>
        <!-- <el-col :span="6">
          <img :src="`${baseImagePath}${n.image}`" alt="没有图片" width="500" height="500">
        </el-col> -->
      </el-row>

      <div />

    </el-card>
  </div>
</template>

<script>
import { parseTime } from '@/utils/common'
import { getNews } from '@/api/manager/news'
import { getUid } from '@/utils/auth'

export default {
  name: 'NewsList',
  data() {
    return {
      newsList: [],
      baseImagePath: process.env.VUE_APP_BASE_API
    }
  },

  mounted() {
    this.loadNews()
  },

  methods: {
    loadNews() {
      const that = this
      getNews().then(r => {
        that.newsList = r.rows
      })
    },
  }
}
</script>

<style scoped>

</style>
