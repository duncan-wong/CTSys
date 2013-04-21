$(document).ready(function(){
    //Move menu bar with scroll of main content
    $(document).scroll(function(){
        $('.scrollLeft').css('left', '-' + $(document).scrollLeft() + 'px');
    });
    
    //control group of hide/show content
    $('.btnContentControl[contentGroup]').click(function(event){
        var element = event.srcElement || event.target;
        var contentGroupId = $(element).attr("contentGroup");
        var contentGroup_target = $('.' + contentGroupId + '.' + $(element).attr('contentGroup_target'));
        if (contentGroup_target && !contentGroup_target.hasClass('activeContent')){
            $('.' + contentGroupId).removeClass('activeContent').addClass('inactiveContent');
            contentGroup_target.removeClass('inactiveContent').addClass('activeContent');
            
            //scroll to the target content
            $(document).scrollTop(0);
        }
    });
    
    
    //read if there is cookie for language option
    //add language parameter to all a.href
    var language = "en";
    if (readCookie('languageOption'))
        language = readCookie('languageOption');
    $('a').each(function(){
        if (!$(this).hasClass('languageOption') && !$(this).hasClass('noLanguageOption')){
            if ($(this).attr('href') && $(this).attr('href').search("\\?") >= 0)
                $(this).attr('href', $(this).attr('href') + "&lang=" + language);
            else
                $(this).attr('href', $(this).attr('href') + "?lang=" + language);
        }
    });
    
    
    //submit form link button
    $('a.btn[type="submit"]').click(function(){
       $(this).closest('form').submit(); 
    });
    
    //intruupt when language options are clicked
    $('.languageOption').click(function(event){
        var element = event.srcElement || event.target;
        language = $(element).attr('href');
        if(document.URL.search("lang=") >= 0)
            $(element).attr('href', document.URL.split('lang=')[0] + 'lang=' + language);
        else
            $(element).attr('href', document.URL.split('?')[0] + '?lang=' + language);
        return true;
    });
    
});

function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}
