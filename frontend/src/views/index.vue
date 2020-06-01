<template>
  <div class="dashboard-editor-container">
    <el-card>
      <div slot="header" class="clearfix">
        <span>近期状况提醒</span>
      </div>

      <div>您的高血压患病机率为：{{data.highPressureProbability}}%</div>
      <div>您的糖尿病患病机率为：{{data.diabetesProbability}}%</div>
    </el-card>
  </div>
</template>

<script>
import { listStatisticLeader } from "@/api/manager/statistic";
import { getUid } from "@/utils/auth";

export default {
  name: "Index",
  components: {},
  data() {
    return {
      data: undefined
    };
  },

  mounted() {
    listStatisticLeader(getUid()).then(r => {
      this.data = r.rows[0];
    });
  },

  methods: {}
};
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  position: relative;

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

@media (max-width: 1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}
</style>
