(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-21e34b21"],{"4f53":function(t,e,r){"use strict";r.d(e,"f",(function(){return a})),r.d(e,"g",(function(){return u})),r.d(e,"e",(function(){return c})),r.d(e,"a",(function(){return s})),r.d(e,"h",(function(){return i})),r.d(e,"b",(function(){return d})),r.d(e,"c",(function(){return f})),r.d(e,"d",(function(){return l}));var n=r("5530"),o=r("b775");function a(t){return Object(o["a"])({url:"/manager/report/list",method:"get",params:t})}function u(t,e){return Object(o["a"])({url:"/manager/report/list",method:"get",params:Object(n["a"])({},t,{uid:e})})}function c(t){return Object(o["a"])({url:"/manager/report/"+t,method:"get"})}function s(t){return Object(o["a"])({url:"/manager/report",method:"post",data:t})}function i(t){return Object(o["a"])({url:"/manager/report",method:"put",data:t})}function d(t){return Object(o["a"])({url:"/manager/report/"+t,method:"delete"})}function f(t){return Object(o["a"])({url:"/manager/report/export",method:"get",params:t})}function l(t){return Object(o["a"])({url:"/manager/report/recent",method:"get",params:{uid:t}})}},6493:function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"app-container"},[r("el-card",{staticClass:"box-card"},[r("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[r("span",[t._v("菜谱推荐")])]),r("div",[t._v(" 根据您最近一周的健康日报，为您推荐以下菜谱： ")]),t._l(t.foodList,(function(e){return r("div",{key:e,staticClass:"text item",staticStyle:{"margin-top":"25px"}},[t._v(" "+t._s(e)+" ")])}))],2)],1)},o=[],a=r("4f53"),u=r("5f87"),c={name:"menu_user",data:function(){return{recentWeekReport:[],foods:{highPressure:["凉拌木耳菜","牡丹花蒸鱼","枸杞炒芹菜","明目菊花鸡片","芹菜水饺","炒莴笋","芹菜炒虾仁"],lever:["菌香杂粮米糊","豆腐鲜虾春卷","腊八粥","海带豆腐汤","葡萄橘子汁"],eye:["胡萝卜排骨粥","猪肝枸杞面","枸杞银耳薏米仁甜汤"]},foodList:[]}},created:function(){var t=this;Object(a["d"])(Object(u["b"])()).then((function(e){console.log("loaded"),t.recentWeekReport=e.rows,t.foodList.length=0,t.foodList.push(t.getRandomElementFromArray(t.foods.highPressure)),t.foodList.push(t.getRandomElementFromArray(t.foods.lever)),t.foodList.push(t.getRandomElementFromArray(t.foods.eye)),console.log(t.foodList)}))},methods:{getRandomElementFromArray:function(t){var e=0,r=t.length-1,n=Math.floor(Math.random()*(r-e)+e);return t[n]}}},s=c,i=r("2877"),d=Object(i["a"])(s,n,o,!1,null,"7fa9f6b4",null);e["default"]=d.exports}}]);