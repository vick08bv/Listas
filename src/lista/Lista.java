package lista;

/**
 *
 * @author vick08bv
 */
public class Lista {

    /**
     * @param arg the command line arguments.
     */
    public static void main(String[] arg){
    
        Casilla cas = new Casilla('a');
        Casilla ncas = new Casilla('b');
        
        Pila p = new Pila();
        
        p.pon(cas);   
        p.pon(ncas);
        
        System.out.println(cas.equals(ncas));
        System.out.println(p.toString());
        
        Pila r = new Pila();
        Casilla s = null;
        
        for(int i = 0; i < 15; i++){
            s = new Casilla((char)('a' + i));
            r.pon(s);
            System.out.println(r.getTope());
        }
            
        System.out.println(r);

        for(int i = 0; i < 15; i++){
            System.out.println(r.getTope());
            r.quita();
        }
        
        System.out.println(r.isVacia());
        
        p.anula();
        
        System.out.println(p.isVacia());
    
        
        Cola c = new Cola();
    
        System.out.println(c);
        
        c.mete(new Casilla('c'));
        
        System.out.println(c);
        
    }
    
    
}
