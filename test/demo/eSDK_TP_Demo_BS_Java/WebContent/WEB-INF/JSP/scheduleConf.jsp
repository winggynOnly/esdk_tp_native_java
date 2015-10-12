  		<style type="text/css">
        
	        .panel
	        {
	        width: 97%;
			border: 1px solid silver;
			padding: 30px 10px 10px;
			border-radius: 6px;
			margin-bottom: 35px;
			}
	        
	        .panel_header
	        {
			margin-top: -30px;
			margin-left: 10px;
			font-size: 1.2em;
			font-weight: bold;
			background: white;
			position: absolute;
			padding: 0 5 0 5;
			}
			
        
        </style>
        
	<form >
	
	  <div id="tab1_alert_content" style="padding: 0;margin: 0;width: 99%;">
		<div id="tab1_success_alert" class="alert alert-success" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am a success alert</span></div>
		<div id="tab1_error_alert" class="alert alert-error" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am an error alert</span></div>
		<div id="tab1_warning_alert"  class="alert alert-warning" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am a warning alert</span></div>
	  </div>
		  <script type="text/javascript">
		  	$('#tab1_alert_content .close').click(function(){
		  		$(this).parent().hide();
		  	})
		  </script>
		<br>
		
		<div class="panel_header"><h3><s:text name="confInfo"/></h3></div>
		<div class="panel" style="height:170px;">
			<div style="height:150px;overflow-y: auto;overflow-x: hidden;">
				<table border="0" cellspacing="0" cellpadding="0" class="dataTable" id="confTable">
					<thead>
						<tr>
							<th class="dataTableHeader"><s:text name="confId"/></th>
							<th class="dataTableHeader" ><s:text name='confName'/></th>
							<th class="dataTableHeader" ><s:text name='startTime'/></th>
							<th class="dataTableHeader" ><s:text name='confSpan'/></th>
							<th class="dataTableHeader" ><s:text name='accessCode'/></th>
							<th class="dataTableHeader"><s:text name='confStatus'/></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
		
		
		
	
			
		<div class="panel_header"><h3><s:text name="confDetails"/></h3></div>
		<div class="panel"> 	
			<p>
			    <label class="itemLabel"><s:text name="confId"/>:</label>
			    <input id="confIdChoose" name="confId" type="text" class="inputElem"  disabled="disabled"/>
			    <span>&nbsp;&nbsp;&nbsp;</span>
			    <label class="itemLabel"><s:text name="confName"/>:</label>
			    <input id="confNameChoose"  type="text" class="inputElem" style="width:478px;"name="confName" disabled="disabled">
			</p>
			<p>
			    <label class="itemLabel"><s:text name="startTime"/>:</label>
			    <input id="beginTimeChoose" name="beginTime" type="text" class="inputElem" disabled="disabled" />
			    <span>&nbsp;&nbsp;&nbsp;</span>
			    <label class="itemLabel"><s:text name="confSpan"/>:</label>
			    <input id="durationChoose" class="inputElem"  type="text"  disabled="disabled" style="width:90px;"/>
			    <label class="itemLabel" style="width: 40px;margin-left: 0;">
			    	<s:text name="minute"/>
			    </label>
			    <label class="itemLabel"><s:text name="recurrenceTime"/>:</label>
				<select id="recurrenceChoose" style="width:205px;" class="select" onchange="recurrenceSites(value);">
				</select>
			</p>

	<br/>
	<div style="overflow-x: hidden; overflow-y: auto; height:152px; width:100%;">
		<table border="0" cellspacing="0" cellpadding="0" class="dataTable" id="sitesTable">
			<thead>
				<tr>
					<th  style="width: 5%" class="dataTableHeader"></th>
					<th  style="width: 20%" class="dataTableHeader" style="width: 20%"><s:text name='siteUri'/></th>
					<th  style="width: 25%" class="dataTableHeader" ><s:text name='siteName'/></th>
					<th  style="width: 25%" class="dataTableHeader"><s:text name='siteType'/></th>
					<th  style="width: 25%" class="dataTableHeader"><s:text name='siteStatus'/></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<p style="width: 600px;margin-top: 15px;" >
		<input type="button" value="<s:text name='addSite'/>" id="addSiteButton" name="addSiteButton" class="btn "></input>
		<span>&nbsp;&nbsp;&nbsp;</span>
		<input type="button" value="<s:text name='delSite'/>" id="delSiteButton" name="delSiteButton" class="btn "></input>
		<span>&nbsp;&nbsp;&nbsp;</span>
		<input type="button" value="<s:text name='connSite'/>" id="connSites" name="connSitesButton"class="btn "></input>
	</p>
	
	</div>
	
	
	<p style="width: 750px;  margin-bottom: 53px; margin-top: 55px; margin-left:10px" class="left" > 
		<input type="button" value="<s:text name='scheduleConf'/>" id="newConfButton" name="newConfButton" class="btn "></input>
		<span>&nbsp;&nbsp;&nbsp;</span>
		<input type="button" value="<s:text name='modifyConf'/>" id="editConfButton" name="editConfButton" class="btn "></input>
		<span>&nbsp;&nbsp;&nbsp;</span>
		<input type="button" value="<s:text name='delConf'/>" id="delConfButton" name="delConfButton" class="btn "></input>
		<span>&nbsp;&nbsp;&nbsp;</span>
		<input type="button" value="<s:text name='prolongConf'/>" id="prolongConfButton" name="prolongConfButton" class="btn "></input>
	</p>
	<div id="codeMsg" style="display:none;border: 1px solid #CCC;position: absolute;height: 140px;width: 250px;margin-left: 720px;"></div> 





</form>

<div id="confMgr-new-conf-modal" class="modal" style="display: none;width:850px;left:auto;margin-left:80px;top:40px;">

	<div class="modal-header">
		<button class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3><s:text name='scheduleConf'/></h3>
	</div>
	
	<div class="modal-body" style = "max-height:500px;">
			
			<%@include file= "newConf.jsp" %>
		
	</div>
	<div class="modal-footer">
            <a id="newConfButton_newConf" href="#" class="btn" ><s:text name="confirm" /></a>
            <a id="newConfButton_newConf1" href="#" class="btn" style="display:none;"><s:text name="confirm" /></a>
            <a href="#" class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="cancel" /></a>
       </div>
	
</div>


<div id="confMgr-add-site-modal" class="modal" style="display: none; width:650px;left:auto;margin-left:180px; ">

	<div class="modal-header">
		<button class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3><s:text name="siteList"/></h3>
	</div>
	
	<div class="modal-body">
		<%@include file= "siteInfoList.jsp" %>
	</div>
	
	<div class="modal-footer">
		<a id="add-site-modal-yes-btn" href="#" class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="confirm" /></a>
		<a href="#" class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="cancel" /></a>
	</div>
</div>


<div id="confMgr-prolong-conf-modal" class="modal" style="display: none; top:300px;">

	<div class="modal-header">
		<button class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3><s:text name="prolongConf"/></h3>
	</div>
	
	<div class="modal-body">
			
			<p>
			<label class="itemLabel"><s:text name='confId'/>:</label><input id="confId"
				name="confId" type="text" class="inputElem" value="" disabled="disabled" />
			</p>
			<p>
			<label class="itemLabel"><s:text name='prolongTime'/>:</label><input id="prolongTime" class="inputElem"
				name="prolongTime"><s:text name='minute'/>
			</p>
			<input id="beginTime" type = "text" value="" style="display: none;">
	</div>
	
	<div class="modal-footer">
		<a id="prolong-conf-modal-yes-btn" href="#" class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="confirm" /></a>
		<a href="#" class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="cancel" /></a>
	</div>
</div>
