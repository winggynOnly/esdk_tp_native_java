function getServerPath()
{
	var url = window.document.location.pathname;
	return url.substring(0,url.substr(1).indexOf('/') + 1);
}

function changeLang()
{
	// 登录页面传入的值
	lang = $("#changeLang").val();
	
	if (lang == "en-us")
	{
		controller = new LanguageControllerEN();
	}
	else
	{
		controller = new LanguageControllerZH();
	}
	
	var langTags = $("[languageTag]");
	for(var i = 0; i < langTags.size(); i++)
	{
		var langTag = langTags.eq(i);
		var tag = langTag.attr('languageTag');
		langTag.html(controller.language.titles[tag]);
		langTag.val(controller.language.titles[tag]);

	}
	
	var zTree = $.fn.zTree.getZTreeObj("eSDKTree");
	var nodes = zTree.getNodes();
	changeTreeName(nodes[0], zTree, controller);
	
}

function changeTreeName(treeNode, zTree, controller)
{
	treeNode.name=controller.language.tree[treeNode.languageTag];
	zTree.updateNode(treeNode);
	
	if (treeNode.isParent)
	{
		for(var obj in treeNode.children)
		{
			changeTreeName(treeNode.children[obj], zTree, controller);
		}
    }

	return;
}

function appendInterface(pName)
{
	if ("scheduleConf" == pName)
	{
		$(function() {
			$.ajax({
				type : "get",
				cache : false,
				url : getServerPath()+"/pages/interface/scheduleConf.html",
				async : false,
				success : function(data) {
					$("#main1").html(data);
				}
			});
		});
	}
	else if ("querySitesByCondition" == pName)
	{
		$(function() {
			$.ajax({
				type : "get",
				cache : false,
				url : getServerPath()+"/pages/interface/querySitesByCondition.html",
				async : false,
				success : function(data) {
					$("#main1").html(data);
				}
			});
		});
	}
	
	
    setTab(1,0);
	
	changeLang();
}

function setTab(m,n)
{  
	 var tli=document.getElementById("menu"+m).getElementsByTagName("li");  
	 var mli=document.getElementById("main"+m).getElementsByTagName("ul");  
	 for(i=0;i<tli.length;i++)
	 {  
	 	tli[i].className=i==n?"hover":"";  
	  	mli[i].style.display=i==n?"block":"none";  
	 }  
}

function clean()
{
	// 当单击节点时，置空标签页
	$("#main1").html("<ul class='block'><li></li></ul><ul><li></li></ul><ul><li></li></ul>");
	setTab(1,0);
}

function isEmpty(value)
{
	if (null == value || "" == value)
	{
		return true;
	}
	else
	{
		return false;
	}
}

function isNumber(num)
{
	var reNum=/^\d*$/;
	return(reNum.test(num));
}

function isDate(date)
{
	$.ajax({
		url : getServerPath()+"/checkDateServlet?dateStr="+date,
		type : "get",
		dataType : "json",
		async : false,
		success : function(data)
		{
			if("true" == data)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	});
}

function table_addRow(obj){
	var cloneRow = $(obj).parent().find("table tbody tr:last-child");
	var newRow = cloneRow.clone();
	newRow.show();
	cloneRow.before(newRow);
	$(obj).parent().find("table").show();
}

function table_delRow(obj)
{
	var tbody = $(obj).parent().parent().parent();
	if(tbody.find("tr").size()<3){
		tbody.parent().hide();
	}
	$(obj).parent().parent().remove();
}
