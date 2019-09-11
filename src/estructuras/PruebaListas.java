package estructuras;

/**
 *
 * @author vick08bv
 */
public class PruebaListas {

    /**
     * @param arg the command line arguments.
     */
    public static void main(String[] arg){
    
//        Casilla cas = new Casilla('a');
//        Casilla ncas = new Casilla('b');
//        
//        Pila p = new Pila();
//        
//        p.pon(cas);   
//        p.pon(ncas);
//        
//        System.out.println(cas.equals(ncas));
//        System.out.println(p.toString());
//        
//        Pila r = new Pila();
//        Casilla s = null;
//        
//        for(int i = 0; i < 15; i++){
//            s = new Casilla((char)('a' + i));
//            r.pon(s);
//            System.out.println(r.getTope());
//        }
//            
//        System.out.println(r);
//
//        for(int i = 0; i < 15; i++){
//            System.out.println(r.getTope());
//            r.quita();
//        }
//        
//        System.out.println(r.isVacia());
//        
//        p.anula();
//        
//        System.out.println(p.isVacia());
//    
//        
//        Cola c = new Cola();
//    
//        System.out.println(c);
//        
//        c.mete(new Casilla('c'));
//        
//        System.out.println(c);
//        
//        Lista l = new Lista();
//        Casilla c1 = new Casilla('a');
//        Casilla c2 = new Casilla('b');
//        Casilla c3 = new Casilla('c');
//        Casilla c4 = new Casilla('d');
//        
//        l.inserta(c1, 1);
//        l.inserta(c2, 1);
//        l.inserta(c3, 3);
//        l.inserta(c4, 1);
//        
//        System.out.println(l.localiza('a'));
//        System.out.println(l.localiza('b'));
//        System.out.println(l.localiza('c'));
//        System.out.println(l.localiza('d'));
//        System.out.println(l.localiza('e'));
//        
//        System.out.println(l);
        
        Nodo a1 = new Nodo("Manzana");
        
        Nodo a2 = new Nodo("Plátano");
        
        Nodo a3 = new Nodo("Mango");
        
        Nodo a4 = new Nodo("Papaya");
        
        Nodo a5 = new Nodo("Melón");
        
        Nodo a6 = new Nodo("Kiwi");
        
        Nodo a7 = new Nodo("Sandía");
        
        Nodo a8 = new Nodo("Pitahaya");
        
        Nodo a9 = new Nodo("Uva");
        
        Nodo a10 = new Nodo("Pera");

        Arbol arbol = new Arbol(a1);
        
        a1.setIzq(a2);
        a1.setDer(a3);
        a2.setDer(a4);
        a4.setIzq(a7);
        a3.setIzq(a5);
        a3.setDer(a6);
        a5.setIzq(a8);
        a6.setIzq(a9);
        a6.setDer(a10);
        
        System.out.printf("\n %s \n", arbol.toString());
        System.out.printf("\n %s \n", arbol.printPostOrden());
        System.out.printf("\n %s \n", arbol.printInOrden());
        
        Arbol arb2 = new Arbol(
                     new Nodo("Manzana"), 
                        new Arbol(new Nodo("Plátano"), null, 
                            new Arbol(new Nodo("Papaya"),
                                new Arbol(new Nodo("Sandía"), null, null), null)
                        ), 
                        new Arbol(new Nodo("Mango"), 
                            new Arbol(new Nodo("Melón"), 
                                new Arbol(new Nodo("Pitahaya"), null, null), null),
                            new Arbol(new Nodo("Kiwi"), 
                                new Arbol(new Nodo("Uva"), null, null), 
                                new Arbol(new Nodo("Pera"), null, null)))
                     )
        
        
    }
    
    
}
