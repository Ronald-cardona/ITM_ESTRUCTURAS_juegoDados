import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

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
        getContentPane().add(lblDado2); //acá agregamos la imagen

        //etiquietas para los titulos que aparecerán al lado de los dados
        JLabel lblTitulo1 = new JLabel("LANZAMIENTOS");
        lblTitulo1.setBounds(50+2*imagen.getIconWidth(),10,100,25);
        lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);    
        getContentPane().add(lblTitulo1); //agregamos la imagen     

        JLabel lblTitulo2 = new JLabel("CENAS");
        lblTitulo2.setBounds(160+2*imagen.getIconWidth(),10,100,25);
        lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);    
        getContentPane().add(lblTitulo2); //agregamos la imagen 

        //etiquetas para mostar los contadores que apareceran debajo de los titulos
        JLabel lblLanzamientos = new JLabel(); //instanciamos
        lblLanzamientos.setBounds(160 + 2* imagen.getIconWidth(), 40, 100, 100); // coordenadas de donde quedara 
        lblLanzamientos.setBackground(new ColorUIResource(0,0,0)); //Fondo negro
        lblLanzamientos.setForeground(new ColorUIResource(51,255,0)); //Color verde para el "0"
        lblLanzamientos.setFont(new FontUIResource("Tahoma", 1, 72)); //Cambio de letra
        lblLanzamientos.setText("0"); // escribimos lo que queramos que aparezca
        lblLanzamientos.setHorizontalAlignment(SwingConstants.RIGHT); //el cero lo queremos a la derecha
        lblLanzamientos.setOpaque(true); // codigo para que nos lea el negro
        getContentPane().add(lblLanzamientos); //agregamos el cero

        JLabel lblCenas = new JLabel();
        lblCenas.setBounds(50 + 2* imagen.getIconWidth(), 40, 100, 100);
        lblCenas.setBackground(new ColorUIResource(0,0,0));
        lblCenas.setForeground(new ColorUIResource(51,255,0));
        lblCenas.setFont(new FontUIResource("Tahoma", 1, 72));
        lblCenas.setText("0");
        lblCenas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCenas.setOpaque(true);
        getContentPane().add(lblCenas);


         //el proximo JButton será para mostrar el boton "Iniciar"   
        JButton btnIniciar=new JButton("Iniciar");// inicializamos el boton y despues lo instanciamos
        btnIniciar.setBounds(10, 15+imagen.getIconHeight(), 100, 25);//Coordenadas 
        getContentPane().add(btnIniciar); //agregamos el boton

        //el proximo JButton será para mostrar el boton "Lanzar"    
        JButton btnLanzar=new JButton("Lanzar");
        btnLanzar.setBounds(10, 45+imagen.getIconHeight(), 100, 25);
        getContentPane().add(btnLanzar);

    }   
}
