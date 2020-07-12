package ec.edu.ups.controlador;

import java.nio.charset.StandardCharsets;

/**
 * CONTROLADOR ENCRIPTADO.
 *
 * Este controlador se encarga de encriptar el texto que nos pasa la vista
 * Encriptacion al metoodo encriptar
 *
 * @author Paul Idrovo, Dennis Dutan
 */
public class ControladorEncriptado {

    /**
     * METODO ENCRIPTAR. Este metodo se encarga de encriptar el texto del text
     * area de la vista para posteriormente crear el documento encriptado.
     *
     * Para el encriptado convertimos el String recibido en un Array de bytes,
     * luego recoremos este array para sacar el codigo ASCII de cada caracter y
     * realizar una operacion para que el codigo ASCII cambie y no pueda ser
     * entendido al abrir el documento sin la apliacion de desencriptado.
     *
     * @param texto String -> Texto text area vista
     * @return textoEncriptado String -> Texto encriptado
     */
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
