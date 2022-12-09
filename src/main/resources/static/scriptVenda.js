(function(){
    const btnNovoItem = document.getElementById('novoItem');
    const formNovoItem = document.getElementById('form-novoItem');
    const btnAddItem = document.getElementById('addItem');
    const itens = document.getElementById('id-item');
    const num = itens.childElementCount;

    
    if(num == 0){
        formNovoItem.classList.remove('d-none');
        btnNovoItem.classList.toggle('d-none');
    }
    
    btnNovoItem.addEventListener('click', () => {
        formNovoItem.classList.remove('d-none');
        btnNovoItem.classList.toggle('d-none');
    });
    
})();