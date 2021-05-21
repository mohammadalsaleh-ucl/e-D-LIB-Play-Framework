function confirmDel() {
  return confirm('Are you sure?');
}

$("#registration").validationEngine().css({border : "2px solid #000"});


// form validation
alert( $("#registration").validationEngine('validate') );

// field validation
alert( $("#registration").validationEngine('validate') );
