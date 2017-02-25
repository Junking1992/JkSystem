$('#form1').form({
		success:function(data){
			console.log('form1.data:',data);
			//解析json
			var datas = eval(data);
			if(datas == undefined){
				return;
			}
			
			$('#tt').datagrid('appendRow',{
				value1 : datas[0].value1,
				value2 : datas[0].value2,
				value3 : datas[0].value3
			});
			
			$('#tt').datagrid('appendRow',{
				value1 : datas[1].value1,
				value2 : datas[1].value2,
				value3 : datas[1].value3
			});
		}
});

function submit(id){
	$('#' + id).submit();
}