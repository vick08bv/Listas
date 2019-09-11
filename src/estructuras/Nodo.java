package estructuras;

/**
 *
 * @author vick08bv
 */
public class Nodo {
    
    private String info;
    private Nodo izq;
    private Nodo der;
    
    public Nodo(){
    
        this.info = "";
        this.izq = null;
        this.der = null;

    }
    
    public Nodo(String info){
    
        this.info = info;
        izq = null;
        der = null;
        
    }
    
    public Nodo(String info, Nodo izq, Nodo der){
    
        this.info = info;
        this.izq = izq;
        this.der = der;
        
    }
    
    public void setIzq(Nodo izq){
    
        this.izq = izq;
        
    }
    
    public void setDer(Nodo der){
    
        this.der = der;
        
    }
    
    public Nodo getIzq(){
    
        return this.izq;
        
    }
    
    public Nodo getDer(){
    
        return this.der;
        
    }
    
    public String getInfo(){
    
        return this.info;
        
    }
    
    @Override
    public String toString(){
    
        String salida = this.info + "\n";
        
        if(this.izq != null){
        
            salida += this.izq.toString();
            
        }
        
        if(this.der != null){
        
            salida += this.der.toString();
            
        }
        
        return salida;
        
    }
    
    public String printPostOrden(){
    
        String salida = "\n";
        
        if(this.izq != null){
        
            salida += this.izq.printPostOrden();
            
        }
        
        if(this.der != null){
        
            salida += this.der.printPostOrden();
            
        }
            
        salida += this.info + "\n";
        
        return salida;
        
    }
    
    public String printInOrden(){
    
        String salida = "\n";
        
        if(this.izq != null){
        
            salida += this.izq.printInOrden();
            
        }
        
        salida += this.info + "\n";
        
        if(this.der != null){
        
            salida += this.der.printInOrden();
        
        }
            
        return salida;
        
    }
    
}
