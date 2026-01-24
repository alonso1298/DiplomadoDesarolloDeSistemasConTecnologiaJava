package dgtic.core.servicio;

public class PredeterminadoServicio {
    private static IEmpleadoServicio empleadoServicio = new EmpleadoServicioImpl();
    private static IReporteEmpleadoServicio empleadoReporteServicio = new ReporteEmpleadoServicioImpl();

    private PredeterminadoServicio(){}

    public IEmpleadoServicio getEmpleadoServicio() {
        return empleadoServicio;
    }
    public IReporteEmpleadoServicio getReporteEmpleadoServicio() {
        return empleadoReporteServicio;
    }
}
