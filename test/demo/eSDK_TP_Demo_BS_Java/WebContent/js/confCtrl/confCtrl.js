var errorMsg = '<s:text name="errorMsg"/>';
/*function queryConfId() {
	$("#selectId").empty();
	$.ajax({
		type : "get",
		url : "<c:out value='${basePath}'/>/confCtrl/queryConfId.action",
		dataType : "json",
		async : false,
		success : function(data) {
			for(var i =0,length = data.length;i < length; i++){
				var option="<option id="+ data[i]+">"+data[i]+"</option>";
				$("#selectId").append(option);
			}
		}
	});
}*/
var siteList;
var confId;
var siteUri;
var siteName;
function queryConf() {
	confId = $("#selectId option:selected").attr("id");
	$.ajax({
				type : "get",
				cache:false,
				url : "<c:out value='${basePath}'/>/confCtrl/queryConfById.action?confId="
						+ confId,
				dataType : "json",
				async : false,
				success : function(data) {
					$('#tab2 #confCtrl_lodingImg').hide();
					if (null !=  data.confStatus && null != data.confStatus.id) {
						$("#tab2 :text").each(function(){
							$(this).val("");
						});
						$("#tab2 #confName").val(data.confStatus.name);
						$("#tab2 #status").val(confStatusMap[data.confStatus.status]);
						$("#tab2 #speaking").val(data.confStatus.speaking);
						$("#tab2 #chair").val(data.confStatus.chair);
						$("#tab2 #broadcast").val(data.confStatus.broadcast);
						siteList = data.siteList;
						$("#siteTable tr").eq(0).nextAll().remove();
						var trObj = "";
						var trStart = "";
						var trEnd = "</tr>";
						for ( var i = 0, len = data.siteList.length; i < len; i++) {
							var tdStr = "";
							var cls="even_row";
							if((i+1)%2 == 0)
							{
								cls = "odd_row";
							}
							if(null ==  data.siteList[i].uri || "" == data.siteList[i].uri )
							{
								 data.siteList[i].uri  = "";
							}
							if(null == data.siteList[i].name || "" == data.siteList[i].name)
							{
								data.siteList[i].name = "<s:text name='anonymous'/>";
							}
							trStart = "<tr id="+ i+" onclick=querySiteInfo(" + i + ") class="+cls+">";
							tdStr = "<td>" + data.siteList[i].uri + "</td>";
							tdStr += "<td>" + data.siteList[i].name + "</td>";
							tdStr += "<td>"
									+ siteTypeMap[data.siteList[i].type]
									+ "</td>";
							trObj = trStart + tdStr + trEnd;
							$("#tab2 #siteTable").append(trObj);
						}
					} else {
						$("#tab2 #confName").val("");
						$("#tab2 #status").val("");
						$("#tab2 #speaking").val("");
						$("#tab2 #chair").val("");
						$("#tab2 #broadcast").val("");
						$("#tab2 #siteTable tr").eq(0).nextAll().remove();
						$("#tab2 #startTime").val("");
						$("#tab2 #span").val("");
						$("#tab2 #siteInConfName").val("");
						$("#tab2 #siteConfstatus").val("");
						$("#tab2 #videoSiteUri").val("");
						var msg = errorMsg +"  "+ data;
						tab2_showAlert('error',msg);
						//$.ligerDialog.error(msg,"<s:text name='tip'/>");
					}
				},
				beforeSend : function(){
					$('#tab2 #confCtrl_lodingImg').show();
					var action=setTimeout(function(){
						$('#tab2 #confCtrl_lodingImg').hide();
					},10000);
				}
			});
}
function querySiteInfo(index) {
	if (null != siteList && null != confId) {
//		var id = "#"+index;
		$("#tab2 #siteTable tr").css("background-color","");
		$("#tab2 #siteTable tr#"+index).css("background-color","silver");
		siteUri = siteList[index].uri;
		siteName = siteList[index].name;
		var flag = true;
		$.ajax({
					type : "get",
					cache:false,
					url : "<c:out value='${basePath}'/>/confCtrl/querySiteStatus.action?siteUri="
							+ siteUri + "&confId=" + confId,
					dataType : "json",
					success : function(data) {
						$('#tab2 #confCtrl_lodingImg').hide();
						if (data.resultCode == 0) 
						{
							$("#tab2 #siteInConfName").val(siteList[index].name);
							$("#tab2 #videoSiteUri").val(siteList[index].uri);
							$("#tab2 #startTime").val(data.beginTime);
							$("#tab2 #span").val(data.span);
							$("#tab2 #siteConfstatus").val(siteStatusMap[data.siteInConfStatus]);
						}
						else
						{
							flag = false;
							var msg = errorMsg +"  "+ data.resultCode;
							tab2_showAlert('error',msg);
//							$.ligerDialog.error(msg,"<s:text name='tip'/>");
						}
					},
					beforeSend : function(){
						$('#tab2 #confCtrl_lodingImg').show();
					}
				});

	}
}

//function setBroadcastSite() {
//	if (null == confId || null == siteUri) {
//		return;
//	}
//	var isBroadcast = 0;
//	$.ligerDialog.confirm( '<s:text name="isSetBroadcastSite"/>'+"?",'<s:text name="tip"/>', function(flag) {
//		if (flag) {
//			isBroadcast = 0;
//			setBroadcastSiteAjax(confId,siteUri,isBroadcast);
//		} else {
//			isBroadcast = 1;
//			setBroadcastSiteAjax(confId,siteUri,isBroadcast);
//		}
//	});
//}
function setBroadcastSiteAjax(isBroadcast){
	$.ajax({
		type : "get",
		cache:false,
		url : "<c:out value='${basePath}'/>/confCtrl/setBroadcastSite.action?confId="
				+ confId
				+ "&siteUri="
				+ siteUri
				+ "&isBroadcast="
				+ isBroadcast,
		dataType : "json",
		success : function(data) {
			$('#confCtrl-setBroadcastSite-modal').modal('hide');
			$('#confCtrl-setBroadcastSite-modal #lodingImg').hide();
			if (data == 0) {
				if(1 == isBroadcast)
				{
					$("#tab2 #broadcast").val("");
				}
				else
			    {
					$("#tab2 #broadcast").val(siteName);
				}
//				$.ligerDialog.success("<s:text name='setSuccess'/>","<s:text name='tip'/>");
				tab2_showAlert('success',"<s:text name='setSuccess'/>");
			} else {
				var msg = errorMsg +"  "+ data;
//				$.ligerDialog.error(msg,"<s:text name='tip'/>");
				tab2_showAlert('error',msg);
			}

		},
		beforeSend : function(){
			$('#confCtrl-setBroadcastSite-modal #lodingImg').show();
		}
	});
	
}
//function setSitesQuiet() {
//	if (null == confId || null == siteUri) {
//		return ;
//	}
//	var isQuiet = 0;
//	$.ligerDialog.confirm('<s:text name="isSetSitesQuiet"/>'+"?"+'<br/>'+'<s:text name="desQuietY"/>'+'<br/>'+'<s:text name="desQuietN"/>', '<s:text name="tip"/>',
//		function(flag) {
//			if (flag) {
//				isQuiet = 0;
//				setSitesQuietAjax(confId,siteUri,isQuiet);
//			} else {
//				isQuiet = 1;
//				setSitesQuietAjax(confId,siteUri,isQuiet);
//			}
//	});
//}
function setSitesQuietAjax(isQuiet){
	$.ajax({
				type : "get",
				cache:false,
				url : "<c:out value='${basePath}'/>/confCtrl/setSitesQuiet.action?confId="
						+ confId
						+ "&siteUri="
						+ siteUri
						+ "&isQuiet="
						+ isQuiet,
				dataType : "json",
				success : function(data) {
					$('#confCtrl-setSitesQuiet-modal #lodingImg').hide();
					$('#confCtrl-setSitesQuiet-modal').modal('hide');
					if (data == 0) {
//						$.ligerDialog.success("<s:text name='setSuccess'/>","<s:text name='tip'/>");
						tab2_showAlert('success',"<s:text name='setSuccess'/>");
					} else {
						var msg = errorMsg +"  "+ data;
//						$.ligerDialog.error(msg,"<s:text name='tip'/>");
						tab2_showAlert('error',msg);
					}
				},
				beforeSend : function(){
					$('#confCtrl-setSitesQuiet-modal #lodingImg').show();
				}
			});
} 

//function setSitesMute() {
//	if (null == confId || null == siteUri) {
//		return;
//	}
//	var isMute = 0;
//	$.ligerDialog.confirm('<s:text name="isSetSitesMute"/>'+"?"+'<br/>'+'<s:text name="desMuteY"/>'+'<br/>'+'<s:text name="desMuteN"/>','<s:text name="tip"/>',
//		function(flag) {
//			if (flag) {
//				isMute = 0;
//				setSitesMuteAjax(confId,siteUri,isMute);
//			} else {
//				isMute = 1;
//				setSitesMuteAjax(confId,siteUri,isMute);
//			}
//	});
//}
function setSitesMuteAjax(isMute){
	$.ajax({
				type : "get",
				cache:false,
				url : "<c:out value='${basePath}'/>/confCtrl/setSitesMute.action?confId="
						+ confId
						+ "&siteUri="
						+ siteUri
						+ "&isMute="
						+ isMute,
				dataType : "json",
				success : function(data) {
					$('#confCtrl-setSitesMute-modal #lodingImg').hide();
					$('#confCtrl-setSitesMute-modal').modal('hide');
					if (data == 0) {
//						$.ligerDialog.success("<s:text name='setSuccess'/>","<s:text name='tip'/>");
						tab2_showAlert('success',"<s:text name='setSuccess'/>");
					} else {
						var msg = errorMsg +"  "+ data;
//						$.ligerDialog.error(msg,"<s:text name='tip'/>");
						tab2_showAlert('error',msg);
					}
				},
				
				beforeSend : function(){
					$('#confCtrl-setSitesMute-modal #lodingImg').show();
				}
			});	
}
function setBroadcastContinuousPresence() {
	if (null != confId) {
		var isBroadcastCP = 0;
		$.ajax({
					type : "post",
					url : "<c:out value='${basePath}'/>/confCtrl/setBroadcastContinuousPresence.action",
					data:{
						'confId':confId,
						'isBroadcastCP':isBroadcastCP
					},
					dataType : "json",
					async : false,
					success : function(data) {
						if (data == 0) {
//							$.ligerDialog.success("<s:text name='setSuccess'/>","<s:text name='tip'/>");
							tab2_showAlert('success',"<s:text name='setSuccess'/>");
						} else {
							var msg = errorMsg +"  "+ data;
//							$.ligerDialog.error(msg,"<s:text name='tip'/>");
							tab2_showAlert('error', msg);
						}
					}
				});
	}
}
function setVideoSource() {
	var siteUri = $("#tab2 #videoSiteUri").val();
	var videoSourceUri = $("#tab2 #videoSourceUri").val();
	var isLock;
	if (null != confId) {
		var isBroadcast = 0;
		$.ajax({
					type : "get",
					cache:false,
					url : "<c:out value='${basePath}'/>/confCtrl/setVideoSource.action?confId="
							+ confId
							+ "&siteUri="
							+ siteUri
							+ "&videoSourceUri=" + videoSourceUri,
					dataType : "json",
					async : false,
					success : function(data) {
						if (data == 0) {
//							$.ligerDialog.success("<s:text name='setSuccess'/>","<s:text name='tip'/>");
							tab2_showAlert('success',"<s:text name='setSuccess'/>");
						} else {
							var msg = errorMsg +"  "+ data;
//							$.ligerDialog.error(msg,"<s:text name='tip'/>");
							tab2_showAlert('error',msg);
						}
					}
				});
	}
}

function setContinuousPresence() {
	var target = $("#tab2 #target").val();
	var mode = presenceMode.value;
	if (null != confId) {
		$.ajax({
					type : "get",
					cache:false,
					url : "<c:out value='${basePath}'/>/confCtrl/setContinuousPresence.action?confId="
							+ confId + "&target=" + target + "&mode=" + mode,
					dataType : "json",
					async : false,
					success : function(data) {
						if (data == 0) {
//							$.ligerDialog.success("<s:text name='setSuccess'/>","<s:text name='tip'/>");
							tab2_showAlert('success',"<s:text name='setSuccess'/>");
						} else {
							var msg = errorMsg +"  "+ data;
//							$.ligerDialog.error(msg,"<s:text name='tip'/>");
							tab2_showAlert('error',msg);
						}
					}
				});
	}
}
//window.onload = queryConfId;
//$(function(){
//	$("input:text").each(function(){
//		$(this).val("");
//	});
//});

function addMouseMoveListener_confCtrl(){
	 $("#tab2 #queryConfInfoBtn").mousemove(function(){
         $("#tab2 #codeMsgConfCtrl").show();
         $("#tab2 #codeMsgConfCtrl").html("TPSDKResponseEx< List<ConferenceStatusEx>> queryConferencesStatusEx (List<String> confIds)");
     });
     $("#tab2 #queryConfInfoBtn").mouseleave(function(){
         $("#tab2 #codeMsgConfCtrl").hide();
     });
     $("#tab2 #siteInConfNameBtn").mousemove(function(){
         $("#tab2 #codeMsgConfCtrl").show();
         $("#tab2 #codeMsgConfCtrl").html("Integer setBroadcastSiteEx (String confId, String siteUri, Integer isBroadcast)");
     });
     $("#tab2 #siteInConfNameBtn").mouseleave(function(){
         $("#tab2 #codeMsgConfCtrl").hide();
     });
     $("#tab2 #setSitesQuietBtn").mousemove(function(){
         $("#tab2 #codeMsgConfCtrl").show();
         $("#tab2 #codeMsgConfCtrl").html("Integer setSitesQuietEx(String confId, List<String> siteUris, Integer isQuiet)");
     });
     $("#tab2 #setSitesQuietBtn").mouseleave(function(){
         $("#tab2 #codeMsgConfCtrl").hide();
     });
     $("#tab2 #setSitesMuteBtn").mousemove(function(){
         $("#tab2 #codeMsgConfCtrl").show();
         $("#tab2 #codeMsgConfCtrl").html("Integer setSitesMuteEx(String confId, List<String> siteUris, Integer isMute) ");
     });
     $("#tab2 #setSitesMuteBtn").mouseleave(function(){
         $("#tab2 #codeMsgConfCtrl").hide();
     });
     $("#tab2 #setBroadcastCPBtn").mousemove(function(){
         $("#tab2 #codeMsgConfCtrl").show();
         $("#tab2 #codeMsgConfCtrl").html("Integer setBroadcastContinuousPresenceEx (String confId, Integer isBroadcast)");
     });
     $("#tab2 #setBroadcastCPBtn").mouseleave(function(){
         $("#tab2 #codeMsgConfCtrl").hide();
     });
     $("#tab2 #setVideoSourceBtn").mousemove(function(){
         $("#tab2 #codeMsgConfCtrl").show();
         $("#tab2 #codeMsgConfCtrl").html("Integer setVideoSourceEx (String confId, String siteUri, String videoSourceUri, Integer isLock)");
     });
     $("#tab2 #setVideoSourceBtn").mouseleave(function(){
         $("#tab2 #codeMsgConfCtrl").hide();
     });
}

function tab2_showAlert(type,msg){
	dismissAlert2();
	
	if('warning' == type){
		$('#tab2_warning_alert').find('#content').html(msg);
		$('#tab2_warning_alert').show();
	}else if('success' == type){
		$('#tab2_success_alert').find('#content').html(msg);
		$('#tab2_success_alert').show();
	}else if("error" == type){
		$('#tab2_error_alert').find('#content').html(msg);
		$('#tab2_error_alert').show();
	}else{
		
	}
}
function dismissAlert2(){
	$('#tab2_alert_content .alert').hide();
}