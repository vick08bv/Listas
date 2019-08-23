package lista;

/**
 *
 * @author windows
 */
public class Lista {
    
    
    private Casilla primero;
    private int longitud;
    

    public Lista() {
        
        this.primero = null;
        this.longitud = 0;
        
    }
    
    
    public void anula(){
    
        this.primero = null;
    
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
