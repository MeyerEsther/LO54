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
            { data: "location.city" },
            { data: "id" }
        ],
         columnDefs:[
            {
               targets:[1, 2], render:function(data)
                {
                    return $.format.date(data, "yyyy-MM-dd HH:mm:ss")
                }
            },
            {
               targets:[4], render:function(data)
                {
                    return "Subscribe <a data-toggle='modal' data-target='#subscribeModal' id='key' href='' course-name-id='my_id_value'>here</a>"
                }
            }
],
        select: true
    } );
    
    var table = $('#dataTable').DataTable();
 
    $('#dataTable tbody').on( 'click', 'a', function () {
        var row = table.row( $(this).parents('tr') ).data();
        console.log(row)
        $("#course_session_id").val(row['course']['id']);
        $("#course_name").text(row['course']['title']);
        $("#course_start_date").html("<b>" + $.format.date(row['startDate'], "yyyy-MM-dd HH:mm:ss") + "</b>");
        $("#course_end_date").html("<b>" + $.format.date(row['endDate'], "yyyy-MM-dd HH:mm:ss") + "</b>");
        $("#course_location").text(row['location']['city']);
    } );
    
    
    $( "#confirm_subscription" ).click(function() {
        var res = {
            course_session_id: $("#course_session_id").val(),
            firstname: $("#firstname").val(),
            lastname: $("#lastname").val(),
            email: $("#email").val(),
            phone: $("#phone").val(),
            address: $("#address").val()
        };
         $.ajax({
            type: "POST",
            //the url where you want to sent the userName and password to
            url: localStorage.getItem('url_api') + 'clients/subscribe/',
            dataType: 'json',
            async: false,
            headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json' 
            },
            data: JSON.stringify(res),
            success: function () {
                $('#subscribeModal').modal('toggle');
                $('#success_modal').modal('show');
            }
        })
    });
});



$.getJSON(localStorage.getItem('url_api') + 'locations/list', function(locations) {
    locations.forEach(function(location){
       $('#location_filter').append('<option value=' + location['id'] + '>' + location['city'] + '</option>');
    });
});