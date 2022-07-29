function generateDriverIds() {
    $("#driverIdTextField").val("D00-0001");

    var test = "id";

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/driver?carId=" + test,
        method: "GET",
        success: function (response) {
            var driverId = response.data;
            var tempId = parseInt(driverId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#driverIdTextField").val("D00-000" + tempId);
            } else if (tempId <= 99) {
                $("#driverIdTextField").val("D00-00" + tempId);
            } else if (tempId <= 999) {
                $("#driverIdTextField").val("D00-0" + tempId);
            } else {
                $("#driverIdTextField").val("D00-" + tempId);
            }
        },
        error: function (ob) {
        }

    });
}

$("#driverSaveBtn").click(function () {
    addDriver();
});

function addDriver() {
    let text = "Do you really want to save this driver?";

    if (confirm(text) == true) {
        addDriverToDB();
    } else {

    }
}

function addDriverToDB() {
    let data = $("#driverForm").serialize();

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/driver",
        method: "POST",
        data: data,
        success: function (response) {
            if (response.code == 200) {
                alert($("#driverIdTextField").val() + " " + response.message);
            }
            loadAllDriver();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
            loadAllDriver();
        }
    });
}

function loadAllDriver() {

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/driver",
        method: "GET",
        success: function (response) {

            $("#tblCar tbody").empty();
            for (var responseKey of response.data) {
                let raw = `<tr><td> ${responseKey.carId} </td><td> ${responseKey.registerNo} </td><td> ${responseKey.transmissionType} </td><td> ${responseKey.color}</td><td> ${responseKey.carType} </td><td> ${responseKey.brand}
                    </td><td> ${responseKey.fuelType} </td><td> ${responseKey.price}</td>
                    <td>${responseKey.noOfPassengers}</td><td>${responseKey.wholeKm}</td><td>${responseKey.extraOneKmFee}</td><td>${responseKey.dailyRatePrice}</td>
                    <td>${responseKey.monthlyRatePrice}</td><td>${responseKey.availableOrNot}</td><td>${responseKey.underMaintainanceOrNot}</td><td>${responseKey.frontView}</td><td>${responseKey.backView}</td><td> ${responseKey.sideView}</td><td> ${responseKey.interiorView}</td></tr>`;
                $("#tblCar tbody").append(raw);
            }
            clear();
            clickEvent();
            generateDriverIds();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

$("#driverUpdateBtn").click(function () {
    let text = "Do you really want to update this driver?";

    if (confirm(text) == true) {
        let driverId = $("#driverIdTextField").val();
        let driverName = $("#nameTextField").val();
        let driverAddress = $("#addressTextField").val();
        let driverContactNo = $("#contactNoTextField").val();
        let driverNic = $("#nicTextField").val();
        let driverLicenseNo = $("#licenseNoTextField").val();
        let driverPassword = $("#passwordTextField").val();

        $(tblCustomerRow).children(':nth-child(1)').text(driverId);
        $(tblCustomerRow).children(':nth-child(2)').text(driverName);
        $(tblCustomerRow).children(':nth-child(3)').text(driverAddress);
        $(tblCustomerRow).children(':nth-child(4)').text(driverContactNo);
        $(tblCustomerRow).children(':nth-child(5)').text(driverNic);
        $(tblCustomerRow).children(':nth-child(6)').text(driverLicenseNo);
        $(tblCustomerRow).children(':nth-child(7)').text(driverPassword);

        updateDriver();

    } else {

    }
});

function updateDriver() {

    var driverDetail = {
        driverId: $("#driverIdTextField").val(),
        driverName: $("#nameTextField").val(),
        driverAddress: $("#addressTextField").val(),
        driverContactNo: $("#contactNoTextField").val(),
        driverNic: $("#nicTextField").val(),
        driverLicenseNo: $("#licenseNoTextField").val(),
        driverPassword: $("#passwordTextField").val(),
    }

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/driver",
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(driverDetail),
        success: function (response) {
            if (response.code == 200) {
                alert($("#driverIdTextField").val() + " " + response.message);
            }
            loadAllDriver()    ;
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
            loadAllDriver();
        }
    });
}

$("#driverSectionSearchBtn").click(function () {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/driver/" + $("#carSearchBarTextField").val(),
        method: "GET",
        success: function (response) {
            $("#driverIdTextField").val(response.data.driverId);
            $("#nameTextField").val(response.data.driverName);
            $("#addressTextField").val(response.data.driverAddress);
            $("#contactNoTextField").val(response.data.driverContactNo);
            $("#nicTextField").val(response.data.driverNic);
            $("#licenseNoTextField").val(response.data.driverLicenseNo);
            $("#passwordTextField").val(response.data.driverPassword);

            },
        error: function (ob) {
            alert(ob.responseJSON.message);
            loadAllDriver();
        }
    });
});