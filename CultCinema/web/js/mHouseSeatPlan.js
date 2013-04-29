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
                $(this).text(seatId);
                $(this).addClass("seat_disable");
                    
        }
    });
//---------------------------------------------------------------------------
    //select and deselect [ available seat ]
    var selectedSeats = new Array();
    $(".houseSeatPlan .houseSeat.seat_available").click(function(event){
        var className = 'seat_select';
        var element = event.srcElement || event.target;
        //select seat
        if (!$(this).hasClass(className)){
            $(this).addClass(className);
            selectedSeats.push(element.id);
        }
        //deselect seat
        else{
            $(this).removeClass(className);
            for (i = 0; i < selectedSeats.length; i ++){
                if (selectedSeats[i] == element.id){
                    selectedSeats.splice(i, 1);
                }
            }
        }
    });
    var selectedSeatsId = $("#txtSelectedSeat").val();
    if (selectedSeatsId != "" && selectedSeatsId != null){
        var seatsId = selectedSeatsId.split(",");
        for (i = 0; i < seatsId.length; i ++){
            $("#" + seatsId[i]).click();
        }
    }
//---------------------------------------------------------------------------
    // select and deselect [ disable seat ]
    var selectedSeats_d = new Array();
    $(".houseSeatPlan .houseSeat.seat_disable").click(function(event){
        var className = 'seat_select_d';
        var element = event.srcElement || event.target;
        //select seat
        if (!$(this).hasClass(className)){
            $(this).addClass(className);
            selectedSeats_d.push(element.id);
        }
        //deselect seat
        else{
            $(this).removeClass(className);
            for (i = 0; i < selectedSeats_d.length; i ++){
                if (selectedSeats_d[i] == element.id){
                    selectedSeats_d.splice(i, 1);
                }
            }
        }
    });
    var selectedSeatsId_d = $("#txtSelectedSeat_d").val();
    if (selectedSeatsId_d != "" && selectedSeatsId_d != null){
        var seatsId = selectedSeatsId_d.split(",");
        for (i = 0; i < seatsId.length; i ++){
            $("#" + seatsId[i]).click();
        }
    }
//---------------------------------------------------------------------------
    //attach the selectedSeat array when submitting form
    $('a.btn[type="submit_orderTicket"]').click(function(event){
        event.preventDefault();
        $('#txtSelectedSeat').val(selectedSeats);
        $('#txtSelectedSeat_d').val(selectedSeats_d);
        $(this).closest('form').submit();
    });
    
    //go backward
    $('a.btn[type="submit_backward"]').click(function(event){
        event.preventDefault();
        $(this).closest('form').attr("action", $(this).closest('form').attr("action") + "&backward=1");
        $(this).closest('form').submit();
    })
    
});
