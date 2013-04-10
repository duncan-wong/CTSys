$(document).ready(function(){
    //Move menu bar with scroll of main content
    $(document).scroll(function(){
        $('.scrollLeft').css('left', '-' + $(document).scrollLeft() + 'px');
    });
    
    //add original url when log in
    /*$('a[href="login"]').click(function(event){
        var element = event.srcElement || event.target;
        
        $(element).attr('href', $(element).attr('href') + "?orgURL=" + location.pathname);
    });*/
})