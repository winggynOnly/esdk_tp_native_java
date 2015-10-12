var errorMsg = '<s:text name="errorMsg"/>';
var selectedSite = "";
var siteUrl = "";
function querySitesInfoRefresh(){
	selectedSite = "";
	siteUrl = "";
	dismissAlert3();
	//页面加载时，查询所有会场列表 
	jQuery.ajax({
				url : "siteCtrl!querySites.action",
				type : 'post',
				dataType : 'text',
				async : false,
				success : function(data) {
					var dataObj=eval("("+data+")");
					var table1 = $("#tab3 #siteCtrlTable");
					//将tbody里面的内容清空
					table1.find("tbody").html("");
					$("#tab3 #auxSrcList").empty();
					$("#tab3 [name='isConnectAuxCB']").attr("checked", false);
					$("#tab3 [name='isSendingAuxCB']").attr("checked", false);
					$.each(dataObj.root,function(idx,item){
							//给页面上的table赋值
							//alert("idx:"+idx+"siteName:"+item.siteName+",siteUri:"+item.siteUri);
							//在table的tbody里面动态添加内容
							//在此处组装table
							var cls = "even_row";
							if((idx+1)%2 == 0){
								cls = "odd_row";
							}
							var row = "<tr class="+cls  +">"
									+ "<td><label id='siteUri' name='siteUri'>"
									+ item.siteUri
									+ "</label></td>"
									+ "<td><label id='siteName' name='siteName'>"
									+ item.siteName
									+ "</label></td>"
									+ "<td><label id='siteType' name='siteType'>"
									+ siteTypeMap[item.siteType]
									+ "</label></td>"
									+ "<td><label id='siteStatus' name='siteStatus'>"
									+ siteFreeBusyStatusMap[item.siteStatus]
									+ "</label></td></tr>";
							table1.append(row);
							
						});
				}
			});
}

function initSiteCtrlPage(){
	function refreshPic() {
		if ("01010086" == selectedSite) {
			siteUrl = "http://10.170.55.205/videomonitor.jpg?VmniLineId=0&Vmncount"
					+ new Date().getTime();
		}
		if ("01010010"== selectedSite) {
			siteUrl = "http://10.170.55.206/videomonitor.jpg?VmniLineId=0&Vmncount"
					+ new Date().getTime();
		}
		$("#tab3 #videoImg").attr('src', siteUrl);
	};
//	setInterval(refreshPic(), 3000);

/*	$(function(){
		//页面加载时，查询所有会场列表 
		jQuery.ajax({
					url : "siteCtrl!querySites.action",
					type : 'post',
					dataType : 'text',
					async : false,
					data : {
					},
					success : function(data) {
						var dataObj=eval("("+data+")");
						var table1 = $("#tab3 #siteCtrlTable");
						//将tbody里面的内容清空
						table1.find("tbody").html("");
						$.each(dataObj.root,function(idx,item){
								//给页面上的table赋值
								//alert("idx:"+idx+"siteName:"+item.siteName+",siteUri:"+item.siteUri);
								//在table的tbody里面动态添加内容
								//在此处组装table
								var cls = "even_row";
								if((idx+1)%2 == 0){
									cls = "odd_row";
								}
								var row = "<tr class="+cls  +">"
										+ "<td><label id='siteUri' name='siteUri'>"
										+ item.siteUri
										+ "</label></td>"
										+ "<td><label id='siteName' name='siteName'>"
										+ item.siteName
										+ "</label></td>"
										+ "<td><label id='siteType' name='siteType'>"
										+ siteTypeMap[item.siteType]
										+ "</label></td>"
										+ "<td><label id='siteStatus' name='siteStatus'>"
										+ siteFreeBusyStatusMap[item.siteStatus]
										+ "</label></td></tr>";
								table1.append(row);
								
							});
					}
				});
	});*/
	
	function onLoadInfo(){
		var successFlag = 0;
		
		jQuery.ajax({
			url:"siteCtrl!isConnectAuxSourceEx.action",
			type:'post',
			async:false,
			dataType:'text',
			data:
			{
				siteUri:selectedSite
			},
			success:function(data){
				$("#tab3 [name='isConnectAuxCB']").attr("checked", false);
				if("true" == data)
				{
					$("#tab3 [name='isConnectAuxCB']").attr("checked", true);
				}
				else if ("false" == data)
				{
					$("#tab3 [name='isConnectAuxCB']").attr("checked", false);
				}
				else
				{
					successFlag = 1;
					var msg = errorMsg +"  "+ data;
//					$.ligerDialog.error(msg,"<s:text name='tip'/>");
					tab3_showAlert('error',msg);
				}
			},
			error:function(data)
			{
				successFlag = 1;
			}
		});
		if( 0 != successFlag)
		{
			return ;
		}
		jQuery.ajax({
			url:"siteCtrl!isSendAuxStreamEx.action",
			type:'post',
			async:false,
			dataType:'text',
			data:
			{
				siteUri:selectedSite
			},
			success:function(data){
				$("#tab3 [name='isSendingAuxCB']").attr("checked", false);
				if("true" == data)
				{
					$("#tab3 [name='isSendingAuxCB']").attr("checked", true);
				}
				else if ("false" == data)
				{
					$("#tab3 [name='isSendingAuxCB']").attr("checked", false);
				}
				else
				{
					successFlag = 1;
				}
			}
		});
		jQuery.ajax({
			url : "siteCtrl!queryMainStreamSourcesEx.action",
			type : 'post',
			async:false,
			dataType : 'text',
			data : {
				siteUri:selectedSite
			},
			success : function(data) {
				$("#tab3 #auxSrcList").empty();
				if(!isNaN(data))
				{
					successFlag = 1;
					return;
				}
				var dataObj=eval("("+data+")");
				//增加下拉列表框内容
				$.each(dataObj.root,function(idx,item) {
					var row = "<option value='" + idx+ "'>"
							+ item.auxName
							+ "</option>";
					 $("#tab3 #auxSrcList").append(row);
				});
			}
		});
		
		if(0 == successFlag)
		{
			dismissAlert3();
		}
	}
	
	$('#siteCtrlTable tbody tr').live('click', function(){
		$('#siteCtrlTable tbody tr').css("background-color","");
		$(this).css("background-color","silver");
		selectedSite = $(this).find("#siteUri").html(); 
		//setInterval(refreshPic(), 3000);
		onLoadInfo();
	});

	$("#tab3 #upButton").click(function() {
	
		if("" == selectedSite)
		{
			tab3_showAlert('warning','<s:text name="notSelectSite"/>');
			return;
		}
		if(null==  $("#tab3 #auxSrcList").val())
		{
			tab3_showAlert('warning','<s:text name="notSelectMainSrc"/>');
			return;
		}
		//控制摄像头向上倾斜 
		jQuery.ajax({
			url : "siteCtrl!cameraAction.action",
			type : 'post',
			dataType : 'text',
			data : {
				siteUri:selectedSite,
				actionCode : "2",
				auxSrc : $("#tab3 #auxSrcList").val()
			},
			success:function(data){
				//alert(data);
				if(0 == data)
				{
//					$.ligerDialog.success("<s:text name='upSuccess'/>","<s:text name='tip'/>");
					tab3_showAlert('success',"<s:text name='upSuccess'/>");
				}
				else
				{
					var msg = errorMsg +"  "+ data;
//					$.ligerDialog.error(msg,"<s:text name='tip'/>");
					tab3_showAlert('error',msg);
				}
			}
		});
	});
	
	$("#tab3 #downButton").click(function() {
		if("" == selectedSite)
		{
			tab3_showAlert('warning','<s:text name="notSelectSite"/>');
			return;
		}
		if(null==  $("#tab3 #auxSrcList").val())
		{
			tab3_showAlert('warning','<s:text name="notSelectMainSrc"/>');
			return;
		}
		jQuery.ajax({
			url : "siteCtrl!cameraAction.action",
			type : 'post',
			dataType : 'text',
			data : {
				siteUri:selectedSite,
				actionCode : "3",
				auxSrc : $("#tab3 #auxSrcList").val()
			},
			success:function(data){
				//alert(data);
				if(0 == data)
				{
//					$.ligerDialog.success("<s:text name='downSuccess'/>","<s:text name='tip'/>");
					tab3_showAlert('success',"<s:text name='downSuccess'/>");
				}
				else
				{
					var msg = errorMsg +"  "+ data;
//					$.ligerDialog.error(msg,"<s:text name='tip'/>");
					tab3_showAlert('error',msg);
				}
			}
		});
	});
	
	$("#tab3 #leftButton").click(function() {
		if("" == selectedSite)
		{
			tab3_showAlert('warning','<s:text name="notSelectSite"/>');
			return;
		}
		if(null==  $("#tab3 #auxSrcList").val())
		{
			tab3_showAlert('warning','<s:text name="notSelectMainSrc"/>');
			return;
		}
		jQuery.ajax({
			url : "siteCtrl!cameraAction.action",
			type : 'post',
			dataType : 'text',
			data : {
				siteUri:selectedSite,
				actionCode : "1",
				auxSrc : $("#tab3 #auxSrcList").val()
			},
			success:function(data){
				//alert(data);
				if(0 == data)
				{
//					$.ligerDialog.success("<s:text name='leftSuccess'/>","<s:text name='tip'/>");
					tab3_showAlert('success',"<s:text name='leftSuccess'/>");
				}
				else
				{
					var msg = errorMsg +"  "+ data;
//					$.ligerDialog.error(msg,"<s:text name='tip'/>");
					tab3_showAlert('error',msg);
				}
			}
		});
	});
	
	$("#tab3 #rightButton").click(function() {
		if("" == selectedSite)
		{
			tab3_showAlert('warning','<s:text name="notSelectSite"/>');
			return;
		}
		if(null==  $("#tab3 #auxSrcList").val())
		{
			tab3_showAlert('warning','<s:text name="notSelectMainSrc"/>');
			return;
		}
		jQuery.ajax({
			url : "siteCtrl!cameraAction.action",
			type : 'post',
			dataType : 'text',
			data : {
				siteUri:selectedSite,
				actionCode : "0",
				auxSrc : $("#tab3 #auxSrcList").val()
			},
			success:function(data){
				//alert(data);
				if(0 == data)
				{
//					$.ligerDialog.success("<s:text name='rightSuccess'/>","<s:text name='tip'/>");
					tab3_showAlert('success',"<s:text name='rightSuccess'/>");
				}
				else
				{
					var msg = errorMsg +"  "+ data;
//					$.ligerDialog.error(msg,"<s:text name='tip'/>");
					tab3_showAlert('error',msg);
				}
			}
		});
	});
	
	$("#tab3 #retriveButton").click(function() {
		if("" == selectedSite)
		{
			tab3_showAlert('warning','<s:text name="notSelectSite"/>');
			return;
		}
		if(null==  $("#tab3 #auxSrcList").val())
		{
			tab3_showAlert('warning','<s:text name="notSelectMainSrc"/>');
			return;
		}
		jQuery.ajax({
			url : "siteCtrl!cameraAction.action",
			type : 'post',
			dataType : 'text',
			data : {
				siteUri:selectedSite,
				actionCode : "16",
				auxSrc : $("#tab3 #auxSrcList").val()
			},
			success:function(data){
				//alert(data);
				if(0 == data)
				{
//					$.ligerDialog.success("<s:text name='retrieveSuccess'/>","<s:text name='tip'/>");
					tab3_showAlert('success',"<s:text name='retrieveSuccess'/>");
				}
				else
				{
					var msg = errorMsg +"  "+ data;
//					$.ligerDialog.error(msg,"<s:text name='tip'/>");
					tab3_showAlert('error',msg);
				}
			}
		});
	});
}

function addMouseMoveListener_siteCtrl(){
	 $("#tab3 #siteCtrlTable").mousemove(function(){
         $("#tab3 #codeMsgSiteCtrl").show();
         $("#tab3 #codeMsgSiteCtrl").html("TPSDKResponseEx<List<SiteInfoEx>> querySitesEx ()");
     });
     $("#tab3 #siteCtrlTable").mouseleave(function(){
         $("#tab3 #codeMsgSiteCtrl").hide();
     });
  $("#tab3 #cameraCtrl").mousemove(function(){
         $("#tab3 #codeMsgSiteCtrl").show();
         $("#tab3 #codeMsgSiteCtrl").html("Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl)");
     });
     $("#tab3 #cameraCtrl").mouseleave(function(){
         $("#tab3 #codeMsgSiteCtrl").hide();
     });
  $("#tab3 #isConnectAuxCB").mousemove(function(){
         $("#tab3 #codeMsgSiteCtrl").show();
         $("#tab3 #codeMsgSiteCtrl").html("TPSDKResponseEx< Integer > isConnectAuxSourceEx (String siteURI)");
     });
     $("#tab3 #isConnectAuxCB").mouseleave(function(){
         $("#tab3 #codeMsgSiteCtrl").hide();
     });
  $("#tab3 #isSendingAuxCB").mousemove(function(){
         $("#tab3 #codeMsgSiteCtrl").show();
         $("#tab3 #codeMsgSiteCtrl").html("TPSDKResponseEx< Integer > isSendAuxStreamEx (String siteURI)");
     });
     $("#tab3 #isSendingAuxCB").mouseleave(function(){
         $("#tab3 #codeMsgSiteCtrl").hide();
     });
  $("#tab3 #auxSrcList").mousemove(function(){
         $("#tab3 #codeMsgSiteCtrl").show();
         $("#tab3 #codeMsgSiteCtrl").html("TPSDKResponseEx< Map<Integer，String>> queryMainStreamSourcesEx (String siteUri)");
     });
     $("#tab3 #auxSrcList").mouseleave(function(){
         $("#tab3 #codeMsgSiteCtrl").hide();
     });
}

function tab3_showAlert(type,msg){
	dismissAlert3();
	
	if('warning' == type){
		$('#tab3_warning_alert').find('#content').html(msg);
		$('#tab3_warning_alert').show();
	}else if('success' == type){
		$('#tab3_success_alert').find('#content').html(msg);
		$('#tab3_success_alert').show();
	}else if("error" == type){
		$('#tab3_error_alert').find('#content').html(msg);
		$('#tab3_error_alert').show();
	}else{
		
	}
}
function dismissAlert3(){
	$('#tab3_alert_content .alert').hide();
}