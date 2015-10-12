var recurrence;
function initNewConfPage() {
	

	   function isDigit(s) 
	    { 
	        var patrn=/^[0-9]+$/; 
	        if (!patrn.exec(s))
	        {
	            return false ;
	        }
	        return true ;
	    }
//    $("#confMgr-new-conf-modal #beginTime,#endDate").calendar();
	var errorMsg = '<s:text name="errorMsg"/>';
//    $.ligerDefaults.DialogString = {
//            yes: '<s:text name="yes"/>',
//            no: '<s:text name="no"/>',
//            ok: '<s:text name="confirm"/>'
//   };
    var tipNumMsg = '<s:text name="tipNumMsg"/>';
    var tipNullMsg = '<s:text name="tipNullMsg"/>';
	

    var recurrenceChoose = $("#confMgr-new-conf-modal #recurrenceChoose").val();
    if( undefined != recurrenceChoose  ||  null != recurrenceChoose){
    	$("#confMgr-new-conf-modal #isRecurrence").attr("checked","checked");
    }
	$("#confMgr-new-conf-modal #newConfButton_newConf").click(function() {
		
//		alert($('#dtp_input1').val());
		
        if($("#confMgr-new-conf-modal #dtp_input1").val() != "" )
        {
//             if(!isDigit( $("#confMgr-new-conf-modal #dtp_input1").val() ) )
//             {
////                parent.$.ligerDialog.error(tipNumMsg,"<s:text name='tip'/>");
//             	tab1_newConf_showAlert('warning',tipNumMsg);
//                return;
//             }
        }
        else
        {
//        	 parent.$.ligerDialog.error(tipNullMsg,"<s:text name='tip'/>");
        	tab1_newConf_showAlert('warning',tipNullMsg);
             return;
        }
        if($("#confMgr-new-conf-modal #rate").val()!= "" )
        {
             if(!isDigit($("#confMgr-new-conf-modal #rate").val()) )
             {
//                parent.$.ligerDialog.error(tipNumMsg,"<s:text name='tip'/>");
            	 tab1_newConf_showAlert('warning',tipNumMsg);
                return;
             }
        }
        else
        {
//        	 parent.$.ligerDialog.error(tipNullMsg,"<s:text name='tip'/>");
        	tab1_newConf_showAlert('warning',tipNullMsg);
             return;
        }
		//		var siteUris="01010010,01010086";
		//获取stateTable中的siteUris的信息 
		var siteUris ="";
		$('#stateTable tr').each(function(){
			siteUris += $(this).find('td').eq(1).find('label').text();
			});
		var isRecurrence = $("#confMgr-new-conf-modal #isRecurrence").attr("checked");
		var cpResouce =  $("#confMgr-new-conf-modal #cpMode option:selected").attr("id");
		
		if(isRecurrence == "checked"){
			if($("#confMgr-new-conf-modal #interval").val() != "" )
			{
			     if(!isDigit( $("#confMgr-new-conf-modal #interval").val()) )
			   	 {
//			        parent.$.ligerDialog.error(tipNumMsg,"<s:text name='tip'/>");
			    	tab1_newConf_showAlert('warning',tipNumMsg);
			    	return;
			   	 }
			}
			if($("#confMgr-new-conf-modal #count").val() != "" )
	        {
	                 if(!isDigit( $("#confMgr-new-conf-modal #count").val() ) )
	                 {
//	                    parent.$.ligerDialog.error(tipNumMsg,"<s:text name='tip'/>");
	                	 tab1_newConf_showAlert('warning',tipNumMsg);
	                    return;
	                 }
	         }
		    if($("#confMgr-new-conf-modal #monthDay").val() != "" )
	        {
	                 if(!isDigit( $("#confMgr-new-conf-modal #monthDay").val() ) )
	                 {
//	                	parent.$.ligerDialog.error(tipNumMsg,"<s:text name='tip'/>");
	                	 tab1_newConf_showAlert('warning',tipNumMsg);
	                    return;
	                 }
	        }
		//周期会议
		recurrence ={confId : $("#confMgr-new-conf-modal #confId").val(),
                name : $("#confMgr-new-conf-modal #confName").val(),
                beginTime : $("#confMgr-new-conf-modal #dtp_input1").val(),
                duration : $("#confMgr-new-conf-modal #duration1").val(),
                rate : $("#confMgr-new-conf-modal #rate").val(),
                siteUris : siteUris,
                frequency:$("#confMgr-new-conf-modal #frequency").val(),
                interval : $("#confMgr-new-conf-modal #interval").val(),
                weekDay : $("#confMgr-new-conf-modal #weekDay").val(),
                monthDay : $("#confMgr-new-conf-modal #monthDay").val(),
                count : $("#confMgr-new-conf-modal #count").val(),
                endDate : $("#confMgr-new-conf-modal #dtp_input2").val(),
                isRecurrence : isRecurrence};
			jQuery.ajax({
				url : basePath+'/confMgr/confMgr!scheduleRecurrenceConference.action',
				type : 'post',
				dataType : 'text',
				data : {
					confId : $("#confMgr-new-conf-modal #confId").val(),
					name : $("#confMgr-new-conf-modal #confName").val(),
					beginTime : $("#confMgr-new-conf-modal #dtp_input1").val(),
					duration : $("#confMgr-new-conf-modal #duration1").val(),
					rate : $("#confMgr-new-conf-modal #rate").val()+"k",
					siteUris : siteUris,
					frequency:$("#confMgr-new-conf-modal #frequency").val(),
					interval : $("#confMgr-new-conf-modal #interval").val(),
					weekDay : $("#confMgr-new-conf-modal #weekDay").val(),
					monthDay : $("#confMgr-new-conf-modal #monthDay").val(),
					count : $("#confMgr-new-conf-modal #count").val(),
					endDate : $("#confMgr-new-conf-modal #dtp_input2").val(),
					cpResouce : cpResouce,
					isRecurrence : isRecurrence
				},
				success : function(data) {
//					alert("schedule conf success");
					$('#newConf_lodingImg').hide();
					if(!isNaN(data) && 0 != data)
					{
			             var msg = errorMsg +"  "+ data;
//			             parent.$.ligerDialog.error(msg,"<s:text name='tip'/>");
			             tab1_newConf_showAlert('error',msg);
						return;
					}
					if("" != $("#confMgr-new-conf-modal #confId").val())
					{
						setConfInfo(data,true);
//						parent.$.ligerDialog.success("<s:text name='modifySuccess' />","<s:text name='tip'/>",function(){
//							  parent.$.ligerDialog.close(); 
//							  parent.location.reload();
//						  });
						tab1_showAlert('success',"<s:text name='modifySuccess' />");
						$('#confMgr-new-conf-modal').modal('hide');
					}
					else
					{
						 setConfInfo(data,false);
//						 parent.$.ligerDialog.success("<s:text name='scheduleSuccess' />","<s:text name='tip'/>",function(){
//			            	   parent.$.ligerDialog.close(); 
//			            	   parent.location.reload();
//			               });
							tab1_showAlert('success',"<s:text name='scheduleSuccess' />");
							$('#confMgr-new-conf-modal').modal('hide');
					}
				},
				beforeSend : function(){
					$('#newConf_lodingImg').show();
				}
			});
		
		
		}else{
		//根据部门id，查询部门人员的详细信息
			jQuery.ajax({
						url : basePath+'/confMgr/confMgr!scheduleConf.action',
						type : 'post',
						dataType : 'text',
						data : {
							confId : $("#confMgr-new-conf-modal #confId").val(),
							name : $("#confMgr-new-conf-modal #confName").val(),
							beginTime : $("#confMgr-new-conf-modal #dtp_input1").val(),
							duration : $("#confMgr-new-conf-modal #duration1").val(),
							rate : $("#confMgr-new-conf-modal #rate").val()+"k",
							cpResouce : cpResouce,
							siteUris : siteUris
						},
						success : function(data) {
//							alert("schedule conf success");
							$('#newConf_lodingImg').hide();
							if(!isNaN(data) && 0 != data)
							{
								  var msg = errorMsg +"  "+ data;
//								  parent.$.ligerDialog.error(msg,"<s:text name='tip'/>");
								  tab1_newConf_showAlert('error',msg);
								  return;
							}
							
							
							if("" != $("#confMgr-new-conf-modal #confId").val())
		                    {
								  setConfInfo(data,true);
//								  parent.$.ligerDialog.success("<s:text name='modifySuccess' />","<s:text name='tip'/>",function(){
//									  parent.$.ligerDialog.close(); 
//									  parent.location.reload();
//								  });
									tab1_showAlert('success',"<s:text name='modifySuccess' />");
									$('#confMgr-new-conf-modal').modal('hide');
		                    }
		                    else
		                    {
		                        setConfInfo(data,false);
//		                        parent.$.ligerDialog.success("<s:text name='scheduleSuccess' />","<s:text name='tip'/>",function (){
//		                            parent.$.ligerDialog.close();   
//		                            parent.location.reload();
//		                        });
								tab1_showAlert('success',"<s:text name='scheduleSuccess' />");
								$('#confMgr-new-conf-modal').modal('hide');
		                    }
						},
						beforeSend : function(){
							$('#newConf_lodingImg').show();
						}
					});
			}
	});
	
	
	//增加匿名会场
	$("#confMgr-new-conf-modal #addDynamicSiteButton_newConf").click(function(){
		var table = $("#confMgr-new-conf-modal #stateTable");
		var row = "<tr><td width=5%><input type='checkbox' name='count' >"
		+ "<td><label id='siteUri' name='siteUri'>" +"<s:text name='anonymous'/>"
		+ "</label></td>"
		+ "<td><label id='siteName' name='siteName'>"
		+ "</label></td>"
		+ "<td><label id='siteType' name='siteType'>"
		+ "</label></td>"
		+ "</tr>";
		table.append(row);
		
	});
	
	//删除会场
	$("#confMgr-new-conf-modal #delSiteButton_newConf").click(function(){
		var table = $("#confMgr-new-conf-modal #stateTable");
		$("#confMgr-new-conf-modal input[type='checkbox'][name='count']").each(function(){
		if($(this).attr("checked")=="checked") //注意：此处判断不能用$(this).attr("checked")==‘true'来判断。 
		{
		$(this).parent().parent().remove(); 
		} 
		}); 
		
	    var tabelbody = $("#confMgr-new-conf-modal #stateTable").find('tbody');
	    tabelbody.find('tr').attr('class','');
	    tabelbody.find('tr:odd').addClass('even_row');
	    tabelbody.find('tr:even').addClass('odd_row');
	    tabelbody.find('tr').hover(function(){
			$(this).addClass('hover_row');
		},function(){
			$(this).removeClass('hover_row');
		});
	});
	
	//点击增加会场，弹出页面
//	alert($("#confMgr-new-conf-modal #addSiteButton_newConf").size());
//	$("#confMgr-new-conf-modal #addSiteButton_newConf").click(function(){
//		alert("addSiteButton");
//		  $.ligerDialog.open({
//			  url: basePath+'/confMgr/jumpSiteInfo.action',
//			  height: 419, width: 485, modal:false,title:"<s:text name='addSite'/>"
//	  });
//	});
	
//		$("#confMgr-new-conf-modal #isRecurrenceDiv").hide();
//		$("#confMgr-new-conf-modal #recurrence").toggle(function(){
//	        $("#confMgr-new-conf-modal #isRecurrenceDiv").show();
//		},function(){
//	        $("#confMgr-new-conf-modal #isRecurrenceDiv").hide();
//		});
	
	}
function setSiteInfo_newConf(siteList){
//	$("#confMgr-new-conf-modal #duration").focus();

	var sites = {};
    var table1 = $("#confMgr-new-conf-modal #stateTable tbody");
    var trs = table1.find('tr');
    
    for(var i = 0 ; i< trs.size(); i++){
    	var siteDetail = trs.eq(i).find('td');
    	var siteUri = siteDetail.eq(1).find('label').text();

    		var site = {};
    		site.siteUri = siteUri;
    		site.siteName = siteDetail.eq(2).find('label').text();
    		site.siteType = siteDetail.eq(3).find('label').attr('data');

    		sites[siteUri] = site;

    }
    
    for(var i = 0; i < siteList.length; i++){
    	sites[siteList[i].siteUri] = siteList[i];
    }
    
    
    var tabelBodyHtml = "";
    for(var key in sites){
    	var item = sites[key];
		var row = "<tr><td width=5%><input type='checkbox' name='count'>"
			+ "<td><label id='siteUri' name='siteUri'>"
			+ item.siteUri
			+ "</label></td>"
			+ "<td><label id='siteName' name='siteName'>"
			+ item.siteName
			+ "</label></td>"
			+ "<td><label id='siteType' name='siteType' data="+item.siteType+">"
			+ siteTypeMap[item.siteType]
			+ "</label></td>"
			+ "</tr>";
		
		tabelBodyHtml += row;
    }
    
    
    table1.html(tabelBodyHtml);
    
    var tabelbody = $("#confMgr-new-conf-modal #stateTable").find('tbody');
    tabelbody.find('tr:odd').addClass('even_row');
    tabelbody.find('tr:even').addClass('odd_row');
    tabelbody.find('tr').hover(function(){
		$(this).addClass('hover_row');
	},function(){
		$(this).removeClass('hover_row');
	});

	
	var trs = tabelbody.find('tr');
	for(var i = 0 ; i < trs.size(); i++)
	{
		var tds = trs.eq(i).find('td');
		for(var j = 1 ; j<tds.size();j++ ){
			tds.eq(j).click(function(){
				$(this).parent().find('input[type="checkbox"]').click();
			});
		}
	}
    
    
//	$("#confMgr-new-conf-modal #duration").blur();
}
function setFrequency(val){
    if(val == 1)
    {
    	$("#confMgr-new-conf-modal #weekDay").removeAttr("disabled");
        $("#confMgr-new-conf-modal #monthDay").attr("disabled","disabled");
    }
    else if(val == 2)
    {
    	$("#confMgr-new-conf-modal #weekDay").attr("disabled","disabled");
    	$("#confMgr-new-conf-modal #monthDay").removeAttr("disabled");
    }
    else if(val == 0)
    {
    	   $("#confMgr-new-conf-modal #weekDay").attr("disabled","disabled");
           $("#confMgr-new-conf-modal #monthDay").attr("disabled","disabled");
    }
}

function switchModalType(){
	tab1_newConf_dismissAlert();
	
	$('#newConf_lodingImg').hide();
	
	$('#confMgr-new-conf-modal #newConfModal1').show();
	$('#confMgr-new-conf-modal #newConfModal2').hide();
	
	$('#confMgr-new-conf-modal #newConfButton_newConf').show();
	$('#confMgr-new-conf-modal #newConfButton_newConf1').hide();
	
	if(0 == isEditConf){
		$('#confMgr-new-conf-modal .inputElem').val('');
		$('#confMgr-new-conf-modal #stateTable').find('tbody').html('');
		$('#confMgr-new-conf-modal #rate').val('1920');
		var dateTime = $('#confMgr-new-conf-modal .form_datetime_newConf');
		for(var i =0 ; i <dateTime.size() ; i++){
			dateTime.eq(i).find('.add-on').eq(0).click();
		}
		$('#confMgr-new-conf-modal .form_datetime_newConf .add-on').eq(0).click();

		$('#confMgr-new-conf-modal .modal-header h3').html('<s:text name="scheduleConf"/>');
	}else{
		$('#confMgr-new-conf-modal .inputElem').val('');
		$('#confMgr-new-conf-modal #stateTable').find('tbody').html('');
		$('#confMgr-new-conf-modal #rate').val('1920');
		var dateTime = $('#confMgr-new-conf-modal .form_datetime_newConf');
		for(var i =0 ; i <dateTime.size() ; i++){
			dateTime.eq(i).find('.add-on').eq(0).click();
		}
		$('#confMgr-new-conf-modal #confId').val(editConf_id);
		$('#confMgr-new-conf-modal #confName').val(editConf_name);
		
		$('#confMgr-new-conf-modal .modal-header h3').html('<s:text name="modifyConf"/>');
		
	}
}

function tab1_newConf_showAlert(type,msg){
	tab1_newConf_dismissAlert();
	
	if('warning' == type){
		$('#tab1_newConf_warning_alert').find('#content').html(msg);
		$('#tab1_newConf_warning_alert').show();
	}else if('success' == type){
		$('#tab1_newConf_success_alert').find('#content').html(msg);
		$('#tab1_newConf_success_alert').show();
	}else if("error" == type){
		$('#tab1_newConf_error_alert').find('#content').html(msg);
		$('#tab1_newConf_error_alert').show();
	}else{
		
	}
}
function tab1_newConf_dismissAlert(){
	$('#tab1_newConf_alert_content .alert').hide();
}