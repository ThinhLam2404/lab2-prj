/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


//$().ready(function () {
$("#loginF").validate({

    rules: {
        username: {
            required: true,
            maxlength: 10

        },
        password: {
            required: true,
            minlength: 5
        }
    },
    messages: {
//        user: {
//            required: "*This field is required! (Please enter your Username)",
//             minlength: "Min length is more than 2 characters!"
//        },
//        pass: {
//            required: "*This field is required! (Please enter your Password)",
//            minlength: "Min length is more than 2 characters!"
//        }

        required: "*This field is required! (Please enter your Username)",
        minlength: "Min length is more than 5 characters!",
        maxlength: "Maximum 10 characters!"
    }
});
//});