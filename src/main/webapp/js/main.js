import {fieldYTest, fieldXTest} from "./validate.js";
import  {buildPoint} from "./builder.js";

$("#send").on("click", function (){
    const x = $("#x").val();
    const r = $("#y").val();
    const form = document.querySelector('.checkerForm');
    const valueX = form.querySelector('.formX');
    const container = document.querySelector('.image');
    const xForm = document.getElementById("Xerror"),
        newX = document.createElement("div"),
        textX = document.createTextNode(fieldXTest(valueX));
    newX.appendChild(textX);
    xForm.replaceChild(newX, xForm.childNodes[0]);

    const rForm = document.getElementById("Yerror"),
        newR = document.createElement("div"),
        textR = document.createTextNode(fieldYTest());
    newR.appendChild(textR);
    rForm.replaceChild(newR, rForm.childNodes[0]);
    event.preventDefault();

    if (textX.data + textR.data === "") {
        const y = document.querySelector('input[name="chooseY"]:checked').value;
        $.ajax({
            url: '',
            type: 'GET',
            cache: false,
            data: {'x': x, 'y': y, 'r': r},
            dataType: 'html',
            success: function (data) {
                $("#send").prop("disabled", false)
                $("#checkerForm").trigger("reset")
                buildPoint(container, x, y, r)
            }
        });
    }
});




