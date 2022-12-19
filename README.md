<h1 align="center" > 💊 SISTEMA DE FARMÁCIA </h1>

<p align="center">
    <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/joaozacheo/sistemafarmacia">
    <img alt="Repository size" src="https://img.shields.io/github/repo-size/joaozacheo/sistemafarmacia">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/joaozacheo/sistemafarmacia">
</p>

<p align="center">
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#%EF%B8%8F-funcionamento">Funcionamento</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-acesso-ao-projeto">Acesso</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-tecnologias-usadas">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#%EF%B8%8F-autores">Autores</a>
</p>

</br>

## 💻 Projeto

Projeto desenvolvido com base no curso *_Novos Talentos em TI_* da [Univille](https://www.univille.edu.br/). A aplicação corresponde a um sistema de cadastro voltado aos funcionários de uma farmácia.

O sistema conta com as funcionalidades:
- Sistema de segurança (tela de login)
- Cadastro de vendas
- Cadastro de clientes
- Cadastro de funcionários
- Cadastro de fornecedores
- Cadastro de produtos
- Cadastro de cidades
- Cadastro de formas de pagamento

</br>

## ⚙️ Funcionamento

Tomamos como exemplo para demonstrar o sistema a rede JG Farmácias.

### 🛡️ Segurança

A aplicação conta com um [sistema de segurança](#-tecnologias-usadas) e apresenta uma tela de login para autorizar o acesso do usuário.

![tela de login](https://imgur.com/u5o4MNU.png)

A principal funcionalidade do sistema é o controle de vendas, por isso, após o login, o usuário é direcionado diretamente para esta tela.

![tela principal](https://imgur.com/wO7Gg67.png)

Porém existem outras abas que servem para cadastros gerais. Aqui usaremos o exemplo da tela de clientes, mas o mesmo serve para as outras. As telas de cadastro contam com 4 funcionalidades principais:
- [`Funcionalidade 1:`](#-funcionalidade-1-botão-para-adição-de-novos-dados) Botão para adição de novos dados
- [`Funcionalidade 2:`](#-funcionalidade-2-barra-de-pesquisa) Barra de pesquisa
- [`Funcionalidade 3:`](#-funcionalidade-3-botão-para-alteração-de-dados) Botão para alteração de dados
- [`Funcionalidade 4:`](#-funcionalidade-4-botão-para-exclusão-de-dados) Botão para exclusão de dados

![exemplo de página de cadastro](https://imgur.com/ZZTikRG.png)

### 📥 Funcionalidade 1: Botão para adição de novos dados

Ao clicar no botão de "Novo Cliente" o sistema direciona o usuário para um formulário, onde ele deverá preencher o mesmo com as informações exigidas.

![exemplo de formulário de cadastro](https://imgur.com/Zmbib5A.png)

Com todas as informações preenchidas, o usuário deverá clicar em "Salvar" para que o sistema salve as informações no [banco de dados](#-tecnologias-usadas).

![novo dado salvo](https://imgur.com/cC7hy6e.png)

### 🔍 Funcionalidade 2: Barra de pesquisa

Com o objetivo de facilitar o acesso às informações da tabela, adicionamos uma barra de pesquisa. Assim o usuário poderá pesquisar por algumas informações para encontrar o dado que precisa.

![pesquisa](https://imgur.com/IHl24RK.gif)

### 📝 Funcionalidade 3: Botão para alteração de dados

O usuário também tem a possibilidade de alterar dados, caso necessário, apenas clicando no botão alterar. O sistema o direcionará para o formulário com os dados preenchidos e após feita a alteração, o usuário poderá salvar as informações normalmente.

![alteração de dados](https://imgur.com/NNFAwjx.gif)

### ❌ Funcionalidade 4: Botão para exclusão de dados

Se houver a necessidade de excluir um dado, o usuário tem a opção de clicar no botão "Excluir". Um alerta de corfimação aparecerá na tela com as opções de confirmar e cancelar o procedimento.

> ⚠️ Atenção: Caso o dado a ser excluído esteja vinculado em outros cadastros, como uma venda, o sistema alertará que é não é possível executar a exclusão.

![alerta de exclusão](https://imgur.com/nJ27DHX.png)

### ⚠️ Alertas
Durante todo o uso da aplicação adicionamos alertas de erros que facilitam a compreensão do que não é aceito pelo sistema. A imagem abaixo ilustra a situação de uma tentativa de venda sem os dados necessários para o cadastro.

![alertas de erros](https://imgur.com/jVj2bGc.png)

### 🛡️ Logout

Ao finalizar o uso, o usuário poderá fazer o logout do sistema clicando no ícone de logout.

![logout](https://imgur.com/U41kIXf.gif)

</br>

## 🔗 Acesso ao projeto

Você pode acessar o projeto [aqui](https://github.com/joaozacheo/sistemafarmacia) ou [baixá-lo](https://github.com/joaozacheo/sistemafarmacia/archive/refs/heads/main.zip).

Se a aplicação estiver no ar, você pode testá-la [aqui](https://sistemafarmacia-1671417070640.azurewebsites.net).

</br>

## 🚀 Tecnologias Usadas

Para a construção da aplicação foram utilizadas as tecnologias:

|   |   |   |   |
|---|---|---|---|
| ![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)  | Java | ![jquery](https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white)  | JQuery |
| ![html](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)  | HTML | ![sprint boot](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)  | Spring Boot |
| ![css](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)  | CSS | ![spring security](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)  | Spring Security |
| ![bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)  | Bootstrap | ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white) | Thymeleaf |
| ![javascript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)  | JavaScript | ![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white) | MariaDB |
|   |   |   |   |

</br>

## ✒️ Autores
| [<img src="https://avatars.githubusercontent.com/u/95360206?v=4" width=120 height=120 style="border-radius:50%"><br><sub>João Zachêo</sub>](https://github.com/joaozacheo) |  [<img src="https://imgur.com/nbMXl1K.png" height=120 style="border-radius:50%"><br><sub>Guilherme Sibovicz</sub>](https://github.com/guilhermesibovicz) | 
| :---: | :---: |