(function(){
    let alertaDel = document.getElementById('alerta-del');
    let valorDel = $('#alerta-del').attr('name');

    $("#tabfornecedor").on("click", ".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalfornecedor").modal("show");
    });
    $("#btnsim").on("click", function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/fornecedores/excluir/" + id,
            method: "GET",
            success: function(){
                window.location.href="/fornecedores";
            }
        });
    });

    if(valorDel == 1){
        alertaDel.classList.remove('d-none');
    }
})();