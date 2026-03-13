document.getElementById("pais").addEventListener("change", function() {

    let idPais = this.value;

    fetch("/ciudades/" + idPais)
        .then(response => response.json())
        .then(data => {

            let ciudadSelect = document.getElementById("ciudad");
            ciudadSelect.innerHTML = "";

            data.forEach(ciudad => {

                let option = document.createElement("option");
                option.value = ciudad.idCiudad;
                option.text = ciudad.nombre;

                ciudadSelect.appendChild(option);
            });

        });

});