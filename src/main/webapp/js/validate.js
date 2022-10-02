export function fieldXTest(field) {
    if (!(field.value.trim() === "")) {
        if (/^(0$|-?[0-9]\d*(\.\d*[0-9]$)?|-?0\.\d*[0-9])$/.test(field.value)) {
            if ((parseFloat(field.value) >= -5) && (parseFloat(field.value) <= 5) && ((!/^-?5[.]0+[1-9]+0*/.test(field.value)))) {
                return "";
            } else return "Координата X задается числом в промежутке {-3...3}!\n";
        } else return "Координата X задается числом!\n";
    } else return "Не введена координата X!\n";
}


export function fieldYTest(){
    if (document.querySelector('input[name="chooseY"]:checked') == null) {
        return "Поле не может быть невыбранным!";
    } else {
        return "";
    }
}