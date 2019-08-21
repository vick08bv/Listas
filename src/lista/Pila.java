package lista;

/**
 *
 * @author vick08bv
 */

public class Pila {

    /**
     * Casilla en la cima de la pila.
     */
    private Casilla tope;

    /**
     * Inicio de una pila vacía.
     */
    public Pila(){
    
        super();
        this.tope = null;
    
    }
    
    /**
     * Pone una casilla en la cima de la pila.
     * @param cas Nueva casilla.
     */
    public void pon(Casilla cas){   
        
        if(cas == null){
            return;
        }
    
        if(this.tope == null){
            tope = cas;
        } else {
            cas.setSig(this.tope);
            this.tope = cas;
        }
    
    }
    
    /**
     * Quita la casilla en la cima de la pila.
     */
    public void quita(){
    
        tope = tope.getSig();
    
    }
    
    /**
     * Revisa si la pila está vacía.
     * @return True si la pila no tiene casillas.
     */
    public boolean isVacia(){
    
        return this.tope == null;
        
    }
    
    /**
     * Quita todas las casillas de la pila.
     */
    public void anula(){
    
        tope = null;
    
    }
    
    /**
     * Obtiene la casilla en la cima de la pila.
     * @return Casilla.
     */
    public char getTope(){
    
        return tope.getInfo();
    
    }
    
    /**
     * Información de la pila.
     * @return Caracteres de las casillas en la pila.
     */
    @Override
    public String toString(){
    
        Casilla aux = this.tope;
        
        String salida = "";
            
        while(aux != null){
            
            salida += aux.getInfo();
            aux = aux.getSig();
            
        }
        
        if ("".equals(salida)){
        
            return "Es vacia";
    
        }
        
        return salida;
        
    }
    
    
}
