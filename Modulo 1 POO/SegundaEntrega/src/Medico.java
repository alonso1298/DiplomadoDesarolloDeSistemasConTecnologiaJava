public class Medico extends Persona{
    // Atributos
    private String especialidad;
    private double precioConsulta;

    // Métodos
    public Medico() {
        super(); // Ejecutanos el constructor del padre (Persona())
        super.setNombre("Dr desconocido");
        this.setEdad(40); // setEdad de Medico
        super.setEdad(40); // setEdad de Persona
        this.especialidad = "Especialidad";
        this.precioConsulta = 100;
    }

    @Override
    public void setEdad (int edad){
        if(edad >= 20 && edad <= 80)
            super.setEdad(edad);
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getPrecioConsulta() {
        return precioConsulta;
    }

    public void setPrecioConsulta(double precioConsulta) {
        if (precioConsulta >= 100)
            this.precioConsulta = precioConsulta;
    }

    @Override
    public String toString() {
        return super.toString() + " . Medico{" +
                "especialidad='" + especialidad + " Consulta $" + precioConsulta;
    }

    // IControles Comunes
    @Override
    public boolean create() {
        // INSERT INTO personalMedico...
        return false;
    }

    @Override
    public boolean read() {
        // SELECT * FROM personalMedico
        return false;
    }

    @Override
    public int update() {
        // UPDATE personalMedico
        return 0;
    }

    @Override
    public int delete() {
        // DELETE/UPDATE personalMedico WHERE....
        return 0;
    }
}
