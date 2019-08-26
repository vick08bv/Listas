package banco;
import java.util.Arrays;
import java.util.stream.IntStream;

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
        int reps = 100;
        
        //Número de ventanillas
        int numV = 3;
        
        //Número de minutos
        int minutos = 8*360;
                
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
            
            //Nueva sesión.
            tendencia = Math.random();
            
//            System.out.printf("\nTendencia: %s", tendencia);
            
            //Clientes en la sesión.
            clientesIn = 0;
            
            //Acontecimientos en cada minuto.
            for(int minuto = 0; minuto < minutos; minuto++){
                
//                System.out.printf("\nMinuto: %s\n", minuto);
                
                //Llegada de un nuevo cliente al banco.
                if(Math.random() < (1000*tendencia)/(minutos)){

                    ultimoU = new Cliente();
                    ultimoM = new Cliente();
                    clientesIn += 1;
                    
//                    System.out.println("\nNuevo Cliente");
//                    System.out.println(ultimoU);
                    
                    /*Obtención de la fila más corta para que 
                    ahí se forme el cliente nuevo. */ 
                    Arrays.sort(multifila);
                    
//                    System.out.println("Fila más corta");
//                    System.out.println(multifila[0]);
                
                    multifila[0].mete(ultimoM);
                    
//                    System.out.println("Fila única");
//                    System.out.println(filaEspera);
                               
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
                        }
                        unifila[i].mete(primero);
                        
//                        System.out.println("Primer cliente en la fila de espera");
//                        System.out.println(primero);
                        
                    }
                
                }
                
//                System.out.println("Filas");
                //Atención de cada cliente.
                for(int i=0;i<numV;i++){

//                    System.out.printf("\nUnifila: %s ", i);
//                    System.out.println(unifila[i]);
//                    System.out.printf("\nMultifila: %s ", i);
//                    System.out.println(multifila[i]);
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
        
            System.out.printf("\nCifra Diaria:");
            System.out.printf("\nClientes formados %s", clientesIn);
            System.out.printf("\nClientes atendidos: ");
            System.out.printf("\nUnifila: %s    Multifila: %s",
                                clientesU, clientesM);
            System.out.printf("\nTiempo de atención: ");
            System.out.printf("\nUnifila: %d    Multifila: %d",
                                tiempoAtendidoU, tiempoAtendidoM);
            System.out.printf("\nTiempo de espera promedio: ");
            System.out.printf("\nUnifila: %.2f    Multifila: %.2f",
                                (double)(tiempoEsperaU / clientesU),
                                (double)(tiempoEsperaM / clientesM));
             
        }
       
        clientesPromedioIn = (double)(clientesInT / reps); 
        clientesAtendidosPromedioU = (double)(clientesUT / reps);
        clientesAtendidosPromedioM = (double)(clientesMT / reps);
        tiempoAtencionPromedioU = (double)(tiempoTotalAtendidoU / reps);
        tiempoAtencionPromedioM = (double)(tiempoTotalAtendidoM / reps);
        tiempoEsperaPromedioU = (double)(tiempoTotalEsperaU / clientesUT);
        tiempoEsperaPromedioM = (double)(tiempoTotalEsperaM / clientesMT);
        
        System.out.printf("\nPromedios:");
        System.out.printf("\nClientes formados en promedio por "
                        + "cada sesión %.2f", clientesPromedioIn);
        System.out.printf("\nClientes atendidos promedio en cada sesión:");
        System.out.printf("\nUnifila: %.2f    Multifila: %.2f",
            clientesAtendidosPromedioU, clientesAtendidosPromedioM);
        System.out.printf("\nTiempo de atención promedio en cada sesión: ");
        System.out.printf("\nUnifila: %.2f    Multifila: %.2f",
            tiempoAtencionPromedioU, tiempoAtencionPromedioM);
        System.out.printf("\nTiempo de espera promedio: ");
        System.out.printf("\nUnifila: %.2f    Multifila: %.2f",
            tiempoEsperaPromedioU, tiempoEsperaPromedioM);
        
    }
    
}
