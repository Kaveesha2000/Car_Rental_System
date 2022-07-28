function generateCustomerIds() {
    $("#customerIdTextField").val("C00-0001");

    var test = "id";

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/customer?customerId=" + test,
        method: "GET",
        success: function (response) {
            var customerId = response.data;
            var tempId = parseInt(customerId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#customerIdTextField").val("C00-000" + tempId);
            } else if (tempId <= 99) {
                $("#customerIdTextField").val("C00-00" + tempId);
            } else if (tempId <= 999) {
                $("#customerIdTextField").val("C00-0" + tempId);
            } else {
                $("#customerIdTextField").val("C00-" + tempId);
            }
        },
        error: function (ob) {
        }

    });
}

var tblCustomerRow;
$("#saveCustomerBtn").click(function () {
    addCustomer();
});

function addCustomer() {
    let text = "Do you really want to register?";

    if (confirm(text) == true) {
        addCustomerToDB();
    } else {
    }
}

function addCustomerToDB() {
    let data = $("#customerForm").serialize();

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/customer",
        method: "POST",
        data: data,
        success: function (response) {
            if (response.code == 200) {
                alert($("#customerIdTextField").val() + " " + response.message);
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

/*
function loadAllCustomer() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/customer",
        method: "GET",
        success: function (response) {

            for (var responseKey of response.data) {
                let raw = `<tr><td> ${responseKey.customerId} </td><td> ${responseKey.customerName} </td><td> ${responseKey.gender} </td><td> ${responseKey.contact} </td><td> ${responseKey.nic} </td><td> ${responseKey.address} </td><td> ${responseKey.email} </td></tr>`;
                $("#tblCustomer tbody").append(raw);
            }
            clear();
            clickEvent();
            generateCustomerIds();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}*/
