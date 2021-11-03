<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
    	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
    	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">    	
	<link rel="stylesheet" href="css/cabinet.css">
	
    <title>Интернет-магазин журналов - Журнал "${magazine.title}"</title>
</head>

<body>
    <div class="wrapper">
        <header>
            <jsp:include page="header.jsp"></jsp:include>
        </header>

        <main>
            <div class="container-fluid single-product">
                <div class="col-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${magazine.title}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">
                                <fmt:formatNumber value="${magazine.subscribePrice/100}" type="currency" currencySymbol=" грн." />
                            </h6>
                            <p class="card-text">${magazine.description}</p>
                            <p class="card-text">Дата публикации: <br>
                                <fmt:parseDate value="${magazine.publishDate}" pattern="yyyy-MM-dd" var="publishDate" type="date" />
                                <fmt:formatDate pattern="dd.MM.yyyy" value="${publishDate}" /> г.
                            </p>
                            <p>Период подписки:<br>
                            <input class="subscribePeriod" type="number" max="12" min="1" value="1"> мес.</p>

                            <button type="button" class="btn btn-primary openModal" data-toggle="modal" data-target="#buyMagazineModal">В корзину</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="buyMagazineModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Оформление подписки на журнал "${magazine.title}"</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                        <script language="javascript">var subscribePeriod = $('.subscribePeriod').val()</script>
                            Вы действительно хотите добавить подписку на <span id="subscribePeriod"></span> мес. на журнал "${magazine.title}" в корзину?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                            <button type="button" magazineID="${magazine.id}" class="btn btn-primary buy-magazine">В корзину</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>

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
    <script src="js/magazineCard.js"></script>
</body>

</html>