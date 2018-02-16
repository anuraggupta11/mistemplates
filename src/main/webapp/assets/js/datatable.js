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
		var thead_column=$(this);
		if($(this).attr('data-val').indexOf('desc') > -1){
			var index = $(this).attr('data-val').indexOf('desc');
			var temp = $(this).attr('data-val').substring(0,index-1);
			$(this).attr('data-val',temp+' asc');
			$(this).removeClass('afteractive');
			$(this).addClass('active');
		}else{
			$(this).attr('data-val',$(this).data('val')+' desc');
			$(this).addClass('afteractive');
			$(this).removeClass('active');
		}
	});
	}
}

function setupSearch(table,search){
	search.unbind().keyup(function () {
		log($(this).val());
		table.attr('data-searchterm',$(this).val());
		fetchJsonFromServer(table,$(this).val());
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
	if(current_offset >table.attr('data-total_count')  ){
		current_offset = (Math.floor(table.attr('data-total_count')/table.attr('data-showentries')))*table.attr('data-showentries');
	}
	var url = table.data('url')+'?limit='+table.attr('data-showentries')+"&offset="+current_offset+"&showentries="+table.attr('data-showentries')+"&searchterm="+table.attr('data-searchterm');
	$('.loading').show();
	$.post(url, function( data ) {
		var id = $(data).find('table').data('id')+'_datatable';
		
		var new_node = $.parseHTML( data );
		$('#'+id).replaceWith(new_node);
		$('#'+id).find('table').attr('data-page',num);
		$('#'+id).find('.datatable_select').val( $(data).find('table').attr('data-showentries'));
		
		if($(data).find('table').attr('data-searchterm') !== ""){
		$('#'+id).find('.datatablesearch').val($(data).find('table').attr('data-searchterm'));
		$('#'+id).find('.datatablesearch').focus();
		}
		afterDrawtable(id);
	    setTimeout(function(){
			$('.loading').hide();

	    },300);


	});

}



















