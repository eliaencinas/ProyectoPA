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
    private boolean enAeropuerto;
    private final Random rand = new Random();
    
    public Autobus(int id, Aeropuerto a){ 
        this.id = "B-" + crearId(id);
        esDeMadrid(id);
        this.enAeropuerto = false;
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
        enAeropuerto = true;
        
    }
    
    public void entrarCiudad(){
        a.autobusEnCiudad(this);
        enAeropuerto = false;
    }
    @Override
    public void run(){
       while(true){
           try{
                /*subirPasajeros();
                a.actualizarNumPersonas();
                if(enAeropuerto){
                    rutaAeropuerto();
                    entrarCiudad();
                } else{
                    rutaCiudad();
                    entrarAeropuerto();
                }
                bajarPasajeros();
                a.actualizarNumPersonas();*/
                numPasajeros= rand.nextInt(51);
                Thread.sleep((rand.nextInt(4) + 2) * 1000);
                rutaAeropuerto();
                a.autobusEnAeropuerto(this);
                a.Entrar(numPasajeros);
                numPasajeros = rand.nextInt(a.NumPersonas());
                a.Salir(numPasajeros);
                rutaCiudad();
                a.autobusEnCiudad(this);
                
            }catch (InterruptedException e){}
       }    
    }
    
    
    private void subirPasajeros() throws InterruptedException{
        //numPasajeros = rand.nextInt(51); // pasajeros que se suben al autobús
        System.out.println(getMarcaTiempo()+ " Bus " + id + " sube " + numPasajeros + " pasajeros");
        //a.Entrar(numPasajeros); //Se meten los pasajeros al aeropuerto
        Thread.sleep((rand.nextInt(4) + 2) * 1000);
    }
    
    private void rutaAeropuerto() throws InterruptedException{
        System.out.println(getMarcaTiempo() + " Bus " + id + " va al aeropuerto ");
        Thread.sleep((rand.nextInt(6)+ 5) * 1000); //Tiempo del trayecto al aeropuerto
    }
    
    private void bajarPasajeros() throws InterruptedException{
        numPasajeros = 0; //Pasajeros que se bajan del autobus
        System.out.println(getMarcaTiempo() + " Bus " + id + " deja " + numPasajeros + " pasajeros");
        a.Salir(numPasajeros); //Se sacan del aeropuerto
        Thread.sleep((rand.nextInt(4) + 2) * 1000);
    }
    
    private void rutaCiudad() throws InterruptedException{
        System.out.println(getMarcaTiempo() + " Bus " + id + " vuelve a la ciudad ");
        Thread.sleep((rand.nextInt(6) + 5) * 1000); //Tiempo del trayecto a la ciudad
    }
    private String getMarcaTiempo(){
        return java.time.LocalTime.now().toString();
    }
}
