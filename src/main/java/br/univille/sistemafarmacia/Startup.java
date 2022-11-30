// package br.univille.sistemafarmacia;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.event.ContextRefreshedEvent;
// import org.springframework.context.event.EventListener;
// import org.springframework.stereotype.Component;

// import br.univille.sistemafarmacia.entity.Login;
// import br.univille.sistemafarmacia.repository.LoginRepository;

// @Component
// public class Startup {
//     @Autowired
//     private LoginRepository repository;
    
//     @EventListener
//     public void onApplicationEvent(ContextRefreshedEvent event){
//         if(repository.findByNome("usuario") == null){
//             var loginUser = new Login();
//             loginUser.setNome("usuario");
//             loginUser.setSenha("usuario");
//             repository.save(loginUser);
//         }
//     }

// }
