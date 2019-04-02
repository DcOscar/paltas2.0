/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import logico.*;
import java.util.*;

/**
 *
 * @author Oscar
 */
public class Principal {

    public static void main(String[] args) {
        // Se mostrarán solamente 3 paltas para ejemplo
        ClasificadorPalta palta = new ClasificadorPalta();
        palta.sortAño();
        palta.mostrarEstadisticasPaltas(10);
       
}
}