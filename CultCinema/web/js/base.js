$(document).ready(function(){
    //Move menu bar with scroll of main content
    $('#mainContainer').scroll(function(){
        $('.scrollLeft').css('left', '-' + $('#mainContainer').scrollLeft() + 'px');
    });
})