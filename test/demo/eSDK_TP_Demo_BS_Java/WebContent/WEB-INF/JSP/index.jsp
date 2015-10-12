<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE>
<html >
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>eSDK TP DEMO</title>
<%@ include file="common/common.jsp"%> 

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<script type="text/javascript" src="<c:out value="${basePath}" />/lib/jquery/jquery-1.8.3.js"></script>

<link rel="stylesheet" href="<c:out value="${basePath}" />/css/index.css" ></link>
<link rel="stylesheet" href="<c:out value="${basePath}" />/js/table/dataTable.css" media="screen"></link>

<!-- 
<link href="<c:out value="${basePath}" />/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
<link href="<c:out value="${basePath}" />/lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />



<script src="<c:out value="${basePath}" />/lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
<script src="<c:out value="${basePath}" />/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="<c:out value="${basePath}" />/lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
<script src="<c:out value="${basePath}" />/lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="<c:out value="${basePath}" />/lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
 -->

<link href="<c:out value="${basePath}" />/lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="<c:out value="${basePath}" />/lib/bootstrap/css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
<link href="<c:out value="${basePath}" />/lib/bootstrap/css/datetimepicker.css" rel="stylesheet" type="text/css" />

<script src="<c:out value="${basePath}" />/lib/bootstrap/js/bootstrap.js" type="text/javascript"></script> 
<script src="<c:out value="${basePath}" />/lib/bootstrap/js/bootstrap-datetimepicker.js" type="text/javascript"></script> 
<script src="<c:out value="${basePath}" />/lib/bootstrap/js/bootstrap-datetimepicker.fr.js" type="text/javascript"></script> 

<script type="text/javascript" src="<c:out value="${basePath}" />/js/scheduleConf/scheduleConf.js"></script>
<script type="text/javascript" src="<c:out value="${basePath}" />/js/time/jquery-calendar.js"></script>
<link rel="stylesheet" type="text/css" href="<c:out value="${basePath}" />/js/time/jquery-calendar.css"></link>
<link rel="stylesheet" type="text/css" href="<c:out value="${basePath}" />/js/time/styles.css"></link>

<script>
	 <%@ include file="/js/scheduleConf/scheduleConf.js"  %>
</script>
<script>
	 <%@ include file="/js/scheduleConf/newConf.js"  %>
</script>
<script>
	 <%@ include file="/js/confCtrl/confCtrl.js"  %>
</script>
<script>
	 <%@ include file="/js/siteCtrl/siteCtrl.js"  %>
</script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#main_frame_tab a").click(function(e){
			e.preventDefault();
			$(this).tab("show");
		});
		
		
		initScheduleConfPage();
	    addMouseMoveListener_scheduleConf();
	    
		initNewConfPage();
		
		addMouseMoveListener_confCtrl();
		
		initSiteCtrlPage();
		addMouseMoveListener_siteCtrl();
	    //   $.ligerDefaults.DialogString = {
         //          yes: '<s:text name="yes"/>',
         //          no: '<s:text name="no"/>',
          //         ok: '<s:text name="confirm"/>'
       //        };
		//设置table中偶数行和奇数行的颜色
	//	$("table tr:even").attr("class", "even_row"); // 偶数行颜色
	//	$("table tr:odd").attr("class", "odd_row"); // 奇数行颜色
		// $("table tr:first-child").attr("class", "");
	//	var tabValue = $("#tabValue").val();

			//Default Action
	//		$(".tab_content").hide(); //Hide all content	
	//		$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	//		$(".tab_content:first").show(); //Show first tab content

		//On Click Event
	//	$("ul.tabs li").click(function() {
	//		$("ul.tabs li").removeClass("active"); //Remove any "active" class
	//		$(this).addClass("active"); //Add "active" class to selected tab
	//		$(".tab_content").hide(); //Hide all tab content
	//		var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
	//		$(activeTab).fadeIn(); //Fade in the active content
	//		return false;
	//	});
	});
	function logout(){

		    $.ajax({
		        type : "get",
		        cache:false,
		        url : "<c:out value='${basePath}'/>/user/logout.action",
		        dataType : "json",
		        async : false,
		        success : function(data) {

		        }
		    });
		    
		    window.location.href = "<c:out value="${basePath}"/>/login.jsp";
	}
	function queryConfId(){
		  $("#selectId").empty();
		    $.ajax({
		        type : "get",
		        cache:false,
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
            $("#confName").val("");
            $("#status").val("");
            $("#speaking").val("");
            $("#chair").val("");
            $("#broadcast").val("");
            $("#siteTable tr").eq(0).nextAll().remove();
            $("#startTime").val("");
            $("#span").val("");
            $("#siteInConfName").val("");
            $("#siteConfstatus").val("");
            $("#videoSiteUri").val("");
	}
	var flag = false;
	function querySitesInfo(){
		if(flag)
		{
			return;
		}
		jQuery.ajax({
            url : "siteCtrl!querySites.action",
            type : 'post',
            dataType : 'text',
            async : true,
            data : {
            },
            success : function(data) {
            	flag = true;
                var dataObj=eval("("+data+")");
                var table1 = $("#siteCtrlTable");
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
	}
</script>
</head>
<body style="background: gainsboro;">

	<div class="container" style="width: 1000px;background: white;padding: 0 15px 0 15px;margin-top: 0;margin-bottom: 0;">

<header class="jumbotron subhead" id="overview">
	<center>
		<h1>eSDK TP DEMO</h1>
	</center>
</header>


	
	
	<div class="row">



		  <div class="span10" style="width:1000px;">
			
				<div style="float:right;clear:both;">
					<span><s:text name="welcome"/></span> 
					<span id="loginUserName" ><s:property value="#session.loginUser"/></span>
					<span style="margin: 0 10px 0 10px;"> | </span>
					<a  style="margin: 20px 20px 0 0px;cursor: pointer;font-weight: bold;" 
					data-toggle="modal" data-target="#logout-modal"><s:text name="logout"/></a>
				</div>
	
				<ul id="main_frame_tab" class="nav nav-tabs">
				
				    <li class="active"><a style="font-size: 1.2em;" href="#tab1"><s:text name="confMgr"/></a>
					</li>
					<li onclick="queryConfId();"><a style="font-size: 1.2em;" href="#tab2"><s:text name="confCtrl"/></a>
					</li>
					<li onclick="querySitesInfo();"><a style="font-size: 1.2em;" href="#tab3"><s:text name="siteCtrl"/></a>
					</li>
				</ul>
				
				<div class="tab-content">
				
				   <div id="tab1" class="tab-pane active">

						 <%@include file="scheduleConf.jsp"%> 
					</div>
					
					<div id="tab2" class="tab-pane">
	
						<%@include file="confCtrl.jsp"%> 
					</div>

					<div id="tab3" class="tab-pane">

					     <%@include file="siteCtrl.jsp"%> 
					</div>
					
				</div>
				
			</div>
	</div>
<footer>
	<center> <p> <a href="http://enterprise.huawei.com"> enterprise.huawei.com</a> <s:text name="indexTip1"/> © <s:text name="indexTip2"/></p></center>
</footer>
</div>

<div id="logout-modal" class="modal" style="display: none; top:300px; width:350px;margin-left: -170px;">

	<div class="modal-header">
		<button class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3><s:text name="tip"/></h3>
	</div>
	
	<div class="modal-body">
			
		<p><s:text name="logoutMsg"/></p>
		
	</div>
	
	<div class="modal-footer">
		<button id="logout-yes-btn" href="#" onclick="logout()" class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="confirm" /></button>
		<button href="#" class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="cancel" /></button>
	</div>
</div>

</body>
</html>


