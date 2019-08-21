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

    
    public Casilla getPrimero(){
        
        return this.primero;
    
    }
    
    
    public Casilla getUltimo(){
    
        return this.ultimo;
        
    }
    
    public Casilla saca() {
        
        return primero;
        
    }
    

    public void mete(Casilla nueva) {
        
        if(nueva == null){
            return;
        }
        
        if(this.isVacia()){
        
            this.primero = nueva;
            this.ultimo = nueva;
            return;
        
        }
        
        this.ultimo.setSig(nueva);
        this.ultimo = nueva;
    
    }

    
    public boolean isVacia(){
    
        return (this.primero == null);
        
    }
    
    
    public void anula(){
    
        this.primero = null;
        this.ultimo = null;
    
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
        
        if ("".equals(salida)){
        
            return "Es vacia";
    
        }
    
        return salida;
        
    }
    
    
    
}
