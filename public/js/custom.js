function confirmDel() {
  return confirm('Are you sure?');
}




        $("#registration").validate({
            rules: {
              username: "required",

              password: "required",

              password2: {
                 required: true,
                 equalTo: "#password"},

              email: {
                  required: true,
                  email: true,
                  remote: {
                      url: "/finduser",
                      type: "get",
                      data: {
                          email: function() {
                              return $( "#email" ).val();
                          }
                      }

                  }
              }

            },


            messages: {
                password: "Please enter the password",

                username: "Please enter the username",

                email: {
                    remote: "already email exists"
                }
            }
        });



$("#login").validationEngine();

