
<style type="text/css">
        #tab2 #siteTable tr{
        	cursor: pointer;
        }
</style>

	  <div id="tab2_alert_content" style="padding: 0;margin: 0;width: 99%;">
		<div id="tab2_success_alert" class="alert alert-success" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am a success alert</span></div>
		<div id="tab2_error_alert" class="alert alert-error" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am an error alert</span></div>
		<div id="tab2_warning_alert"  class="alert alert-warning" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am a warning alert</span></div>
	  </div>
		  <script type="text/javascript">
		  	$('#tab2_alert_content .close').click(function(){
		  		$(this).parent().hide();
		  	})
		  </script>
		  
<br>
<div>
	<div class="left"><s:text name="confId"/>:</div>
	<div  style="margin-left: 10px;" class="left" >
		<select   id="selectId" style="width: 150px;" class="select">
		</select>
	</div>
	<div class="left"  style="margin-left: 20px;"><input id="queryConfInfoBtn" class="btn" type="button" value="<s:text name='queryConfInfo'/>"  onclick='queryConf();' ></div>
	<img id="confCtrl_lodingImg" src="${basePath}/lib/images/loading.gif" style="display:none;position: absolute;margin: -10px 0 0 400px;">
</div>

<div class="clear"></div>
<br>
<div class="panel_header"><h3><s:text name="confStatus"/></h3></div>
<div class="panel">
		<table class="dataTable" cellspacing="0" cellpadding="0" border="0" >
			<tr>
				<td  ><s:text name='confName'/>:</td>
				<td  ><input type="text"  id="confName"  value="" disabled="disabled"  class=" inputElem"/></td>
				<td    align="right"><s:text name='confStatus'/>:</td>
				<td   ><input type="text"  id="status" value="" disabled="disabled"  class=" inputElem"/></td>
				<td    align="center"><input type="checkbox" id="isLock" disabled="disabled"></td>
				<td   ><s:text name='confIsLock'/></td>
			</tr>
			  
			<tr>
				<td  ><s:text name='chairSite'/>:</td>
				<td   ><input type="text" value="" disabled="disabled"  id="chair" class=" inputElem"/></td>
				<td align="right"><s:text name='broadcastSite'/>:</td>
				<td  ><input type="text" value="" disabled="disabled"  id="broadcast" class=" inputElem"/></td>
				<td    align="center"><s:text name='speakingSite'/>:</td>
				<td  ><input type="text" value="" disabled="disabled" id="speaking" class=" inputElem"/></td>
			</tr>
			 
		     <tr>
		        <td    align="center"><input type="checkbox" id="isAudioSwitch" disabled="disabled"></td>
		        <td  ><s:text name='audioSwitch'/></td>
		        <td    align="right"><s:text name='swtichGate'/>:</td>
		        <td  ><input type="text" value="" disabled="disabled"  id="swtichGate" class=" inputElem"/></td>
		    </tr>
		</table>
</div>

<div class="panel_header"><h3><s:text name="confSiteInfo"/></h3></div>
<div class="panel" style="margin-top: 15px;">
        <div class="left" style="width:51%;height:200px;overflow:auto ;margin-right: 25px;" >
			<table style="width:100%" id="siteTable"  class="dataTable" cellspacing="0" cellpadding="0" border="0">
			    <tr>
			        <th width="31%"  class="dataTableHeader"><s:text name='siteUri'/></th>
			        <th  width="31%"  class="dataTableHeader"><s:text name='siteName'/></th>
			         <th width="38%"  class="dataTableHeader"><s:text name='siteType'/></th>
			    </tr>
			</table>
		</div>
		<div style="margin-left: 5px;">
			<fieldset>
			<table  class="dataTable" cellspacing="0" cellpadding="0" border="0">
			    <tr>
			        <td><s:text name='siteName'/>:</td>
			        <td><input id="siteInConfName" type="text" value=""  disabled="disabled" class=" inputElem"></td>
			        <td><input id="siteInConfNameBtn" style="margin-bottom: 10px;" class="btn" type="button"  value="<s:text name='broadcastSite'/>"
			     		data-toggle="modal" data-target="#confCtrl-setBroadcastSite-modal"></td>
			    </tr>

			    <tr>
			        <td><s:text name='startTime'/>:</td>
			        <td><input type="text" value=""  disabled="disabled" id="startTime" class=" inputElem"></td>
			        <td><input id="setSitesQuietBtn" style="margin-bottom: 10px;" class="btn" type="button"  value="<s:text name='quiet'/>"
						data-toggle="modal" data-target="#confCtrl-setSitesQuiet-modal"	></td>
			    </tr>

			      <tr>
	                <td><s:text name='confSpan'/>:</td>
	                <td><input type="text" value=""  disabled="disabled"  id="span" class=" inputElem" style="width:118px;"> <s:text name='minute'/></td>
	                <td><input id="setSitesMuteBtn" style="margin-bottom: 10px;" class="btn" type="button"  value="<s:text name='mute'/>" 
							data-toggle="modal" data-target="#confCtrl-setSitesMute-modal"></td>
	            </tr>

	              <tr>
	                <td><s:text name='siteStatus'/>:</td>
	                <td><input type="text" value=""  disabled="disabled" id="siteConfstatus" class=" inputElem"></td>
	                <td><input id="setBroadcastCPBtn" style="margin-bottom: 10px;" class="btn" type="button"  value="<s:text name='broadcastContinuousPresence'/>" onclick="setBroadcastContinuousPresence();"></td>
	            </tr>
			</table>
			</fieldset>
		</div>
</div>

<div class="panel_header"><h3><s:text name="specifySiteVideoSource"/></h3></div>
<div class="panel" style="margin-top: 15px;">
		<table style="margin-top: 5px; width:35%;" class="dataTable" >
		    <tr>
		        <td align="right"><s:text name='siteUri'/>:</td>
		        <td align="right"><input id="videoSiteUri" type="text" value=""  disabled="disabled" class=" inputElem"/></td>
		    </tr>

		    <tr>
		        <td align="right"><s:text name='videoSourceUri'/>:</td>
		        <td align="right"><input type="text" value=""  id="videoSourceUri"  class=" inputElem"/></td>
		    </tr>

		     <tr>
		        <td></td>
		        <td align="right"><input  class="btn" type="button"  value="<s:text name='setting'/>"  id="setVideoSourceBtn" onclick="setVideoSource();"  /></td>
		    </tr>
		</table>


		    <div id="codeMsgConfCtrl" class="left" style="border: 1px solid #CCCCCC;height: 120px;width:58%; margin-top: 5px;margin-top: -125px;float: right;" >
		    </div>


 </div>



<div class="clear"></div>

<!-- modals -->

<div id="confCtrl-setBroadcastSite-modal" class="modal" style="display: none; top:300px;">

	<div class="modal-header">
		<button class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3><s:text name="tip"/></h3>
	</div>
	
	<div class="modal-body">
			<p>
				<s:text name="isSetBroadcastSite"/>? <img id="lodingImg" src="${basePath}/lib/images/loading.gif" style="display:none;width: 32px;position: absolute;left: 280px;top: 20px;">
			</p>
	</div>
	
	<div class="modal-footer">
		<input type="button" class="btn" onclick="setBroadcastSiteAjax(0);" value='<s:text name="yes" />'>
		<input type="button" class="btn" onclick="setBroadcastSiteAjax(1);" value='<s:text name="no" />'>
		<input type="button" class="btn" data-dismiss="modal" aria-hidden="true"  value='<s:text name="cancel" />'>
	</div>
</div>

<div id="confCtrl-setSitesQuiet-modal" class="modal" style="display: none; top:300px;">

	<div class="modal-header">
		<button class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3><s:text name="tip"/></h3>
	</div>
	
	  <div class="modal-body">
            <p>
                <s:text name="isSetSitesQuiet"/> ? <br/> <s:text name="desQuietY"/> <br/> <s:text name="desQuietN"/>
                <img id="lodingImg" src="${basePath}/lib/images/loading.gif" style="display:none;width: 32px;position: absolute;left: 280px;top: 20px;">
            </p>
    </div>
	
	
	<div class="modal-footer">
		<input type="button" class="btn" onclick="setSitesQuietAjax(0);" value='<s:text name="yes" />'>
		<input type="button" class="btn" onclick="setSitesQuietAjax(1);" value='<s:text name="no" />'>
		<input type="button" class="btn" data-dismiss="modal" aria-hidden="true"  value='<s:text name="cancel" />'>
	</div>
</div>

<div id="confCtrl-setSitesMute-modal" class="modal" style="display: none; top:300px;">

	<div class="modal-header">
		<button class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3><s:text name="tip"/></h3>
	</div>
	
    <div class="modal-body">
            <p>
                <s:text name="isSetSitesMute"/> ? <br/> <s:text name="desMuteY"/> <br/> <s:text name="desMuteN"/>
                <img id="lodingImg" src="${basePath}/lib/images/loading.gif" style="display:none;width: 32px;position: absolute;left: 280px;top: 20px;">
            </p>
    </div>
	
	
	<div class="modal-footer">
		<input type="button" class="btn" onclick="setSitesMuteAjax(0);" value='<s:text name="yes" />'>
		<input type="button" class="btn" onclick="setSitesMuteAjax(1);" value='<s:text name="no" />'>
		<input type="button" class="btn" data-dismiss="modal" aria-hidden="true"  value='<s:text name="cancel" />'>
	</div>
</div>
<script>
$('#confCtrl-setSitesMute-modal').on('show',function(){
	$('#confCtrl-setSitesMute-modal #lodingImg').hide();
});
$('#confCtrl-setSitesQuiet-modal').on('show',function(){
	$('#confCtrl-setSitesQuiet-modal #lodingImg').hide();
});
$('#confCtrl-setBroadcastSite-modal').on('show',function(){
	$('#confCtrl-setBroadcastSite-modal #lodingImg').hide();
});

</script>