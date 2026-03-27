document.addEventListener("DOMContentLoaded", function() {
    
    // 1. Carrega o Header
    fetch('header.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('header-placeholder').innerHTML = data;
            
            // Depois que o header carregar, verifica o login
            verificarEstadoLogin();
        });

    // 2. Carrega o Footer
    fetch('footer.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('footer-placeholder').innerHTML = data;
        });
});

// Função que muda a cara do Header se o usuário estiver logado
function verificarEstadoLogin() {
    // Lê a 'memória' do navegador
    const usuarioLogado = localStorage.getItem('logado');

    if (usuarioLogado === 'true') {
        // Pega os elementos do HTML pelo ID
        const textoConta = document.getElementById('texto-conta');
        const linkConta = document.getElementById('btn-conta');
        
        // Altera para a visão de logado
        if (textoConta) textoConta.innerText = "Minha Conta";
        if (linkConta) linkConta.href = "#"; // Aqui você colocaria o link do perfil do usuário
        
        // Opcional: Você pode mudar a imagem do ícone também
        // document.getElementById('icone-conta').src = "link-do-novo-icone-aqui";
    }
}