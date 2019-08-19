package lista;

/**
 *
 * @author windows
 */
public class SignoAgrupacion {
    
    String cadena;
    final char[] todos = {'{', '}', '[', ']', '(', ')'};
    final char[] abre = {'{', '[', '('};

    public SignoAgrupacion(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public String toString() {
        return "SignoAgrupacion{" + "cadena=" + cadena + '}';
    }
    
    
    
}
