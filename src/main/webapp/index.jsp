<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Hit checker</title>
    <style>
        <%@include file='css/form.css' %>
        <%@include file='css/header.css' %>
        <%@include file='css/point.css' %>
        <%@include file='css/style.css' %>
        <%@include file='css/table.css' %>
    </style>
    <script type="module" defer src="js/main.js"></script>
    <script type="module" defer src="js/validate.js"></script>
    <script type="module" defer src="js/builder.js"></script>
    <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

</head>
<body style="background-image: url(images/background.png); background-position: top center; background-size: cover;">
<table>
    <tr>
        <td colspan="2">
            <!-- Шапка с именем и группой -->
            <header> Выполнила: Громилова Мария Дмитриевна, группа P3130, вариант 6543
            </header>
        </td>
    </tr>
    <tr><!-- Форма ввода значений -->
        <td>
            <form action="#" class="checkerForm" id="checkerForm">
                <div class="formHeader">Проверьте попадание значений вашей точки</div>
                <div class="textX">Введите значение X:</div>
                <input type="text" id="x" class="formX" name="formX" placeholder="Введите число от -5 до 5" />
                <div id="Xerror" class="Xerror"> </div>
                <div class="textY">Выберите значение Y:</div>
                <div>
                <input type="radio" name="chooseY" value="-3" class="formR">-3
                <input type="radio" name="chooseY" value="-2" class="formR">-1
                <input type="radio" name="chooseY" value="-1" class="formR">-1
                <input type="radio" name="chooseY" value="0" class="formR">0
                <input type="radio" name="chooseY" value="1" class="formR">1
                <input type="radio" name="chooseY" value="2" class="formR">2
                <input type="radio" name="chooseY" value="3" class="formR">3
                <input type="radio" name="chooseY" value="4" class="formR">4
                <input type="radio" name="chooseY" value="5" class="formR">5
                </div>

                <div id="Yerror" class="Yerror"> </div>

                <div class="textR" id="r">Выберите значение R:
                <select name="chooseY" id="y" class="formY" >
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
                </div>


                <button type="button"  class="submitButton" id="send">Отправить</button>
            </form>
        </td>
        <td class="image" >
            <!-- Координатная плоскость с содержимым -->
            <img id="img" src="images/web2.png" height="378" alt="Координатная плоскость">
        </td>
    </tr>
    <tr>
        <!-- Таблица -->
        <td colspan="2">
            <div>
                <table class="resultTable" id="resultTable">
                    <td>    </td>
                    <td class="elementX">X</td>
                    <td class="elementY">Y</td>
                    <td class="elementR">R</td>
                    <td>Результат</td>
                    <td>Время выполнения</td>
                    <td>Текущее время</td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
</table>
<div id="cleaner">
    <input type="button" value="Очистить таблицу" id="cleanButton">
</div>
</body>
</html>
