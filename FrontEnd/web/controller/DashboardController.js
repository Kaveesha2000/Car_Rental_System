$("#dashboardDriverBtn").click(function () {
    $("#homePageSection").css('display', 'none');
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('display', 'none');
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'none');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'none');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'none');
    $("#driverSection").css('display', 'block');

    generateDriverIds();
    loadAllDriver();
})

$("#dashboardCarBtn").click(function () {
    $("#homePageSection").css('display', 'none');
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('display', 'none');
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'block');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'none');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'none');
    $("#driverSection").css('display', 'none');

    generateCarIds();
    loadAllCar();
})

$("#dashboardScheduleBtn").click(function () {
    $("#homePageSection").css('display', 'none');
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('display', 'none');
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'none');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'none');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'block');
    $("#incomeSection").css('display', 'none');
    $("#driverSection").css('display', 'none');
})

$("#dashboardIncomeBtn").click(function () {
    $("#homePageSection").css('display', 'none');
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('display', 'none');
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'none');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'none');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'block');
    $("#driverSection").css('display', 'none');
})

$("#dashboardReservationViewBtn").click(function () {
    $("#homePageSection").css('display', 'none');
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('display', 'none');
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'none');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'none');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'block');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'none');
    $("#driverSection").css('display', 'none');
})

$("#dashboardCustomerViewBtn").click(function () {
    $("#homePageSection").css('display', 'none');
    $("#logInSection").css('display', 'none');
    $("#dashboardSection").css('display', 'none');
    $("#adminSection").css('display', 'none');
    $("#carSection").css('display', 'none');
    $("#customerSection").css('display', 'none');
    $("#customerViewSection").css('display', 'block');
    $("#rentSection").css('display', 'none');
    $("#reservationSection").css('display', 'none');
    $("#reserveViewSection").css('display', 'none');
    $("#scheduleSection").css('display', 'none');
    $("#incomeSection").css('display', 'none');
    $("#driverSection").css('display', 'none');
})