$( window ).load(function(){
        $('#test-btn').on('click', function(){
           $.ajax('/api/register/user', {
                type:"POST",
                data:getData(),
                success:function(response, status){
                    var list = $('<ul></ul>');
                   for(var key in response){
                       console.log(key, response[key]);
                       $(list).append($('<li>'+key+ '::' + response[key]+'</li>'));
                   }

                   $('#user-container').append(list);
                },

           });
        });
    });

function getData(){

    var form = $('form.register-form');
    var data = form.serialize();
    var dataArr = form.serializeArray();

    return data;

}