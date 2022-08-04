function generateCustomerIds() {
    var test = "id";

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/customer?customerId=" + test,
        method: "GET",
        success: function (response) {
            var customerId = response.data;

            if (customerId==null){
                $("#customerIdTextField").val("C00-0001");
            }else {
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
            }
        },
        error: function (ob) {
        }

    });
}

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

//----------------------load details of customers----------------------------------

function loadAllCustomer() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/api/v1/customer",
        method: "GET",
        success: function (response) {

            $("#tblCustomerView").empty();
            for (var responseKey of response.data) {
                let raw = `<tr><td> ${responseKey.customerId} </td><td> ${responseKey.customerName} </td><td> ${responseKey.customerAddress} </td>
                            <td> ${responseKey.customerNIC}</td><td> ${responseKey.customerLicenseNo} </td><td> ${responseKey.customerRegisteredDate}
                            </td><td> ${responseKey.customerEmail}</td><td> ${responseKey.customerContact}</td><td> ${responseKey.customerNewPassword}</td></tr>`;
                $("#tblCustomerView").append(raw);
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}