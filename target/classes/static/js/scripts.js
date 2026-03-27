document.addEventListener("DOMContentLoaded", function() {
    
    // 1. Header
    fetch('header.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('header-placeholder').innerHTML = data;
            
            verificarEstadoLogin();
        });

    // 2. Footer
    fetch('footer.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('footer-placeholder').innerHTML = data;
        });
});

function verificarEstadoLogin() {
    const usuarioLogado = localStorage.getItem('logado');

    if (usuarioLogado === 'true') {
        const textoConta = document.getElementById('texto-conta');
        const linkConta = document.getElementById('btn-conta');
        
        if (textoConta) textoConta.innerText = "Minha Conta";
        if (linkConta) linkConta.href = "#";

    }
}