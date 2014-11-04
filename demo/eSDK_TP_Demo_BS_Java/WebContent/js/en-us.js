function LanguageControllerEN()
{
	this.language = {
			tree : {			
				"typicalApplication" : "TypicalApplication",
				
				"CTD" : "CTD",
				"createCTD" : "createCTD",
				
				"addrBook" : "addrBook",
				"updateDept" : "updateDept",
				"queryDept" : "queryDept",
				"Number" : "Number",
				"addNumber" : "addNumber",
				
				"confMgr":"Conference Management",
				"siteMgr" : "Site Management",
				
				"scheduleConf" : "Schedule Conference",
				"querySitesByCondition" : "querySitesByCondition"
			},

			titles : {
				"om" : "eSDK UC2.2 BS Demo",
				"language" : "Language",
				"description" : "Description",
				"execution" : "Execution",
				"sourceCode" : "Source code",
				
				"createCTDFunction" : "Interface fuction",
				"createCTDFunctionDesc" : "This is used to make a CTD call",
				"createCTDAccess" : "Access path",
				"createCTDAccessDesc" : "http://{ip}:{port}/esdk/rest/uc/appserver/ctd",
				"createCTDRequestType" : "Requset type",
				"createCTDRequestTypeDesc" : "POST",
				"createCTDParamFormat" : "Parameters format",
				"createCTDParamFormatDesc" : "application/json;charset=UTF-8",
				
				"scheduleConfExFunctionDesc" : "This is used to call up or book a schedule conference",
				"scheduleConfExAccessDesc" : "http://{ip}:{port}/esdk/rest/uc/bmu/sch",
				"scheduleConfExRequestTypeDesc" : "POST",
				
				"querySitesByConditionExFunctionDesc" : "This is used to query sites by condition",
				"querySitesByConditionExAccessDesc" : "http://{ip}:{port}/esdk/rest/uc/bmu/sit",
				"querySitesByConditionExRequestTypeDesc" : "POST",
				
				"inputParameterDesc" : "Input parameters description:",
				"outputParameterDesc" : "Output parameters description:",
				"resultCodeDesc" : "Result message code, zero is successful, other code reference API doc",
				"resultContextDesc" : "Result message, for displaying success and failed infomation",
				
				"accountParam" : "UC account:",
				"callerParam" : "Calling number:",
				"calleeParam" : "Called number:",
				"createCTD" : "makeCTDCall",
				"input" : "Input:",
				"output" : "Output:",
				"resultCode" : "Result code:",
				"resultContext" : "Result message:",
				
				"inputParameter" : "Parameter",
				"inputType" : "Data type",
				"inputRestriction" : "Restriction",
				"inputDescription" : "Description",
				"accountParamDesc" : "UC account which logined by mobile phone",
				"callerParamDesc" : "Calling number",
				"calleeParamDesc" : "Called number",
				
				
				"scheduleConfParamDesc" : "the params to ready to book a conference,including the params of conference and conference sites,the params of ConferenceInfoEx to have to input when booked including:name:conference name,beginTime:conference begin time，rate:rate,duration:conference duration,sites:sites infomation.The params of SiteInfoEX to have to input are:uri sites identification.(when uri is empty,book anonymous conference)",
				"confIdParamDesc" : "conference ID,auto distribute by the system.",
				"nameParamDesc11" : "conference name",
				"beginTimeParamDesc" : "conference begin time.format like:2013-05-07T22:46:31.235+08:00，2013-05-07T22:46:31.235 is Greenwich Time(GMT)，+08:00 is the equation of time between China and CMT.The format to return by server is 013-05-07T22:46:31.235+08:00",
				"durationParamDesc" : "conference duration,for example：P0Y0M0DT1H0M0.000S or PT1H：means an hour.Amone in it PT is the identification bit,YMDHMS respectively means year,month,date,hour,minute and second.Instruction：the max value of conference duration cannot be longer than the conference configuration duration in SMC.",
				"accessCodeParamDesc" : "conference access code.They must be string of number format.for example:075560166.",
				"passwordParamDesc" : "conference access password.Only support number between 0 and 9.And its length is 6,password encryption format is AES128.",
				"mediaEncryptTypeParamDesc" : "media stream encryption format.Instruction of value is like that:0：AutoEncrypt,auto negotiation about password encrytion or not.Conference support negotiation according to the ability of sites equipment.If conference support encryption,then media launch encryption.If conference do not support encrytion,and media stream do not launch encryption.1：ForceEncrypt,enforce to launch encrytion.If the site which ready to join in conference does not have the ability of encrytion,then it cannot join conference.2：None no encryption.No metter site has the ability of encrytion or not,media stream neither launch encryption.",
				"auxVideoFormatParamDesc" : "Aided flow video format.Instruction of value is like that:0：Auto 1：4 CIF 2：720P30 3：1080P30 4：480P 5：720P60 6：1080P60   Instruction：when conference is booked,if the param is not set,aided flow video format is made auto by the system according to conference network bandwidth.",
				"auxVideoProtocolParamDesc" : "Aided flow video protocal,Instruction of value is like that:0：Auto 1：H.261protocal 2：H.263protocal 3：H.264protocal   Instruction：when conference is booked,if the param is not set,aided flow video protocal is made auto by the system according to conference network bandwidth.",
				"cpResouceParamDesc" : "multiply pictures resouce number.Instruction:brand-new edition can set 8 multiply pictures at maximum.",
				"rateParamDesc" : "rate.Format is “rate value k/M”,like “1920k”.Instruction:if rate is less than 64k,it is set to be 64K by the system,if it is more than 8M ,is 8M,the value between 64K and 8M is according to the true input value,must be the integer.",
				"isRecordingParamDesc" : "conference  conference support recording or not,if it is empty,then the conference does not support recording:0：not support 1：support Instruction:if it is 1 when we book a conference(support recording),we need the system can support the function of recording,and when the mediaEncryptType is 2,the function of recording can run 且当mediaEncryptType设置为2（不加密）时，录制功能才能够正常使用，mediaEncryptType为其它值时，录制功能暂不支持。",
				"recorderAddrParamDesc" : "录播地址。说明：该值为预约会议的返回属性，作为输入参数时不填写该值，且mediaEncryptType需填2（不加密）。",
				"isLiveBroadcastParamDesc" : "录播会议是否支持直播功能，不填写则默认不支持：0：不支持 1：支持 说明：预约会议时若填1（支持），则需要系统支持直播功能，当会议支持直播时，系统默认支持录制功能（isRecording值为1，不需要用户填写）。",
				"presentationParamDesc" : "演示方式。取值说明如下：0：胶片演示方式 1：活动图像方式 2：双流（暂不支持）说明：预约会议时，不设置此参数，系统默认为0(胶片演示方式)。如果想预约其它演示方式的会议，在预约时将该参数修改为对应的数值。",
				"chairmanPasswordParamDesc" : "主席密码或会议启动密码。只支持0～9的数字。长度为6位数字，密码加密方式为AES128。",
				"statusParamDesc" : "会议状态。取值说明如下：0：未知状态（保留）1：会议不存在 2：已预约 3：会议已经召开 4：会议已经结束 说明：预约、修改会议时该参数无效，该参数作为查询操作的返回属性。",
				"billCodeParamDesc" : "计费码（可选）。说明：根据SMC侧配置赋值，目前支持数字输入。",
				"sitesParamDesc" : "会场信息列表。",
				"uriParamDesc" : "会场标识。",
				"typeParamDesc11" : "会场类型。取值说明如下：0：无效类型 1：根据会场标识自动从系统获取 2：E1 类型会场 3：ISDN 类型会场 4：H.323 类型会场 5：PSTN 类型会场 6：4E1 类型会场 7：SIP 类型会场 8：VoIP SIP 类型会场 9：VoIP H.323 类型会场",
				"fromParamDesc" : "会场来源。取值说明如下：0：内部会场 1：外部会场 2：eConference 网关会场 3：Lync 会场 说明：预约、修改会议时如果不修改时该参数作为默认值处理。默认为内部会场。",
				"dialingModeParamDesc" : "呼叫方式。取值说明如下：0：MCU 呼叫会场 1：会场主动呼入",
				"rate1ParamDesc" : "速率。格式为“速率值k/M”，如“1920k”。说明：预约、修改会议时，如果不填写该参数，默认使用会议速率。速率如果小于64K，系统默认为64K，大于8M则默认为8M，64K和8M中间的取值按照实际输入赋值，且必须为整数取值。",
				"videoFormatParamDesc" : "视频格式。取值说明如下：0：Auto   1：4 CIF   2：720P30   3：1080P30   4：480P   5：720P60   6：1080P60 说明：在预约会议时，如果不设置该参数，视频格式由系统根据会议带宽自动适配。",
				"videoProtocolParamDesc" : "视频协议，取值说明如下：0：Auto 1：H.261协议 2：H.263协议 3：H.264协议 说明：在预约会议时，如果不设置该参数，视频协议由系统根据会议带宽自动适配。",
				"statusParamDesc" : "会场状态。取值说明如下：0：未知状态（保留） 1：会场不存在 2：在会议中 3：未入会 4：正在呼叫 5：正在震铃 说明：该参数作为查询会场状态的返回属性。",
				
				
				"accountNull" : "UC account can not be null",
				"callerNull" : "Calling number can not be null",
				"calleeNull" : "Called number can not be null",
				
				"operationSuccess" : "Operation succeeded",
				"operationFailed" : "Operation failed",
				"userAuthFailed" : "User authricated failed",
				
				"sourceCodeDesc" : "The red color and bold fonts are codes of interface, other color is simulated to IDE tool, for easy reading.",
				
				"descriptionUC" : "eSDK Server supports all interfaces of UC2.2 service. eSDK provides Rest service，ISV can implement all UC function by sending Rest message",
				"copyright" : "Copyright © Huawei Technologies Co., Ltd. 1998-2014. All rights reserved"
			}
		};
}