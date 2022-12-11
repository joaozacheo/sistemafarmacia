(function(){
    const btnNovoItem = document.getElementById('novoItem');
    const formNovoItem = document.getElementById('form-novoItem');
    const btnAddItem = document.getElementById('addItem');
    const itens = document.getElementById('id-item');
    const num = itens.childElementCount;

    let alerta1 = document.getElementById('alerta-estoque');
    let alerta2 = document.getElementById('alerta-minimo');
    let alerta3 = document.getElementById('alerta-produto');
    let alertaItens = document.getElementById('alerta-itens');
    let valorEstoque = $('#alerta-estoque').attr('name');
    let valorMinimo = $('#alerta-minimo').attr('name');
    let valorProduto = $('#alerta-produto').attr('name');
    let valorItens = $('#alerta-itens').attr('name');
    
    if(num == 0){
        formNovoItem.classList.remove('d-none');
        btnNovoItem.classList.toggle('d-none');
    }
    
    btnNovoItem.addEventListener('click', () => {
        formNovoItem.classList.remove('d-none');
        btnNovoItem.classList.toggle('d-none');
    });

    if(valorEstoque == 1){
        alerta1.classList.remove('d-none');
    }

    if(valorMinimo == 1){
        alerta2.classList.remove('d-none');
    }

    if(valorProduto == 1){
        alerta3.classList.remove('d-none');
    }

    if(valorItens == 1){
        alertaItens.classList.remove('d-none');
    }
    
})();