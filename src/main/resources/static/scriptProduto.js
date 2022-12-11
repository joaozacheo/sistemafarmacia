(function(){
    let alertaDel = document.getElementById('alerta-del');
    let valorDel = $('#alerta-del').attr('name');

    $("#tabproduto").on("click", ".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalproduto").modal("show");
    });
    
    $("#btnsim").on("click", function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/produtos/excluir/" + id,
            method: "GET",
            success: function(){
                window.location.href="/produtos";
            }
        });
    });

    if(valorDel == 1){
        alertaDel.classList.remove('d-none');
    }
})();