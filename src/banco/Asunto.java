package banco;

/**
 * Implementación de un asunto en la ventanilla de un banco.
 * @author vick08bv
 */
public class Asunto {
    
    /**
     * Duración del asunto en minutos, en un rango de 0 a 10.
     */
    private int duracion; 

    /**
     * Inicia el asunto con su respectiva duración.
     */
    public Asunto() {
        
        this.duracion = (int)(10*Math.random() + 1);
        
    }
    
    /**
     * Devuelve la duración del asunto.
     * @return Duración del asunto.
     */
    public int getDuracion(){
    
        return this.duracion;
        
    }
    
    /**
     * Se atiende el asunto tanto tiempo como se necesite.
     */
    public void atenderse(){
    
        this.duracion -= 1;
    
    }

}
