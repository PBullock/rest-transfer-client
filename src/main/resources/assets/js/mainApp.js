$( window ).load(function(){

    window.bank_user = {};
        
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
                window.bank_user['Kunden_ID'] = response.Kunden_ID;
             },
        });
     });
	$('#update_btn').on('click', function(){
        $.ajax('', {
             type:"POST",
             data:getData('update-form'),
             success:function(response, status){
                    debugger;
             },
        });
     });
	$('#trans_btn').on('click', function(){
        $.ajax('/api/user/transfer', {
             type:"POST",
             data:getData('transfer-form'),
             success:function(response, status){
                debugger;
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

function show(pageClass, checkLogin){

    $('.content').hide();

    if(checkLogin && ! window.bank_user['Kunden_ID']) {
        $('#main_regist').show();
    } else {
        $('#'+pageClass).show();
    }


}