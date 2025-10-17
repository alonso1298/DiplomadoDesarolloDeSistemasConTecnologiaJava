import org.w3c.dom.ls.LSOutput;

public class MesesConTryCatch {
    public static void main(String[] args) {

        System.out.println(nombreMes(3));
        System.out.println(nombreMes(55));
        System.out.println(nombreMes(99));

    }
        public static String nombreMes(int numero) {
            String[] meses = {
                    "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                    "Julio", "Agosto", "Septiembre", "Octubre", "Nomviembre", "Diciembre"
            };
            try {
                return "El mes que corresponde: " + meses[numero - 1];
            } catch (ArithmeticException e) {
                return "Invalido";
            }
        }
}
