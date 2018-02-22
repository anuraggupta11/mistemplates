$(document).ready(function() {
	ratingCourseCard();
	ratingCourseGroupInnercard();
	carouselForCorseInnerGroupCard();
	highChartForCourseReport();
	courseCardClick();
	
});


function ratingCourseCard(){
	 $('.rate-yo-roles-report').each(function(){
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
}
function ratingCourseGroupInnercard(){
	 $('.rate-roles-group-report').each(function(){
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
	
}
function carouselForCorseInnerGroupCard(){
	  $('.group-card-in-course').slick({
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
		  ]
		});
}
function highChartForCourseReport(){

	 Highcharts.setOptions({
	     colors: ['#fd6c81', '#7692ff', '#35bdf0', '#b8e986']
	    });
	  $('.pie-chart-course-report').each(function(){
		  var course_id=$(this).data('courseid');
		  var table_id= $(this).attr('id');;
		  var course_chart_container="container_course_"+course_id;
		  var h=$('#'+course_chart_container).height();
		  var w=$('#'+course_chart_container).width();
		  
			var charts = Highcharts.chart(course_chart_container, {
			    data: {
			        table: table_id
			    },
			    chart: {
			        type: 'pie',
			        margin: [0, 0, 0, 0],
			        padding : [0,0,0,0,],
			        spacingTop: 0,
			        spacingBottom: 0,
			        spacingLeft: 0,
			        spacingRight: 0,
			        plotBackgroundColor: null,
			        plotBorderWidth: null,
			        plotShadow: false
			      
			    },
			    title:null,	
			    tooltip: {
			        formatter: function () {
			            return '<b>' + this.series.name + '</b><br/>' +
			                this.point.y + ' ' + this.point.name.toLowerCase();
			        }
			    },
			    plotOptions: {
			        pie: {
			        	 size:'100%',
			        	 innerSize: 70,
			            allowPointSelect: true,
			            cursor: 'pointer',
			            dataLabels: {
			                enabled: false
			            },
			            showInLegend: true
			        }
			    },
			    exporting:{
			    	enabled: false
			    },

			    legend: {
			      enabled: true,
			      align: 'right',
			      verticalAlign: 'middle',
			      layout: 'vetical',
			      symbolRadius: 0,
			      useHTML: true,
			      labelFormatter: function() {
			        return '<div style="font: 0.8em sans-serif;padding:5px;">'+this.name.toUpperCase()+'</div>'
			      }
			    },
			    responsive: {
			        rules: [{
			            condition: {
			                maxWidth: 286
			            },
			            chartOptions: {
			                legend: {
			                	enabled: true,
							      align: 'bottom',
							      verticalAlign: 'bottom',
							      layout: 'horizontal',
							      symbolRadius: 0,
							      useHTML: true,
							      labelFormatter: function() {
							        return '<div style="font: 0.8em sans-serif;padding:5px;">'+this.name.toUpperCase()+'</div>'
							      }
			                }
			            }
			        }]
			    }
			});
	  });
	  setTimeout(function(){
		  $('.highcharts-credits').html('');
	  },500);
}
function courseCardClick(){
	$('.course-report-card-header').unbind().click(function(e){
		e.stopPropagation();	
		var course_id=$(this).data('courseid');
		location.href="individual_roles_report.jsp?course_id="+course_id;
	});
}