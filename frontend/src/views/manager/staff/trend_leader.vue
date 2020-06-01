<template>
  <div class="app-container">
    <el-table v-loading="loading" :data="reportList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="uid" align="center" prop="userId" /> -->
      <el-table-column label="姓名" align="center" prop="userName" />
      <el-table-column label="体重" align="center" prop="weight">
        <template slot-scope="scope">
          <el-tag type="info" v-if="scope.row.weight === null">无数据</el-tag>
          <span v-else>{{scope.row.weight}}</span>
        </template>
      </el-table-column>

      <el-table-column label="身高" align="center" prop="height">
        <template slot-scope="scope">
          <el-tag type="info" v-if="scope.row.height === null">无数据</el-tag>
          <span v-else>{{scope.row.height}}</span>
        </template>
      </el-table-column>

      <el-table-column label="高压" align="center" prop="bloodPressureHigh">
        <template slot-scope="scope">
          <el-tag type="info" v-if="scope.row.bloodPressureHigh === null">无数据</el-tag>
          <span v-else>{{scope.row.bloodPressureHigh}}</span>
        </template>
      </el-table-column>

      <el-table-column label="近期低压" align="center" prop="bloodPressureLow">
        <template slot-scope="scope">
          <el-tag type="info" v-if="scope.row.bloodPressureLow === null">无数据</el-tag>
          <span v-else>{{scope.row.bloodPressureLow}}</span>
        </template>
      </el-table-column>

      <el-table-column label="近期高压" align="center" prop="bloodPressureHigh">
        <template slot-scope="scope">
          <el-tag type="info" v-if="scope.row.bloodPressureHigh === null">无数据</el-tag>
          <span v-else>{{scope.row.bloodPressureHigh}}</span>
        </template>
      </el-table-column>

      <el-table-column label="近期血糖" align="center" prop="bloodSugar">
        <template slot-scope="scope">
          <el-tag type="info" v-if="scope.row.bloodSugar === null">无数据</el-tag>
          <span v-else>{{scope.row.bloodSugar}}</span>
        </template>
      </el-table-column>

      <el-table-column label="高血压概率" align="center" prop="highPressureProbability">
        <template slot-scope="scope">
          <el-tag type="info" v-if="scope.row.highPressureProbability === 0">暂无</el-tag>
          <span v-else>{{scope.row.highPressureProbability}}%</span>
        </template>
      </el-table-column>

      <el-table-column label="糖尿病概率" align="center" prop="diabetesProbability">
        <template slot-scope="scope">
          <el-tag type="info" v-if="scope.row.diabetesProbability === 0">暂无</el-tag>
          <span v-else>{{scope.row.diabetesProbability}}%</span>
        </template>
      </el-table-column>

      <el-table-column label="检测日期" align="center" prop="checkupDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.checkupDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['manager:report:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['manager:report:remove']"
          >删除</el-button>
        </template>
      </el-table-column>-->
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
  </div>
</template>

<script>
import { listStatisticLeader } from "@/api/manager/statistic";

export default {
  name: "LeaderStatistic",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 总条数
      total: 0,
      // 【请填写功能名称】表格数据
      reportList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        uid: undefined,
        smoke: undefined,
        sleep: undefined,
        bloodPressureHigh: undefined,
        bloodPressureLow: undefined,
        alcohol: undefined,
        date: undefined
      },
      // 表单参数
      form: {}
      // 表单校验
    };
  },
  created() {
    this.getList();
    // this.form.uid = getUid();
  },

  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listStatisticLeader().then(response => {
        this.reportList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: undefined,
        uid: undefined,
        smoke: undefined,
        sleep: undefined,
        bloodPressureHigh: undefined,
        bloodPressureLow: undefined,
        alcohol: undefined,
        date: undefined
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id);
      this.single = selection.length != 1;
      this.multiple = !selection.length;
    }
  }
};
</script>
