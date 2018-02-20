$(document).ready(function(){
	ajaxifySearchInput();
	scanButtonClick();
	createGroupSubmit();
	
	
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
			    	
			    	if( res.data[0].message !=undefined &&  res.data[0].message !='' &&  res.data[0].message != null ){
		        		//alert("message "+ item.message);
		        		 $(".alert").addClass("create-group-alert").addClass("show").fadeIn(500 , function() {
		        				$('.alert').children().remove();
		        				 $(".alert").append(" <span class='alert-message-custom'>"+res.data[0].message+"</span>");
		        				 setTimeout(function(){ 
		        						$(".alert").removeClass('show');
		        				 }, 2000);
		        	     });
		        		
		        	}else{ 
		        		   $('#scanSkillModal').modal('show');
		        		   $('#scanSkillModalBodyId').children('.btn').remove();
		        	      res.data.forEach(function(item){
		        	    	  
		        	    	  if($(".alert").hasClass('show')){
		        	    			$(".alert").removeClass('show');
		        	    		}
		        	    	  
					        	
					        		if(item.type == 'COURSE'){
						        		 $('#scanSkillModalBodyId').append("<button type='button'	class='btn btn-outline-secondary btn-sm gray-text p-2 ml-2 mt-2' data-skilltype='"+item.type+"' data-courseid='"+item.id+"'> "+item.name+"</button>");
						        	}
					        		  skillSelectClick();
					        	
					        });
		        	}
			     
			  
			      
			    }
			});			
		}else{
			$('#skillValdationId').show()	
		}
	});
}

function skillSelectClick(){
	var add_Skill=[];
	$("#scanSkillModalBodyId >.btn").unbind().click(function(e){
		e.stopPropagation();
		var select_skill=$(this);
		if(select_skill.hasClass('show')){
			select_skill.removeClass('btn-outline-secondary').removeClass('gray-text').addClass('btn-outline-danger');
			var skill_obj={
					id : $(this).data('courseid'),
					name : select_skill.text(),
					type : $(this).data('skilltype')
					
			};
			
			add_Skill.push(skill_obj);
			
		}
		else if(select_skill.hasClass('show')){
			select_skill.removeClass('btn-outline-danger').addClass('btn-outline-secondary').addClass('gray-text');
			
		} 
	});
	$('#addSkillBtnId').unbind().click(function(e){
		e.stopPropagation();
		$('#scanSkillModalBodyId').children('.btn').remove();
		$('#scanSkillModal').modal('hide');
			
			
			add_Skill.forEach(function(item){
				var isFound=false;
				
				var listSkills=$('#exampleSkill>.btn');
				listSkills.each(function() {
					if($(this).data('skilltype') == 'COURSE' && item.id == $(this).data('courseid')){
						isFound =true;
						return false;
					}
				});
							
				if(!isFound){
					$('#exampleSkill').append("	<button type='button'	class='btn btn-outline-danger btn-sm p-2 ml-2 mt-2' data-skilltype='"+item.type+"' data-courseid='"+item.id+"'> "+item.name+"<span class='selected-skill-cross'><i class='fas fa-times ml-2'></i> </span></button>");
				}
				
			});
			removeSkill();
	 
		
		
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
						if(item.type == 'COURSE'){
							$('#ajaxdropdownid').append("<div class='dropdown-item' value='"+item.name+"' data-skilltype='"+item.type+"' data-courseid='"+item.id+"'>"+item.name+"</div>");
						}else if(item.type == 'SKILL'){
							$('#ajaxdropdownid').append("<div class='dropdown-item' value='"+item.name+"' data-skilltype='"+item.type+"'>"+item.name+"</div>");							
						}
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
		var item = $(this).attr('value').trim();
		if(item != undefined && item != ''){
			var skilltype=$(this).data('skilltype');
			var course_id
			log(skilltype);
			if(skilltype == 'COURSE'){
				 course_id=$(this).data('courseid');
			}
			
			/* Compare skill in already selected */	
			var isFound=false;
			var listSkills=$('#exampleSkill>.btn');
			listSkills.each(function() {
				if($(this).data('skilltype') == 'COURSE' && course_id == $(this).data('courseid')){
					//alert("already exist course");
					 $(".alert").addClass("create-group-alert").addClass("show").fadeIn(500 , function() {
	        				$('.alert').children().remove();
	        				 $(".alert").append(" <span class='alert-message-custom'>already selected course</span>");
	        				 setTimeout(function(){ 
	        						$(".alert").removeClass('show');
	        				 }, 2000);
	        	     });
					isFound =true;
					return false;
				}else if($(this).data('skilltype') == 'SKILL' && item == $(this).text().trim()){
					//alert("already exist skill");
					 $(".alert").addClass("create-group-alert").addClass("show").fadeIn(500 , function() {
	        				$('.alert').children().remove();
	        				 $(".alert").append(" <span class='alert-message-custom'>already selected skill</span>");
	        				 setTimeout(function(){ 
	        						$(".alert").removeClass('show');
	        				 }, 2000);
	        	     });
					isFound =true;
					return false;
				}
			});
			
			if(!isFound){
				 if($(".alert").hasClass('show')){
 	    			$(".alert").removeClass('show');
 	    		}
 	    	  
				if(skilltype == 'COURSE'){
					$('#exampleSkill').append("	<button type='button'	class='btn btn-outline-danger btn-sm  p-2 ml-2 mt-2' data-skilltype='"+skilltype+"' data-courseid='"+course_id+"'> "+item+"<span class='selected-skill-cross'><i class='fas fa-times ml-2'></i></span> </button>");
				}else if(skilltype == 'SKILL'){
					$('#exampleSkill').append("	<button type='button'	class='btn btn-outline-info btn-sm  p-2 ml-2 mt-2' data-skilltype='"+skilltype+"'> "+item+"<span class='selected-skill-cross'><i class='fas fa-times ml-2'></i></span> </button>");
				}
				
			}
			
			
			
			removeSkill();
				
		}	
	})
}

function removeSkill(){
	$('#exampleSkill> .btn > .selected-skill-cross').unbind().click(function(e){
		$(this).parent().remove();
	});
	
}

function createGroupSubmit(){
	
 
	$('#createGroupBtnId').unbind().click(function(e){
		e.stopPropagation();
		
		
		$( "#createGroupFormId" ).unbind().submit(function(e) {
			e.stopPropagation();
			e.preventDefault();
			var allSkills=[];
			var group_Name=$('#groupName').val();
			var group_Type=$('#groupType').val();
			var listSkills=$('#exampleSkill>.btn');
			listSkills.each(function() {
				var skill_name=$(this).text().trim();
				var skill_type=$(this).data('skilltype');
				if(skill_type == 'COURSE'){
					var skill_obj={
							id : $(this).data('courseid'),
							title : skill_name,
							type : skill_type
					};
					
				}else if(skill_type == 'SKILL'){
					var skill_obj={
							title : skill_name,
							type : skill_type
					};
				}
				allSkills.push(skill_obj);
			});
		 
			var group_obj = {
					name : group_Name,
					type : group_Type,
					skills : allSkills
				};
			var group_object = $.param({
				group_object : JSON.stringify(group_obj)
			});
			$.ajax({
			    type: 'POST',
			    url: 'http://192.168.1.13:8080/istar/rest/group/create/3',
			    data:group_object,
			    success: function(res){
			       //alert("sucess");	
			    	
			    	 $(".alert").addClass("create-group-alert").addClass("show").fadeIn(500 , function() {
	        				$('.alert').children().remove();
	        				 $(".alert").append(" <span class='alert-message-custom'>"+res.message+"</span>");
	        				 setTimeout(function(){ 
	        						$(".alert").removeClass('show');
	        				 }, 3000);
	        	     });
			    	
			       $('#createGroupFormId').trigger("reset");
			       $('#exampleSkill').children('.btn').remove();
			    }
			});	
			
			
			
			
			});

			
	});
	
}

function log(message){
	console.log(message);
}
function error(message){
	console.error(message);
}	