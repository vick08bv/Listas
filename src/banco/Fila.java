package banco;

/**
 * Implementación de la fila de un banco.
 * @author vick08bv
 */
class Fila implements Comparable<Fila>{
    
    /**
     * Primer cliente en la fila.
     */
    private Cliente primero;
    
    /**
     * Último cliente en la fila.
     */
    private Cliente ultimo;
    
    /**
     * Cantidad de clientes en la fila.
     */
    private int longitud;
    
    /**
     * Clientes atendidos.
     */
    private int clientes;
    
    /**
     * Tiempo total atendido.
     */
    private int tiempoAtencion;
    
    /**
     * Tiempo de espera total de los clientes atendidos.
     */
    private int tiempoEspera;
    
    /**
     * Inicia la fila, sin clientes.
     */
    public Fila() {

        this.primero = null;
        this.ultimo = null;
        this.longitud = 0;
        this.clientes = 0;
        this.tiempoAtencion = 0;
        this.tiempoEspera = 0;
        
    }

    /**
     *Añade un cliente a la fila.
     * @param nuevo Cliente nuevo.
     */
    public void mete(Cliente nuevo) {
        
        if(nuevo == null){
            
            return;
        
        }
        
        if(this.isVacia()){
        
            this.primero = nuevo;
            this.ultimo = nuevo;
            
            this.longitud += 1;
            
            return;
        
        }
        
        this.ultimo.setSiguiente(nuevo);
        this.ultimo = this.ultimo.getSiguiente();
        
        this.longitud += 1;
    
    }

    /**
     * Saca el cliente que ya ha sido atendido.
     */
    public void saca() {
        
        if (this.isVacia()){
            
            return;
            
        }
        
        this.clientes += 1;
        this.tiempoAtencion += this.primero.getTiempoAtencion();
        this.tiempoEspera += this.primero.getTiempoEspera();
        this.longitud -= 1;
        
        if(this.isVacia()){
        
            this.ultimo = null;
        
        }
        
        this.primero = primero.getSiguiente();
        
    }
    
    /**
     * Hace esperar a los clientes.
     */
    public void esperar(){
    
        Cliente cliente = this.primero;
                    
        while(cliente != null){
            
            cliente.esperar();
            cliente = cliente.getSiguiente();
            
        }
    
    }
    
    /**
     * Atiende un asunto de un cliente mientras los demás esperan. 
     */
    public void atenderClientes(){
    
        if(this.isVacia()){
        
            return;
            
        }
        
        Cliente cliente = this.primero.getSiguiente();
                    
        while(cliente != null){
            
            cliente.esperar();
            cliente = cliente.getSiguiente();
            
        }
    
        this.primero.atenderAsuntos();
        
        if(this.primero.terminado()){
            
            this.saca();
        
        }
        
    }
    
    /**
     * Anula la fila.
     */
    public void anula(){
    
        this.primero = null;
        this.ultimo = null;
        
        this.longitud = 0;
        this.clientes = 0;
        this.tiempoAtencion = 0;
        this.tiempoEspera = 0;
    
    }

    /**
     * Revisa si la fila está vacía.
     * @return 
     */
    public boolean isVacia(){
    
        return (this.primero == null);
        
    }
    
    /**
     * Obtiene el primer cliente en la fila.
     * @return Primero.
     */
    public Cliente getPrimero(){
        
        return this.primero;
    
    }
    
    /**
     * Obtiene el último cliente en la fila.
     * @return Último.
     */
    public Cliente getUltimo(){
        
        return this.ultimo;
    
    }
    
    /**
     * Devuelve la longitud de la fila.
     * @return Longitud.
     */
    public int getLongitud(){
    
        return this.longitud;
    
    }
    
    /**
     * Regresa el número total de clientes atendidos.
     */
    public int getClientes(){
    
        return this.clientes;
        
    }
    
    /**
     * Regresa el tiempo total de atención.
     */
    public int getTiempoAtencion(){
    
        return this.tiempoAtencion;
    
    }
    
    /**
     * Regresa el tiempo total de espera de los clientes atendidos.
     */
    public int getTiempoEspera(){
    
        return this.tiempoEspera;
    
    }

    /**
     * Compara dos filas, por su longitud
     * @param fila Otra fila del banco.
     * @return Fila más corta.
     */
    @Override
    public int compareTo(Fila fila) {
        
        if(this.getLongitud() < fila.getLongitud()){
        
            return -1;
        
        } else if(this.getLongitud() > fila.getLongitud()){
        
            return 1;
        
        } else {
        
            return 0;
        
        }
        
    }
    
    /**
     * Impresión de la fila.
     * @return Longitud de la fila.
     */
    @Override
    public String toString(){
    
        return String.format("Longitud: %s", this.longitud);
        
    }
    
}
