//prepear the house seat plan
$(document).ready(function(){
    //convert seat status to icon
    //and allocate class to seat elements
    $(".houseSeatPlan .houseSeat").each(function(){
        var status = $(this).attr('status');
        var seatId = $(this).attr('seatId');
        
        //status: 
        //  available: 1
        //  booked: 0
        //  disable: -1
        switch(status){
            case '1':
                $(this).text(seatId);
                $(this).addClass("seat_available");
                break;
            case '0':
                $(this).text("X");
                $(this).addClass("seat_book");
                break;
            case '-1':
                $(this).addClass("seat_disable");
                    
        }
    });
    
    //select and deselect
    var selectedSeat = new Array();
    $(".houseSeatPlan .houseSeat.seat_available").click(function(event){
        var className = 'seat_select';
        var element = event.srcElement || event.target;
        //select seat
        if (!$(this).hasClass(className)){
            $(this).addClass(className);
            selectedSeat.push(element.id);
        }
        //deselect seat
        else{
            $(this).removeClass(className);
            for (i = 0; i < selectedSeat.length; i ++){
                if (selectedSeat[i] == element.id){
                    selectedSeat.splice(i, 1);
                }
            }
        }
    });
    
    
    //attach the selectedSeat array when submitting form
    $('a.btn[type="submit_orderTicket"]').click(function(){
        var element = event.srcElement || event.target;
        $('#txtSelectedSeat').val(selectedSeat);
        $(this).closest('form').submit();
    });
});