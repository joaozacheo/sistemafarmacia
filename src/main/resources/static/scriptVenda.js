(function(){
    const btnNovoItem = document.getElementById('novoItem');
    const formNovoItem = document.getElementById('form-novoItem');
    const btnAddItem = document.getElementById('addItem');
    const itens = document.getElementById('id-item');
    const num = itens.childElementCount;
    let alerta = document.getElementById('alerta-estoque');
    let valorAlerta = $('#alerta-estoque').attr('name');
    
    if(num == 0){
        formNovoItem.classList.remove('d-none');
        btnNovoItem.classList.toggle('d-none');
    }
    
    btnNovoItem.addEventListener('click', () => {
        formNovoItem.classList.remove('d-none');
        btnNovoItem.classList.toggle('d-none');
    });

    if(valorAlerta == 1){
        alerta.classList.remove('d-none');
    }
    
})();