import java.awt.Color;
import javax.swing.*;

class Proceso extends Thread{
    JProgressBar barra;
    
    int tamano;
    int i;
    
    //Constructor con Argumentos de la clase padre Thread y Clase Interfaz JProgressbar
    public Proceso(String nombre,JProgressBar barra){
        super(nombre);//Le damos un nombre a nuestros Threads
        this.barra=barra;//Inicializamos nuuestras barras
        i=0;//Contador Inicializamos
    }
    
    
//    Metodo de clase Thread hay que sobreescribirlo
    @Override
    public void run() {
        
        //El for se utliza para iterar la barra y vaya interando el tamaño de cada proceso
//        donde cada proceso tiene 3 condiciones el cual consta de 2 E/S y Un termino donde se finaliza el proceso
         for(i=0;i<=tamano;i++){
                
                                     
                barra.setValue(i);//Asignamos el contador a las barras para que vaya aumentando
                

                try {
                    Proceso.sleep(200); //Metodo para que vaya mas lento el incremento de los procesos
//                    y se observe el incremento de mejor manera
                } catch (InterruptedException e1) {
                }
                //NOTA:En los sigientes if de cada Hilo es el mismo procedimiento para todos los demas, 
                //es por eso que solo se documenta un proceso
                
                
                //Hilo 1------------------------------------------------------------
                
                // Primera entrada y salida del Proceso 1
                if(i==5 && "Proceso 1".equals(getName())) {
                    System.out.println ("Primer Tiempo de E/S");
                    Interfaz.Etiqueta1.setText("<html>Tamaño: 20&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 0"
                            + " <br> E/S:  5 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 5"
                            + "<br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 20 </html>");
                    Interfaz.primer1.setVisible(true);//Marcamos en la barra la primera E/S
                    Interfaz.hilo2.start();//Iniciamos el hilo
                    Interfaz.hilo1.suspend();//Pausamos el hilo
                    
                    
                }
                // Segunda entrada y salida del Proceso 1
                if(i==15 && "Proceso 1".equals(getName())) {
                    System.out.println ("Segundo Tiempo de E/S");
                    Interfaz.Etiqueta1.setText("<html>Tamaño: 10&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 110"
                            + " <br> E/S: 5 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 10"
                            + "<br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 10 </html>");
                    Interfaz.segunda.setVisible(true);//Marcamos en la barra la segunda E/S
                    Interfaz.hilo2.resume();//Reanudamos el hilo 2 donde se quedo
                    Interfaz.hilo1.suspend();//Pausamos el hilo 1 hasta la tercera vuelta
                }
                //Proceso Finalizado
                if(i==25 && "Proceso 1".equals(getName())) {
                    JOptionPane.showMessageDialog(null, "El PROCESO 1 a Finalizado");
                    Interfaz.Etiqueta1.setText("Proceso Finalizado");
                    barra.setString("PROCESO FINALIZADO: 25%"); //Indicamos en la barra que el proceso a Finalizado
                    Interfaz.hilo2.resume();//Reanudamos el hilo 2 donde se quedo
                    Interfaz.hilo1.interrupt();//Finalizamos el hilo donde cumple con el tamaño indicado
                    
                }

                
                
                //Hilo 2-----------------------------------------------------------------------------------------
                // Primera entrada y salida del Proceso 2
                if(i==10 && "Proceso 2".equals(getName())) {
                    System.out.println ("Primer Tiempo de E/S");
                    Interfaz.Etiqueta2.setText("<html>Tamaño: 25&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 5"
                            + " <br> E/S:  10 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 10"
                            + "<br> E/S: 30 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 25 </html>");
                    Interfaz.primer2.setVisible(true);
                    Interfaz.hilo3.start();
                    Interfaz.hilo2.suspend();
                    
                }
                // Segunda entrada y salida del Proceso 2
                if(i==30 && "Proceso 2".equals(getName())) {
                    System.out.println ("Segundo Tiempo de E/S");
                    Interfaz.Etiqueta2.setText("<html>Tamaño: 5&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 120"
                            + " <br> E/S: 10 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 20"
                            + "<br> E/S: 30 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 5 </html>");
                    Interfaz.segunda2.setVisible(true);
                    Interfaz.hilo3.resume();
                    Interfaz.hilo2.suspend();
                }
                //Proceso Finalizado
                if(i==35 && "Proceso 2".equals(getName())){
                    JOptionPane.showMessageDialog(null, "El PROCESO 2 a Finalizado");
                    Interfaz.Etiqueta2.setText("Proceso Finalizado");
                    barra.setString("PROCESO FINALIZADO: 35%");
                    Interfaz.hilo3.resume();
                    Interfaz.hilo1.interrupt();
                }
                
                
                //Hilo 3---------------------------------------------------------------------------------------
                // Primera entrada y salida del Proceso 3
                if(i==15 && "Proceso 3".equals(getName())) {
                    System.out.println ("Primer Tiempo de E/S");
                    Interfaz.Etiqueta3.setText("<html>Tamaño: 20&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 15"
                            + " <br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 10"
                            + "<br> E/S: 25 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 20 </html>");
                    Interfaz.primer3.setVisible(true);
                    Interfaz.hilo4.start();
                    Interfaz.hilo3.suspend();
                    
                }
                // Segunda entrada y salida del Proceso 3
                if(i==25 && "Proceso 3".equals(getName())) {
                    System.out.println ("Segundo Tiempo de E/S");
                    Interfaz.Etiqueta3.setText("<html>Tamaño: 5&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 140"
                            + " <br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 10"
                            + "<br> E/S: 25 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 5 </html>");
                    Interfaz.segunda3.setVisible(true);
                    Interfaz.hilo4.resume();
                    Interfaz.hilo3.suspend();
                }
                //Proceso Finalizado
                if(i==30 && "Proceso 3".equals(getName())){
                    JOptionPane.showMessageDialog(null, "El PROCESO 3 a Finalizado");
                    Interfaz.Etiqueta3.setText("Proceso Finalizado");
                    barra.setString("PROCESO FINALIZADO: 30%");
                    Interfaz.hilo4.resume();
                    Interfaz.hilo3.interrupt();
                }
                
                
                
                
                //Hilo 4------------------------------------------------------------------------------------
                // Primera entrada y salida del Proceso 4
                if(i==5 && "Proceso 4".equals(getName())) {
                    System.out.println ("Primer Tiempo de E/S");
                    Interfaz.Etiqueta4.setText("<html>Tamaño: 15&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 25"
                            + " <br> E/S: 5 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 5"
                            + "<br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 15 </html>");
                    Interfaz.primer4.setVisible(true);
                    Interfaz.hilo5.start();
                    Interfaz.hilo4.suspend();    
                }
                // Primera entrada y salida del Proceso 4
                if(i==15 && "Proceso 4".equals(getName())) {
                    System.out.println ("Segundo Tiempo de E/S");
                    Interfaz.Etiqueta4.setText("<html>Tamaño: 5&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 160"
                            + " <br> E/S: 5 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 10"
                            + "<br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 5 </html>");
                    Interfaz.segunda4.setVisible(true);
                    Interfaz.hilo5.resume();
                    Interfaz.hilo4.suspend();
                }
                //Proceso Finalizado
                if(i==20 && "Proceso 4".equals(getName())){
                    JOptionPane.showMessageDialog(null, "El PROCESO 4 a Finalizado");
                    Interfaz.Etiqueta4.setText("Proceso Finalizado");
                    barra.setString("PROCESO FINALIZADO: 20%");
                    Interfaz.hilo5.resume();
                    Interfaz.hilo4.interrupt();
                }
                
                
                //Hilo 5-------------------------------------------------------------------------------------
                // Primera entrada y salida del Proceso 5
                if(i==20 && "Proceso 5".equals(getName())) {
                    System.out.println ("Primer Tiempo de E/S");
                    Interfaz.Etiqueta5.setText("<html>Tamaño: 15&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 30"
                            + " <br> E/S: 20 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 20"
                            + "<br> E/S: 35 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 15 </html>");
                    Interfaz.primer5.setVisible(true);
                    Interfaz.hilo6.start();
                    Interfaz.hilo5.suspend();
                    
                }
                // Segunda entrada y salida del Proceso 5
                if(i==35 && "Proceso 5".equals(getName())) {
                    System.out.println ("Segundo Tiempo de E/S");
                    Interfaz.Etiqueta5.setText("<html>Tamaño: 5&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 170"
                            + " <br> E/S: 20 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 15"
                            + "<br> E/S: 35 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 5 </html>");
                    Interfaz.segunda5.setVisible(true);
                    Interfaz.hilo6.resume();
                    Interfaz.hilo5.suspend();
                }
                //Proceso Finalizado
                if(i==40 && "Proceso 5".equals(getName())){
                    JOptionPane.showMessageDialog(null, "El PROCESO 5 a Finalizado");
                    Interfaz.Etiqueta5.setText("Proceso Finalizado");
                    barra.setString("PROCESO FINALIZADO: 40%");
                    Interfaz.hilo6.resume();
                    Interfaz.hilo5.interrupt();
                }
                
                
                
                //Hilo 6------------------------------------------------------------------------------------
                // Primera entrada y salida del Proceso 6
                if(i==15 && "Proceso 6".equals(getName())) {
                    System.out.println ("Primer Tiempo de E/S");
                    Interfaz.Etiqueta6.setText("<html>Tamaño: 20&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 50"
                            + " <br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 15"
                            + "<br> E/S: 30 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 20 </html>");
                    Interfaz.primer6.setVisible(true);
                    Interfaz.hilo7.start();
                    Interfaz.hilo6.suspend();  
                }
                // Segunda entrada y salida del Proceso 6
                if(i==30 && "Proceso 6".equals(getName())) {
                    System.out.println ("Segundo Tiempo de E/S");
                    Interfaz.Etiqueta6.setText("<html>Tamaño: 5&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 185"
                            + " <br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 15"
                            + "<br> E/S: 30 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 5 </html>");
                    Interfaz.segunda6.setVisible(true);
                    Interfaz.hilo7.resume();
                    Interfaz.hilo6.suspend();
                }
                //Proceso Finalizado
                if(i==35 && "Proceso 6".equals(getName())){
                    JOptionPane.showMessageDialog(null, "El PROCESO 6 a Finalizado");
                    Interfaz.Etiqueta6.setText("Proceso Finalizado");
                    barra.setString("PROCESO FINALIZADO: 35%");
                    Interfaz.hilo7.resume();
                    Interfaz.hilo6.interrupt();
                }
                
                
                //Hilo 7--------------------------------------------------------------------------------------
                // Primera entrada y salida del Proceso 7
                if(i==15 && "Proceso 7".equals(getName())) {
                    System.out.println ("Primer Tiempo de E/S");
                    Interfaz.Etiqueta7.setText("<html>Tamaño: 35&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 65"
                            + " <br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 15"
                            + "<br> E/S: 35 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 35 </html>");
                    Interfaz.primer7.setVisible(true);
                    Interfaz.hilo8.start();
                    Interfaz.hilo7.suspend();
                    
                }
                // Segunda entrada y salida del Proceso 7
                if(i==35 && "Proceso 7".equals(getName())) {
                    System.out.println ("Segundo Tiempo de E/S");
                    Interfaz.Etiqueta7.setText("<html>Tamaño: 15&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 200"
                            + " <br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 20"
                            + "<br> E/S: 35 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 15 </html>");
                    Interfaz.segunda7.setVisible(true);
                    Interfaz.hilo8.resume();
                    Interfaz.hilo7.suspend();
                }
                //Proceso Finalizado
                if(i==50 && "Proceso 7".equals(getName())){
                    JOptionPane.showMessageDialog(null, "El PROCESO 7 a Finalizado");
                    Interfaz.Etiqueta7.setText("Proceso Finalizado");
                    barra.setString("PROCESO FINALIZADO: 50%");
                    Interfaz.hilo8.resume();
                    Interfaz.hilo7.interrupt();
                }
                
                
                //Hilo 8-------------------------------------------------------------------------------------
                // Primera entrada y salida del Proceso 8
                if(i==5 && "Proceso 8".equals(getName())) {
                    System.out.println ("Primer Tiempo de E/S");
                    Interfaz.Etiqueta8.setText("<html>Tamaño: 30&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 80"
                            + " <br> E/S: 5 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 5"
                            + "<br> E/S: 25 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 30 </html>");
                    Interfaz.primer8.setVisible(true);
                    Interfaz.hilo9.start();
                    Interfaz.hilo8.suspend();
                    
                }
                // Segunda entrada y salida del Proceso 8
                if(i==25 && "Proceso 8".equals(getName())) {
                    System.out.println ("Segundo Tiempo de E/S");
                    Interfaz.Etiqueta8.setText("<html>Tamaño: 10&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 220"
                            + " <br> E/S: 5 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 20"
                            + "<br> E/S: 25 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 10 </html>");
                    Interfaz.segunda8.setVisible(true);
                    Interfaz.hilo9.resume();
                    Interfaz.hilo8.suspend();
                }
                //Proceso Finalizado
                if(i==35 && "Proceso 8".equals(getName())){
                    JOptionPane.showMessageDialog(null, "El PROCESO 8 a Finalizado");
                    Interfaz.Etiqueta8.setText("Proceso Finalizado");
                    barra.setString("PROCESO FINALIZADO: 35%");
                    Interfaz.hilo9.resume();
                    Interfaz.hilo8.interrupt();
                }
                
                
                
                //Hilo 9--------------------------------------------------------------------------------------
                // Primera entrada y salida del Proceso 9
                if(i==15 && "Proceso 9".equals(getName())) {
                    System.out.println ("Primer Tiempo de E/S");
                    Interfaz.Etiqueta9.setText("<html>Tamaño: 30&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 85"
                            + " <br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 15"
                            + "<br> E/S: 40 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 30 </html>");
                    Interfaz.primer9.setVisible(true);
                    Interfaz.hilo10.start();
                    Interfaz.hilo9.suspend();
                    
                }
                // Segunda entrada y salida del Proceso 9
                if(i==40 && "Proceso 9".equals(getName())) {
                    System.out.println ("Segundo Tiempo de E/S");
                    Interfaz.Etiqueta9.setText("<html>Tamaño: 5&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 235"
                            + " <br> E/S: 15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 25"
                            + "<br> E/S: 40 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 5 </html>");
                    Interfaz.segunda9.setVisible(true);
                    Interfaz.hilo10.resume();
                    Interfaz.hilo9.suspend();
                }
                //Proceso Finalizado
                if(i==45 && "Proceso 9".equals(getName())){
                    JOptionPane.showMessageDialog(null, "El PROCESO 9 a Finalizado");
                    Interfaz.Etiqueta9.setText("Proceso Finalizado");
                    barra.setString("PROCESO FINALIZADO: 45%");
                    Interfaz.hilo10.resume();
                    Interfaz.hilo9.interrupt();
                }
                
                
                
                //Hilo 10-------------------------------------------------------------------------------------
                // Primera entrada y salida del Proceso 10
                if(i==10 && "Proceso 10".equals(getName())) {
                    System.out.println ("Primer Tiempo de E/S");
                    Interfaz.Etiqueta10.setText("<html>Tamaño: 20&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 100"
                            + " <br> E/S: 10 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 10"
                            + "<br> E/S: 20 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 20 </html>");
                    Interfaz.primer10.setVisible(true);
                    Interfaz.hilo1.resume();
                    Interfaz.hilo10.suspend();
                    
                }
                // Segunda entrada y salida del Proceso 10
                if(i==20 && "Proceso 10".equals(getName())) {
                    System.out.println ("Segundo Tiempo de E/S");
                    Interfaz.Etiqueta10.setText("<html>Tamaño: 10&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tiempo Espera: 250"
                            + " <br> E/S: 10 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Ejecucion: 10"
                            + "<br> E/S: 20 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;Tiempo Restante: 10 </html>");
                    Interfaz.segunda10.setVisible(true);
                    Interfaz.hilo1.resume();
                    Interfaz.hilo10.suspend();
                }
                //Proceso Finalizado
                if(i==30 && "Proceso 10".equals(getName())){
                    JOptionPane.showMessageDialog(null, "El PROCESO 10 a Finalizado");
                    Interfaz.Etiqueta10.setText("Proceso Finalizado");
                    barra.setString("PROCESO FINALIZADO: 30%");
                    Interfaz.hilo10.interrupt();
                }

        }//WHILE
            
            
    }
    
    
    //Obtenemos el tamaño de cada proceso indicados en la clase Interfaz
    public void iniciar(int tamano){
        this.tamano=tamano;
    }
    

    
    
    
    
}
