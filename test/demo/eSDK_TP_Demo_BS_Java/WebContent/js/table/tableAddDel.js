var row_count = 0;
function addNew()
{
var table1 = $('#table1');
var firstTr = table1.find('tbody>tr:first');
var row = $("<tr></tr>");
var td = $("<td></td>");
td.append($("<input type='checkbox' name='count' value='New'><b>CheckBox"+row_count+"</b>")
);
row.append(td);
table1.append(row);
row_count++;
}
function del()
{
var checked = $("input[type='checkbox'][name='count']");
$(checked).each(function(){
if($(this).attr("checked")) //注意：此处判断不能用$(this).attr("checked")==‘true'来判断。
{
$(this).parent().parent().remove();
}
});
}