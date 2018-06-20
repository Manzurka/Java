/**
 * 
 */

$(document).ready(function(){
    $("p, h1").hover(function(){
        $(this).css("background-color", "pink");
        }, function(){
        $(this).css("background-color", "white");
    });
});
