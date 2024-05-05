/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.Random;

/**
 *
 * @author elia y noelia
 */
public class Autobus extends Thread{
    private String id;
    private int numPasajeros;
    private Aeropuerto a;
    private final Random rand = new Random();
    
    public Autobus(int id, Aeropuerto a){ 
        this.id = "B-" + crearId(id);
        esDeMadrid(id);
        this.a = a;
        System.out.println(getMarcaTiempo()+ " Bus " + this.id + " es creado ");
    }
    
    private String crearId(int id){
        String ident;
        if (id < 10){
            ident = "000" + id;
        }else if (id < 100 && id >= 10){
            ident = "00" + id;
        }else if (id < 1000 && id > 100){
            ident = "0" + id;
        }else{
            ident ="" + id;
        }
        return ident;
        
    }
    
    private boolean esDeMadrid(int id){
        return id % 2 == 0;
    }
    
    public String miId(){
        return id;
    }
    
    public void entrarAeropuerto(){
        a.autobusEnAeropuerto(this);
        
        
    }
    
    public void entrarCiudad(){
        a.autobusEnCiudad(this);
        
    }
    @Override
    public void run(){
       while(true){
           try{
                
                entrarCiudad();
                numPasajeros= rand.nextInt(51);
                Thread.sleep((rand.nextInt(4) + 2) * 1000);
                rutaAeropuerto();
                entrarAeropuerto();
                a.Entrar(numPasajeros);
                Thread.sleep((rand.nextInt(4) + 2) * 1000);
                if(a.NumPersonas() >= 50){
                    numPasajeros = rand.nextInt(51);
                }else{
                    if (a.NumPersonas() <= 0){
                        numPasajeros = 0;
                    }else{
                        numPasajeros = rand.nextInt(a.NumPersonas());
                    }
                }
                a.Salir(numPasajeros);
                rutaCiudad();
                numPasajeros = 0;
            }catch (InterruptedException e){}
       }    
    }
    
    
    private void rutaAeropuerto() throws InterruptedException{
        System.out.println(getMarcaTiempo() + " Bus " + id + " va al aeropuerto ");
        Thread.sleep((rand.nextInt(6)+ 5) * 1000); //Tiempo del trayecto al aeropuerto
    }
    
    
    private void rutaCiudad() throws InterruptedException{
        System.out.println(getMarcaTiempo() + " Bus " + id + " vuelve a la ciudad ");
        Thread.sleep((rand.nextInt(6) + 5) * 1000); //Tiempo del trayecto a la ciudad
    }
    private String getMarcaTiempo(){
        return java.time.LocalTime.now().toString();
    }
}
