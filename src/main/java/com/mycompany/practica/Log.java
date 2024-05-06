/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  Clase para registrar eventos en un archivo de registro.
 * Esta clase permite registrar eventos en un archivo de texto,
 * junto con la fecha y hora en que ocurrieron.
 * Los eventos se escriben en el formato "[dd-MM-yyyy HH:mm:ss] acción".
 * La clase es serializable para permitir su uso en diferentes contextos.

 * @author Elia y Noelia
 */
public class Log implements Serializable{
    private String rutaLog; //Ruta del archivo de registro

    /**
     * Constructor de la clase Log.
     * @param rutaLog La ruta del archivo de registro donde se escribirán los eventos.
     */
    public Log(String rutaLog) {
        this.rutaLog = rutaLog;
    }

    /**
    * Método para registrar un evento en el archivo de registro.
     * Este método es sincronizado para garantizar que múltiples hilos
     * no escriban eventos simultáneamente en el archivo.
     * @param accion La acción o evento que se va a registrar.

     */
    public synchronized void logEvent(String accion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaLog, true));){
            
            String fechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()); //Obtenie la fecha y hora actual en el formato especificado 
            
            String contenido = String.format("[%s] %s\n", fechaHora, accion);//Formatea el contenido del evento con la fecha, hora y acción
            
            bw.write(contenido);//Escribe el contenido en el archivo de registro
        } catch (IOException e) {
            e.printStackTrace(); // Manejar cualquier excepción de E/S imprimiendo el seguimiento de la pila
        }
    }
}
