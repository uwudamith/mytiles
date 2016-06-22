
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
	
	$(".projectUsers").click(function(e){
	    e.preventDefault();//this will prevent the link trying to navigate to another page
	    var href = $(this).attr("href");//get the href so we can navigate later
		
	    $("#hdnPage").val(parseInt($(this).data("page")) -1 );
		$("#hdnSize").val($(this).data("size"));
	    
	    var username = $("#txtUserName").val();
	    if(username){
	    	href = href.concat("&username="+username);
	    }

	    //when update has finished, navigate to the other page
	    //window.location = href;
	    $(".project-users-form").submit();
	});
	
	$(".remove-userd").click(function(e){
		e.preventDefault();
		// Set the remove user flag
		$("#hdnRemoveUser").val(true);
		$("#hdnUserId").val($(this).data("userid"));
		// Submit the form
	     //$(".project-users-form").submit();
	  });
	
	$(".add-user").click(function(e){
		// Set the remove user flag
		$("#hdnAddUser").val(true);
		$("#hdnUserId").val($(this).data("userid"));
		// Submit the form
	     $(".project-users-form").submit();
	  });
	
	$(".btn-ok").click(function(e){
		$(".project-users-form").submit();
	});

});
