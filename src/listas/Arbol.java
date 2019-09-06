package listas;

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
    
    @Override
    public String toString (){
    
        return "Raiz\n" + this.raiz.toString();
        
    }
    
}
