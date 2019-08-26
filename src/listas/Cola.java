package listas;

/**
 *
 * @author vick08bv
 */
public class Cola {
    
    private Casilla primero;
    private Casilla ultimo;
    private int longitud;
    
    public Cola() {
        
        super();
        this.primero = null;
        this.ultimo = null;
        this.longitud = 0;
        
    }

    
    public Casilla getPrimero(){
        
        return this.primero;
    
    }
    
    
    public Casilla getUltimo(){
    
        return this.ultimo;
        
    }
    
    public void saca() {
        
        if (this.isVacia()){
            return;
        }
        
        primero = primero.getSig();
        
        this.longitud -= 1;
        
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
        
        this.longitud += 1;
    
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
    
    
    public int getLongitud(){
    
        return this.longitud;
    
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
