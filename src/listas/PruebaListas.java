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
        l.inserta(c2, 1);
        l.inserta(c3, 3);
        l.inserta(c4, 1);
        System.out.println(l.localiza('a'));
        System.out.println(l.localiza('b'));
        System.out.println(l.localiza('c'));
        System.out.println(l.localiza('d'));
        System.out.println(l.localiza('e'));
        
        System.out.println(l);
        
        Nodo a1 = new Nodo("Plátano");
        
        Nodo a2 = new Nodo("Pera");
        
        Nodo a3 = new Nodo("Manzana");
        
        Nodo a4 = new Nodo("Guayaba");
        
        Nodo a5 = new Nodo("Kiwi");
        
        Nodo a6 = new Nodo("Uva");
        
        System.out.println(a1);
        Arbol arbol = new Arbol(a1);
        
        a1.setIzq(a2);
        a1.setDer(a3);
        a2.setIzq(a4);
        a4.setDer(a5);
        a5.setDer(a6);
        
        System.out.println(arbol);
        
    }
    
    
}
