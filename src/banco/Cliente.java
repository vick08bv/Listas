 package banco;

/**
 * Implementación de un cliente en la fila de un banco.
 * @author vick08bv
 */
public class Cliente {
    
    /**
     * Asuntos que tendrá el cliente.
     */
    private Asunto[] asuntos;
    
    /**
     * Siguiente en la fila.
     */
    private Cliente siguiente;
    
    /**
     * Duración total de los asuntos del cliente.
     */
    private final int tiempoAtencion;
    
    /**
     * Tiempo de espera total en la fila.
     */
    private int tiempoEspera;
    
    /**
     * Constructor del cliente con una cantidad variable 
     * de asuntos por ser atendidos en el banco. 
     * @param asuntos Número máximo de asuntos.
     * @param duracion Duración máxima de cada asunto.
     */
    public Cliente(int asuntos, int duracion){
        
        this.asuntos = new Asunto[(int)(asuntos*Math.random() + 1)];
        int tiempo = 0;
        Asunto asunto;
    
        for(int i = 0; i < this.asuntos.length; i++){
        
            asunto = new Asunto(duracion);
            this.asuntos[i] = asunto;
            tiempo += asunto.getDuracion();
        
        }
        
        this.tiempoAtencion = tiempo;
        this.tiempoEspera = 0;
        this.siguiente = null;
    
    }
    
    /**
     * Cliente que se llega a formar en la fila.
     * @param siguiente Siguiente cliente.
     */
    public void setSiguiente(Cliente siguiente){
    
        this.siguiente = siguiente;
    
    }
    
    /**
     * Cliente que se llega a formar en la fila.
     * @return siguiente Siguiente cliente.
     */
    public Cliente getSiguiente(){
    
        return this.siguiente;
    
    }
    
    /**
     * El cliente espera en la fila.
     */
    public void esperar(){
    
        this.tiempoEspera += 1;
    
    }
    
    /**
     * Revisa si el cliente ha terminado de atender sus asuntos.
     * @return Si el cliente ha terminado.
     */
    public boolean terminado(){
    
        return (this.asuntos[this.asuntos.length - 1]
                                 .getDuracion() == 0);       
                
    }
    
    /**
     * El cliente atiende cada asunto.
     */
    public void atenderAsuntos(){
    
        for(int i = 0; i < this.asuntos.length; i++){
        
            if(this.asuntos[i].getDuracion() == 0){
            
                continue;
            
            }
            
            this.asuntos[i].atenderse();
            
            break;
        
        }
    
    }

    /**
     * Regresa el tiempo que tardará el cliente en el banco.
     * @return Tiempo.
     */
    public int getTiempoAtencion(){
    
        return this.tiempoAtencion;
    
    }
    
    /**
     * Regresa el tiempo de espera total.
     * @return Tiempo.
     */
    public int getTiempoEspera(){
    
        return this.tiempoEspera;
    
    }
    
    /**
     * Regresa el tiempo restante  del cliente en el banco.
     * @return Tiempo.
     */
    public int getTiempoRestante(){
    
        int restante = 0; 
                
        for(int i = 0; i < this.asuntos.length; i++){
        
            restante += this.asuntos[i].getDuracion();
            
        }
        
        return restante;
    
    }
    
    /**
     * Impresión del cliente.
     * @return Número de asuntos y duración total.
     */
    @Override
    public String toString(){
    
        return String.format("Asuntos: %s Duración Restante: %s",
                    this.asuntos.length, this.getTiempoRestante());
        
    }
    
}
