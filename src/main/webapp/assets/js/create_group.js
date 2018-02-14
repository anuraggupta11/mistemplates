$(document).ready(function(){
	ajaxifySearchInput();
	scanButtonClick();
	
	
});

function scanButtonClick(){
	$('#scanSkillBtn').unbind().click(function(e){
		e.stopPropagation();
		var skill_str=$('#scanSkilTextarea').val().trim();
		if(skill_str != undefined && skill_str !=''){
			$('#skillValdationId').hide();
			var SkillObject = {
					skills : skill_str
				};
			var skill_object = $.param({
				skill_object : JSON.stringify(SkillObject)
			});
			
			$.ajax({
			    type: 'POST',
			    url: 'http://192.168.1.13:8080/istar/rest/group/skills/3',
			    data:skill_object,
			    success: function(res){
			        $('#scanSkillModal').modal('show')
			        res.data.forEach(function(item){
			        	 $('#scanSkillModalBodyId').append("<button type='button'	class='btn btn-outline-secondary btn-sm gray-text p-2 ml-2 mt-2'> "+item.name+"</button>");
			        });
			        skillSelectClick();
			    }
			});			
		}else{
			$('#skillValdationId').show()	
		}
	});
}

function skillSelectClick(){
	$("#scanSkillModalBodyId >.btn").unbind().click(function(){
		var select_skill=$(this);
		if(select_skill.hasClass('btn-outline-secondary')){
			select_skill.removeClass('btn-outline-secondary').removeClass('gray-text').addClass('btn-outline-danger');
			
		}
		else if(select_skill.hasClass('btn-outline-danger')){
			select_skill.removeClass('btn-outline-danger').addClass('btn-outline-secondary').addClass('gray-text');
		}
		
		 
	});
}

function ajaxifySearchInput(){
	$('.ajaxifySearchInput').keyup(function() {
		$('#ajax_dropdown_hidden_btn').trigger('click')
		$('.dropdown-toggle').dropdown()
		var search_skill_val=$(this).val();
		if(search_skill_val != undefined && search_skill_val !=''){
			$.get( "http://192.168.1.13:8080/istar/rest/group/skills/"+search_skill_val+"/3", function( data ) {
				$('#ajaxdropdownid').children('.dropdown-item').remove();
				data.data.forEach(function(item){
					if(item.name !== undefined && item.name !== ''){
						$('#ajaxdropdownid').append("<div class='dropdown-item' value='"+item.name+"' data-skilltype='"+item.type+"'>"+item.name+"</div>");	
					}			    
					else{
						$('#ajaxdropdownid').append("<div class='dropdown-item text-danger'  value=''>"+item.message+"</div>");	
					}
					ajaxifyClick();	
				});
				});
			
		}
		
	});
}

function ajaxifyClick(){
	$('.ajaxdropdown>.dropdown-item').unbind().click(function(e){
		e.stopPropagation();
		var item = $(this).attr('value');
		if(item != undefined && item != ''){
			var skilltype=$(this).data('skilltype');
			log(skilltype);
		$('#exampleSkill').append("	<button type='button'	class='btn btn-outline-secondary btn-sm white-bg gray-text p-2 ml-2 mt-2' data-skilltype='"+skilltype+"'> "+item+"<i class='fas fa-times ml-2'></i> </button>");
		}	
	})
}

function createGroupSubmit(){
	
}

function log(message){
	console.log(message);
}
function error(message){
	console.error(message);
}