function generateCustomerIds() {
    $("#carIdTextField").val("V00-0001");

    var test = "id";

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/car?carId=" + test,
        method: "GET",
        success: function (response) {
            var carId = response.data;
            var tempId = parseInt(carId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#carIdTextField").val("V00-000" + tempId);
            } else if (tempId <= 99) {
                $("#carIdTextField").val("V00-00" + tempId);
            } else if (tempId <= 999) {
                $("#carIdTextField").val("V00-0" + tempId);
            } else {
                $("#carIdTextField").val("V00-" + tempId);
            }
        },
        error: function (ob) {
        }

    });
}

$("#carSaveBtn").click(function () {

    /* $("#tblCar tbody > tr").off("click");
     $("#tblCar tbody > tr").off("dblclick");
     */
    addCar();
});

function addCar() {
    let text = "Do you really want to save this car?";

    if (confirm(text) == true) {
        addCarToDB();
    } else {

    }
}

function addCarToDB() {
    let data = $("#carForm").serialize();

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/car",
        method: "POST",
        data: data,
        success: function (response) {
            if (response.code == 200) {
                alert($("#carId").val() + " " + response.message);
            }
            loadAllCar();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
            loadAllCar();
        }
    });
}

function loadAllCar() {

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/customer",
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
            generateCustomerIds();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

var search = false;

/*
function searchIfCustomerAlreadyExists() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/customer/" + $("#customerId").val(),
        method: "GET",
        success: function (response) {
            if (response.data.customerId == $("#carId").val()) {
                search = true;
            }
        },
        error: function (ob) {
            search = false;
            alert(ob.responseJSON.message);
            loadAllCustomer();
        }
    });
}
*/

$("#carUpdateBtn").click(function () {
        let text = "Do you really want to update this Customer?";

        if (confirm(text) == true) {
            let carId = $("#carIdTextField").val();
            let registerId = $("#registerIdTextField").val();
            let noOfPassengers = $("#noOfPassengers option:selected").text();
            let color = $("#colorTextField").val();
            let type = $("#type option:selected").text();
            let wholeKm = $("#wholeKmTextField").val();
            let brand = $("#brandTextField").val();
            let fuelType = $("#fuelType option:selected").text();
            let transmissionType = $("#transmissionType option:selected").text();
            let dailyRatePrice = $("#dailyRatePricetextField").val();
            let monthlyRatePrice = $("#monthlyRatePricetextField").val();
            let frontView = $("#frontView").val();
            let sideView = $("#sideView").val();
            let backView = $("#backView").val();
            let interiorView = $("#interiorView").val();

            $(tblCustomerRow).children(':nth-child(1)').text(carId);
            $(tblCustomerRow).children(':nth-child(2)').text(registerId);
            $(tblCustomerRow).children(':nth-child(3)').text(noOfPassengers);
            $(tblCustomerRow).children(':nth-child(4)').text(color);
            $(tblCustomerRow).children(':nth-child(5)').text(type);
            $(tblCustomerRow).children(':nth-child(6)').text(wholeKm);
            $(tblCustomerRow).children(':nth-child(7)').text(brand);
            $(tblCustomerRow).children(':nth-child(7)').text(fuelType);
            $(tblCustomerRow).children(':nth-child(7)').text(transmissionType);
            $(tblCustomerRow).children(':nth-child(7)').text(dailyRatePrice);
            $(tblCustomerRow).children(':nth-child(7)').text(monthlyRatePrice);
            $(tblCustomerRow).children(':nth-child(7)').text(frontView);
            $(tblCustomerRow).children(':nth-child(7)').text(sideView);
            $(tblCustomerRow).children(':nth-child(7)').text(backView);
            $(tblCustomerRow).children(':nth-child(7)').text(interiorView);

            updateCar();

        } else {

        }
});

function updateCar() {

    var carDetail = {
        carId: $("#carIdTextField").val(),
        registerNo: $("#registerIdTextField").val(),
        transmissionType: $("#transmissionType").val(),
        color: $("#colorTextField").val(),
        carType: $("#type").val(),
        brand: $("#brandTextField").val(),
        fuelType: $("#fuelType").val(),
        noOfPassengers: $("#noOfPassengers").val(),
        wholeKm: $("#wholeKmTextField").val(),
        extraOneKmFee: $("#carExtraKmTextField").val(),
        dailyRatePrice: $("#dailyRatePricetextField").val(),
        monthlyRatePrice: $("#monthlyRatePricetextField").val(),
        availableOrNot: $("#availableOrNottextField").val(),
        underMaintainanceOrNot: $("#underMaintainanceorNottextField").val(),
        frontView: $("#frontView").val(),
        backView: $("#sideView").val(),
        sideView: $("#backView").val(),
        interiorView: $("#interiorView").val()
    }

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/customer",
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(carDetail),
        success: function (response) {
            if (response.code == 200) {
                alert($("#carIdTextField").val() + " " + response.message);
            }
            loadAllCar()    ;
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
            loadAllCar();
        }
    });
}

$("#carSectionSearchBtn").click(function () {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/customer/" + $("#carSearchBarTextField").val(),
        method: "GET",
        success: function (response) {
            $("#carIdTextField").val(response.data.carId);
            $("#registerIdTextField").val(response.data.registerNo);
            $("#transmissionType").val(response.data.transmissionType);
            $("#colorTextField").val(response.data.color);
            $("#type").val(response.data.type);
            $("#brandTextField").val(response.data.brand);
            $("#fuelType").val(response.data.fuelType);
            $("#noOfPassengers").val(response.data.noOfPassengers);
            $("#wholeKmTextField").val(response.data.wholeKm);
            $("#carExtraKmTextField").val(response.data.extraOneKmFee);
            $("#dailyRatePricetextField").val(response.data.dailyRatePrice);
            $("#monthlyRatePricetextField").val(response.data.monthlyRatePrice);
            $("#availableOrNottextField").val(response.data.availableOrNot);
            $("#underMaintainanceorNottextField").val(response.data.underMaintainanceOrNot);
            $("#frontView").val(response.data.frontView);
            $("#sideView").val(response.data.sideView);
            $("#backView").val(response.data.backView);
            $("#interiorView").val(response.data.interiorView);
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
            loadAllCar();
        }
    });
});