/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementación del servidor RMI para el aeropuerto.
 * @author Noelia y elia
 */
public class ServidorAeropuerto extends UnicastRemoteObject implements InterfazAeropuerto{
    private Aeropuerto aeropuerto; // Referencia al objeto Aeropuerto
    
    /**
     * Constructor que inicializa el servidor RMI.
     * @throws RemoteException
     */
    public ServidorAeropuerto() throws RemoteException{
        super(); // Llama al constructor de la superclase UnicastRemoteObject
    }
    
    /**
     * Método para obtener una referencia al objeto Aeropuerto
     * @param aeropuerto
     * @throws RemoteException
     */
    @Override
    public void obtenerAeropuerto(Aeropuerto aeropuerto) throws RemoteException{
        this.aeropuerto = aeropuerto;
    }
    
    /**
     * Método para obtener el número de pasajeros en el aeropuerto.
     * @return
     * @throws RemoteException
     */
    @Override
    public int obtenerNumPasajeros() throws RemoteException {
        return aeropuerto.NumPersonas();
    }

    /**
     * Método para obtener el número de aviones en el hangar del aeropuerto.
     * @return
     * @throws RemoteException
     */
    @Override
    public int obtenerNumAvionesHangar() throws RemoteException {
       return aeropuerto.numAvionesHangar();
    }

    /**
     * Método para obtener el número de aviones en el taller del aeropuerto.
     * @return
     * @throws RemoteException
     */
    @Override
    public int obtenerNumAvionesTaller() throws RemoteException {
        return aeropuerto.numAvionesTaller();
    }

    /**
     * Método para obtener el número de aviones en el área de estacionamiento del aeropuerto.
     * @return
     * @throws RemoteException
     */
    @Override
    public int obtenerNumAvionesAreaEst() throws RemoteException {
       return aeropuerto.numAvionesAreaEstac();
    }

    /**
     * Método para obtener el número de aviones en el área de rodaje del aeropuerto.
     * @return
     * @throws RemoteException
     */
    @Override
    public int obtenerNumAvionesAreaRod() throws RemoteException {
        return aeropuerto.numAVionesAreaRod();
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public Listas obtenerColaAvionesAerovia() throws RemoteException {
        return aeropuerto.getAerovia();
    }

    /**
     * Método para cerrar una pista específica del aeropuerto.
     * @param numPista
     * @throws RemoteException
     */
    @Override
    public void cerrarPista( int numPista) throws RemoteException {
        aeropuerto.getPista().cerrada(numPista);
    }

    /**
     * Método para abrir una pista específica del aeropuerto.
     * @param numPista
     * @throws RemoteException
     */
    @Override
    public void abrirPista( int numPista) throws RemoteException {
        aeropuerto.getPista().abierta(numPista);
        
    }
    
}
