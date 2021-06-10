$('#modalAgenda').on('show.bs.modal', function(event){
	var button= $(event.relatedTarget);
	
	var codigoAgenda= button.data('codigo');
	var nome=button.data('descricao');
	
	var modal= $(this);
	
	var form= modal.find('form');
	
	var action= form.data('url-base');
	
	if(!action.endsWith('/')){
		action+='/';
	}
	
	form.attr('action', action+ codigoAgenda);
	
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o agendamento do cliente <strong>' + nome + '</strong>?');
});