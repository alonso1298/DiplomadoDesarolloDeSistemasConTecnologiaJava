document.getElementById("categoria").addEventListener("change", function () {
        const categoriaId = this.value;
        const productoSelect = document.getElementById("producto");

        productoSelect.innerHTML = '<option value="">Seleccione producto</option>';
        if (categoriaId) {
            fetch('/utilerias/productos/' + categoriaId)
                .then(res => res.json())
                .then(data => {
                    data.forEach(p => {
                        let option = document.createElement("option");
                        option.value = p.id_producto;
                        option.text = p.nombre;
                        productoSelect.appendChild(option);
                    });
                });
        }
    });