$(document).ready(function(){
    //Move menu bar with scroll of main content
    $(document).scroll(function(){
        $('.scrollLeft').css('left', '-' + $(document).scrollLeft() + 'px');
    });
})