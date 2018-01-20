Date.prototype.pattern=function(fmt) {         
    var o = {         
    "M+" : this.getMonth()+1, //月份         
    "d+" : this.getDate(), //日         
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时         
    "H+" : this.getHours(), //小时         
    "m+" : this.getMinutes(), //分         
    "s+" : this.getSeconds(), //秒         
    "q+" : Math.floor((this.getMonth()+3)/3), //季度         
    "S" : this.getMilliseconds() //毫秒         
    };         
    var week = {         
    "0" : "/u65e5",         
    "1" : "/u4e00",         
    "2" : "/u4e8c",         
    "3" : "/u4e09",         
    "4" : "/u56db",         
    "5" : "/u4e94",         
    "6" : "/u516d"        
    };         
    if(/(y+)/.test(fmt)){         
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));         
    }         
    if(/(E+)/.test(fmt)){         
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);         
    }         
    for(var k in o){         
        if(new RegExp("("+ k +")").test(fmt)){         
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));         
        }         
    }         
    return fmt;         
}  

$(function() {
	var myChart = echarts.init(document.getElementById('main'));
	var now = new Date();
	var res = [];
	var len = 20;
	while (len--) {
		var time = now.pattern("HH:mm:ss");
		res.unshift(time);
		now = new Date(now - 1000);
	}
	option = {
		tooltip : {
			 trigger: 'axis',
	        formatter: "{a0} : {c0}%<br/>{a1} : {c1}%<br/>{a2} : {c2}%  "
	    },
		legend : {
			data : [ 'JVM内存使用率', '物理内存使用率', 'CPU使用率' ]
		},
		grid : {
			x : 40,
			y : 30,
			x2 : 10,
			y2 : 35,
			borderWidth : 0,
			borderColor : "#FFFFFF"
		},
		xAxis : [ {
			axisLabel : {
				
				interval:0,
				rotate : 22,
				formatter:function(val){
					return val;
				}
			},
			type : 'category',
			data : res
		} ],		
		yAxis : [ {
			min : 0,
			max : 100,
			axisLabel : {
				formatter : '{value}%'
			}
		} ],
		series : [
				{
					name : 'JVM内存使用率',
					type : 'line',
					data : [ 12, 25, 31, 11, 45, 50, 11, 09, 28, 35, 40, 24,
							28, 39, 23, 31, 14, 18, 08, 36 ]
				},
				{
					name : '物理内存使用率',
					type : 'line',
					data : [ 55, 41, 10, 23, 15, 44, 29, 41, 27, 05, 12, 25,
							31, 11, 45, 50, 11, 09, 28, 35 ]
				},
				{
					name : 'CPU使用率',
					type : 'line',
					data : [ 40, 24, 28, 39, 23, 31, 14, 18, 08, 36, 55, 41,
							10, 23, 15, 44, 29, 41, 27, 05 ]
				} ]
	};
	myChart.setOption(option);
	
	
	
	
	
	var main_one = echarts.init(document.getElementById('main_one'));
	var main_two = echarts.init(document.getElementById('main_two'));
	var main_three = echarts.init(document.getElementById('main_three'));
	one_option = {
		    tooltip : {
		        formatter: "{a} <br/>{b} : {c}%"
		    },
		    series : [
		        {
		        	title:{
		        	    show : true,
		        	    offsetCenter: [0, "95%"],
		        	 },
		        	 pointer: {
		                 color: '#FF0000'
		             },
		             name:'监控指标',
		            radius:[0, '95%'],
		            axisLine: {        
		                lineStyle: {      
		                    width: 20
		                }
		            },
		            detail : {formatter:'{value}%'},
		            type:'gauge',
		            data:[{value: 50, name: 'JVM内存使用率'}]
		        }
		    ]
		};
	 two_option = {
			 tooltip : {
			        formatter: "{a} <br/>{b} : {c}%"
			    },
			    series : [
			        {
			            name:'监控指标',
			            type:'gauge',
			            startAngle: 180,
			            endAngle: 0,
			            center : ['50%', '90%'],   
			            radius : 180,
			            axisLine: {            
			                lineStyle: {      
			                    width: 140
			                }
			            },
			            axisTick: {            
			                splitNumber: 10,   
			                length :12,       
			            },
			            axisLabel: {          
			                textStyle: {       
			                    color: '#fff',
			                    fontSize: 15,
			                    fontWeight: 'bolder'
			                }
			            },
			          
			            pointer: {
			                width:10,
			                length: '80%',
			                color: 'rgba(255, 255, 255, 0.8)'
			            },
			            title : {
			                show : true,
			                offsetCenter: [0, 15],       // x, y，单位px
			               /* textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			                    color: '#fff',
			                    fontSize: 25
			                }*/
			            },
			            detail : {
			                show : true,
			                backgroundColor: 'rgba(0,0,0,0)',
			                borderWidth: 0,
			                borderColor: '#ccc',
			                offsetCenter: [0, -40],       // x, y，单位px
			                formatter:'{value}%',
			                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			                    fontSize : 20
			                }
			            },
			            data:[{value: 50, name: 'CPU使用率'}]
			        }
			    ]
			};
	 main_one.setOption(one_option);
	 main_two.setOption(two_option);
	 one_option.series[0].data[0].name ='物理内存使用率';
	 one_option.series[0].pointer.color='#428bca'
	 main_three.setOption(one_option);
	var axisData;
	clearInterval(timeTicket);
	var timeTicket = setInterval(function() {
		axisData = new Date().pattern("HH:mm:ss");
		var jvm = [];
		var ram = [];
		var cpu = [];
		$.ajax({
			type : "POST",
			url :'/a/monitor/usage',
			async : false,
			dataType : 'json',
			success : function(json) {
				$("#td_jvmUsage").html(json.jvmUsage);
				$("#td_serverUsage").html(json.ramUsage);
				$("#td_cpuUsage").html(json.cpuUsage);
				jvm.push(json.jvmUsage);
				ram.push(json.ramUsage);
				cpu.push(json.cpuUsage);
				// 动态数据接口 addData
				myChart.addData([ [ 0, // 系列索引
				jvm, // 新增数据
				false, // 新增数据是否从队列头部插入
				false, // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
				], [ 1, // 系列索引
				ram, // 新增数据
				false, // 新增数据是否从队列头部插入
				false, // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
				], [ 2, // 系列索引
				cpu, // 新增数据
				false, // 新增数据是否从队列头部插入
				false, // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
				axisData // 坐标轴标签
				] ]);
				
				one_option.series[0].data[0].value =json.jvmUsage;
				one_option.series[0].data[0].name ='JVM内存使用率';
				 one_option.series[0].pointer.color='#FF0000'
				main_one.setOption(one_option, true);
				
				two_option.series[0].data[0].value =json.cpuUsage;
				main_two.setOption(two_option, true);
				
				one_option.series[0].data[0].value =json.ramUsage;
				 one_option.series[0].data[0].name ='物理内存使用率';
				 one_option.series[0].pointer.color='#428bca'
				main_three.setOption(one_option, true);
			}
		});
	}, 3000);
	
});