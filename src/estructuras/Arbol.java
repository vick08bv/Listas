package estructuras;

/**
 *
 * @author vick08bv
 */
public class Arbol {
    
    private Nodo raiz;
    
    public Arbol(){
    
        this.raiz = null;
        
    }
    
    public Arbol(Nodo raiz){
    
        this.raiz = raiz;
        
    }
    
    public Arbol(Nodo raiz, Arbol izq, Arbol der){
    
        this.raiz = raiz;
        
        if(izq != null){
            
            raiz.setIzq(izq.getRaiz());
        
        }
        
        if(der != null){
            
            raiz.setDer(der.getRaiz());
        
        }
        
    }
    
    public Nodo getRaiz(){
    
        return this.raiz;
        
    }
    
    @Override
    public String toString (){
    
        return this.raiz.toString();
        
    }
    
    public String printPostOrden (){
    
        return  this.raiz.printPostOrden();
        
    }
    
    public String printInOrden (){
    
        return  this.raiz.printInOrden();
        
    }
    
}
