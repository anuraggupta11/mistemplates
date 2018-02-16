$( document ).ready(function() {
 
 
resetSearchBox();
setTimeout(equalheights,500);
<<<<<<< HEAD

page_Selection(undefined,undefined);

handleChangeEvent();

function handleChangeEvent(){
	$(".datatable_select").unbind().change(function(){
		var selected_value = $(this).val();
		var temp_url= $(this).parent().parent().parent().find('table').data('url');
		var limit = $(this).parent().parent().parent().find('table').data('limit');
		var offset =  $(this).parent().parent().parent().find('table').data('offset');
		
		var url = temp_url+'?limit='+selected_value+'&offset='+offset;
		log(url);

		$.post(url, function( data ) {
			var total_count = $(data).find('table').data('total_count');
			var id = $(data).find('table').data('id');
			$('#'+(id+'_datatable')).replaceWith( data );
			
			page_Selection(total_count,(offset/limit+1));
			
		});
		
			
	});
}


function page_Selection(totalcounts,page){

	$('.page-selection').unbind().each(function(){	
		var url = $(this).siblings("table").data('url');
		
		var total_count,num;
		if(totalcounts!== undefined || totalcounts === '' ){
			total_count = totalcounts;
		}else{
			total_count = $(this).siblings("table").data('total_count');
		}
		if(page!== undefined || page === '' ){
			num = page;
		}else{
			num = 1;
		}
		
		
		var limit = $(this).siblings("table").data('limit');
		var mybootpag = $(this);
		$(this).bootpag({
		    total: total_count/10,
		    maxVisible: 10,
		    firstLastUse: true,
		    first: '←',
		    last: '→',
		    page: num
		}).unbind().on("page", function(event, /* page number here */ num){
			var current = $(this);
			handlePaginatedDatable(current,mybootpag,num);
			
			
			});
	});
	$('.page-selection li').addClass('page-item');
	$('.page-selection a').addClass('page-link');
}


function handlePaginatedDatable(current,mybootpag,num){
	var limit = current.siblings("table").data('limit');	
	var offset = (num-1) * limit;	
	var url = current.siblings("table").data('url')+"?limit="+limit+"&offset="+offset;
	log(url);
	$.post(url, function( data ) {
		var total_count = $(data).find('table').data('total_count');
		var id = $(data).find('table').data('id');
		$('#'+(id+'_datatable')).replaceWith( data );
		
		page_Selection(total_count,num);
		handleChangeEvent();
	});
}


=======
readMoreReadLessByClass();
>>>>>>> branch 'master' of https://github.com/anuraggupta11/mistemplates.git
});





/* start of setup dropdown component 
search_dropdown is a class which is at input present in drop down div
 */
<<<<<<< HEAD
 
=======
function setupDropDown(){
	$('.search_dropdown').unbind().keyup(function() {
		var search_term = $(this).val(); 
		//alert(search_term);
		iterate_drop_down($(this),search_term);
		});
}


function iterate_drop_down(search_elem,search_term ){
	$(search_elem).parent().siblings('.dropdown-item').each(function (){
		
		if(search_term !== "" ){
			
		var options = $(this).find('.option-texts').text();
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
	
}

>>>>>>> branch 'master' of https://github.com/anuraggupta11/mistemplates.git

function resetSearchBox(){
	$('.viksitdropdown').unbind().on('show.bs.dropdown', function () {
		  // do something…
		$('.search_dropdown').val('');
		$('.dropdown-item').each(function (){
			$(this).show();
		});
		});
	
}



/* end of setup dropdown component */



/* start of handling click on drop down item*/
 
 
/* end of handling click on drop down item*/


/* start of generic function for logging */
function log(message){
	console.log(message);
}
function error(message){
	console.error(message);
}

/* end of generic function for logging */
/* start of generic function for equal heights */
function equalheights(){
	var max_height=0;
	$('.equal_heights').each(function(){
		if($(this).height() > max_height){
			max_height = $(this).height() ;
			max_height =max_height;
		}
		
	});
	$('.equal_heights').each(function(){
		$(this).css('min-height',max_height);
		$(this).css('max-height',max_height);

	});
	
}
/* end of generic function for equal heights */
 
 