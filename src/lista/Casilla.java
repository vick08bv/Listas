package lista;

/**
 *
 * @author vick08bv
 */

public class Casilla {
    
    /**
     * Carácter que contiene la casilla.
     */
    private char info;
    
    /**
     * Casilla que queda por debajo en la pila.
     */
    private Casilla sig;

    /**
     * Constructor con valores nulos.
     */
    public Casilla(){
        
        super();
        this.info = '\000';
        this.sig = null;
    }

    /**
     * Constructor con carácter inicial.
     * @param c Caractér.
     */
    public Casilla(char c){
    
        super();
        this.info = c;
        this.sig = null;
    
    }

    /**
     * Averigua si una casilla posee la misma información que otra.
     * @param c Casilla.
     * @return La igualdad entre casillas.
     */
    public boolean equals(Casilla c){
    
        return this.info == c.info;
    
    }

    /**
     * Información de la casilla.
     * @return Carácter que contiene la casilla.
     */
    public char getInfo(){
    
        return this.info;
    
    }
    
    /**
     * Cambia el carácter de la casilla.
     * @param c Nuevo caractér.
     */
    public void setInfo(char c){
    
        this.info = c;
        
    }
    
    /**
     * Casilla por debajo de la casilla actual en la pila.
     * @return Casilla.
     */
    public Casilla getSig(){
    
        return this.sig;
    
    }
    
    /**
     * Apunta a la casilla que irá inmediatamente debajo en la pila.
     * @param s Casilla.
     */
    public void setSig(Casilla s){
    
        this.sig = s;
        
    }

    /**
     * Caracter en la casilla.
     * @return Caracter convertido a cadena.
     */
    public String toString(){
    
        return this.info + "";
    
    }
    
}
