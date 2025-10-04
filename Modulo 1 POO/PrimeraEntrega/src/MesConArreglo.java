public class MesConArreglo {
    public static void main(String[] args) {
        System.out.println(nombreMes(1));
    }
    public static String nombreMes(int numero) {
        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Nomviembre", "Diciembre"
        };
        if (numero < 1 || numero > meses.length)
            return "Desconocido";
        return "El mes que corresponde: " + meses[numero - 1];
    }
}
