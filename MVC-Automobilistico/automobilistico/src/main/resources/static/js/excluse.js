$('#modalAutomoveis').on('show.bs.modal', function(event){
	var button= $(event.relatedTarget);
	
	var codigoAutomovel= button.data('codigo');
	var nome=button.data('descricao');
	
	var modal= $(this);
	
	var form= modal.find('form');
	
	var action= form.data('url-base');
	
	if(!action.endsWith('/')){
		action+='/';
	}
	
	form.attr('action', action+ codigoAutomovel);
	
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o automovel <strong>' + nome + '</strong>?');
});