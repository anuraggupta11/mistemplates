$(document).ready(function(){
	
	$('.rating-groups-report').each(function(){
		  var groupfeedback,starwidth;
		  groupfeedback = $(this).data('groupfeedback');
			if( (groupfeedback > 5 || groupfeedback < 0)){
				groupfeedback = 0;
			}
			$(this).rateYo({
			    rating: groupfeedback,
			    starWidth: 14+'px',
			    readOnly: true
			  });
	  });
	 
	  $('.rate-group-roles-report').each(function(){
		  var coursefeedback,starwidth;
		  coursefeedback = $(this).data('coursefeedback');
			if( (coursefeedback > 5 || coursefeedback < 0)){
				coursefeedback = 0;
			}
			$(this).rateYo({
			    rating: coursefeedback,
			    starWidth: 14+'px',
			    readOnly: true
			  });
	  });
	  
	  $('.course-card-in-group').slick({
		  infinite: false,
		  slidesToShow: 4,
		  slidesToScroll: 4,
		  centerMode: false,
		  responsive: [
		    {
		      breakpoint: 1024,
		      settings: {
		        slidesToShow: 3,
		        slidesToScroll: 3,
		        infinite: true,
		        dots: true
		      }
		    },
		    {
		      breakpoint: 600,
		      settings: {
		        slidesToShow: 2,
		        slidesToScroll: 2
		      }
		    },
		    {
		      breakpoint: 480,
		      settings: {
		        slidesToShow: 1,
		        slidesToScroll: 1
		      }
		    }
		    // You can unslick at a given breakpoint now by adding:
		    // settings: "unslick"
		    // instead of a settings object
		  ]
		});
	  
	  
	  $('.group-report-cards-header').unbind().click(function(e){
		  e.stopPropagation();
		  var group_id=$(this).data('groupid');
			location.href="individual_groups_report.jsp?group_id="+group_id;
	  })
	
})
	  