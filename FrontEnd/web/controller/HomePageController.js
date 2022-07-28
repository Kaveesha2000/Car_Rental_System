/*$("#homePageSection").css('display', 'block');*/
$("#logInSection").css('display', 'none');
/*$("#dashboardSection").css('display', 'none');*/
/*$("#adminSection").css('display', 'none');*/
/*$("#carSection").css('display', 'none');*/
/*$("#customerSection").css('display', 'none');*/
$("#customerViewSection").css('display', 'none');
/*$("#driverSection").css('display', 'none');*/
/*$("#rentSection").css('display', 'none');*/
/*$("#reservationSection").css('display', 'none');*/
$("#reserveViewSection").css('display', 'none');
$("#scheduleSection").css('display', 'none');
$("#incomeSection").css('display', 'none');

$("#adminBtn").click(function () {
    $("#homePageSection").css('transform','scale(0)');
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('transform','scale(1)');
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'none');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'none');
    $("#driverSection").css('display', 'none');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'none');
})

/*$("#driverBtn").click(function () {
    $("#homePageSection").css('transform','scale(0)')
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('transform','scale(0)')
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'none');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'none');
    $("#driverSection").css('transform', 'scale(1)');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'none');
})*/

$("#customerBtn").click(function () {
    $("#homePageSection").css('transform','scale(0)')
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('transform','scale(0)')
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'none');
    $("#customerSection").css('transform', 'scale(1)');
    $("#customerViewSection").css('display', 'none');
    $("#driverSection").css('transform', 'scale(0)');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'none');
})

$("#carManageBtn").click(function () {
    $("#homePageSection").css('transform', 'scale(0)');
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('display','none')
    $("#adminSection").css('display', 'none');
    $("#carSection").css('transform', 'scale(1)');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'none');
    $("#driverSection").css('display', 'none');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'none');
})

$("#reserveBtn").click(function () {
    $("#homePageSection").css('transform', 'scale(0)');
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('display','none')
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'none');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'none');
    $("#driverSection").css('display', 'none');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('transform', 'scale(1)');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'none');
})

$("#dashboardDriverBtn").click(function () {
    $("#homePageSection").css('display', 'none');
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('display', 'none');
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'none');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'none');
    $("#driverSection").css('display', 'block');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'none');

    console.log("driver section")
})
