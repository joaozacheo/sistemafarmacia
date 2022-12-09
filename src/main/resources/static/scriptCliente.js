(function(){
    let alertaDel = document.getElementById('alerta-del');
    let valorDel = $('#alerta-del').attr('name');

    $("#tabclientes").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalcliente").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/clientes/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/clientes";
            }
        });
    });

    if(valorDel == 1){
        alertaDel.classList.remove('d-none');
    }
})();