
$(document).ready(function() {
	var eventDate = $(".add-event-form").find(".input-group.date");
	if (eventDate) {
		$('.input-group.date').datepicker({});
	}

	$('#confirm-delete').on('show.bs.modal', function(e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
        
        $('.proj-name').html('<strong>' + $(e.relatedTarget).data('project') + '</strong>');
    });
	
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
