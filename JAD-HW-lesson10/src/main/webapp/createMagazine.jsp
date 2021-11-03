<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
    	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
    	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">   
    <link rel="stylesheet" href="css/createMagazine.css">

    <title>Интернет-магазин журналов - Добавление журнала</title>
</head>

<body>
    <header>
        <jsp:include page="header.jsp"></jsp:include>
    </header>

    <main>
        <div>
            <form>
                <input class="title" type="text" placeholder="Название журнала" />
                <input class="description" type="text" placeholder="Описание журнала" />
                <input class="publishDate" type="text" onfocus="(this.type='date')" onblur="if(this.value=='') {this.type='text'}" placeholder="Дата публикации" />
                <input class="subscribePrice" type="number" step=0.01 min=0 oninput="up(this)" onblur="nullize(this)" placeholder="Цена подписки" />
                <button class="register" type="button">Создать журнал</button>
            </form>
        </div>
    </main>

    <footer>
        <jsp:include page="footer.jsp"></jsp:include>
    </footer>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="js/header.js"></script>
    <script src="js/createMagazine.js"></script>
</body>

</html>