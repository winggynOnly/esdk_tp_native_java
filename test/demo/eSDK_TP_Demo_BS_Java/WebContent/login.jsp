<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8"/>
    <%@ include file="WEB-INF/JSP/common/common.jsp"%> 
    <title>SDK <s:text name="manageSystem"/>（TP）</title>
    <link href="<c:out value='${basePath}'/>/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    
    <link href="<c:out value='${basePath}'/>/lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
			var contextPath = '<c:out value="${basePath}"/>';
			var groupicon = contextPath+"/lib/ligerUI/skins/icons/communication.gif";
	</script>
    <script src="<c:out value="${basePath}" />/lib/jquery/jquery-1.8.3.js" type="text/javascript" ></script>
    <script src="<c:out value='${basePath}'/>/lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
    <script src="<c:out value='${basePath}'/>/lib/jquery-validation/jquery.validate.js" type="text/javascript"></script> 
    <script src="<c:out value='${basePath}'/>/lib/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
    <script src="<c:out value='${basePath}'/>/lib/jquery-validation/messages_cn.js" type="text/javascript"></script>

        
        <script type="text/javascript">
     
            var tab = null;
            var accordion = null;
            var tree = null;
            var changePassWindow = null;
            var mainform;
            $(function ()
            {
                $.ligerDefaults.DialogString = {
                           yes: '<s:text name="yes"/>',
                           no: '<s:text name="no"/>',
                           ok: '<s:text name="confirm"/>'
                 };
                //布局
                $("#layout1").ligerLayout({ leftWidth: 190, height: '100%',heightDiff:-34,space:4, onHeightChanged: f_heightChanged });

                var height = $(".l-layout-center").height();


                $("#pageloading").hide();

            });
            
            function f_heightChanged(options)
            {
                if (tab)
                    tab.addHeight(options.diff);
                if (accordion && options.middleHeight - 24 > 0)
                    accordion.setHeight(options.middleHeight - 24);
            }
            
            function valiLogin()
            {
            	if(document.getElementById("userName").value==""){
                    $.ligerDialog.error('<s:text name="userNameErrorMsg"/>',"<s:text name='tip'/>");
					document.getElementById("userName").focus();
					return false;
				}else if(document.getElementById("password").value==""){
				    $.ligerDialog.error('<s:text name="userNameErrorMsg"/>',"<s:text name='tip'/>");
				    document.getElementById("password").focus();
				    return false;
				}else {
					var url ="<c:out value='${basePath}'/>/user/login.action?language=" + $("#language").val();
					$("#form1").attr("action",url);
					return true;
				}
            }
            function changeLanguage(obj)
            {
            	window.location.href="<c:out value='${basePath}'/>/user/changeLanguage.action?language="+obj.value;
            }
            
            function setLanguageSelect(){
            	var url = window.location.href;
            	if(url.indexOf("language") > 1)
            	{
            		var language = url.split("=")[1];
            		if(language == "zh_CN")
            		{
            			  $("#language").find("option").eq(0).attr("selected","selected");
            		}
            		else
            		{
            			  $("#language").find("option").eq(1).attr("selected","selected");
            		}
            	}
            	else
            	{
            		if(navigator.userLanguage == "zh-cn")
            		{
            			 $("#language").find("option").eq(0).attr("selected","selected");
            		}
            		else if( undefined == navigator.userLanguage )
            		{
            			if(navigator.language == "zh-CN" ||  navigator.browserLanguage == "zh-cn")
                        {
                            $("#language").find("option").eq(0).attr("selected","selected");
                        }
                        else
                        {
                              $("#language").find("option").eq(1).attr("selected","selected");
                        }
            		}
            		else
            		{
            			  $("#language").find("option").eq(1).attr("selected","selected");
            		}
            	}
            }
            window.onload=setLanguageSelect;
     </script> 
     

<style type="text/css"> 
    body,html{height:100%;}
    body{ padding:0px; margin:0;   overflow:hidden;}  
    .l-link{ display:block; height:26px; line-height:26px; padding-left:10px; text-decoration:underline; color:#333;}
    .l-link2{text-decoration:underline; color:white; margin-left:2px;margin-right:2px;}
    .l-layout-top{background:#102A49; color:White;}
    .l-layout-bottom{ background:#E5EDEF; text-align:center;}
    #pageloading{position:absolute; left:0px; top:0px; background:white  no-repeat center; width:100%; height:100%;z-index:99999;}
    .l-link{ display:block; line-height:22px; height:22px; padding-left:16px;border:1px solid white; margin:4px;}
    .l-link-over{ background:#FFEEAC; border:1px solid #DB9F00;} 
    .l-winbar{ background:#2B5A76; height:30px; position:absolute; left:0px; bottom:0px; width:100%; z-index:99999;}
    .space{ color:#E7E7E7;}
    /* 顶部 */ 
    
    .login{
    	position:relative;
		overflow:hidden;
		margin:auto;/*重要,IE兼容模式*/
		height:250px;
		width:400px;
		top:70%;
		left:50%;
		margin-top:-285px;
		margin-left:-250px;
		border:#ebebeb 3px solid;
    }

 </style>
</head>
<body style="padding:0px;background:#EAEEF5;">  
<div id="pageloading"></div>  
<div id="topmenu" class="l-topmenu">
    <div class="l-topmenu-logo">TP_Demo</div>
    <div class="l-topmenu-welcome" style="color:white">
    </div> 
</div>
  <div id="layout1" style="width:99.2%; margin:0 auto; margin-top:4px; "> 
       
        <div position="center" id="framecenter"> 
        	<div class="login">
        		<form method="post" id="form1" class="l-form" name="form1"  action="" onsubmit="return valiLogin()">
        			<div class="l-group l-group-hasicon">
        				<img  src="<c:out value='${basePath}'/>/lib/ligerUI/skins/icons/communication.gif" />
        				<span><s:text name="loginPlatform"/></span>
        			</div>
        			<ul>
        				<li style="text-align :right;width:90px;"><s:text name="username"/>:</li>
        				<li style="width:20px;"></li>
        				<li style="text-align :left;width:170px;">
        					<div class="l-text" style="width:168px;">
        						<input name="loginParam.userName" class="l-text-field" id="userName" style="width:164px;" type="text"  value="user1"/>
        						<div class="l-text-l"></div>
        						<div class="l-text-r"></div>
        					</div>
        				</li>
        				<li style="width:40px;"></li>
        			</ul>
        			<ul>
        				<li style="text-align :right;width:90px;"><s:text name="password"/>:</li>
        				<li style="width:20px;"></li>
        				<li style="text-align :left;width:170px;">
        					<div class="l-text" style="width:168px;">
        						<input name="loginParam.password" class="l-text-field" id="password" style="width:164px;" type="password"  value="AAAaaa111" />
        						<div class="l-text-l"></div>
        						<div class="l-text-r"></div>
        					</div>
        				</li>
        				<li style="width:40px;"></li>
        			</ul>
        			 <ul>
                        <li style="text-align :right;width:90px;"><s:text name="language"/>:</li>
                        <li style="width:20px;"></li>
                        <li style="text-align :left;width:170px;">
                            <div class="l-text" style="width:168px;">
                                <select id="language"  onchange="changeLanguage(this)"  style="width: 100%">
                                       <option value="zh_CN"><s:text name="cn"/></option>
                                       <option value="en_US"><s:text name="en"/></option>
                                </select>
                                <div class="l-text-l"></div>
                                <div class="l-text-r"></div>
                            </div>
                        </li>
                        <li style="width:40px;"></li>
                    </ul>
        			<ul>
        				<li style="text-align:center;width:320px;">
        					<input name="search" class="l-button-button" type="submit" value="<s:text name="login"/>" />
        					<input name="reset" class="l-button-button" type="reset" value="<s:text name="reset"/>" />
        				</li>
        			</ul>
        			<ul>
        				<li style="text-align:center;width:320px;">
        				</li>
        			</ul>
        		</form>
        	</div>
        </div> 
        
    </div>
    <div  style="height:32px; line-height:32px; text-align:center;">
    </div>
    <div style="display:none"></div>
</body>
</html>
