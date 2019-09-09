package banco;
import java.util.Arrays;

/**
 * Simulación de las ventanillas de un banco.
 * @author vick08bv
 */
public class PruebaBanco {
    
    /**
     * Simulación.
     * @param args 
     */
    public static void main(String[] args) {
        
        //Número de simulaciones.
        int reps = 500;
        
        //Número de ventanillas
        int numV = 3;
        
        //Número de minutos
        int minutos = 8*3600;
        
        //Máximo de asuntos
        int asuntos = 7;
        
        //Máxima duración de cada asunto
        int duracion = 10;
                
        //Ventanillas del banco, en modalidad unifila o multifila.
        Fila[] unifila = new Fila[numV];
        Fila[] multifila = new Fila[numV];
        
        //Fila de espera usada en lo modalidad multifila.
        Fila filaEspera = new Fila();
        
        //Creación de las ventanillas.
        for(int i=0;i<numV;i++){
            
            unifila[i] = new Fila();
            multifila[i] = new Fila();
        
        }
        
        //Primer cliente en la fila de espera (unifila).
        Cliente primero;
        
        //Nuevo cliente en llegar al banco (unifila).
        Cliente ultimoU;
        //Nuevo cliente en llegar al banco (multifila).
        Cliente ultimoM;
        
        //Saturación de clientes en la sesión.
        double tendencia;
        
        //Clientes formados en la fila
        int clientesIn = 0;
        //Clientes atendidos en la unifila.
        int clientesU = 0;
        //Clientes atendidos en la multifila.
        int clientesM = 0;
        //Tiempo de atención en la unifila.
        int tiempoAtendidoU = 0;
        //Tiempo de atención en la multifila.
        int tiempoAtendidoM = 0;
        /*Tiempo de espera de los clientes 
          atendidos en la unifila.*/
        int tiempoEsperaU = 0;
        /*Tiempo de espera de los clientes 
          atendidos en la multifila.*/
        int tiempoEsperaM = 0;
        
        
        //Totales
        //Clientes que llegaron.
        int clientesInT = 0;
        //Clientes atendidos en la unifila.
        int clientesUT = 0;
        //Clientes atendidos en la multifila.
        int clientesMT = 0;
        //Tiempo total de atención en la unifila.
        int tiempoTotalAtendidoU = 0;
        //Tiempo total de atención en la multifila.
        int tiempoTotalAtendidoM = 0;
        /*Tiempo de espera total de los clientes 
          atendidos en la unifila.*/
        int tiempoTotalEsperaU = 0;
        /*Tiempo de espera total de los clientes 
          atendidos en la multifila.*/
        int tiempoTotalEsperaM = 0;

        //Promedios
        //Clientes formados en promedio por cada sesión.
        double clientesPromedioIn;
        //Clientes atendidos en promedio por la unifila.
        double clientesAtendidosPromedioU;
        //Clientes atendidos en promedio por la multifila.
        double clientesAtendidosPromedioM;
        //Tiempo de atención promedio en la unifila.
        double tiempoAtencionPromedioU;
        //Tiempo de atención promedio en la multifila.
        double tiempoAtencionPromedioM;
        //Tiempo de espera promedio en la unifila.
        double tiempoEsperaPromedioU;
        //Teimpo de espera promedio en la multifila.
        double tiempoEsperaPromedioM;
        
        //Simulación de cada sesión de atención (día).
        for(int sesion = 0; sesion < reps; sesion++){
            
            for(int i=0;i<numV;i++){
        
                unifila[i].anula();
                multifila[i].anula();
  
            }
            
            //Anula la fila de espera
            filaEspera.anula();
            
            //Nueva sesión.
            tendencia = Math.random();
            
            //Clientes en la sesión.
            clientesIn = 0;
            
            //Acontecimientos en cada minuto.
            for(int minuto = 0; minuto < minutos; minuto++){
                
                //Llegada de un nuevo cliente al banco.
                if(Math.random() < tendencia/8){

                    ultimoU = new Cliente(asuntos, duracion);
                    ultimoM = new Cliente(asuntos, duracion);
                    clientesIn += 1;
                    
                    /*Obtención de la fila más corta para que 
                    ahí se forme el cliente nuevo. */ 
                    Arrays.sort(multifila);

                    multifila[0].mete(ultimoM);

                    //El cliente nuevo se forma en la fila única.
                    filaEspera.mete(ultimoU);
                    
                }
                
                /*En la modalidad unifila, si hay una ventanilla 
                  vacía, el primer cliente en la fila pasa a ella.*/
                for(int i=0;i<numV;i++){
                
                    if(unifila[i].isVacia()){
                        
                        primero = filaEspera.getPrimero();
                        filaEspera.saca();
                        
                        if(primero != null){
                            
                            primero.setSiguiente(null);
                            unifila[i].mete(primero);
                            
                        }
                        
                    }
                
                }
                
                //Atención de cada cliente.
                for(int i=0;i<numV;i++){

                    unifila[i].atenderClientes();            
                    multifila[i].atenderClientes();
                
                }
                
                //Espera en la fila de espera.
                filaEspera.esperar();
                
            }
            
            clientesU = 0;
            clientesM = 0;
            tiempoAtendidoU = 0;
            tiempoAtendidoM = 0;
            tiempoEsperaU = 0;
            tiempoEsperaM = 0;
            
            for(int i=0;i<numV;i++){
                    
                clientesU += unifila[i].getClientes();
                clientesM += multifila[i].getClientes();
                tiempoAtendidoU += unifila[i].getTiempoAtencion();
                tiempoAtendidoM += multifila[i].getTiempoAtencion();
                tiempoEsperaU += unifila[i].getTiempoEspera();
                tiempoEsperaM += multifila[i].getTiempoEspera();
                
            }
            
            clientesInT += clientesIn;
            clientesUT += clientesU;
            clientesMT += clientesM;
            tiempoTotalAtendidoU += tiempoAtendidoU;
            tiempoTotalAtendidoM += tiempoAtendidoM;
            tiempoTotalEsperaU += tiempoEsperaU;
            tiempoTotalEsperaM += tiempoEsperaM;
            
        }
       
        clientesPromedioIn = (double)((float)(clientesInT) / reps); 
        clientesAtendidosPromedioU = (double)((float)(clientesUT) / reps);
        clientesAtendidosPromedioM = (double)((float)(clientesMT) / reps);
        tiempoAtencionPromedioU = (double)((float)(tiempoTotalAtendidoU) / (numV*minutos*reps));
        tiempoAtencionPromedioM = (double)((float)(tiempoTotalAtendidoM) / (numV*minutos*reps));
        tiempoEsperaPromedioU = (double)((float)(tiempoTotalEsperaU) / clientesUT);
        tiempoEsperaPromedioM = (double)((float)(tiempoTotalEsperaM) / clientesMT);
        
        System.out.printf("\nSimulaciones: %s\n", reps);
        System.out.printf("\nPromedios:\n");
        System.out.printf("\nClientes formados en promedio por "
                        + "cada sesión %.2f\n", clientesPromedioIn);
        System.out.printf("\nClientes atendidos promedio en cada sesión:");
        System.out.printf("\nUnifila: %.2f    Multifila: %.2f\n",
            clientesAtendidosPromedioU, clientesAtendidosPromedioM);
        System.out.printf("\nTiempo de atención promedio en cada sesión (porcentaje): ");
        System.out.printf("\nUnifila: %.2f    Multifila: %.2f\n",
            tiempoAtencionPromedioU, tiempoAtencionPromedioM);
        System.out.printf("\nTiempo de espera promedio: ");
        System.out.printf("\nUnifila: %.2f    Multifila: %.2f\n",
            tiempoEsperaPromedioU, tiempoEsperaPromedioM);
        
    }
    
}
