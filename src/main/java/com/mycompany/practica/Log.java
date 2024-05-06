/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author elia3
 */
public class Log implements Serializable{
    private String rutaLog;

    public Log(String rutaLog) {
        this.rutaLog = rutaLog;
    }

   
    public synchronized void logEvent(String accion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaLog, true));){
            
            String fechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
            
            String contenido = String.format("[%s] %s\n", fechaHora, accion);
            
            bw.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
