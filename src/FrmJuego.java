import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class FrmJuego extends JFrame{ //Herencia para una ventana

        public FrmJuego(){   //Creacion del metodo
        setSize(500, 300); // este setSize es el tamaño de la ventana, se mide en pixeles
        setTitle("Juguemos a los dados"); //Titulo para nuestra ventana 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Cierra la ventana automaticamente
        setLayout(null); //codigo para ubicar el dando con las coordenadas que quiero

        //El proximo JLabel sera para mostrar el primer dado    
        JLabel lblDado1 = new JLabel();  //estamos declarando una etiqueta de la clase JLabel y segundo se instancia 
        String nombreImagen ="/imagenes/1.jpg"; //acá estamos cargando la imagen 
        ImageIcon imagen= new ImageIcon(getClass().getResource(nombreImagen)); //declaramos la imagen y despues la instanciamos 
        lblDado1.setIcon(imagen);//acá cargamos la imagen

        //Coordenadas donde la imagen se va a ubicar, ancho y largo
        lblDado1.setBounds(10,10,imagen.getIconWidth(), imagen.getIconHeight());
        getContentPane().add(lblDado1);  
        
        //creacion del segundo dado 
        JLabel lblDado2 = new JLabel();
        lblDado2.setIcon(imagen);//acá cargamos la imagen
        lblDado2.setBounds(10+imagen.getIconWidth(),10,imagen.getIconWidth(), imagen.getIconHeight()); //defino coordenadas
        getContentPane().add(lblDado2);

        //etiquietas para los titulos que aparecerán al lado de los dados
        JLabel lblTitulo1 = new JLabel("LANZAMIENTOS");
        lblTitulo1.setBounds(50+2*imagen.getIconWidth(),10,100,25);    
        getContentPane().add(lblTitulo1); //agregamos    

        JLabel lblTitulo2 = new JLabel("CENAS");
        lblTitulo2.setBounds(160+2*imagen.getIconWidth(),10,100,25);    
        getContentPane().add(lblTitulo2); //agregamos    
    }   
}
