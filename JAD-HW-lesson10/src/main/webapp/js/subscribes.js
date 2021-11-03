function search() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById('search');
	filter = input.value.toUpperCase();
	table = document.getElementById('table');
	tr = table.getElementsByTagName('tr');
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName('td')[0];
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = '';
			} else {
				tr[i].style.display = 'none';
			}
		}
	}
}

var buckets = null;
$.get('subscribes', function(data) {
	if (data !== '') {
		buckets = data;
	}
}).done(
		function() {
			var tableContent = "<tr class='header'>"
					+ "<th style='width: 20%;'>Название</th>"
					+ "<th style='width: 20%;'>Описание</th>"
					+ "<th style='width: 10%;'>Дата публикации</th>"
					+ "<th style='width: 10%;'>Цена подписки</th>"
					+ "<th style='width: 10%;'>Период подписки</th>"
					+ "<th style='width: 10%;'>Дата подписки</th>"
					+ "<th style='width: 5%;'>Статус подписки</th>"
					+ "<th style='width: 15%;'></th>"					
					+ "</tr>";

			jQuery.each(buckets, function(i, value) {
				var publishDateFormatted = ('0' + value.publishDate.day).slice(-2) + "." + ('0' + value.publishDate.month).slice(-2) + "." + value.publishDate.year;
				var subscribeDateFormatted = ('0' + value.subscribeDate.day).slice(-2) + "." + ('0' + value.subscribeDate.month).slice(-2) + "." + value.subscribeDate.year;
				
				var subscribeStatus;
				if (value.subscribeStatus) {
					subscribeStatus = "class='fas fa-check'"							
				} else {
					subscribeStatus = "class='fas fa-times'"
				}
				
				tableContent += "<tr>"
						+ "<td>" + value.title + "</td>"
						+ "<td>" + value.description + "</td>"
						+ "<td>" + publishDateFormatted + " г." + "</td>"
						+ "<td>" + value.subscribePrice/100 + " грн." + "</td>"
						+ "<td>" + value.subscribePeriod + " мес." + "</td>"
						+ "<td>" + subscribeDateFormatted + " г." + "</td>"
						+ "<td " + subscribeStatus + ">" + "</td>"
						+ "<td><button title='Оформить подписку/отписаться' class='fa fa-shopping-cart mr-3' onclick='buyOrder(" + value.id + ")'></button>" 
						+ "<button title='Удалить' class='fa fa-trash' onclick='deleteOrder(" + value.id + ")'></button></td>"
						+ "</tr>"
			});

			$('#table').html(tableContent);
		});

function buyOrder(id) {
	var customUrl = '';
	var urlContent = window.location.href.split('/');
	
	for (var i = 0; i < urlContent.length - 1; i++) {
		customUrl += urlContent[i] + '/'
	}
	
	customUrl += 'subscribe?id=' + id;

	$.ajax({
		url: customUrl,
		type: 'PUT',
		success: function(data) {
			if (data !== '') {
				location.reload();
				if (data) {
					alert('Подписка оформлена!');
				} else {
					alert('Подписка отменена!');
				}
			}
		}
	});
}

function deleteOrder(id) {
	var customUrl = '';
	var urlContent = window.location.href.split('/');
	
	for (var i = 0; i < urlContent.length - 1; i++) {
		customUrl += urlContent[i] + '/'
	}
	
	customUrl += 'subscribe?id=' + id;

	$.ajax({
		url: customUrl,
		type: 'DELETE',
		success: function(data) {
			if (data == 'Success') {
				location.reload();
				alert('Запись удалена!');
			}
		}
	});
}