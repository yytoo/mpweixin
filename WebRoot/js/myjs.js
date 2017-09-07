function fileUpload(aBasePath){
		var type=$('#typeId').val();
		 alert(type),
			$.ajaxFileUpload({
				url:"https://85015021.qcloud.la/mpweixin/uploadImg",
				/*url:"uploadImg",*/
				secureuri:"false",
				fileElementId:"upload",
				dataType:"json",
				data:{
                        type:type,
                        },
                 
				success:function(data){		
					alert('success');

				 	
				}
			});
		}