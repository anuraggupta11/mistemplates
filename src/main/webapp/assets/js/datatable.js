
$( document ).ready(function() {
drawTable();
});


function drawTable(){
	$('.datatable_container').each(function(){
		var data_table_id = $(this).attr('id')+'_datatable';
		afterDrawtable(data_table_id);
		log('hello');
	});
	
}




function afterDrawtable(data_table_id){
	var show_entries = $('#'+data_table_id).find('.datatable_select');
	var search = $('#'+data_table_id).find('.datatablesearch');
	var pagination = $('#'+data_table_id).find('.page-selection');
	var table = $('#'+data_table_id).find('table');
	setupHeaderClick(table);
	setupSearch(table,search);
	setupShowEntries(table,show_entries);
	setupPagination(table,pagination);
	setUpColumnDropDown(data_table_id,table);

}


function setUpColumnDropDown(data_table_id,table){
	$('#'+data_table_id).find('.datatablecolumnsearch').unbind().each(function(){
		$(this).change(function(){
			
			var selected_value= $(this).val();
			var column_name = $(this).attr('data-column');
			log('selected value: '+selected_value+' for column: '+column_name);
			
		});
	});
	
}


function setupHeaderClick(table){

	if(table.attr('data-sorting') === 'true'){
	$("thead > tr > th", table).unbind().click(function() {
		$(this).removeClass('default');

		var thead_column=$(this);
		if($(this).attr('data-sort').indexOf('desc') > -1){
			$(this).attr('data-sort','asc');
			$(this).removeClass('desc');
			$(this).addClass('asc');
		}else{
			$(this).attr('data-sort','desc');
			$(this).addClass('desc');
			$(this).removeClass('asc');
		}
		
		fetchJsonFromServer(table,table.attr('data-page'));
	});

	
	
	}
	
	
	$("tbody> tr > td", table).unbind().click(function() {
		var column_name = $(this).parent().parent().siblings('thead').children().children()[$(this).index()];
		log('clicked '+column_name.textContent +' value --> '+$(this).html());
	});
	

}

function setupSearch(table,search){
	search.unbind().keyup(function () {
		log($(this).val());
		table.attr('data-searchterm',$(this).val());
		fetchJsonFromServer(table,table.attr('data-page'));
	});

}


function setupShowEntries(table,show_entries){
	show_entries.unbind().change(function(){
		log($(this).val());
		table.attr('data-showentries',$(this).val());
		fetchJsonFromServer(table,table.attr('data-page'));
	});
}

function setupPagination(table,pagination){
	
	var total_count = table.data('total_count');
	var showentries = table.attr('data-showentries');
	var nums = table.data('page');

	log(total_count);
	pagination.bootpag({
	    total:Math.ceil(total_count/showentries),
	    maxVisible: 10,
	    firstLastUse: true,
	    first: '←',
	    last: '→',
	    page:nums
	}).unbind().on("page", function(event, /* page number here */ num){
		fetchJsonFromServer(table,num);		
		});
	
	$('.page-selection li').addClass('page-item');
	$('.page-selection a').addClass('page-link');
}

function fetchJsonFromServer(table,num){
	var current_offset = table.attr('data-showentries')*(num-1);
	var colmun_search_field = $('.datatablecolumnsearch').val();
	
	
	if(current_offset >table.attr('data-total_count')  ){
		current_offset = (Math.floor(table.attr('data-total_count')/table.attr('data-showentries')))*table.attr('data-showentries');
	}
	
	var arr = {};
	$("thead > tr > th", table).each(function(){
		arr[$(this).text()]=$(this).attr('data-sort');
	});
	console.log(arr);

	
	var url = table.data('url')+'?limit='+table.attr('data-showentries')+"&offset="+current_offset
				+"&showentries="+table.attr('data-showentries')+"&searchterm="
				+table.attr('data-searchterm')+"&colmun_search_field="+colmun_search_field
				
	$('.loading').show();
	$.post(url, {sorted:JSON.stringify(arr)},function( data ) {
		var id = $(data).find('table').data('id')+'_datatable';

		var new_node = $.parseHTML( data );
		$('#'+id).replaceWith(new_node);
		$('#'+id).find('table').attr('data-page',num);
		$('#'+id).find('.datatable_select').val( $(data).find('table').attr('data-showentries'));
		$('#'+id).find('.datatablecolumnsearch').val( $(data).find('table').attr('data-colmun_search_field'));

		if($(data).find('table').attr('data-searchterm') !== ""){
		$('#'+id).find('.datatablesearch').val($(data).find('table').attr('data-searchterm'));
		$('#'+id).find('.datatablesearch').focus();
		}
		
		
		
$("thead > tr > th", $('#'+id).find('table')).each(function() {
			
			if($(this).attr('data-sort').indexOf('desc') > -1){
				$(this).removeClass('default');
				$(this).addClass('desc');
			}else if($(this).attr('data-sort').indexOf('asc') > -1){
				$(this).removeClass('default');
				$(this).addClass('asc');
			}
		});
		
		
		afterDrawtable(id);
	    setTimeout(function(){
			$('.loading').hide();

	    },300);


	});

}



















