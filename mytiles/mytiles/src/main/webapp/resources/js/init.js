$(document).ready(function(){
	var eventDate = $(".add-event-form").find(".input-group.date");
	if(eventDate){
		$('.input-group.date').datepicker({});
	}
});
