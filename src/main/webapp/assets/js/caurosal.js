$( document ).ready(function() {
	
	$('.rating_star').each(function(){
		var rating,starwidth;
		rating = $(this).data('rating');
		starwidth = $(this).data('star_width');
		if( (rating > 5 || rating < 0)){
			rating = 0;
		}
		log(rating);
		$(this).rateYo({
		    rating: 3.6,
		    starWidth: starwidth+'px'
		  });
		
	});
	
	
	
	$('.multiple-items').slick({
		  infinite: false,
		  slidesToShow: 3,
		  slidesToScroll: 3,
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
			        slidesToShow: 1,
			        slidesToScroll: 1
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
	
});