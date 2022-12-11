(function(){
    let alertaDel = document.getElementById('alerta-del');
    let valorDel = $('#alerta-del').attr('name');
    
    $("#tabfuncionario").on("click", ".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalfuncionario").modal("show");
    });

    $("#btnsim").on("click", function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/funcionarios/excluir/" + id,
            method: "GET",
            success: function(){
                window.location.href="/funcionarios";
            }
        });
    });

    if(valorDel == 1){
        alertaDel.classList.remove('d-none');
    }
    
    $(document).ready(function(){
        $('#txt-cpf').mask('000.000.000-00');
    });

})();