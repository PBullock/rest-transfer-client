$( window ).load(function(){
        
	$('#regist_btn').on('click', function(){
           $.ajax('/api/register/user', {
                type:"POST",
                data:getData(),
                success:function(response, status){
                   $('#user-container').html(response.Vorname+ ' ' + response.Nachname);
                },
           });
        });
	
	$('#log_btn').on('click', function(){
        $.ajax('', {
             type:"POST",
             data:getData(),
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
             data:getData(),
             success:function(response, status){
                $('#user-container').html(response.Vorname+ ' ' + response.Nachname);
             },
        });
     });
    });

function getData(){
    var form = $('form.register-form');
    var data = form.serialize();
    //var dataArr = form.serializeArray();

    return data;

}

function show(pageClass){
	$('.content').hide();
	$('#'+pageClass).show();
	
}