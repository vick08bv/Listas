package lista;

/**
 *
 * @author vick08bv
 */
public class Cola {
    
    private Casilla primero;
    private Casilla ultimo;

    
    public Cola() {
        
        super();
        this.primero = null;
        this.ultimo = null;
        
    }

    
    public Casilla getInicio(){
        
        return this.primero;
    
    }
    
    
    public Casilla getFinal(){
    
        return this.ultimo;
        
    }
    
    public Casilla saca() {
        
        return primero;
        
    }
    

    public void mete(Casilla nueva) {
        
        this.ultimo.setSig(nueva);
        this.ultimo = nueva;
    
    }

    
    public boolean isVacia(){
    
        return (this.primero == null);
        
    }
    
    
    public void anula(){
    
        this.primero = null;
    
    }
    
    
    @Override
    public boolean equals(Object o) {
        
        return true;
        
    }
    
    
    @Override
    public String toString(){
    
        Casilla aux = this.primero;
        
        String salida = "";
            
        while(aux != null){
            
            salida += aux.getInfo();
            aux = aux.getSig();
            
        }
    
        return salida;
        
    }
    
    
    
}
