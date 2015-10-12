	 
	  <div id="tab3_alert_content" style="padding: 0;margin: 0;width: 99%;">
		<div id="tab3_success_alert" class="alert alert-success" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am a success alert</span></div>
		<div id="tab3_error_alert" class="alert alert-error" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am an error alert</span></div>
		<div id="tab3_warning_alert"  class="alert alert-warning" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am a warning alert</span></div>
	  </div>
		  <script type="text/javascript">
		  	$('#tab3_alert_content .close').click(function(){
		  		$(this).parent().hide();
		  	})
		  </script>


<form action="siteCtrl!siteCtrl.action" method="post">

		<br/>
		


<div class="panel_header"><h3><s:text name="siteList"/></h3></div>
<div class="panel" >

	<div style="float: right;margin-top: -20px; margin-bottom: 5px;"  >
	       <input type="button" class = "btn" value="<s:text name="refresh"/>" style="width:100px;  margin-bottom: 3px;" onclick="querySitesInfoRefresh();"/>
	</div>

	<div style="overflow-y:scroll; height:302px; width:100%;">
		<table width="98%" border="1" cellspacing="0" cellpadding="0"
			class="dataTable" id="siteCtrlTable">
			<thead>
				<tr>
					<th width="25%" class="dataTableHeader"><s:text name='siteUri'/></th>
					<th width="25%" class="dataTableHeader"><s:text name='siteName'/></th>
					<th width="25%" class="dataTableHeader"><s:text name='siteType'/></th>
					<th width="25%" class="dataTableHeader"><s:text name='siteStatus'/></th>
				</tr>
			</thead>
			<tbody id="siteinfo">
			</tbody>
		</table>
	</div>
</div>
	
		<br/>
		
		
		<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr valign="top">
		<td width="33%" align="left">
				<div class="panel_header"><h3><s:text name="siteRealtimeVideo"/></h3></div>
				<div class="panel" style="width:90%">
						<div style="height:310px; width:90%">
							<div style="width: 80%;height: 80%;" >
								<div id="siteVideo">
							       <img id="videoImg" src="" style="border:none">
								</div>
							</div>
						</div>
				</div>
		</td>
		<td width="33%" align="left">
				<div class="panel_header"><h3><s:text name="cameraCtrl"/></h3></div>
				<div class="panel"  style="width:90%">
																<div style="height:310px; width:90%">
															<br><br>
										   	  <table border="0" cellpadding="3" cellspacing="0"   id="cameraCtrl">
													<tr style="margin-bottom: 5px;">
														<td />
														<td align="center"><input type="button"
															value="<s:text name='moveUp'/>" id="upButton" name="upButton"
															class="btn" style="width:90px;min-width: 50px;"></input></td>
														<td />
													</tr>
													<tr><td>&nbsp;</td></tr>
													<tr style="margin-bottom: 5px;">
														<td><input type="button" value="<s:text name='moveLeft'/>"
															id="leftButton" name="leftButton" class="btn" style="width:90px;min-width: 50px;"></input></td>
														<td align="center"><input type="button"
															value="<s:text name='retrive'/>" id="retriveButton"
															name="retriveButton" class="btn" style="width:90px;min-width: 50px;"></input></td>
														<td><input type="button" value="<s:text name='moveRight'/>"
															id="rightButton" name="rightButton" class="btn" style="width:90px;min-width: 50px;"></input></td>
													</tr>
													<tr><td>&nbsp;</td></tr>
													<tr>
														<td />
														<td align="center" ><input type="button" value="<s:text name='moveDown'/>"
															id="downButton" name="downButton" class="btn" style="width:90px;min-width: 50px;"></input></td>
														<td />
													</tr>
											</table>
										</div>
				</div>
		</td>
		<td width="33%" align="left">
				<div class="panel_header"><h3><s:text name="siteInfo"/></h3></div>
				<div class="panel"  style="width:90%">
													<div style="height:310px; width:90%">

														<div  class="top"id="isConnectAuxCB">
															  <input type="checkbox" name="isConnectAuxCB" disabled="disabled" ></input> 
															  <s:text name='isConnectAux'/>
														</div>
														<div  class="top" id="isSendingAuxCB">
															  <input type="checkbox" name="isSendingAuxCB" disabled="disabled"></input> 
															  <s:text name='isSendingAux'/>
														</div>
														<div  class="top">
																<s:text name='mainAuxSrc'/>:
																<select name="auxSrcList" id="auxSrcList" ></select>
														</div>
													</div>				
				</div>		
		</td>
		</tr>
		</table>
		
		<div id="codeMsgSiteCtrl" style="border: 1px solid #CCC;float: right;height: 100px;margin-top: -150px;margin-right: 50px;width: 520px;display: none;"></div> 
</form>

		
	<script type="text/javascript">
	    <%@ include file="/js/siteCtrl/siteCtrl.js" %>
	    $(document).ready(function() {
	           $("#siteCtrlTable").mousemove(function(){
	                  $("#codeMsgSiteCtrl").show();
	                  $("#codeMsgSiteCtrl").html("TPSDKResponseEx<List<SiteInfoEx>> querySitesEx ()");
	              });
	              $("#siteCtrlTable").mouseleave(function(){
	                  $("#codeMsgSiteCtrl").hide();
	              });
	           $("#cameraCtrl").mousemove(function(){
	                  $("#codeMsgSiteCtrl").show();
	                  $("#codeMsgSiteCtrl").html("Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl)");
	              });
	              $("#cameraCtrl").mouseleave(function(){
	                  $("#codeMsgSiteCtrl").hide();
	              });
	           $("#isConnectAuxCB").mousemove(function(){
	                  $("#codeMsgSiteCtrl").show();
	                  $("#codeMsgSiteCtrl").html("TPSDKResponseEx< Integer > isConnectAuxSourceEx (String siteURI)");
	              });
	              $("#isConnectAuxCB").mouseleave(function(){
	                  $("#codeMsgSiteCtrl").hide();
	              });
	           $("#isSendingAuxCB").mousemove(function(){
	                  $("#codeMsgSiteCtrl").show();
	                  $("#codeMsgSiteCtrl").html("TPSDKResponseEx< Integer > isSendAuxStreamEx (String siteURI)");
	              });
	              $("#isSendingAuxCB").mouseleave(function(){
	                  $("#codeMsgSiteCtrl").hide();
	              });
	           $("#auxSrcList").mousemove(function(){
	                  $("#codeMsgSiteCtrl").show();
	                  $("#codeMsgSiteCtrl").html("TPSDKResponseEx< Map<Integer，String>> queryMainStreamSourcesEx (String siteUri)");
	              });
	              $("#auxSrcList").mouseleave(function(){
	                  $("#codeMsgSiteCtrl").hide();
	              });
	    	
	    	
	    });
	</script>
	
	<style>
		.click{ background-color: grey;}
	    .left {
	            float: left;
	     }
	      .clear {
	            clear: both;
	            height: 0;
	            overflow: hidden;
	        }
	    #siteVideo{
	        height: 300px;
            width: 300px;
	        BORDER-RIGHT: #7b9ebd 1px solid;
	        BORDER-TOP: #7b9ebd 1px solid;
	        BORDER-LEFT: #7b9ebd 1px solid;
	        CURSOR: pointer;
	        COLOR: black;
	        BORDER-BOTTOM: #7b9ebd 1px solid
	    }
	    .top{
	        margin-top: 3px;
	        margin-bottom: 20px;
	    }
	</style>

