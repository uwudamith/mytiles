
$(document).ready(function() {
	var eventDate = $(".add-event-form").find(".input-group.date");
	if (eventDate) {
		$('.input-group.date').datepicker({});
	}

/*	$(window).scroll(function() {
	    if($(window).scrollTop() == $(document).height() - $(window).height()) {
	    	$.ajax({
				url: "/timelineItems",
				type: 'GET',
				success: function (response)
				{
					$("#jobs-container").append(response);
				}
			});
	    }
	});*/
	
	
});
