$(document).ready(function() {
    $("select").each(function(i) {
     if (null == this.id || "" == this.id){
      $(this).attr("id","jQuery_auto_create_select_id"+i);
     }
     id = this.id;
     jquery_val_w = $(this).width();
     jquery_val_p = $(this).offset();
     $(this).hide();
     jquery_val_t = ct(jquery_val_w,id);
     jquery_val_img = ci(jquery_val_w,id);
     $(jquery_val_img).click(function(){
      if ("none" == $("#" + this.selId + "_div").css("display")){
       $("#"+this.selId + "_div").slideDown("fast",findRow(this.selId));
      }else{
       $("#"+this.selId + "_div").hide();
      }
     });
     $(this).after(jquery_val_img);
     $(jquery_val_img).before(jquery_val_t);
    
     $(jquery_val_t).click(function(){
      if ("none" == $("#" + this.selId + "_div").css("display")){
       $("#"+this.selId + "_div").slideDown("fast",findRow(this.selId));
      }else{
       $("#"+this.selId + "_div").hide();
      }
     });    
    
     jquery_val_dp = $(jquery_val_t).offset();
     jquery_val_divLeft = jquery_val_dp.left;
     jquery_val_divTop = jquery_val_dp.top + $(jquery_val_t).height();
     jquery_val_param = {left:jquery_val_divLeft,top:jquery_val_divTop,width:jquery_val_w,selId:this.id};
     var jquery_val_divNode = cd(jquery_val_param);
    
     $("body").append(jquery_val_divNode);
    });
    $("body").click(function(){
     var divs = $("div").filter(".jQuery_select_div");
     $(divs).each(function(){
      $(this).hide();
     });
    });
    //alert(document.body.outerHTML);
  });
 
  function findRow(id){
   var showText = $("#"+id+"_text").val();
   $("#"+id+"_div > table").each(function(){
    txt = $(this).find("td").text();
    $(this).css("background","");
    if (showText == txt){
     $(this).css("background","whitesmoke");
    }
   });
  }
  
   function ct(w,id){
    var jquery_val_t = document.createElement("input");
    $(jquery_val_t).attr("id",id+"_text");
    $(jquery_val_t).attr("selId",id);
    $(jquery_val_t).attr("type","text");
    $(jquery_val_t).attr("value",$("#"+id+" option:selected").text());
    $(jquery_val_t).attr("readonly","true");
    $(jquery_val_t).css("width",w - 15);
    $(jquery_val_t).css("marginTop",0);
    $(jquery_val_t).css("border","1px solid #d3e4ec");
    $(jquery_val_t).css("border-right-style","none");
    $(jquery_val_t).css("cursor","hand");
   
    $(jquery_val_t).hover(
     function(){
      $(this).css("border","1px solid lightsteelblue");
      $(this).css("border-right-style","none");
     },
     function(){
      $(this).css("border","1px solid #d3e4ec");
      $(this).css("border-right-style","none");
     }
    );
    return jquery_val_t;
   }
  
   function ci(jquery_val_w,id){
     var jquery_val_i = document.createElement("img");
     $(jquery_val_i).attr({src:"sanjiao.gif"});
     $(jquery_val_i).attr("height","19");
     $(jquery_val_i).attr("selId",id);
     $(jquery_val_i).css("cursor","hand");
     $(jquery_val_i).css("verticalAlign","bottom");
     $(jquery_val_i).css("margin-bottom","1px");
     $(jquery_val_i).mousedown(function(){$(this).fadeTo("fast",0.3)});
     $(jquery_val_i).mouseup(function(){$(this).fadeTo("fast",1)});
     $(jquery_val_i).hover(
      function(){
       $(this).fadeTo("fast",0.7);
      },
      function(){
       $(this).fadeTo("fast",1);
      }
     );

     return jquery_val_i;
   }
  
   function cd(param){
    var left = param.left;
    var top = param.top;
    var width = param.width;
    var selId = param.selId;
   
    var d = document.createElement('div');
    $(d).css("position","absolute");
    $(d).css("width",width + 3);
    $(d).css("border","1px solid #d3e4ec");
    $(d).css("border-top-style","none");
    $(d).css("font-size","12px");
    $(d).css("backgroundColor","#FFF");
    $(d).addClass("jQuery_select_div");
    d.style.posLeft = left;
    d.style.posTop = top + 4;
    if ($("#"+selId+" option").length > 11){
      $(d).css("overflow-y","auto");
        $(d).css("height",20 * 11);
        $(d).css("scrollbar-face-color","#eef6f9");
        $(d).css("scrollbar-highlight-color","#d8eff8");
      $(d).css("scrollbar-shadow-color","#d8eff8");
      $(d).css("scrollbar-3dlight-color","#d8eff8");
      $(d).css("scrollbar-arrow-color","#7fbfe5");
      $(d).css("scrollbar-track-color","#eef6f9");
      $(d).css("scrollbar-darkshadow-color","#48486c");
      $(d).css("scrollbar-base-color","#eef6f9");
    }
    $("#"+selId+" option").each(function(i){
      value = this.value;
      text = this.text;
      a = ca({value:value,text:text,id:selId,width:width,row:i});
      $(d).append(a);    
    });

    $(d).hide();
    $(d).attr("id",selId+"_div");
    return d;
   }
  
   function ca(pam){
     var id = pam.id;
    
     var tbl = $("<table></table>");
     var trNode = $("<tr></tr>");
     var td = $("<td></td>");
    
     $(tbl).css("width","100%");
     $(tbl).css("cursor","hand");
     $(tbl).css("table-layout","fixed");
     $(tbl).css("font-size","12px");
    
     $(tbl).attr("cellSpacing","0");
     $(tbl).hover(function(){$(td).css("background","gainsboro")},function(){$(td).css("background","")});
    
     $(td).attr("value",pam.value);
     $(td).attr("innerText",pam.text);
     $(td).css("padding","2");
     $(td).css("height","20");
     if (pam.text.length * 12 > pam.width){
      $(td).attr("title",pam.text);
     }    
     $(td).css("white-space","nowrap");
     $(td).click(function(){
      $("#"+id+"_div").hide();
      $("#"+id)[0].selectedIndex = pam.row;
      $("#"+id+"_text").attr("value",pam.text);
      $("#"+id).change();
     });
    
     td.appendTo(trNode);
     trNode.appendTo(tbl);

     return tbl;
   } 