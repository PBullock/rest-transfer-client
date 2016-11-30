$( window ).load(function(){
        $('#test-btn').on('click', function(){
           $.ajax('/api/register/user', {
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