function generateAdminIds() {
    var test = "id";

    alert("admin gen")
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

            $("#adminIdTextField").val(adminId);
            $("#adminNameTextField").val(userName);
            $("#adminPasswordTextField").val(adminPassword);

        } else {

        }
    });
}

$("#adminUpdateBtn").click(function () {
    let text = "Do you really want to update this admin?";

    if (confirm(text) == true) {

        let adminId = $("#adminIdTextField").val(adminId);
        let adminName = $("#adminNameTextField").val(userName);
        let adminPassword = $("#adminPasswordTextField").val(adminPassword);

        $(tblDriverRow).children(':nth-child(1)').text(adminId);
        $(tblDriverRow).children(':nth-child(2)').text(adminName);
        $(tblDriverRow).children(':nth-child(3)').text(adminPassword);

        updateAdmin();

    } else {

    }
});

function updateAdmin() {

    var adminDetail = {
        adminId: $("#adminIdTextField").val(),
        username: $("#adminNameTextField").val(),
        adminPassword: $("#adminPasswordTextField").val(),
    }

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/admin",
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(adminDetail),
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

$("#adminSearchBtn").click(function () {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/admin/" + $("#adminSearchBarTextField").val(),
        method: "GET",
        success: function (response) {
            $("#adminIdTextField").val(response.data.adminId);
            $("#adminNameTextField").val(response.data.username);
            $("#adminPasswordTextField").val(response.data.adminPassword);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
            loadAllAdmin();
        }
    });
});
