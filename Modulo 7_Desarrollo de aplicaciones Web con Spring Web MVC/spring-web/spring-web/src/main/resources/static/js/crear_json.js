function crear(){
    const formulario = {
        categoriaId: document.getElementById("categoria").value,
        productoId: document.getElementById("producto").value
    };
    fetch("/utilerias/guardar_json", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formulario)
    })
    .then(response => response.json())
    .then(data => {
        alert(data.mensaje)
    });

}