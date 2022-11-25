const btnNovoItem = document.getElementById('novoItem');
const formNovoItem = document.getElementById('form-novoItem');
const btnAddItem = document.getElementById('addItem');
btnNovoItem.addEventListener('click', () => {
    btnNovoItem.classList.toggle('d-none');
    formNovoItem.classList.remove('d-none');
})

