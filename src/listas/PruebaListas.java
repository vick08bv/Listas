package listas;

/**
 *
 * @author vick08bv
 */
public class PruebaListas {

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
        
        Lista l = new Lista();
        Casilla c1 = new Casilla('a');
        Casilla c2 = new Casilla('b');
        Casilla c3 = new Casilla('c');
        Casilla c4 = new Casilla('d');
        
        l.inserta(c1, 1);
        l.inserta(c2, 2);
        l.inserta(c3, 2);
        l.inserta(c4, 1);
        
        System.out.println(l);
        
        
    }
    
    
}
