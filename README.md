# Practica-de-laboratorio-07-Gestion-de-Archivos-de-texto-en-Java
Práctica de laboratorio 07: Gestión de Archivos de texto en Java

**1.	se pidió desarrolla dos interfaces. una que permita el ingreso de un texto e encripte ese texto.**
	Proyecto: Practica-07-Encriptado
  
**2.	Proyecto: Practica-07-Encriptado**

En este proyecto se crearon tres paquetes:

	ec.edu.ups.controlador
	ec.edu.ups.multimedia
	ec.edu.ups.vista
  
**3.	ec.edu.ups.controlador**

En este paquete se creo una clase en la cual se encarga de encriptar el texto que recibe del textArea.
*ControladorEncriptado.java

    package ec.edu.ups.controlador;

    import java.nio.charset.StandardCharsets;

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



**4.	ControladorEncriptado.java**

En esta clase se importaron los siguientes paquetes:

	import java.nio.charset.StandardCharsets 
  
esta clase solamente tiene un método la cual sirve para encriptar el texto de la interfaz

	encriptar: recibe en sus parámetros un objeto de tipo String. Este método al recibir una cadena de texto en su parámetro convierte el texto en un Array de bytes. Al convertirlo en una Array de bytes luego se recorre ese array con un for para poder conseguir el código ASCII de cada carácter. Una vez que se obtiene el código el código ASCII de cada carácter se realiza una operación personalizada en la cual cambia el código ASCII y retorna ese código encriptado.
  
**5.	ec.edu.ups.multimedia**
este paquete solamente contiene graficas para mejorar la visualización de la interfaz al momento de utilizarla.

**6.	ec.edu.ups.vista**
este paquete contiene una interfaz de tipo Aplication Sample Form.
	Encriptación 
  
    package ec.edu.ups.vista;

    import ec.edu.ups.controlador.ControladorEncriptado;
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileWriter;
    import java.io.IOException;
    import javax.swing.ImageIcon;
    import javax.swing.JFileChooser;
    import javax.swing.UIManager;
    import javax.swing.UnsupportedLookAndFeelException;
    import javax.swing.filechooser.FileNameExtensionFilter;

    public class Encriptacion extends javax.swing.JFrame {

    private String ruta;
    private String texto;
    private ControladorEncriptado controladorEncriptado;

    /**
     * CONSTRUCTOR. Se inicializa los componentes graficos y las variables
     * globales
     */
    public Encriptacion() {
        initComponents();
        this.ruta = "";
        this.texto = "";
        this.controladorEncriptado = new ControladorEncriptado();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/ec/edu/ups/multimedia/carpeta.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
	aqui va toda la implementación de los componentes graficos
    }// </editor-fold>//GEN-END:initComponents

    private void mnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGuardarActionPerformed

        texto = controladorEncriptado.encriptar(txtaTexto.getText());
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("BUSCAR DOCUMENTO");
        fc.setCurrentDirectory(new File("D:\\"));
        fc.setFileFilter(new FileNameExtensionFilter("Notas.txt", "txt"));
        if (fc.showSaveDialog(this) == 0) {
            ruta = fc.getSelectedFile().toString() + ".txt";
        }
        try {
            FileWriter archivoEscritura = new FileWriter(ruta, true);
            BufferedWriter escritura = new BufferedWriter(archivoEscritura);
            escritura.append(texto);
            escritura.close();
            archivoEscritura.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Ruta de archivo no encontrada");
        } catch (IOException e2) {
            System.out.println("Eror de escritura");
        } catch (Exception e3) {
            System.out.println("Error General");
        }
    }//GEN-LAST:event_mnGuardarActionPerformed

    private void mnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCerrarActionPerformed
        txtaTexto.setEditable(false);
        txtaTexto.setText("");
    }//GEN-LAST:event_mnCerrarActionPerformed

    private void mnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNuevoActionPerformed
        txtaTexto.setEditable(true);
        txtaTexto.setText("");
    }//GEN-LAST:event_mnNuevoActionPerformed

    private void mnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Encriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Encriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Encriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Encriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    System.out.println("Error setting Java LAF: " + e);
                }
                new Encriptacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnCerrar;
    private javax.swing.JMenuItem mnGuardar;
    private javax.swing.JMenuItem mnNuevo;
    private javax.swing.JMenuItem mnSalir;
    private javax.swing.JTextArea txtaTexto;
    // End of variables declaration//GEN-END:variables

}


**7.	Encriptacion (Application Sample Form)**

Esta interfaz se encargará de encriptar todo el text que ingrese el usuario. A la misma vez se ofrece múltiples opciones tales como: nuevo, guardar, cerrar, y salir. 

En esta interfaz se importaron los siguientes paquetes:

	import ec.edu.ups.controlador.ControladorEncriptado;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import javax.swing.ImageIcon;
	import javax.swing.JFileChooser;
	import javax.swing.UIManager;
	import javax.swing.UnsupportedLookAndFeelException;
	import javax.swing.filechooser.FileNameExtensionFilter;
  
se instanciaron los siguientes objetos para su funcionalidad 

	String Ruta
	String texto
	ControladorEncriptado controladorEncriptado
  
Así mismo se crearon ActionPerformed Events para que el usuario pueda decidir que desea hacer.

	mnGuardarActionPerformed: esta opción ejecuta el JFileChooser la cual nos ayuda a encontrar la ruta del directorio donde deseamos guardar nuestro archivo. Este se puede personalizar según el usuario, en el caso de nuestro programa se utilizo el método setDialogTitle("") para nombrar el archivo. También se utilizo el método setCurrentDirectory(File) en la cual se la pasa la ruta indicando donde deseamos abrir como predeterminando. En caso de no encontrar la ruta ingresada simplemente se utilizará la ruta predeterminada del sistema de documentos. El tercer método utilizado es el setFileFilter(FileNameExtensionFilter) en la cual se le pasa el tipo de archivo que el usuario debe elegir. El primer atributo es el nombre que queremos visualizar y el segundo es la extensión del archivo. Por ultimo se abre la ventana de guardar mediante el método showSaveDialog(). Una vez obtenido la ruta mediante el FileWriter() se crea un documento y se guarda el texto encriptado. 
	mnCerrarActionPerformed: esta opción nos permite cerrar el documento en caso de que se creo algún documento no deseado. 
	mnNuevoActionPerformed: esta opción nos permite crear un nuevo documento. 
	mnSalirActionPerformed: esta opción termina el programa. 
