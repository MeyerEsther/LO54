var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};

$('#date_filter').datepicker({
  format: "yyyy-mm-dd"
});

filter = false;

// Call the dataTables jQuery plugin
$(document).ready(function() {
   
  var api_url = localStorage.getItem('url_api') + 'sessions/list';
  
  if(getUrlParameter("location")) {
      api_url = localStorage.getItem('url_api') + 'sessions/location/' + getUrlParameter("location");
  } else if (getUrlParameter("date")) {
      api_url = localStorage.getItem('url_api') + 'sessions/date/' + getUrlParameter("date");
  } else if (getUrlParameter("search")) {
      api_url = localStorage.getItem('url_api') + 'sessions/search/' + getUrlParameter("search");
  }
 
  $('#dataTable').DataTable( {
        ajax: {
            url: api_url,
            type: 'GET',
            dataSrc: ''
        },
        columns: [
            { data: "course.title" },
            { data: "startDate" },
            { data: "endDate" },
            { data: "location.city" }
        ],
         columnDefs:[
            {
               targets:[1, 2], render:function(data)
                {
                    return $.format.date(data, "yyyy-MM-dd HH:mm:ss")
                }
            }
],
        select: true
    } );
});

$.getJSON(localStorage.getItem('url_api') + 'locations/list', function(locations) {
    locations.forEach(function(location){
       $('#location_filter').append('<option value=' + location['id'] + '>' + location['city'] + '</option>');
    });
});