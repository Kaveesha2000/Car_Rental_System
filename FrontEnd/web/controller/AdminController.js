function generateAdminIds() {
    var test = "id";

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/admin?adminId=" + test,
        method: "GET",
        success: function (response) {
            var adminId = response.data;
            if (adminId==null){
                $("#adminIdTextField").val("A00-0001");
            }else {
                var tempId = parseInt(adminId.split("-")[1]);
                tempId = tempId + 1;
                if (tempId <= 9) {
                    $("#adminIdTextField").val("A00-000" + tempId);
                } else if (tempId <= 99) {
                    $("#adminIdTextField").val("A00-00" + tempId);
                } else if (tempId <= 999) {
                    $("#adminIdTextField").val("A00-0" + tempId);
                } else {
                    $("#adminIdTextField").val("A00-" + tempId);
                }
            }
        },
        error: function (ob) {
        }

    });
}

$("#adminSaveBtn").click(function () {
    addAdmin();
});

function addAdmin() {
    let text = "Do you really want to save this admin?";

    if (confirm(text) == true) {
        addAdminToDB();
    } else {

    }
}

function addAdminToDB() {
    let data = $("#adminForm").serialize();

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/admin",
        method: "POST",
        data: data,
        success: function (response) {
            if (response.code == 200) {
                alert($("#adminIdTextField").val() + " " + response.message);
            }
            loadAllAdmin();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
            loadAllAdmin();
        }
    });
}

function loadAllAdmin() {

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/admin",
        method: "GET",
        success: function (response) {

            $("#tblAdmin").empty();
            for (var responseKey of response.data) {
                let raw = `<tr><td> ${responseKey.adminId} </td><td> ${responseKey.userName} </td><td> ${responseKey.adminPassword}</td></tr>`;
                $("#tblAdmin").append(raw);
            }
            generateAdminIds();
            clickAdminTableRow();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

var tblAdminRow =-1;
function clickAdminTableRow() {
    $("#tblAdmin > tr").click(function () {

        tblAdminRow = $(this);

        let text = "Do you want to edit admin ?";

        if (confirm(text) == true) {
            var adminId = $.trim(tblAdminRow.children(':nth-child(1)').text());
            var userName = $.trim(tblAdminRow.children(':nth-child(2)').text());
            var adminPassword = $.trim(tblAdminRow.children(':nth-child(3)').text());

            $("#driverIdTextField").val(adminId);
            $("#nameTextField").val(userName);
            $("#addressTextField").val(adminPassword);

        } else {

        }
    });
}

/*
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
});*/
