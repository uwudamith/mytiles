
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
	
	var test = function(e){
		e.preventDefault();
		var page = $(this).data("page");
		var size = $(this).data("size");
		
		$("#hdnPage").val(page);
		$("#hdnSize").val(size);
		
		debugger;
		
		return true;
	};
	
	$(".projectUsers").click(function(e){
	    e.preventDefault();//this will prevent the link trying to navigate to another page
	    var href = $(this).attr("href");//get the href so we can navigate later

	    var username = $("#txtUserName").val();
	    if(username){
	    	href = href.concat("&username="+username);
	    }

	    //when update has finished, navigate to the other page
	    window.location = href;
	});

});
