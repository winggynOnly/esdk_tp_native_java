function LanguageControllerZH()
{
	this.language = {
		tree : {
			"typicalApplication" : "典型功能",

			"confMgr" : "会议管理",
			"scheduleConf" : "scheduleConf",
				
			"siteMgr" : "会场管理",
			"querySitesByCondition":"querySitesByCondition"
		},

		titles : {
			"om" : "eSDK TP Demo",
			"language" : "语言",
			"description" : "描述",
			"execution" : "执行",
			"sourceCode" : "源码",
			
			"Function" : "接口功能",
			"Access" : "访问路径",
			"RequestType" : "请求类型",
			"ParamFormat" : "参数格式",
			"ParamFormatDesc" : "application/json;charset=UTF-8",
			
			"scheduleConfExFunctionDesc" : "此接口用于召集或预约非周期性会议",
			"scheduleConfExAccessDesc" : "http(s)://${ip}:${port}/esdk/services/tpProfessionalConfMgr",
			"scheduleConfExRequestTypeDesc" : "POST",
			
			"querySitesByConditionExFunctionDesc" : "此接口用于根据条件查询会场列表",
			"querySitesByConditionExAccessDesc" : "http(s)://${ip}:${port}/esdk/services/tpProfessionalConfMgr",
			"querySitesByConditionExRequestTypeDesc" : "POST",
			
			"inputParameterDesc" : "输入参数描述:",
			"outputParameterDesc" : "返回参数描述:",
			"resultCodeDesc" : "返回消息码，0代表成功，其他请参见错误码",
			"resultContextDesc" : "返回消息体，记录成功或失败的具体信息",
			"resultDesc" : "添加成功后返回帐号ID",
			
			"input" : "输入:",
			"output" : "输出:",
			"resultCode" : "返回码:",
			"resultContext" : "返回消息:",
			"result" : "返回值：",
			
						
			
			"inputParameter" : "参数",
			"inputType" : "数据类型",
			"inputLength" : "数据长度",
			"inputRestriction" : "约束",
			"inputDescription" : "描述",
			
			"scheduleConfParamDesc" : "准备预约的会议参数，包含会场列表和会场的参数，预约时ConferenceInfoEx必填参数包括：name：会议名称，beginTime：会议开始时间，rate：速率，duration：会议时长，sites：会场信息。列表其中会场列表参数中的SiteInfoEx必填参数为：uri 会场标识。(当 uri 为空时，预约匿名会议。)",
			"confIdParamDesc" : "会议 ID，由系统自动分配。",
			"nameParamDesc11" : "会议名称。",
			"beginTimeParamDesc" : "会议开始时间。格式如：2013-05-07T22:46:31.235+08:00，2013-05-07T22:46:31.235为格林威治时间（GMT时间），+08:00为中国大陆与GMT的时差。服务器端返回的格式为2013-05-07T22:46:31.235+08:00",
			"durationParamDesc" : "会议时长，如：P0Y0M0DT1H0M0.000S或者PT1H：表示1小时。其中PT为标志位，YMDHMS分别代表年月日时分秒。说明：会议时长最大值不能超过SMC中配置的会议最大时长数。",
			"accessCodeParamDesc" : "会议接入码 。必须为数字格式的字符串。如：075560166。",
			"passwordParamDesc" : "会议接入密码。只支持0～9的数字。长度为6位数字，密码加密方式为AES128。",
			"mediaEncryptTypeParamDesc" : "媒体流加密方式。取值说明如下：0：AutoEncrypt自动协商是否使用加密。会议根据会场设备的能力进行协商。如果会场支持加密，则媒体流启用加密。如果会场不支持加密，则媒体流不启用加密。1：ForceEncrypt强制使用加密。如果准备入会的会场没有加密能力，则无法加入会议。2：None 不加密。无论会场是否有加密能力，媒体流都不启用加密。",
			"auxVideoFormatParamDesc" : "辅流视频格式。取值说明如下：0：Auto 1：4 CIF 2：720P30 3：1080P30 4：480P 5：720P60 6：1080P60   说明：在预约会议时，如果不设置该参数，辅流视频格式由系统根据会议带宽自动适配。",
			"auxVideoProtocolParamDesc" : "辅流视频协议，取值说明如下：0：Auto 1：H.261协议 2：H.263协议 3：H.264协议   说明：在预约会议时，如果不设置该参数，辅流视频协议由系统根据会议带宽自动适配。",
			"cpResouceParamDesc" : "多画面资源数。说明：目前版本最多可设置8个多画面。",
			"rateParamDesc" : "速率。格式为“速率值k/M”，如“1920k”。说明：速率如果小于64K，系统默认为64K，大于8M则默认为8M，64K和8M中间的取值按照实际输入赋值，且必须为整数取值。",
			"isRecordingParamDesc" : "会议是否支持录制功能，不填写则默认不支持：0：不支持 1：支持 说明：预约会议时若填1（支持录制），则需要系统支持录制功能，且当mediaEncryptType设置为2（不加密）时，录制功能才能够正常使用，mediaEncryptType为其它值时，录制功能暂不支持。",
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
			"passwordParamDesc" : "会议接入密码。只支持0～9的数字。长度为6位数字，密码加密方式为AES128。",
			
			"queryConfigParamDesc" : "查询预定义会场时使用的过滤、排序、翻页条件。",
			"sortItemsParamDesc" : "排序条件组合，目前只支持单列排序。",
			"filtersParamDesc" : "过滤条件组合，支持多个过滤条件，为AND关系。",
			"focusItemParamDesc" : "焦点数据ID。指定当前查询优先返回包含指定ID的数据页面。当查询结果不包含指定ID的数据，按照PageParam要求的页面返回。",
			"pageParamParamDesc" : "页码定位参数。指定返回查询结果的第几页。",
			"sortParamDesc" : "排序方式：0：升序   1：降序",
			"itemIndexParamDesc" : "查询条件的数据列标识：0：会场名称   1：会场URI   2：会场状态   3：会场类型   4：会议模板名称   5：会议模板接入号（Ad hoc类型会议才有接入号）   6：MCU名称（eSDK V1R2版本不支持）",
			"columnIndexParamDesc" : "过滤条件的数据列标识：0：会场名称   1：会场URI   2：会场状态   3：会场类型   4：会议模板名称   5：会议模板接入号（Ad hoc类型会议才有接入号）  6：MCU名称（eSDK V1R2版本不支持）",
			"numberPerPageParamDesc" : "每页的记录条数",
			"currentPageParamDesc" : "当前页码，或需要返回的页码。页码从1开始。",
			
			"sites1ParamDesc" : "操作成功，则根据查询条件，返回查询的会场列表。",
			"pageInfoParamDesc" : "输出查询结果的翻页信息。第三方应用程序可以根据返回的翻页信息，显示当前页码、总页数、总记录数。",
			
			"resultCodeParamDesc" : "返回错误码，具体说明如下：0：表示成功   其他数值：表示失败",
			"conferenceInfoParamDesc" : "预约成功后的会议基本信息，包括系统分配的会议 ID，会议的接入码等信息。",

			"sourceCodeDesc" : "红色加粗部分代码为接口调用,其他颜色为模拟IDE开发工具中的色彩，便于阅读。",
			
			"descriptionUC" : "eSDK智真服务端接口发布形态主要包括SOAP和Native（本地API）两种，介绍内容包括相关数据类型、接口参数、返回值和使用示例。",
			"copyright" : "版权所有 © 华为技术有限公司 1998-2014。 保留一切权利。粤A2-20044005号",
		
				"confNameNull" : "会议名称不能为空",
				"beginTimeNull" : "开始时间不能为空",
				"beginTimeError" : "开始时间格式错误",
				"durationNull" : "会议时长不能为空",
				"durationError" : "会议时长必须是整数",
				
				"numberPerPageNull":"每页记录条数不能为空",
				"numberPerPageError":"每页记录条数必须是整数",
				"currentPageNull":"当前页码不能为空",
				"currentPageError":"当前页码必须是整数",
				"focusItemError":"焦点数据ID必须是整数",
				
				"scheduleConf" : "预约会议",
				"confName" : "会议名称",
				"beginTime" : "开始时间",
				"duration" : "会议时长",
				"accessCode" : "会议接入码",
				"password" : "会议接入密码",
				"cpResouce" : "多画面资源数",
				"rate" : "会议速率",
				"isRecording" : "是否录播",
				"isLiveBroadcast" : "是否直播",
				"chairmanPassword" : "主席密码",
					
				"numberPerPage": "每页记录条数",
				"currentPage": "当前页码",
				
				"addSortItem":"增加会场查询条件",
				"sortItem_sort":"排序方式",
				"sortItem_itemIndex":"查询条件的数据列标识",
					
				"addStringFilter":"增加会场过滤条件",
				"stringFilter_columnIndex":"过滤条件的数据列标识",
				"stringFilter_value":"包含的字符串",
				
				"focusItem":"焦点数据ID",
				
				"querySitesByCondition":"根据条件查询会场"


		}
	};
}