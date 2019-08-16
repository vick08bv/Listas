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
public class Lista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] arg){
    
        Casilla cas = new Casilla('a');
        
        Casilla ncas = new Casilla('b');
        
        Pila p = new Pila();
        
        p.pon(cas);
                
        p.pon(ncas);
        
        System.out.println(p.toString());
        
        
        Pila r = new Pila();
        Casilla s = null;
        
        for(int i = 0; i < 15; i++){
            
            s = new Casilla((char)('a' + i));
            r.pon(s);
            
            
        }
            
        System.out.println(r);
    
    }
    
}
