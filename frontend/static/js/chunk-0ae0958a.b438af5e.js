(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0ae0958a","chunk-2d230898","chunk-2d0de3b1"],{"4b72":function(e,t,l){"use strict";l.d(t,"e",(function(){return a})),l.d(t,"d",(function(){return n})),l.d(t,"b",(function(){return r})),l.d(t,"g",(function(){return s})),l.d(t,"c",(function(){return i})),l.d(t,"f",(function(){return u})),l.d(t,"a",(function(){return c}));var o=l("b775");function a(e){return Object(o["a"])({url:"/tool/gen/list",method:"get",params:e})}function n(e){return Object(o["a"])({url:"/tool/gen/db/list",method:"get",params:e})}function r(e){return Object(o["a"])({url:"/tool/gen/"+e,method:"get"})}function s(e){return Object(o["a"])({url:"/tool/gen",method:"put",data:e})}function i(e){return Object(o["a"])({url:"/tool/gen/importTable",method:"post",params:e})}function u(e){return Object(o["a"])({url:"/tool/gen/preview/"+e,method:"get"})}function c(e){return Object(o["a"])({url:"/tool/gen/"+e,method:"delete"})}},"76f8":function(e,t,l){"use strict";l.r(t);var o=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("el-card",[l("el-tabs",{model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[l("el-tab-pane",{attrs:{label:"基本信息",name:"basic"}},[l("basic-info-form",{ref:"basicInfo",attrs:{info:e.info}})],1),l("el-tab-pane",{attrs:{label:"字段信息",name:"cloum"}},[l("el-table",{attrs:{data:e.cloumns,"max-height":e.tableHeight}},[l("el-table-column",{attrs:{label:"序号",type:"index","min-width":"5%"}}),l("el-table-column",{attrs:{label:"字段列名",prop:"columnName","min-width":"10%","show-overflow-tooltip":!0}}),l("el-table-column",{attrs:{label:"字段描述","min-width":"10%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-input",{model:{value:t.row.columnComment,callback:function(l){e.$set(t.row,"columnComment",l)},expression:"scope.row.columnComment"}})]}}])}),l("el-table-column",{attrs:{label:"物理类型",prop:"columnType","min-width":"10%","show-overflow-tooltip":!0}}),l("el-table-column",{attrs:{label:"Java类型","min-width":"11%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-select",{model:{value:t.row.javaType,callback:function(l){e.$set(t.row,"javaType",l)},expression:"scope.row.javaType"}},[l("el-option",{attrs:{label:"Long",value:"Long"}}),l("el-option",{attrs:{label:"String",value:"String"}}),l("el-option",{attrs:{label:"Integer",value:"Integer"}}),l("el-option",{attrs:{label:"Double",value:"Double"}}),l("el-option",{attrs:{label:"BigDecimal",value:"BigDecimal"}}),l("el-option",{attrs:{label:"Date",value:"Date"}})],1)]}}])}),l("el-table-column",{attrs:{label:"java属性","min-width":"10%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-input",{model:{value:t.row.javaField,callback:function(l){e.$set(t.row,"javaField",l)},expression:"scope.row.javaField"}})]}}])}),l("el-table-column",{attrs:{label:"插入","min-width":"5%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-checkbox",{attrs:{"true-label":"1"},model:{value:t.row.isInsert,callback:function(l){e.$set(t.row,"isInsert",l)},expression:"scope.row.isInsert"}})]}}])}),l("el-table-column",{attrs:{label:"编辑","min-width":"5%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-checkbox",{attrs:{"true-label":"1"},model:{value:t.row.isEdit,callback:function(l){e.$set(t.row,"isEdit",l)},expression:"scope.row.isEdit"}})]}}])}),l("el-table-column",{attrs:{label:"列表","min-width":"5%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-checkbox",{attrs:{"true-label":"1"},model:{value:t.row.isList,callback:function(l){e.$set(t.row,"isList",l)},expression:"scope.row.isList"}})]}}])}),l("el-table-column",{attrs:{label:"查询","min-width":"5%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-checkbox",{attrs:{"true-label":"1"},model:{value:t.row.isQuery,callback:function(l){e.$set(t.row,"isQuery",l)},expression:"scope.row.isQuery"}})]}}])}),l("el-table-column",{attrs:{label:"查询方式","min-width":"10%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-select",{model:{value:t.row.queryType,callback:function(l){e.$set(t.row,"queryType",l)},expression:"scope.row.queryType"}},[l("el-option",{attrs:{label:"=",value:"EQ"}}),l("el-option",{attrs:{label:"!=",value:"NE"}}),l("el-option",{attrs:{label:">",value:"GT"}}),l("el-option",{attrs:{label:">=",value:"GTE"}}),l("el-option",{attrs:{label:"<",value:"LT"}}),l("el-option",{attrs:{label:"<=",value:"LTE"}}),l("el-option",{attrs:{label:"LIKE",value:"LIKE"}}),l("el-option",{attrs:{label:"BETWEEN",value:"BETWEEN"}})],1)]}}])}),l("el-table-column",{attrs:{label:"必填","min-width":"5%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-checkbox",{attrs:{"true-label":"1"},model:{value:t.row.isRequired,callback:function(l){e.$set(t.row,"isRequired",l)},expression:"scope.row.isRequired"}})]}}])}),l("el-table-column",{attrs:{label:"显示类型","min-width":"12%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-select",{model:{value:t.row.htmlType,callback:function(l){e.$set(t.row,"htmlType",l)},expression:"scope.row.htmlType"}},[l("el-option",{attrs:{label:"文本框",value:"input"}}),l("el-option",{attrs:{label:"文本域",value:"textarea"}}),l("el-option",{attrs:{label:"下拉框",value:"select"}}),l("el-option",{attrs:{label:"单选框",value:"radio"}}),l("el-option",{attrs:{label:"复选框",value:"checkbox"}}),l("el-option",{attrs:{label:"日期控件",value:"datetime"}})],1)]}}])}),l("el-table-column",{attrs:{label:"字典类型","min-width":"12%"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-select",{attrs:{clearable:"",filterable:"",placeholder:"请选择"},model:{value:t.row.dictType,callback:function(l){e.$set(t.row,"dictType",l)},expression:"scope.row.dictType"}},e._l(e.dictOptions,(function(t){return l("el-option",{key:t.dictType,attrs:{label:t.dictName,value:t.dictType}},[l("span",{staticStyle:{float:"left"}},[e._v(e._s(t.dictName))]),l("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[e._v(e._s(t.dictType))])])})),1)]}}])})],1)],1),l("el-tab-pane",{attrs:{label:"生成信息",name:"genInfo"}},[l("gen-info-form",{ref:"genInfo",attrs:{info:e.info}})],1)],1),l("el-form",{attrs:{"label-width":"100px"}},[l("el-form-item",{staticStyle:{"text-align":"center","margin-left":"-100px","margin-top":"10px"}},[l("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm()}}},[e._v("提交")]),l("el-button",{on:{click:function(t){return e.close()}}},[e._v("返回")])],1)],1)],1)},a=[],n=(l("a623"),l("d81d"),l("d3b7"),l("3ca3"),l("ddb0"),l("4b72")),r=l("ed45"),s=l("ed69"),i=l("8586"),u={name:"GenEdit",components:{basicInfoForm:s["default"],genInfoForm:i["default"]},data:function(){return{activeName:"cloum",tableHeight:document.documentElement.scrollHeight-245+"px",cloumns:[],dictOptions:[],info:{}}},beforeCreate:function(){var e=this,t=this.$route.query.tableId;t&&(Object(n["b"])(t).then((function(t){e.cloumns=t.data.rows,e.info=t.data.info})),Object(r["f"])().then((function(t){e.dictOptions=t.data})))},methods:{submitForm:function(){var e=this,t=this.$refs.basicInfo.$refs.basicInfoForm,l=this.$refs.genInfo.$refs.genInfoForm;Promise.all([t,l].map(this.getFormPromise)).then((function(o){var a=o.every((function(e){return!!e}));if(a){var r=Object.assign({},t.model,l.model);r.columns=e.cloumns,r.params={treeCode:r.treeCode,treeName:r.treeName,treeParentCode:r.treeParentCode},Object(n["g"])(r).then((function(t){e.msgSuccess(t.msg),200===t.code&&e.close()}))}else e.msgError("表单校验未通过，请重新检查提交内容")}))},getFormPromise:function(e){return new Promise((function(t){e.validate((function(e){t(e)}))}))},close:function(){this.$store.dispatch("tagsView/delView",this.$route),this.$router.push({path:"/tool/gen",query:{t:Date.now()}})}}},c=u,m=l("2877"),p=Object(m["a"])(c,o,a,!1,null,null,null);t["default"]=p.exports},8586:function(e,t,l){"use strict";l.r(t);var o=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("el-form",{ref:"genInfoForm",attrs:{model:e.info,rules:e.rules,"label-width":"150px"}},[l("el-row",[l("el-col",{attrs:{span:12}},[l("el-form-item",{attrs:{prop:"tplCategory"}},[l("span",{attrs:{slot:"label"},slot:"label"},[e._v("生成模板")]),l("el-select",{model:{value:e.info.tplCategory,callback:function(t){e.$set(e.info,"tplCategory",t)},expression:"info.tplCategory"}},[l("el-option",{attrs:{label:"单表（增删改查）",value:"crud"}}),l("el-option",{attrs:{label:"树表（增删改查）",value:"tree"}})],1)],1)],1),l("el-col",{attrs:{span:12}},[l("el-form-item",{attrs:{prop:"packageName"}},[l("span",{attrs:{slot:"label"},slot:"label"},[e._v(" 生成包路径 "),l("el-tooltip",{attrs:{content:"生成在哪个java包下，例如 com.example.system",placement:"top"}},[l("i",{staticClass:"el-icon-question"})])],1),l("el-input",{model:{value:e.info.packageName,callback:function(t){e.$set(e.info,"packageName",t)},expression:"info.packageName"}})],1)],1),l("el-col",{attrs:{span:12}},[l("el-form-item",{attrs:{prop:"moduleName"}},[l("span",{attrs:{slot:"label"},slot:"label"},[e._v(" 生成模块名 "),l("el-tooltip",{attrs:{content:"可理解为子系统名，例如 system",placement:"top"}},[l("i",{staticClass:"el-icon-question"})])],1),l("el-input",{model:{value:e.info.moduleName,callback:function(t){e.$set(e.info,"moduleName",t)},expression:"info.moduleName"}})],1)],1),l("el-col",{attrs:{span:12}},[l("el-form-item",{attrs:{prop:"businessName"}},[l("span",{attrs:{slot:"label"},slot:"label"},[e._v(" 生成业务名 "),l("el-tooltip",{attrs:{content:"可理解为功能英文名，例如 user",placement:"top"}},[l("i",{staticClass:"el-icon-question"})])],1),l("el-input",{model:{value:e.info.businessName,callback:function(t){e.$set(e.info,"businessName",t)},expression:"info.businessName"}})],1)],1),l("el-col",{attrs:{span:12}},[l("el-form-item",{attrs:{prop:"functionName"}},[l("span",{attrs:{slot:"label"},slot:"label"},[e._v(" 生成功能名 "),l("el-tooltip",{attrs:{content:"用作类描述，例如 用户",placement:"top"}},[l("i",{staticClass:"el-icon-question"})])],1),l("el-input",{model:{value:e.info.functionName,callback:function(t){e.$set(e.info,"functionName",t)},expression:"info.functionName"}})],1)],1)],1),l("el-row",{directives:[{name:"show",rawName:"v-show",value:"tree"==e.info.tplCategory,expression:"info.tplCategory == 'tree'"}]},[l("h4",{staticClass:"form-header"},[e._v("其他信息")]),l("el-col",{attrs:{span:12}},[l("el-form-item",[l("span",{attrs:{slot:"label"},slot:"label"},[e._v(" 树编码字段 "),l("el-tooltip",{attrs:{content:"树显示的编码字段名， 如：dept_id",placement:"top"}},[l("i",{staticClass:"el-icon-question"})])],1),l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.info.treeCode,callback:function(t){e.$set(e.info,"treeCode",t)},expression:"info.treeCode"}},e._l(e.info.columns,(function(e){return l("el-option",{key:e.columnName,attrs:{label:e.columnName+"："+e.columnComment,value:e.columnName}})})),1)],1)],1),l("el-col",{attrs:{span:12}},[l("el-form-item",[l("span",{attrs:{slot:"label"},slot:"label"},[e._v(" 树父编码字段 "),l("el-tooltip",{attrs:{content:"树显示的父编码字段名， 如：parent_Id",placement:"top"}},[l("i",{staticClass:"el-icon-question"})])],1),l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.info.treeParentCode,callback:function(t){e.$set(e.info,"treeParentCode",t)},expression:"info.treeParentCode"}},e._l(e.info.columns,(function(e){return l("el-option",{key:e.columnName,attrs:{label:e.columnName+"："+e.columnComment,value:e.columnName}})})),1)],1)],1),l("el-col",{attrs:{span:12}},[l("el-form-item",[l("span",{attrs:{slot:"label"},slot:"label"},[e._v(" 树名称字段 "),l("el-tooltip",{attrs:{content:"树节点的显示名称字段名， 如：dept_name",placement:"top"}},[l("i",{staticClass:"el-icon-question"})])],1),l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.info.treeName,callback:function(t){e.$set(e.info,"treeName",t)},expression:"info.treeName"}},e._l(e.info.columns,(function(e){return l("el-option",{key:e.columnName,attrs:{label:e.columnName+"："+e.columnComment,value:e.columnName}})})),1)],1)],1)],1)],1)},a=[],n={name:"BasicInfoForm",props:{info:{type:Object,default:null}},data:function(){return{rules:{tplCategory:[{required:!0,message:"请选择生成模板",trigger:"blur"}],packageName:[{required:!0,message:"请输入生成包路径",trigger:"blur"}],moduleName:[{required:!0,message:"请输入生成模块名",trigger:"blur"}],businessName:[{required:!0,message:"请输入生成业务名",trigger:"blur"}],functionName:[{required:!0,message:"请输入生成功能名",trigger:"blur"}]}}},created:function(){}},r=n,s=l("2877"),i=Object(s["a"])(r,o,a,!1,null,null,null);t["default"]=i.exports},a623:function(e,t,l){"use strict";var o=l("23e7"),a=l("b727").every,n=l("a640"),r=l("ae40"),s=n("every"),i=r("every");o({target:"Array",proto:!0,forced:!s||!i},{every:function(e){return a(this,e,arguments.length>1?arguments[1]:void 0)}})},ed45:function(e,t,l){"use strict";l.d(t,"e",(function(){return a})),l.d(t,"d",(function(){return n})),l.d(t,"a",(function(){return r})),l.d(t,"g",(function(){return s})),l.d(t,"b",(function(){return i})),l.d(t,"c",(function(){return u})),l.d(t,"f",(function(){return c}));var o=l("b775");function a(e){return Object(o["a"])({url:"/system/dict/type/list",method:"get",params:e})}function n(e){return Object(o["a"])({url:"/system/dict/type/"+e,method:"get"})}function r(e){return Object(o["a"])({url:"/system/dict/type",method:"post",data:e})}function s(e){return Object(o["a"])({url:"/system/dict/type",method:"put",data:e})}function i(e){return Object(o["a"])({url:"/system/dict/type/"+e,method:"delete"})}function u(e){return Object(o["a"])({url:"/system/dict/type/export",method:"get",params:e})}function c(){return Object(o["a"])({url:"/system/dict/type/optionselect",method:"get"})}},ed69:function(e,t,l){"use strict";l.r(t);var o=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("el-form",{ref:"basicInfoForm",attrs:{model:e.info,rules:e.rules,"label-width":"150px"}},[l("el-row",[l("el-col",{attrs:{span:12}},[l("el-form-item",{attrs:{label:"表名称",prop:"tableName"}},[l("el-input",{attrs:{placeholder:"请输入仓库名称"},model:{value:e.info.tableName,callback:function(t){e.$set(e.info,"tableName",t)},expression:"info.tableName"}})],1)],1),l("el-col",{attrs:{span:12}},[l("el-form-item",{attrs:{label:"表描述",prop:"tableComment"}},[l("el-input",{attrs:{placeholder:"请输入"},model:{value:e.info.tableComment,callback:function(t){e.$set(e.info,"tableComment",t)},expression:"info.tableComment"}})],1)],1),l("el-col",{attrs:{span:12}},[l("el-form-item",{attrs:{label:"实体类名称",prop:"className"}},[l("el-input",{attrs:{placeholder:"请输入"},model:{value:e.info.className,callback:function(t){e.$set(e.info,"className",t)},expression:"info.className"}})],1)],1),l("el-col",{attrs:{span:12}},[l("el-form-item",{attrs:{label:"作者",prop:"functionAuthor"}},[l("el-input",{attrs:{placeholder:"请输入"},model:{value:e.info.functionAuthor,callback:function(t){e.$set(e.info,"functionAuthor",t)},expression:"info.functionAuthor"}})],1)],1),l("el-col",{attrs:{span:24}},[l("el-form-item",{attrs:{label:"备注",prop:"remark"}},[l("el-input",{attrs:{type:"textarea",rows:3},model:{value:e.info.remark,callback:function(t){e.$set(e.info,"remark",t)},expression:"info.remark"}})],1)],1)],1)],1)},a=[],n={name:"BasicInfoForm",props:{info:{type:Object,default:null}},data:function(){return{rules:{tableName:[{required:!0,message:"请输入表名称",trigger:"blur"}],tableComment:[{required:!0,message:"请输入表描述",trigger:"blur"}],className:[{required:!0,message:"请输入实体类名称",trigger:"blur"}],functionAuthor:[{required:!0,message:"请输入作者",trigger:"blur"}]}}}},r=n,s=l("2877"),i=Object(s["a"])(r,o,a,!1,null,null,null);t["default"]=i.exports}}]);