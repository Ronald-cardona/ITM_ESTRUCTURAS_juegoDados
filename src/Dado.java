import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dado {

    private int numero; //numero privado porque no se cambia 

    //Metodo para lanzar los dados aleatoreamente
    public void lanzar (Random r) {
        numero = r.nextInt(6)+ 1; //numeros aleatorios del 1 al 6
    
    }
    //Funcion para hacer visible el numero, ya que esta encapsulado por el (private) para protegerlo
    public int getNumero() {
        return numero;
    } 

    //Metodo para mostrar el dado
    public void mostrar (JLabel lbl){
        String nombreImagen ="/imagenes/"+ String.valueOf(numero) + ".jpg"; //value of es para que el texto me lea el numero
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen));  
        lbl.setIcon(imagen);
    }
    
    

}
