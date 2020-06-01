<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="uid" prop="uid">
        <el-input
          v-model="queryParams.uid"
          placeholder="请输入uid"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身高" prop="height">
        <el-input
          v-model="queryParams.height"
          placeholder="请输入身高"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="体重" prop="weight">
        <el-input
          v-model="queryParams.weight"
          placeholder="请输入体重"
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
      <el-form-item label="血糖" prop="bloodSugar">
        <el-input
          v-model="queryParams.bloodSugar"
          placeholder="请输入血糖"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="体检时间" prop="date">
        <el-date-picker clearable size="small" style="width: 200px"
                        v-model="queryParams.date"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择体检时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

<!--    <el-row :gutter="10" class="mb8">-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['manager:checkup:add']"-->
<!--        >新增</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="success"-->
<!--          icon="el-icon-edit"-->
<!--          size="mini"-->
<!--          :disabled="single"-->
<!--          @click="handleUpdate"-->
<!--          v-hasPermi="['manager:checkup:edit']"-->
<!--        >修改</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="danger"-->
<!--          icon="el-icon-delete"-->
<!--          size="mini"-->
<!--          :disabled="multiple"-->
<!--          @click="handleDelete"-->
<!--          v-hasPermi="['manager:checkup:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="warning"-->
<!--          icon="el-icon-download"-->
<!--          size="mini"-->
<!--          @click="handleExport"-->
<!--          v-hasPermi="['manager:checkup:export']"-->
<!--        >导出</el-button>-->
<!--      </el-col>-->
<!--    </el-row>-->

    <el-table v-loading="loading" :data="checkupList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="体检id" align="center" prop="id" />
      <el-table-column label="uid" align="center" prop="uid" />
      <el-table-column label="身高" align="center" prop="height" />
      <el-table-column label="体重" align="center" prop="weight" />
      <el-table-column label="高压" align="center" prop="bloodPressureHigh" />
      <el-table-column label="低压" align="center" prop="bloodPressureLow" />
      <el-table-column label="血糖" align="center" prop="bloodSugar" />
      <el-table-column label="体检时间" align="center" prop="date" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.date) }}</span>
        </template>
      </el-table-column>
<!--      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">-->
<!--        <template slot-scope="scope">-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleUpdate(scope.row)"-->
<!--            v-hasPermi="['manager:checkup:edit']"-->
<!--          >修改</el-button>-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-delete"-->
<!--            @click="handleDelete(scope.row)"-->
<!--            v-hasPermi="['manager:checkup:remove']"-->
<!--          >删除</el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
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
  import { listCheckup, getCheckup, delCheckup, addCheckup, updateCheckup, exportCheckup } from "@/api/manager/checkup";
  import { listUser } from "@/api/system/user"
  import { getUid } from '../../../utils/auth'


  export default {
    name: "Checkup",
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
        // 体检信息表格数据
        checkupList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          uid: getUid(),
          height: undefined,
          weight: undefined,
          bloodPressureHigh: undefined,
          bloodPressureLow: undefined,
          bloodSugar: undefined,
          date: undefined
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          uid: [
            { required: true, message: "uid不能为空", trigger: "blur" }
          ],
          height: [
            { required: true, message: "身高不能为空", trigger: "blur" }
          ],
          weight: [
            { required: true, message: "体重不能为空", trigger: "blur" }
          ],
          bloodPressureHigh: [
            { required: true, message: "高压不能为空", trigger: "blur" }
          ],
          bloodPressureLow: [
            { required: true, message: "低压不能为空", trigger: "blur" }
          ],
          bloodSugar: [
            { required: true, message: "血糖不能为空", trigger: "blur" }
          ],
          date: [
            { required: true, message: "体检时间不能为空", trigger: "blur" }
          ]
        },

        // user list
        userList: []
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询体检信息列表 */
      getList() {
        this.loading = true;
        listCheckup(this.queryParams).then(response => {
          this.checkupList = response.rows;
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
          height: undefined,
          weight: undefined,
          bloodPressureHigh: undefined,
          bloodPressureLow: undefined,
          bloodSugar: undefined,
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
        this.single = selection.length!==1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加体检信息";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getCheckup(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改体检信息";
        });
      },
      /** 提交按钮 */
      submitForm: function() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id !== undefined) {
              updateCheckup(this.form).then(response => {
                if (response.code === 200) {
                  this.msgSuccess("修改成功");
                  this.open = false;
                  this.getList();
                } else {
                  this.msgError(response.msg);
                }
              });
            } else {
              addCheckup(this.form).then(response => {
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
        this.$confirm('是否确认删除体检信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delCheckup(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
      },
      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有体检信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportCheckup(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
      }
    },
    watch: {
      open () {
        if(this.open) {
          // 加载用户列表
          const that = this
          listUser().then(r => {
            const rows = r.rows
            that.userList.length = 0
            for(const p in rows) {
              that.userList.push({uid: rows[p].userId, name: rows[p].nickName})
            }
            console.log('userList', that.userList)
          })
        }
      }
    }
  };
</script>
