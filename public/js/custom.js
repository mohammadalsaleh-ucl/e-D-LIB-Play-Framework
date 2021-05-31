function confirmDel() {
  return confirm('Are you sure?');
}




        $("#registration").validate({
            rules: {
              username: "required",
              password: "required",
              password2: {
                 required: true,
                 equalTo: "#password"
             }
          },
            messages: {
                password: "Please enter the password",

                username: "Please enter the username"
            }
        });



$("#login").validationEngine();

