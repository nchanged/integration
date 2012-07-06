window.jcube = {}


window.jcube.form = function( element, callback ){

	element.find('.submit').click(function(){
		
		var values = {};
		var action = element.attr("action");
		$(".pinched").remove();
		
		element.find("input[type='text'],input[type='hidden'],input[type='checkbox'],input[type='password'],textarea,select,input[type='radio']:checked").each(function(){
			var name = $(this).attr("name");
			var ck_editor = $(this).hasClass("ckeditor")
			if (ck_editor) 
			{
				var p = $(this).parents(".item").find(".cke_contents").find("iframe");
				
				values[name] = p.contents().find("body").html();
				
				
			}
			else 
			{
				if ($(this).attr("type") == "checkbox") 
				{
				
					values[name] = $(this).attr("checked") ? true : false
				}
				else 
					values[name] = $(this).val();
			}
		});
		
		
		$.post(action, values, function(e){
			if (e && e.code ) {
				if (e.code < 0) 
				{
					for (form_key in e.message) 
					{
						var o = element.find("*[name=" + form_key + "]");
						var tip = $(document.createElement("div")).addClass("pinched");
						tip.html(e.message[form_key].error)
						tip.hide();
					//	o.parents(".item").addClass("error")
						
						tip.insertAfter(o);
						tip.fadeIn();
					}
				}
				
			} else {
				callback(e);
			}
		},"json");
		return false;
	});
}
	
	

