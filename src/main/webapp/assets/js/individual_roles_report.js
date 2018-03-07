$(document).ready(function(){
	moduleExpandClick();
	
})
function moduleExpandClick(){
	$('.module-click-expand').unbind().click(function(e){
		//e.stopPropagation();	
		var module_expand=$(this);
		if(module_expand.hasClass('fa-plus-circle')){
			module_expand.removeClass('fa-plus-circle').addClass('fa-minus-circle');
		}else{
			module_expand.removeClass('fa-minus-circle').addClass('fa-plus-circle');
		}
	
	})
}