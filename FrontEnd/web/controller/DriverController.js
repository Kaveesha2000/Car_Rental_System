function generateDriverIds() {
    var test = "id";

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/driver?driverId=" + test,
        method: "GET",
        success: function (response) {
            var driverId = response.data;
            if (driverId==null){
                $("#driverIdTextField").val("D00-0001");
            }else {
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

            $("#tblDriver").empty();
            for (var responseKey of response.data) {
                let raw = `<tr><td> ${responseKey.driverId} </td><td> ${responseKey.driverName} </td><td> ${responseKey.driverAddress} </td>
                            <td> ${responseKey.driverContact}</td><td> ${responseKey.driverNIC} </td><td> ${responseKey.driverLicenseNo}
                            </td><td> ${responseKey.driverPassword}</td><td> ${responseKey.driverReleaseOrNot}</td></tr>`;
                $("#tblDriver").append(raw);
            }
            generateDriverIds();
            clickDriverTableRow();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

var tblDriverRow =-1;
function clickDriverTableRow() {
    $("#tblDriver > tr").click(function () {

        tblDriverRow = $(this);

        let text = "Do you want to edit driver ?";

        if (confirm(text) == true) {
            var driverId = $.trim(tblDriverRow.children(':nth-child(1)').text());
            var driverName = $.trim(tblDriverRow.children(':nth-child(2)').text());
            var driverAddress = $.trim(tblDriverRow.children(':nth-child(3)').text());
            var driverContactNo = $.trim(tblDriverRow.children(':nth-child(4)').text());
            var driverNIC = $.trim(tblDriverRow.children(':nth-child(5)').text());
            var driverLicenseNo = $.trim(tblDriverRow.children(':nth-child(6)').text());
            var driverPassword = $.trim(tblDriverRow.children(':nth-child(7)').text());
            var driverReleaseOrNot = $.trim(tblDriverRow.children(':nth-child(8)').text());

            $("#releaseOrNot").append($("<option selected></option>").attr("value", "repeat").text($.trim(tblDriverRow.children(':nth-child(8)').text())));

            $("#driverIdTextField").val(driverId);
            $("#nameTextField").val(driverName);
            $("#addressTextField").val(driverAddress);
            $("#contactNoTextField").val(driverContactNo);
            $("#nicTextField").val(driverNIC);
            $("#licenseNoTextField").val(driverLicenseNo);
            $("#passwordTextField").val(driverPassword);
            $("#releaseOrNot").val(driverReleaseOrNot);

        } else {

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
        let driverReleaseOrNot = $("#releaseOrNot option:selected").text();

        $(tblDriverRow).children(':nth-child(1)').text(driverId);
        $(tblDriverRow).children(':nth-child(2)').text(driverName);
        $(tblDriverRow).children(':nth-child(3)').text(driverAddress);
        $(tblDriverRow).children(':nth-child(4)').text(driverContactNo);
        $(tblDriverRow).children(':nth-child(5)').text(driverNic);
        $(tblDriverRow).children(':nth-child(6)').text(driverLicenseNo);
        $(tblDriverRow).children(':nth-child(7)').text(driverPassword);
        $(tblDriverRow).children(':nth-child(8)').text(driverReleaseOrNot);

        updateDriver();

    } else {

    }
});

function updateDriver() {

    var driverDetail = {
        driverId: $("#driverIdTextField").val(),
        driverName: $("#nameTextField").val(),
        driverAddress: $("#addressTextField").val(),
        driverContact: $("#contactNoTextField").val(),
        driverNIC: $("#nicTextField").val(),
        driverLicenseNo: $("#licenseNoTextField").val(),
        driverPassword: $("#passwordTextField").val(),
        driverReleaseOrNot: $("#releaseOrNot option:selected").text()
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
            loadAllDriver();
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
            $("#contactNoTextField").val(response.data.driverContact);
            $("#nicTextField").val(response.data.driverNIC);
            $("#licenseNoTextField").val(response.data.driverLicenseNo);
            $("#passwordTextField").val(response.data.driverPassword);
            $("#releaseOrNot").val(response.data.driverReleaseOrNot);

            },
        error: function (ob) {
            alert(ob.responseJSON.message);
            loadAllDriver();
        }
    });
});

function loadAllDriversToTableView() {

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/driver",
        method: "GET",
        success: function (response) {

            $("#tblDriverView").empty();
            for (var responseKey of response.data) {
                let raw = `<tr><td> ${responseKey.driverId} </td><td> ${responseKey.driverName} </td>
                            <td> ${responseKey.driverContact}</td><td> ${responseKey.driverLicenseNo}
                            </td><td> ${responseKey.driverReleaseOrNot}</td></tr>`;
                $("#tblDriverView").append(raw);
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}
