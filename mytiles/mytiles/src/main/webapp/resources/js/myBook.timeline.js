(function($) {

	MyBook.timeline = {

		bindAll : function() {
			this.loadTimeLineData();
		},
		loadTimeLineData:function(){
			$.ajax({
				url: "/timeline",
				type: 'GET',
				success: function (response)
				{
					debugger;
				}
			});
		}
		

	};

	$(document).ready(function() {
		MyBook.timeline.bindAll();
	});

}(jQuery));
