$(function() {
	$('#novo').click(function(e) {
		e.preventDefault();
		limpaTela();
	});

	$('a').click(function(e) {
		e.preventDefault();
		$.ajax({
			url: location.origin + '/api/pessoas',
			method: 'GET',
			data: { id: '', nome: '', cpf: '', any: '', page: 0, size: 0, sort: 'id' },
			dataType: 'json'
		}).done(function(result) {
			findPessoa(result);
		});
	});

	$('#salvar').click(function(e) {
		//e.preventDefault();
		if (valida_form() == true) {
			var id = $('#id').val();
			var data = {
				nome: $('#nome').val(),
				sexo: $('#sexo').val(),
				email: $('#email').val(),
				nascimento: $('#nascimento').val(),
				naturalidade: $('#naturalidade').val(),
				nacionalidade: $('#nacionalidade').val(),
				cpf: $('#cpf').val()
			}
			if (id == 0) {
				console.log('inserindo');
				$.ajax({
					url: location.origin + '/api/pessoas',
					method: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(data)
				}).done(function(result) {
					//console.log(result);
				});
			} else {
				console.log('atualizando');
				$.ajax({
					url: location.origin + '/api/pessoas/' + id,
					method: 'PUT',
					contentType: 'application/json',
					data: JSON.stringify(data)
				}).done(function(result) {
					//console.log(result);
				});
			}
		} else {
			console.log('não válido');
		}
	});
});

function edit(p_id) {
	//console.log(p_id);
	$.ajax({
		url: location.origin + '/api/pessoas',
		method: 'GET',
		data: { id: p_id },
		dataType: 'json'
	}).done(function(result) {
		//console.log(result);
		carregaTela(result);
	});
}

function del(p_id) {
	var r = confirm('Tem certeza de que deseja remover?');
	if (r == true) {
		//console.log(p_id);
		$.ajax({
			url: location.origin + '/api/pessoas/' + p_id,
			method: 'DELETE',
			contentType: 'application/json',
		}).done(function(result) {
			console.log(result);
			//carregaTela(result);
		});
	}
}

function findPessoa(result) {
	//console.log(result);
	$('tbody').remove();
	var html = '<tbody>';
	for (var i = 0; i < result.numberOfElements; i++) {
		html += '<tr> ' +
			'<td>' + result.content[i].id + '</td> ' +
			'<td>' + result.content[i].nome + '</td> ' +
			'<td>' + result.content[i].sexo + '</td> ' +
			'<td>' + result.content[i].email + '</td> ' +
			'<td> ' +
			'	<input type="button" onclick="edit(' + result.content[i].id + ')" class="btn btn-warning btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal" value="Editar">' +
			'	<a onclick="del(' + result.content[i].id + ')" class="btn btn-danger btn-sm">Remover</a> ' +
			'</td> ' +
			'</tr>';
	}
	html += '</tbody>';
	$('table').append(html);
	if (result.numberOfElements == 0) {
		alert('Nenhum Registro Encontrado!');
	}
}

function carregaTela(result) {
	$('#id').val(result.content[0].id);
	$('#nome').val(result.content[0].nome);
	$('#sexo').val(result.content[0].sexo);
	$('#email').val(result.content[0].email);
	$('#nascimento').val(result.content[0].nascimento);
	$('#naturalidade').val(result.content[0].naturalidade);
	$('#nacionalidade').val(result.content[0].nacionalidade);
	$('#cpf').val(result.content[0].cpf);
}

function limpaTela() {
	$('#id').val(0);
	$('#nome').val('');
	$('#sexo').val('');
	$('#email').val('');
	$('#nascimento').val('');
	$('#naturalidade').val('');
	$('#nacionalidade').val('');
	$('#cpf').val('');
}

function valida_form() {
	if ($("#nome").text() == "") {
		alert('Informe o nome');
		$("nome").text('Informe um nome');
		return false
	}
	return true;
}