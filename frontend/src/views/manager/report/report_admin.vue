<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="uid" prop="uid">
        <el-input
          v-model="queryParams.uid"
          placeholder="请输入UID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="吸烟情况" prop="smoke">
        <el-input
          v-model="queryParams.smoke"
          placeholder="请输入吸烟情况"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="睡眠情况" prop="sleep">
        <el-input
          v-model="queryParams.sleep"
          placeholder="请输入睡眠情况"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="高压" prop="bloodPressureHigh">
        <el-input
          v-model="queryParams.bloodPressureHigh"
          placeholder="请输入高压"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="低压" prop="bloodPressureLow">
        <el-input
          v-model="queryParams.bloodPressureLow"
          placeholder="请输入低压"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="饮酒情况" prop="alcohol">
        <el-input
          v-model="queryParams.alcohol"
          placeholder="请输入饮酒情况"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="填报日期" prop="date">
        <el-date-picker clearable size="small" style="width: 200px"
                        v-model="queryParams.date"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择填报日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
     <el-col :span="1.5">
       <el-button
         type="primary"
         icon="el-icon-plus"
         size="mini"
         @click="handleAdd"
       >新增</el-button>
     </el-col>
     <el-col :span="1.5">
       <el-button
         type="success"
         icon="el-icon-edit"
         size="mini"
         :disabled="single"
         @click="handleUpdate"
       >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="reportList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="uid" align="center" prop="uid" />
      <el-table-column label="吸烟情况" align="center" prop="smoke" />
      <el-table-column label="睡眠情况" align="center" prop="sleep" />
      <el-table-column label="高压" align="center" prop="bloodPressureHigh" />
      <el-table-column label="低压" align="center" prop="bloodPressureLow" />
      <el-table-column label="饮酒情况" align="center" prop="alcohol" />
      <el-table-column label="日记内容" align="center" prop="diary" />
      <el-table-column label="填报日期" align="center" prop="date" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.date, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="uid" prop="uid">
          <el-input v-model="form.uid" placeholder="请输入UID" />
        </el-form-item>
        <el-form-item label="饮酒情况" prop="smoke">
          <el-input v-model="form.smoke" placeholder="请输入饮酒情况" />
        </el-form-item>
        <el-form-item label="睡眠情况" prop="sleep">
          <el-input v-model="form.sleep" placeholder="请输入睡眠情况" />
        </el-form-item>
        <el-form-item label="高压" prop="bloodPressureHigh">
          <el-input v-model="form.bloodPressureHigh" placeholder="请输入高压" />
        </el-form-item>
        <el-form-item label="低压" prop="bloodPressureLow">
          <el-input v-model="form.bloodPressureLow" placeholder="请输入低压" />
        </el-form-item>
        <el-form-item label="饮酒情况" prop="alcohol">
          <el-input v-model="form.alcohol" placeholder="请输入饮酒情况" />
        </el-form-item>
        <el-form-item label="填报日期" prop="date">
          <el-date-picker clearable size="small" style="width: 200px"
                          v-model="form.date"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择填报日期">
          </el-date-picker>
        </el-form-item>

        <el-col :span="24">
          <el-form-item label="日记" prop="diary">
            <el-input type="textarea" v-model="form.diary" placeholder="填写日记内容" />
          </el-form-item>
        </el-col>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import { listReport, getReport, delReport, addReport, updateReport, exportReport } from "@/api/manager/report";

  export default {
    name: "Report",
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
        form: {},
        // 表单校验
        rules: {
          uid: [
            { required: true, message: "UID不能为空", trigger: "blur" }
          ],
          smoke: [
            { required: true, message: "吸烟情况不能为空", trigger: "blur" }
          ],
          sleep: [
            { required: true, message: "睡眠情况不能为空", trigger: "blur" }
          ],
          bloodPressureHigh: [
            { required: true, message: "高压不能为空", trigger: "blur" }
          ],
          bloodPressureLow: [
            { required: true, message: "低压不能为空", trigger: "blur" }
          ],
          alcohol: [
            { required: true, message: "饮酒情况不能为空", trigger: "blur" }
          ],
          date: [
            { required: true, message: "填报日期不能为空", trigger: "blur" }
          ]
        }
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询【请填写功能名称】列表 */
      getList() {
        this.loading = true;
        listReport(this.queryParams).then(response => {
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
        this.ids = selection.map(item => item.id)
        this.single = selection.length!=1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加数据";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getReport(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改数据";
        });
      },
      /** 提交按钮 */
      submitForm: function() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != undefined) {
              updateReport(this.form).then(response => {
                if (response.code === 200) {
                  this.msgSuccess("修改成功");
                  this.open = false;
                  this.getList();
                } else {
                  this.msgError(response.msg);
                }
              });
            } else {
              addReport(this.form).then(response => {
                if (response.code === 200) {
                  this.msgSuccess("新增成功");
                  this.open = false;
                  this.getList();
                } else {
                  this.msgError(response.msg);
                }
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const ids = row.id || this.ids;
        this.$confirm('是否确认删除编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delReport(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
      },
      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportReport(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
      }
    }
  };
</script>
