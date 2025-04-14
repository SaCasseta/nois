fetch('http://localhost:8080/usuario/login', {
    method: 'POST',
    headers: { 
        'Content-Type': 'application/json',
        'Accept-Language': language // Enviando a linguagem selecionada
    },
    body: JSON.stringify({ username, password, remember })
})
.then(response => response.json())
.then(data => {
    if (data.success) {
        alert(data.message);  // A resposta do backend já contém a mensagem traduzida
        window.location.href = 'dashboard.html';
    } else {
        alert(data.message);  // A resposta do backend já contém a mensagem de erro traduzida
    }
})
.catch(error => {
    alert("Erro ao fazer login");
    console.log(error);
});
