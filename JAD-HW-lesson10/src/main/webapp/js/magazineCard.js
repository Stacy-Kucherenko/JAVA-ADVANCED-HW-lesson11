$('button.openModal').click(function() {
	$('#subscribePeriod').html($('.subscribePeriod').val());
});

$('button.buy-magazine').click(function() {
	var magazineID = jQuery(this).attr('magazineID');
	var subscribePeriod = $('.subscribePeriod').val();
	
	$.post('subscribe', {'magazineID': magazineID, 'subscribePeriod': subscribePeriod},
			function(data) {
				if (data == 'Success') {
//					$('[data-dismiss=modal]').trigger({type: 'click'});
					$('#buyMagazineModal').hide();
					$('.modal-backdrop').remove();
					alert('Подписка на журнал успешно добавлена в корзину!');
				}
			});
});