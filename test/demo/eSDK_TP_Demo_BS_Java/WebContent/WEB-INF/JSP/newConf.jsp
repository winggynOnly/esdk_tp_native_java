<div id="newConfModal1" style="width:800px;">

	  <div id="tab1_newConf_alert_content" style="padding: 0;margin: 0;width: 99%;">
		<div id="tab1_newConf_success_alert" class="alert alert-success" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am a success alert</span></div>
		<div id="tab1_newConf_error_alert" class="alert alert-error" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am an error alert</span></div>
		<div id="tab1_newConf_warning_alert"  class="alert alert-warning" style="display: none;">
		<a class="close">x</a>
		<span id="content">I am a warning alert</span></div>
	  </div>
		  <script type="text/javascript">
		  	$('#tab1_newConf_alert_content .close').click(function(){
		  		$(this).parent().hide();
		  	})
		  </script>
		  
		  <img id="newConf_lodingImg" src="${basePath}/lib/images/loading.gif" style="display:none;position: absolute;margin:40px 0 0 360px;">
		  
<br>
<div class="panel_header"><h3><s:text name="confInfo"/></h3></div>
<div class="panel">

<table border="0" id="confInfo_newConf" class="datatable" style="width: 100%;" >
<tr>
<td style="padding: 0px;"><label class="itemLabel"><s:text name='confId'/>:</label></td>
<td style="padding: 0px;"><input id="confId" disabled="disabled"
	name="confId" type="text" class="inputElem"  value='<%=request.getAttribute("confId")==null?"": request.getAttribute("confId")%>'/></td>
<td style="padding: 0px;"><label class="itemLabel"><s:text name='confName'/>:</label></td>
<td style="padding: 0px;"><input id="confName" class="inputElem"  type="text"
	name="confName" value='<%=request.getAttribute("confName")==null?"": request.getAttribute("confName")%>'></td>
</tr>
<tr>
<td style="padding: 0px;"><label class="itemLabel"><s:text name='startTime'/>:</label></td>
<td style="padding: 0px;">	 	 <div class="control-group" style="display: inline-block;margin-bottom: 0px;">
                <div class="controls input-append date form_datetime_newConf"  data-date-format="dd M yyyy - hh:ii" data-link-field="dtp_input1">
                    <input size="16" type="text" value="" style="width:154px;" >
                    <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
                </div>
				<input type="hidden" id="dtp_input1" name="beginTime" value="" /><br/>
            </div></td>
<td style="padding: 0px;"><label class="itemLabel"><s:text name='confSpan'/>:</label></td>
<td style="padding: 0px;"><input id="duration1" class="inputElem"  type="text" name="duration"  value=""> <s:text name='minute'/></td>
</tr>

<tr>
<td style="padding: 0px;">	<label class="itemLabel"><s:text name='rate'/>:</label> </td>
<td style="padding: 0px;">	<input id="rate" name="rate" type="text" value="1920" class="inputElem"  /> K
	</td>
<td style="padding: 0px;">    <label class="itemLabel" style="width:auto;"><s:text name="cpMode"/>:</label>  </td>
<td style="padding: 0px;">    <select  id="cpMode" style="width:150px;" >
        <option id="0"><s:text name="none"/></option>
        <option id="2"><s:text name="twoPanes"/></option>
        <option id="3"><s:text name="threePanes"/></option>
        <option id="4"><s:text name="fourPanes"/></option>
        <option id="5"><s:text name="fivePanes"/></option>
        <option id="6"><s:text name="sixPanes"/></option>
        <option id="7"><s:text name="sevenPanes"/></option>
        <option id="8"><s:text name="eightPanes"/></option>
    </select></td>
</tr>

<tr>
<td align="center"  style="padding: 0px;">	<input type='checkbox' name='isRecurrence' id="isRecurrence"  style="margin-left: 20px;margin-right: 45px;"></td>
<td  style="padding: 0px;">	<input id="recurrence" type = "button" value ="<s:text name='recurrenceConf'/>" name="recurrence" class="btn" ></td>
<td style="padding: 0px;"></td>
<td style="padding: 0px;"></td>
</tr>
</table>





<div id="isRecurrenceDiv" style="display:none;margin-top:20px;">
<p  style=" margin: 0;padding: 0;"><label class="itemLabel"><s:text name='recurrenceType'/>:</label>
<select  name="frequency" id="frequency" style="margin-left: -5px;width: 160px;" onchange="setFrequency(this.value);">
    <option value="0"><s:text name='everyDay'/></option>
    <option value="1"><s:text name='everyWeek'/></option>
    <option value="2"><s:text name='everyMonth'/></option>
   </select>
   <span>&nbsp;&nbsp;&nbsp;</span>
<label class="itemLabel"><s:text name='interval'/>:</label><input type='text' name='interval' id="interval"  class="inputElem" >
</p>
<p style=" margin: 0;padding: 0;"><label class="itemLabel"><s:text name='whichWeek'/>:</label>
<select name="weekDay" id="weekDay" style="margin-left: -5px;width: 160px;height: 24px;" disabled="disabled"> 
    <option value=""></option>
    <option value="0"> <s:text name='sunday'/></option>
    <option value="1"><s:text name='monday'/></option>
    <option value="2"><s:text name='tuesday'/></option>
    <option value="3"><s:text name='wednesday'/></option>
    <option value="4"><s:text name='thursday'/></option>
    <option value="5"><s:text name='friday'/></option>
    <option value="6"><s:text name='saturday'/></option>
   </select>
   <span>&nbsp;&nbsp;&nbsp;</span>
   <label class="itemLabel"><s:text name='whichDay'/>:</label><input type='text' name='monthDay' id="monthDay" class="inputElem" disabled="disabled" >
</p>
<p style=" margin: 0;padding: 0;">
<label class="itemLabel"><s:text name='replication'/>:</label><input type='text' name='count' id="count" class="inputElem" >
<span>&nbsp;&nbsp;&nbsp;</span>
<label class="itemLabel"><s:text name='endDate'/>:</label>
			<div class="control-group" style="display: inline-block;margin-left: 415px;margin-top: -35px;position: absolute;">
                <div class="controls input-append date form_datetime_newConf"  data-date-format="dd M yyyy - hh:ii" data-link-field="dtp_input2">
                    <input size="16" type="text" value="" style="width:154px;" >
                    <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
                </div>
				<input type="hidden" id="dtp_input2" name="endTime" value="" /><br/>
            </div>
</p>
<p>

</p>
</div>



<script>

$("#recurrence").click(function(){
	if($("#isRecurrenceDiv").is(":visible")){
		$("#isRecurrenceDiv").hide();
	}else{
		$("#isRecurrenceDiv").show();
	}
});

$('.form_datetime_newConf').datetimepicker({
    //language:  'fr',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	forceParse: 0,
    showMeridian: 1
});

</script>

</div>








<div class="panel_header"><h3><s:text name="siteInfo"/></h3></div>
<div class="panel" style="margin-bottom:0px;">

<div style="overflow-x: hidden; overflow-y: auto; height:150px; width:100%;">
<table border="0" cellspacing="0" cellpadding="0" class="dataTable"
	id="stateTable">
	<thead>
		<tr>
			<th width="5%" class="dataTableHeader"></th>
			<th class="dataTableHeader" width="35%"><s:text name='siteUri'/></th>
			<th class="dataTableHeader" width="30%"><s:text name='siteName'/></th>
			<th class="dataTableHeader"width="30%"><s:text name='siteType'/></th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
</div>

<p><span>&nbsp;&nbsp;&nbsp;</span><input type="button" value="<s:text name='addSite'/>" id="addSiteButton_newConf"
	name="addSiteButton" class="btn" ></input><span>&nbsp;&nbsp;&nbsp;</span>
<input type="button" value="<s:text name='delSite'/>" id="delSiteButton_newConf" name="delSiteButton"
	class="btn"></input><span>&nbsp;&nbsp;&nbsp;</span>
<input type="button" value="<s:text name='addDynamicSite'/>" id="addDynamicSiteButton_newConf" name="addDynamicSiteButton"
	class="btn"></input></p>

</div>



</div>







			<div id="newConfModal2" style="overflow-x: hidden; overflow-y: auto; height:300px; width:100%;display: none;">
				<table border="0" cellspacing="0" cellpadding="0" class="dataTable" id="sitesTableInMode_newConf">
						<thead>
							<tr>
								<th  style="width: 5%" class="dataTableHeader"></th>
								<th  style="width: 30%" class="dataTableHeader" style="width: 20%"><s:text name='siteUri'/></th>
								<th  style="width: 35%" class="dataTableHeader" ><s:text name='siteName'/></th>
								<th  style="width: 30%" class="dataTableHeader"><s:text name='siteType'/></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
				</table>
			</div>