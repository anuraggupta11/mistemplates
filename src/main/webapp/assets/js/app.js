$( document ).ready(function() {
setupDropDown();
handleClickDropDownItem();

});


/* start of setup dropdown component 
search_dropdown is a class which is at input present in drop down div
 */
function setupDropDown(){
	$('.search_dropdown').unbind().keyup(function() {
		var search_term = $(this).val(); 
		//alert(search_term);
		$(this).parent().siblings('.dropdown-item').each(function (){
			
			if(search_term !== "" ){
				
			var options = $(this).html();
			if(options.trim().toLowerCase().indexOf(search_term.trim().toLowerCase()) > -1){
				log('matched '+options);
				
				$(this).show();
			}else{
				$(this).hide();
			}
			}else{
				$(this).show();
			}
		});
		});
}


/* end of setup dropdown component */



/* start of handling click on drop down item*/
function handleClickDropDownItem(){
	$('.dropdown-item').click(function (e){
		e.stopPropagation();		
		var find_div = $(this).find('.option-texts').find('svg');
		
			if(find_div.hasClass('white')){
				find_div.removeClass('white');
				find_div.css('color','red');
			}else{
				find_div.addClass('white');
			}
		
	});
}
/* end of handling click on drop down item*/


/* start of generic function for logging */
function log(message){
	console.log(message);
}
function error(message){
	console.error(message);
}

/* end of generic function for logging */

