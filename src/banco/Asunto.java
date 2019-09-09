package banco;

/**
 * Implementación de un asunto en la ventanilla de un banco.
 * @author vick08bv
 */
public class Asunto {
    
    /**
     * Duración del asunto en minutos, en un rango de 1 a 10.
     */
    private int duracion; 

    /**
     * Inicia el asunto con su respectiva duración.
     * @param duracion Duración máxima del asunto.
     */
    public Asunto(int duracion) {
        
        this.duracion = (int)(duracion*Math.random() + 1);
        
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
