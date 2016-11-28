$( window ).load(function(){
        $('#test-btn').on('click', function(){
           $.ajax('/api/register/user', {
                type:"POST",
                data:{"name":"test1", "first_name":"test2"},
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