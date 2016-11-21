$( window ).load(function(){
        $('#test-btn').on('click', function(){
           $.ajax('/api/login/auth', {
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