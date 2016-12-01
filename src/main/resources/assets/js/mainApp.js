$( window ).load(function(){
        
	$('#regist_btn').on('click', function(){
	    $('.error-message-container').hide();
           $.ajax('/api/register/user', {
                type:"POST",
                data:getData('register-form'),
                success:function(response, status){
                   $('#user-container').html(response.Vorname+ ' ' + response.Nachname);
                },
                statusCode:{
                418: function(){
                    $('.error-message-container').show();
                    }
                }
           });
        });
	
	$('#log_btn').on('click', function(){
        $.ajax('/api/login/auth', {
             type:"POST",
             data:getData('login-form'),
             success:function(response, status){
                $('#user-container').html(response.Vorname+ ' ' + response.Nachname);
             },
        });
     });
	$('#update_btn').on('click', function(){
        $.ajax('', {
             type:"POST",
             data:getData(),
             success:function(response, status){
                $('#user-container').html(response.Vorname+ ' ' + response.Nachname);
             },
        });
     });
	$('#trans_btn').on('click', function(){
        $.ajax('', {
             type:"POST",
             data:getData('transfer-form'),
             success:function(response, status){
                $('#user-container').html(response.Vorname+ ' ' + response.Nachname);
             },
        });
     });
    });

function getData(form_id){
    var form = $('form.register-form');
    if(form_id) {
        form = $('form#' + form_id)
    }
    var data = form.serialize();
    //var dataArr = form.serializeArray();

    return data;

}

function show(pageClass){
	$('.content').hide();
	$('#'+pageClass).show();
	
}