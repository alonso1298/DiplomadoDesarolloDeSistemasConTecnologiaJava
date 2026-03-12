document.getElementById("pais").addEventListener("change", function () {

    const paisId = this.value;
    const ciudadSelect = document.getElementById("ciudad");

    ciudadSelect.innerHTML = '<option value="">Seleccione ciudad</option>';

    if (paisId) {

        fetch('/utilerias/capitales/' + paisId)
            .then(res => res.json())
            .then(data => {

                data.forEach(c => {

                    let option = document.createElement("option");

                    option.value = c.id;
                    option.text = c.nombre;

                    ciudadSelect.appendChild(option);

                });

            });
    }
});