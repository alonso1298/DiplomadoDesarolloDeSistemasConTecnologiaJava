document.addEventListener("DOMContentLoaded", function(){

    const paisSelect = document.getElementById("pais");
    const ciudadSelect = document.getElementById("ciudad");

    paisSelect.addEventListener("change", function(){

        let idPais = this.value;

        if(idPais === ""){
            ciudadSelect.innerHTML = '<option value="">Seleccione ciudad</option>';
            return;
        }

        fetch("/utilerias/ciudades/" + idPais)
            .then(response => response.json())
            .then(data => {

                ciudadSelect.innerHTML = '<option value="">Seleccione ciudad</option>';

                data.forEach(ciudad => {

                    let option = document.createElement("option");

                    option.value = ciudad.idCiudad;
                    option.textContent = ciudad.nombre;

                    ciudadSelect.appendChild(option);

                });

            })
            .catch(error => console.error("Error:", error));

    });

});