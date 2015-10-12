var isEditConf = 0;
var editConf_id = '';
var editConf_name = '';

var siteListTableDate = {};

var confStatusMap = {
	0 : '<s:text name="confStatusMap.0"/>',
	1 : "<s:text name='confStatusMap.1'/>",
	2 : "<s:text name='confStatusMap.2'/>",
	3 : "<s:text name='confStatusMap.3'/>",
	4 : "<s:text name='confStatusMap.4'/>",
	5 : "<s:text name='confStatusMap.5'/>"
};

   
var confStatusMap = {
		0 : '<s:text name="confStatusMap.0"/>',
		1 : "<s:text name='confStatusMap.1'/>",
		2 : "<s:text name='confStatusMap.2'/>",
		3 : "<s:text name='confStatusMap.3'/>",
		4 : "<s:text name='confStatusMap.4'/>",
		5 : "<s:text name='confStatusMap.5'/>"
	};
	var siteTypeMap = {
		0 : '<s:text name="siteType.0"/>',//"无效类型"
		1 : '<s:text name="siteType.1"/>',//自动，根据会场标识从系统获取
		2 : '<s:text name="siteType.2"/>',//"E1类型会场",
		3 : '<s:text name="siteType.3"/>',//"ISDN类型会场",
		4 : '<s:text name="siteType.4"/>',//"H.323类型会场",
		5 : '<s:text name="siteType.5"/>',//"PSTN类型会场",
		6 : '<s:text name="siteType.6"/>',//"4E1类型会场",
		7 : '<s:text name="siteType.7"/>',//"SIP类型会场",
		8 : '<s:text name="siteType.8"/>',//"VoIP SIP 类型会场",
		9 : '<s:text name="siteType.9"/>'//"VoIP H.323 类型会场"
	};
	var siteStatusMap = {
		0 : '<s:text name="siteStatus.0"/>',//未知状态（保留）",
		1 : '<s:text name="siteStatus.1"/>',//"会场不存在",
		2 : '<s:text name="siteStatus.2"/>',//:"在会议中",
		3 : '<s:text name="siteStatus.3"/>',//'"未入会",
		4 : '<s:text name="siteStatus.4"/>',//"正在呼叫",
		5 : '<s:text name="siteStatus.5"/>'//"正在振铃"
	};

	var siteFreeBusyStatusMap = {
		0 : '<s:text name="siteFreeBusyStatus.0"/>',//“闲",
		1 : '<s:text name="siteFreeBusyStatus.1"/>',//"忙",
		2 : '<s:text name="siteFreeBusyStatus.2"/>'//"无效",
	};
//查询会议信息
		function queryConfInfo() {
			$.ajax({
				type : "get",
				cache:false,
				url : "<c:out value='${basePath}'/>/confMgr/queryConfInfo.action",
				dataType : "json",
				async : false,
				success : function(data) {
					if(null  == data || 0 == data.length)
					{
						return;
					}
					var table1 = $("#confTable");
//					var idx=$("#confTable tr").length;
					for ( var i = 0, len = data.length; i < len; i++) {
						var item =data[i];
//						idx = idx + i;
						var idx = i;
						var cls = "even_row";
						if(idx%2 == 0){
							cls = "odd_row";
						}	
						if(null == item.accessCode)
						{
							item.accessCode="";
						}
						var row = "	<tr onclick='selectConfInfo("+idx+")'; id="+idx+" class='"+cls+"'>"
						+ "<td><label id='confId' name='confId'>"
						+ item.confId
						+ "</label></td>"
						+ "<td><label id='name' name='name'>"
						+ item.name
						+ "</label></td>"
						+ "<td><label id='beginTime' name='beginTime'>"
						+ item.beginTime
						+ "</label></td>"
						+ "<td><label id='duration' name='duration'>"
						+ item.duration + "  <s:text name='minute'/>"
						+ "</label></td>"
						+ "<td><label id='accessCode' name='accessCode'>"
						+ item.accessCode
						+ "</label></td>"
						+ "<td style='white-space: nowrap'><label id='confStatus' name='confStatus'>"
						+ confStatusMap[item.status]
						+ "</label></td></tr>";
						$(table1).find('tbody').append(row);
					}
					setSiteInfo(data[0].sites);
				}
			});
		}	
var index;
function initScheduleConfPage() {
//	var btnIndexs = new Array();
//	btnIndexs.push(3);
//	UnDisableBtns(btnIndexs);
		queryConfInfo();
		var table1 = $("#sitesTable");
		table1.find("tbody").html("");


//	    modalAction_scheduleConf();
		//加载时间控件
//		$("#beginTime").calendar();
		//点击增加会场，弹出页面
						$("#addSiteButton").click(function(e){
							if(0== $("#confIdChoose").val().length )
							{
								tab1_showAlert('warning',"<s:text name='notSelectConf'/>");
								return;
							}
							loadingSiteInfoList();
							$('#confMgr-add-site-modal').modal();
						});
					//点击预约会议，弹出页面
						$("#newConfButton").click(function(){
							isEditConf = 0;
							switchModalType();
							$('#confMgr-new-conf-modal').modal();
						});

					//点击修改会议，弹出页面
						$("#editConfButton").click(function(){
							editConf_id = $("#confIdChoose").val();
							editConf_name = $("#confNameChoose").val();
							isEditConf = 1;
							if('' == editConf_id){
								tab1_showAlert('warning',"<s:text name='notSelectConf'/>");
								return;
							}
							switchModalType();
							$('#confMgr-new-conf-modal').modal();
						});

					// 呼叫会场
					$("#connSites").click(function(){
						var sites ="" ;
						var confId = $("#confIdChoose").val();
						$(":checkbox[name=countSite]:checked").each(function(index){
							sites =$(this).parent().parent().children('td').eq(1).children('label').text()+","+sites;
						});
						if(undefined ==sites || 0 == sites.length || "" ==  sites)
						{
							tab1_showAlert('warning',"<s:text name='selectConnSite'/>");
							return;
						}
						$.ajax({
							type:'post',
							url:basePath+"/confMgr/connectSites.action",
							data:{
								'confId':confId,
								'sites':sites
							},
							async:false,
							dataType:'json',
							success:function(data){
								if(data ==0)
								{
									//alert("success");
									tab1_showAlert('success',"<s:text name='connSuccess'/>");
//									$.ligerDialog.success("<s:text name='connSuccess'/>","<s:text name='tip'/>",function(){
//										if( null != index || undefined != index || "" != index )
//										{
//											selectConfInfo(index);
//										}
//									});
									var targerConf = {};
				             		var allConf = $('#confTable tbody tr');
				             		for(var i = 0 ; i < allConf.size(); i++){
				             			if(confId == allConf.eq(i).find('td').eq(0).find('label').text()){
				             				allConf.eq(i).click();
				             				targerConf = allConf.eq(i);
				             			}
				             		}
				             		
				             		var  timer = setInterval(function runner(){
				             			
				             			var callingSites = $('#sitesTable tbody tr');
				             			
				             			var flag = 0;
				             			for(var i = 0; i < callingSites.size(); i++){
					             			if(4 == (callingSites.eq(i)).find('td').eq(4).find('label').attr('data')){
					             				targerConf.click();
					             				flag++;
					             				break;
					             			}
				             			}
				             			
				             			if(flag == 0){
				             				clearInterval(timer);
				             			}

				             		},1000);
				             		
								}
								else
								{
									tab1_showAlert('error','<s:text name="errorMsg"/>' +"  "+ data);
//									var msg =  '<s:text name="errorMsg"/>' +"  "+ data;
//									$.ligerDialog.error(msg,"<s:text name='tip'/>");
								}
							}
						});
					});

						//删除会议
						$("#delConfButton").click(function(){
							var confId = $("#confIdChoose").val();
							/*$("#confTable").find("tr").each(function(idx){
								if($(this).find("input[type='checkbox']").attr("checked")=="checked") //注意：此处判断不能用$(this).attr("checked")==‘true'来判断。 
								{
									confId = $(this).find("label[id='confId']").text();
								} 
							});
							*/
							if("" == confId)
							{
								tab1_showAlert('warning',"<s:text name='notSelectConf'/>");
								return;
							}
//							$.ligerDialog.confirm( "<s:text name='isDelConf'/>"+"?", function(flag) {
//								if (flag) {
									//获取会议id
									jQuery.ajax({
										url : basePath+'/confMgr/confMgr!cancelScheduledConf.action',
										type : 'post',
										dataType : 'text',
										data : {
											confId : confId,
											beginTime : $("#beginTimeChoose").val()
										},
										success : function(data) {
											if(data != "0" && data != "1342177282"){
												var msg =  '<s:text name="errorMsg"/>' +"  "+ data;
//												$.ligerDialog.error(msg,"<s:text name='tip'/>");
												return;
											}

											tab1_showAlert('success',"<s:text name='delSuccess'/>");
//											$.ligerDialog.success("<s:text name='delSuccess'/>","<s:text name='tip'/>");
											$("#recurrenceChoose").empty();
											table1.find("tbody").html("");
											$("#confTable").find("tr").each(function(){
												
												if($(this).children('td').eq(0).children('label').text()== confId) 
												{
													$(this).remove();
													$("#confIdChoose").val("");
													$("#confNameChoose").val("");
													$("#beginTimeChoose").val("");
													$("#durationChoose").val("");
												} 
											});
										}
									});
//								} else {
//									
//								}
//							});
		
						});
						

						
						$("#prolongConfButton").click(function(){
							var chooseConfId = $("#confIdChoose").val();
							var chooseTime = $("#beginTimeChoose").val();
							if('' == chooseConfId){
								tab1_showAlert('warning',"<s:text name='notSelectConf'/>");
								return;
							}
							$("#confMgr-prolong-conf-modal #confId").val(chooseConfId);
							$("#confMgr-prolong-conf-modal #beginTime").val(chooseTime);
							$("#confMgr-prolong-conf-modal").modal();
						});
						
						$("#addSiteButton_newConf").click(function(){
//							$('#confMgr-add-site-modal').modal();
//							$('#addSiteButton').click();
							$('#confMgr-new-conf-modal #newConfModal1').hide();
							$('#confMgr-new-conf-modal #newConfModal2').show();
							
							$('#confMgr-new-conf-modal #newConfButton_newConf').hide();
							$('#confMgr-new-conf-modal #newConfButton_newConf1').show();
							
							loadingSiteInfoList1();
						});
						
						$('#confMgr-new-conf-modal #newConfButton_newConf1').click(function(){
							$('#confMgr-new-conf-modal #newConfModal1').show();
							$('#confMgr-new-conf-modal #newConfModal2').hide();
							
							$('#confMgr-new-conf-modal #newConfButton_newConf').show();
							$('#confMgr-new-conf-modal #newConfButton_newConf1').hide();
							
							var selectSites = new Array();
							var checkboxs = $("#sitesTableInMode_newConf tbody").find('input[type="checkbox"]');
							var j = 0;
							for(var i =0 ; i <checkboxs.size(); i++ ){
								if(checkboxs.eq(i).is(":checked")){
									selectSites[j] = siteListTableDate[i];
									j++;
								}
							}

								setSiteInfo_newConf(selectSites);
						});
						
						//延长会议
						$("#prolong-conf-modal-yes-btn").click(function(){
							//弹出延长会议页面
							
							//以下方法写在延长会议页面中
							var confId = $("#confMgr-prolong-conf-modal #confId").val();
							var prolongTime = $("#confMgr-prolong-conf-modal #prolongTime").val();
							var beginTime = $("#confMgr-prolong-conf-modal #beginTime").val();
							if(confId!=""&&confId!=undefined){
//								  $.ligerDialog.open({
//									  url: basePath+'/confMgr/jumpProlongTime.action?confId='+confId,
//									  height: 300, width: 630, modal:false,title:"<s:text name='prolongConf'/>"
//								  });
								  
							jQuery.ajax({
									url : basePath+'/confMgr/confMgr!prolongScheduledConf.action',
									type : 'post',
									dataType : 'text',
									data : {
										confId : confId,
										prolongTime : prolongTime,
										beginDate : beginTime
									},
									success : function(data) {
										if(data != 0)
										{
										     var msg = errorMsg +"  "+ data;
											tab1_showAlert('error',msg);
//										     parent.$.ligerDialog.error(msg,"<s:text name='tip'/>");
										 	 return;
										}
										var confTimeNum;
									    $("#confTable").find("tr").each(function(idx){
										    if($(this).find("label[id='confId']").text()==confId) 
											{
										    	var confTime = $(this).find("label[id='duration']").text();
										    	confTimeNum = parseInt(confTime);
										    	var prolongTimeNum = parseInt(prolongTime);
										    	confTimeNum = confTimeNum +  prolongTimeNum;
												$(this).find("label[id='duration']").text(confTimeNum +"<s:text name='minute'/>");
											} 
										});
									    $("#durationChoose").val(confTimeNum);

										tab1_showAlert('success',"<s:text name='prolongSuccess'/>");
//									    $.ligerDialog.success("<s:text name='prolongSuccess'/>","<s:text name='tip'/>",function(){
//				                        	  	parent.$.ligerDialog.close(); 
//				                        });
									}
								});
								  
								}
						
						});
						
						//从会议中删除会场
						$("#delSiteButton").click(function(){
							var confId = $("#confIdChoose").val();

							var siteckbox = $("#tab1 #sitesTable").find("input[type='checkbox']");
							var count = 0;
							for(var i = 0; i < siteckbox.size(); i++){
								if(siteckbox.eq(i).is(':checked')){
									count++;
								}
							}

							if(0 == count){
								tab1_showAlert('warning',"<s:text name='notSelectSite'/>");
								return;
							}
							var siteForDel = new Array();
							$("#sitesTable").find("tr").each(function(){
								if($(this).find("input[type='checkbox']").attr("checked")=="checked") //注意：此处判断不能用$(this).attr("checked")==‘true'来判断。 
								{
									siteForDel.push($(this).find("label[id='siteUri']").text());
								} 
							});


							var beginTime = "";
						    var isRecurrence = $("#recurrenceChoose option").size();
			                if(isRecurrence > 0)
			                {
			                	beginTime = $("#recurrenceChoose option:selected").attr("value");
			               	}
			                else
			                {
			                	beginTime = $("#beginTime").val();
			               	}
			                for(var i = 0 ; i < siteForDel.length; i ++){
								$.ajax({
									url : basePath+'/confMgr/confMgr!delSiteFromConf.action',
									type : 'post',
									dataType : 'json',
									data : {
										'siteUri' : siteForDel[i],
										'confId' : confId,
										'beginTime': beginTime
									},
									success : function(data) {
										if(data ==0)
										{
	//										$("#sitesTable").find("tr").each(function(){
	//											if(siteUri == $(this).find("label[id='siteUri']").text())
	//											{
	//												$(this).empty();
	//											} 
	//										});

											tab1_showAlert('success',"<s:text name='delSuccess'/>");
	//										$.ligerDialog.success("<s:text name='delSuccess'/>","<s:text name='tip'/>",function(){
	//											location.reload();
	//										});
						             		var allConf = $('#confTable tbody tr');
						             		for(var i = 0 ; i < allConf.size(); i++){
						             			if(confId == allConf.eq(i).find('td').eq(0).find('label').text()){
						             				allConf.eq(i).click();
						             			}
						             		}
										}
										else
										{

											var msg =  '<s:text name="errorMsg"/>' +"  "+ data;
											tab1_showAlert('error',msg);
	//										$.ligerDialog.error(msg,"<s:text name='tip'/>");
										}
									}
								});
							}

						});
	};
/*$(function(){
    var handler = function(){
   	var idx=$("#confTable tr").length;
    	selectConfInfo(idx);
    };
    var timer = setTimeout( handler , 800);
    
    var clear = function(){
        clearTimeout(timer);
    };
    window.unload = clear;
});*/
	function addSiteToConf(siteInfo){
         var confId = $("#confIdChoose").val(); 
         var beginTime = "";

         if('' == confId){
        	 return;
         }
         
         var isRecurrence = $("#recurrenceChoose option").size();
         if(isRecurrence > 0)
         {
         	beginTime = $("#recurrenceChoose option:selected").attr("value");
         }
         $.ajax({
             type : "post",
             url : "<c:out value='${basePath}'/>/confMgr/addSiteToConf.action",
             dataType : "json",
             data:{
             	'confId':confId,
             	'beginTime':beginTime,
             	'siteUri': siteInfo.siteUri,
             	'siteName': siteInfo.siteName,
             	'siteType': siteInfo.siteType
             },

             success : function(data) {
             	if(data == 0)
             	{
             		//parent.addSiteInfo(selectedIndexs);
					tab1_showAlert('success',"<s:text name='addSuccess'/>");
//             		  parent.$.ligerDialog.success("<s:text name='addSuccess' />","<s:text name='tip'/>",function(){
//             			    parent.location.reload();
//                      });
             		var allConf = $('#confTable tbody tr');
             		for(var i = 0 ; i < allConf.size(); i++){
             			if(confId == allConf.eq(i).find('td').eq(0).find('label').text()){
             				allConf.eq(i).click();
             			}
             		}
             	}
             	else
             	{
                    var msg =errorMsg +"  "+ data;
					tab1_showAlert('error',msg);
//             		parent.$.ligerDialog.error(msg,"<s:text name='tip'/>",function(){
//                           parent.$.ligerDialog.close(); 
//                     });
             	}
             }
         });
	}
	
	function setSiteInfo(siteList){
			//alert(1);
			//给页面上的table赋值
			//alert("idx:"+idx+"staffName:"+item.staffName+",ucAccount:"+item.ucAccount);
			//在table的tbody里面动态添加内容
			//在此处组装table
		var table1 = $("#sitesTable");
		table1.find("tbody").html("");
		for(var idx=0,length =siteList.length; idx < length;idx++ ){
			var item = siteList[idx];
			if(null ==  item.uri )
			{
				item.uri  = "";
			}
			if(null == item.name)
			{
				item.name = "<s:text name='anonymous'/>";
			}
			if(null == item.status)
			{
				item.status =3;
			}
			var cls = "even_row";
			if((idx+1)%2 == 0){
				cls = "odd_row";
			}	
			var row = "<tr class='"+cls+"'><td width=5%><input type='checkbox' name='countSite' id='checkBox"+idx+"'>"
			+ "<td><label id='siteUri' name='siteUri'>"
			+ item.uri
			+ "</label></td>"
			+ "<td><label id='siteName' name='siteName'>"
			+ item.name
			+ "</label></td>"
			+ "<td><label id='siteType' name='siteType'>"
			+ siteTypeMap[item.type]
			+ "</label></td>"
			+ "<td style='white-space: nowrap'><label id='siteStatus' name='siteStatus' data='"+item.status+"'>"
			+ siteStatusMap[item.status]
			+ "</label></td>"
			+ "</tr>";
			table1.find('tbody').append(row);
		}
	}
	function setConfInfo(data,flag){
		var item = eval("("+ data+ ")");
		if(flag)
		{
			$("#confTable tr").each(function (){
				if($(this).children("td").eq(0).children('label').text() ==item.confId){
					$(this).children("td").eq(1).children('label').text(item.name);
					$(this).children("td").eq(2).children('label').text(item.beginTime);
					$(this).children("td").eq(3).children('label').text(item.duration + "<s:text name='minute'/>");
					$(this).children("td").eq(4).children('label').text(item.accessCode);
					$(this).children("td").eq(5).children('label').text(confStatusMap[item.status]);
				} ;
			});
			
		    return ;
		}
		//将tbody里面的内容清空
	//	table1.find("tbody").html("");
		var table1 = document.getElementById("confTable");
		var idx=$("#confTable tbody tr").size();
		var cls = "even_row";
		if( ( idx )%2 == 0)
		{
			cls = "odd_row";
		}	
		//$.each(dataObj.root,function(idx,item) {
							//alert(1);
							//给页面上的table赋值
							//alert("idx:"+idx+"staffName:"+item.staffName+",ucAccount:"+item.ucAccount);
							//在table的tbody里面动态添加内容
							//在此处组装table
		var row = "	<tr onclick='selectConfInfo("+idx+")'; id='"+idx+"' class='"+cls+"'>"
									+ "<td><label id='confId' name='confId'>"
									+ item.confId
									+ "</label></td>"
									+ "<td><label id='name' name='name'>"
									+ item.name
									+ "</label></td>"
									+ "<td><label id='beginTime' name='beginTime'>"
									+ item.beginTime
									+ "</label></td>"
									+ "<td><label id='duration' name='duration'>"
									+ item.duration+ " <s:text name='minute'/>"
									+ "</label></td>"
									+ "<td><label id='accessCode' name='accessCode'>"
									+ item.accessCode
									+ "</label></td>"
									+ "<td style='white-space: nowrap'><label id='confStatus' name='confStatus'>"
									+ confStatusMap[item.status]
									+ "</label></td></tr>";
			$(table1).find('tbody').append(row);
	}
	function addSiteInfo(siteInfo)
	{
		var table1 = document.getElementById("sitesTable");
		var idx=$("#sitesTable tr").length;
		var cls = "even_row";
		if((idx)%2 == 0){
			cls = "odd_row";
		}		
		var row = "<tr class="+cls+" id='tr"+ idx+"'><td width=5%><input type='checkbox' name='countSite' id='checkBox"+idx+"'>"
					+ "<td><label id='siteUri' name='siteUri'>"
					+ siteInfo[0].siteUri
					+ "</label></td>"
					+ "<td><label id='siteName' name='siteName'>"
					+ siteInfo[0].siteName
					+ "</label></td>"
					+ "<td><label id='siteType' name='siteType'>"
					+ siteInfo[0].siteType
					+ "</label></td>"
					+ "<td style='white-space: nowrap'><label id='siteStatus' name='siteStatus'>"
					+ siteInfo[0].siteStatus
					+ "</label></td>"
					+ "</tr>";
			$(table1).find('tbody').append(row);
	}
	var recurrenceMap;
	var siteStatusList ;
	function selectConfInfo(idx)
	{
		if("" == $("#confIdChoose").val($(id).children('td').eq(0).children('label').text()))
		{
			return;
		}
		index = idx;
		var table1 = $("#sitesTable");
		table1.find("tbody").html("");
		var id = "#"+idx;
		$("#confTable  tr").css("background-color","");
		$(id).css("background-color","silver");
		$.ajax({
			type : "post",
			cache:false,
			url : "<c:out value='${basePath}'/>/confMgr/selectConfById.action" ,
			data:{
				'confId':$(id).children('td').eq(0).children('label').text()
			},
			dataType : "json",
			async : false,
			success : function(data) {
				$("#recurrenceChoose").empty();
				if(data[0] == undefined ){
					siteStatusList =  data.siteStatusList;
					recurrenceMap = data.recurrenceMap;
					var length ="";
					var time="";
					for(var key in data.recurrenceMap)
					{
						var optionStr = "<option value='"+key+"'>"+key+"</option>";
						$("#recurrenceChoose").append(optionStr);
						if("" == time)
						{
							time = key;
						}
					}
					siteList = data.recurrenceMap[time];
					var table1 = $("#sitesTable");
					table1.find("tbody").html("");
					if(null == siteStatusList)
					{
						return;
					}
					length =siteList.length;
					for(var idx=0; idx < length;idx++ ){
						var item = siteList[idx];
						if(null == item.uri){
							continue;
						}
						var cls = "even_row";
						if((idx+1)%2 == 0){
							cls = "odd_row";
						}	
						if(undefined == item.status || null == item.status)
						{
							item.status = 3;
						}
						var row = "<tr class='"+cls+"'><td width=5%><input type='checkbox' name='countSite' id='checkBox"+idx+"'>"
						+ "<td><label id='siteUri' name='siteUri'>"
						+ item.uri
						+ "</label></td>"
						+ "<td><label id='siteName' name='siteName'>"
						+ item.name
						+ "</label></td>"
						+ "<td><label id='siteType' name='siteType'>"
						+ siteTypeMap[item.type]
						+ "</label></td>"
						+ "<td style='white-space: nowrap'><label id='siteStatus' name='siteStatus'  data='"+item.status+"'>"
						+ siteStatusMap[item.status]
						+ "</label></td>"
						+ "</tr>";
						table1.find('tbody').append(row);
					}
					
					return;
				}
				else if(data[0].siteList == undefined){
					return;
				}
				setSiteInfo(data[0].siteList);
			} 
		});
		$("#confIdChoose").val($(id).children('td').eq(0).children('label').text());
		$("#confNameChoose").val($(id).children('td').eq(1).children('label').text());
		$("#beginTimeChoose").val($(id).children('td').eq(2).children('label').text());
		if($(id).children('td').eq(3).children('label').text().length != 0)
		{
			$("#durationChoose").val(parseInt ($(id).children('td').eq(3).children('label').text()));
		}
	}

	function recurrenceSites(val)
	{
		var isRecurrence = $("#recurrenceChoose option").size();
		if(undefined == recurrenceMap || ""  == recurrenceMap || undefined == siteStatusList)
		{
			return;
		}
		var table1 = $("#sitesTable");
		table1.find("tbody").html("");
		for(var key in recurrenceMap)
		{
			if(key == val)
			{
				var siteList = recurrenceMap[key];
				for(var idx=0,length =siteList.length; idx < length;idx++ ){
					var item = siteList[idx];
					if(null == item.uri){
						continue;
					}
					var cls = "even_row";
					if((idx+1)%2 == 0){
						cls = "odd_row";
					}	
					if(undefined == item.status || null == item.status)
					{
						item.status = 3;
					}
					var row = "<tr class='"+cls+"'><td width=5%><input type='checkbox' name='countSite' id='checkBox"+idx+"'>"
					+ "<td><label id='siteUri' name='siteUri'>"
					+ item.uri
					+ "</label></td>"
					+ "<td><label id='siteName' name='siteName'>"
					+ item.name
					+ "</label></td>"
					+ "<td><label id='siteType' name='siteType'>"
					+ siteTypeMap[item.type]
					+ "</label></td>"
					+ "<td style='white-space: nowrap'><label id='siteStatus' name='siteStatus' data='"+item.status+"'>"
					+ siteStatusMap[item.status]
					+ "</label></td>"
					+ "</tr>";
					table1.find('tbody').append(row);
				}
			}
		}
	}

	
	function addMouseMoveListener_scheduleConf(){
		
//		var option1 = {title:"123123",container:"adfg",container:"container",trigger:"hover"};
//
//		$("#addSiteButton").tooltip(option1);
//		$("#addSiteButton").tooltip();
	    	
	        $("#addSiteButton").mousemove(function(){
	        	$("#codeMsg").show();
	        	$("#codeMsg").html("TPSDKResponseEx<List< SiteAccessInfoEx >> addSiteToConfEx (String confId,SiteInfoEx siteInfo, Date beginTime)");
	        });
	        $("#addSiteButton").mouseleave(function(){
	            $("#codeMsg").hide();
	        });
	        $("#delSiteButton").mousemove(function(){
	            $("#codeMsg").show();
	            $("#codeMsg").html("Integer delSiteFromConfEx(String confId, String siteUri, Date beginTime)");
	        });
	        $("#delSiteButton").mouseleave(function(){
	            $("#codeMsg").hide();
	        });
	        $("#connSites").mousemove(function(){
	            $("#codeMsg").show();
	            $("#codeMsg").html("Integer connectSitesEx (String confId, List<String> siteUris)");
	        });
	        $("#connSites").mouseleave(function(){
	            $("#codeMsg").hide();
	        });
	        $("#newConfButton").mousemove(function(){
	            $("#codeMsg").show();
	            $("#codeMsg").html("TPSDKResponseEx<ConferenceInfoEx> scheduleConfEx(ConferenceInfoEx scheduleConf) ");
	        });
	        $("#newConfButton").mouseleave(function(){
	            $("#codeMsg").hide();
	        });
	        $("#delConfButton").mousemove(function(){
	            $("#codeMsg").show();
	            $("#codeMsg").html("Integer delScheduledConfEx(String confId, Date beginTime)");
	        });
	        $("#delConfButton").mouseleave(function(){
	            $("#codeMsg").hide();
	        });
	        $("#prolongConfButton").mousemove(function(){
	            $("#codeMsg").show();
	            $("#codeMsg").html("Integer prolongScheduledConfEx (String confId, java.util.Date beginDate, Duration prolongTime) ");
	        });
	        $("#prolongConfButton").mouseleave(function(){
	            $("#codeMsg").hide();
	        });

	}
	
//	function modalAction_scheduleConf()
//	{
//		$("#confMgr-add-site-modal").on("show",function(){
//			$(".modal-backdrop").hide();
//			$("#confMgr-new-conf-modal").hide();
////			alert("loadingSiteInfoList");
//			loadingSiteInfoList();
//		});
//		
//		$("#confMgr-add-site-modal").on("hide",function(){
//			if($(".modal-backdrop").size() == 2){
//				$(".modal-backdrop").show();
//				$("#confMgr-new-conf-modal").show();
//			}
//
//		});
//		
//	}
	
	function loadingSiteInfoList()
	{
//		var tableDate = {};
		$('#add-site-modal-yes-btn').unbind("click");
		$('#add-site-modal-yes-btn').click(function(){
			
			var selectSites = new Array();
			var checkboxs = $("#sitesTableInMode tbody").find('input[type="checkbox"]');
			var j = 0;
			for(var i =0 ; i <checkboxs.size(); i++ ){
				if(checkboxs.eq(i).is(":checked")){
					selectSites[j] = siteListTableDate[i];
					j++;
				}
			}
//			if($(".modal-backdrop").size() == 2){
//				setSiteInfo_newConf(selectSites);
//			}else{
				for(var i = 0 ; i < selectSites.length; i++){
					addSiteToConf(selectSites[i]);
				}
				
//			}
		});
		
		$.ajax({

			cache:false,
			url: basePath+"/confMgr/jumpSiteInfo.action",
			dataType : "json",


			
			success : function(data) {
				
				if(null  == data || 0 == data.Rows.length)
				{
					return;
				}
				
				siteListTableDate = data.Rows;

				var table1 = $("#sitesTableInMode tbody");
//				var idx=$("#sitesTableInMode tr").length;
				var len = siteListTableDate.length;
				
				var rwosHtml = '';
				for ( var i = 0; i < len; i++) {
					var item =siteListTableDate[i];

					if(null == item.accessCode)
					{
						item.accessCode="";
					}
					var row = "	<tr>"
					+'<td><input type="checkbox"/></td>'
					+ "<td><label id='siteUri' name='siteUri'>"
					+ item.siteUri
					+ "</label></td>"
					+ "<td><label id='siteName' name='siteName'>"
					+ item.siteName
					+ "</label></td>"
					+ "<td><label id='siteType' name='siteType'>"
					+ siteTypeMap[item.siteType]
					+ "</label></td></tr>";
					

					
					rwosHtml = rwosHtml + row;
					

				}
				
				table1.html(rwosHtml);
				
				table1.find('tr:odd').addClass('even_row');
				table1.find('tr:even').addClass('odd_row');
				table1.find('tr').hover(function(){
					$(this).addClass('hover_row');
				},function(){
					$(this).removeClass('hover_row');
				});
	
				
				var trs = table1.find('tr');
				for(var i = 0 ; i < trs.size(); i++)
				{
					var tds = trs.eq(i).find('td');
					for(var j = 1 ; j<tds.size();j++ ){
						tds.eq(j).click(function(){
							$(this).parent().find('input[type="checkbox"]').click();
						});
					}
				}
				
//				setSiteInfo(data[0].sites);
			}
		});
	}
	
	function tab1_showAlert(type,msg){
		dismissAlert();
		
		if('warning' == type){
			$('#tab1_warning_alert').find('#content').html(msg);
			$('#tab1_warning_alert').show();
		}else if('success' == type){
			$('#tab1_success_alert').find('#content').html(msg);
			$('#tab1_success_alert').show();
		}else if("error" == type){
			$('#tab1_error_alert').find('#content').html(msg);
			$('#tab1_error_alert').show();
		}else{
			
		}
	}
	function dismissAlert(){
		$('#tab1_alert_content .alert').hide();
	}
	
	function loadingSiteInfoList1()
	{

		
		$.ajax({

			cache:false,
			url: basePath+"/confMgr/jumpSiteInfo.action",
			dataType : "json",


			
			success : function(data) {
				
				if(null  == data || 0 == data.Rows.length)
				{
					return;
				}
				
				siteListTableDate = data.Rows;

				var table1 = $("#sitesTableInMode_newConf tbody");
//				var idx=$("#sitesTableInMode tr").length;
				var len = siteListTableDate.length;
				
				var rwosHtml = '';
				for ( var i = 0; i < len; i++) {
					var item =siteListTableDate[i];

					if(null == item.accessCode)
					{
						item.accessCode="";
					}
					var row = "	<tr>"
					+'<td><input type="checkbox"/></td>'
					+ "<td><label id='siteUri' name='siteUri'>"
					+ item.siteUri
					+ "</label></td>"
					+ "<td><label id='siteName' name='siteName'>"
					+ item.siteName
					+ "</label></td>"
					+ "<td><label id='siteType' name='siteType'>"
					+ siteTypeMap[item.siteType]
					+ "</label></td></tr>";
					

					
					rwosHtml = rwosHtml + row;
					

				}
				
				table1.html(rwosHtml);
				
				table1.find('tr:odd').addClass('even_row');
				table1.find('tr:even').addClass('odd_row');
				table1.find('tr').hover(function(){
					$(this).addClass('hover_row');
				},function(){
					$(this).removeClass('hover_row');
				});
	
				
				var trs = table1.find('tr');
				for(var i = 0 ; i < trs.size(); i++)
				{
					var tds = trs.eq(i).find('td');
					for(var j = 1 ; j<tds.size();j++ ){
						tds.eq(j).click(function(){
							$(this).parent().find('input[type="checkbox"]').click();
						});
					}
				}
				

			}
		});
	}
