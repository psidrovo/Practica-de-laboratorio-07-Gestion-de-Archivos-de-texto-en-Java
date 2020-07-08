/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorEncriptado {
    public String encriptar(String texto) {
        String textoEncriptado = "";
        
        byte[] cadenaAscii = texto.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < cadenaAscii.length; i++) {
            int numero = cadenaAscii[i];
            numero = numero * 5;
            numero += 10;
            textoEncriptado += numero + "%$";
        }
        return textoEncriptado;
    }
}
