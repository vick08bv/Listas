package listas;

/**
 *
 * @author vick08bv
 */
public class Lista {
    
    
    private Casilla primero;
    private int longitud;
    

    public Lista() {
        
        this.primero = null;
        this.longitud = 0;
        
    }
    
    
    public void inserta(Casilla elemento, int pos){
    
        if (elemento == null){
            return;
        }
        
        if (this.isVacia()){
            
            if(pos == 1){
            
                this.primero = elemento;
            
            } else {
        
                return;
        
            }
            
        if(pos > this.getLongitud()){
        
            return;
        
        }
        
        Casilla aux = this.primero;
        
        for (int i = 0; i < pos - 1; i++){
        
            aux = aux.getSig();
        
        }
        
        elemento.setSig(aux.getSig());
        aux.setSig(elemento);
            
        }
    
    }
    
    
    public void anula(){
    
        this.primero = null;
    
    }
    
    
    public int getLongitud(){
    
        return this.longitud;
    
    }
    
    
    public boolean isVacia(){
    
        return this.primero == null;
    
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
