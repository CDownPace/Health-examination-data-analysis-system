<template>
  <div :class="className" :style="{height:height,width:width, marginTop: '40px'}" />
</template>

<script>
  import { listCheckup, getCheckup, delCheckup, addCheckup, updateCheckup, exportCheckup } from "@/api/manager/checkup";
  import { getUid } from '../../../utils/auth'
  import echarts from 'echarts'
  require('echarts/theme/macarons') // echarts theme

  export default {
    name: 'checkup_chart',

    data () {
      return {
        className: 'health-data-chart',
        height: '600px',
        width: '800px',

        chartData: []
      }
    },

    methods: {
      initChart() {
        this.chart = echarts.init(this.$el, 'macarons')
        // this.setOptions(this.chartData)
      },

      setOptions(chartData) {
        console.log('chart data', chartData)
        const xData = chartData.map(d => d.date)
        const heights = chartData.map(d => d.height)
        const weights = chartData.map(d => d.weight)
        const bloodPressureHighs = chartData.map(d => d.bloodPressureHigh)
        const bloodPressureLows = chartData.map(d => d.bloodPressureLow)
        const bloodSugars = chartData.map(d => d.bloodSugar)

        this.chart.setOption({
          xAxis: {
            data: xData,
            boundaryGap: false,
            axisTick: {
              show: false
            }
          },
          grid: {
            left: 50,
            right: 10,
            bottom: 20,
            top: 60,
            containLabel: true
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross'
            },
            padding: [5, 10]
          },
          yAxis: {
            axisTick: {
              show: false
            }
          },
          legend: {
            data: ['体重', '身高', '低压', '高压', '血糖']
          },

          series: [
          {
            name: '体重',
            itemStyle: {
              normal: {
                color: '#64B5F6',
                lineStyle: {
                  color: '#64B5F6',
                  width: 2
                }
              }
            },
            smooth: true,
            type: 'line',
            data: weights,
            animationDuration: 2800,
            animationEasing: 'cubicInOut'
          },
          {
            name: '身高',
            smooth: true,
            type: 'line',
            itemStyle: {
              normal: {
                color: '#4DB6AC',
                lineStyle: {
                  color: '#4DB6AC',
                  width: 2
                },
                // areaStyle: {
                //   color: '#f3f8ff'
                // }
              }
            },
            data: heights,
            animationDuration: 2800,
            animationEasing: 'quadraticOut'
          },
          {
            name: '高压',
            smooth: true,
            type: 'line',
            itemStyle: {
              normal: {
                color: '#FFCA28',
                lineStyle: {
                  color: '#FFCA28',
                  width: 2
                },
                areaStyle: {
                  color: '#f3f8ff'
                }
              }
            },
            data: bloodPressureHighs,
            animationDuration: 2800,
            animationEasing: 'quadraticOut'
          },
          {
            name: '低压',
            smooth: true,
            type: 'line',
            itemStyle: {
              normal: {
                color: '#9CCC65',
                lineStyle: {
                  color: '#9CCC65',
                  width: 2
                },
                // areaStyle: {
                //   color: '#9CCC65'
                // }
              }
            },
            data: bloodPressureLows,
            animationDuration: 2800,
            animationEasing: 'quadraticOut'
          },
          {
              name: '血糖',
              smooth: true,
              type: 'line',
              itemStyle: {
                normal: {
                  color: '#D4E157',
                  lineStyle: {
                    color: '#D4E157',
                    width: 2
                  },
                  // areaStyle: {
                  //   color: '#f3f8ff'
                  // }
                }
              },
              data: bloodSugars,
              animationDuration: 2800,
              animationEasing: 'quadraticOut'
            },
          ]
        })
      }
    },

    mounted() {
      this.$nextTick(() => {
        this.initChart()
        // load data
        const that = this
        listCheckup({uid: getUid()}).then(r => {
          const data = r.rows
          that.chartData = data
        })
      })
    },

    watch: {
      chartData: {
        deep: true,
        handler(val) {
          this.setOptions(val)
        }
      }
    }
  }
</script>

<style scoped>

</style>
