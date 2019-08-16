/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lista;


/**
 *
 * @author vick08bv
 */
public class Pila {
    
    
    private Casilla tope;
    
    
    public Pila(){
    
        this.tope = null;
    
    }
    
    
    public void pon(Casilla cas){
    
        if(this.tope == null){
            tope = cas;
        } else {
            cas.setSig(this.tope);
            this.tope = cas;
        }
    
    }
    
    
    public Casilla getTope(){
    
        return this.tope;
    
    }
    
    
    public String toString(){
    
        Casilla aux = this.tope;
        
        String salida = "";
            
        while(aux != null){
            
            salida += aux.getInfo();
            aux = aux.getSig();
            
        }
    
    }

    
}
