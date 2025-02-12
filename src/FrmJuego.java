import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class FrmJuego extends JFrame { // Herencia para una ventana

    private Dado dado1, dado2; // declaramos los dados que necesitamos
    private Random r = new Random(); // declaramos e instanciamos r
    private JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas;
    private int lanzamientos, cenas;

    public FrmJuego() { // Creacion del metodo
        setSize(500, 300); // este setSize es el tamaño de la ventana, se mide en pixeles
        setTitle("Juguemos a los dados"); // Titulo para nuestra ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Cierra la ventana automaticamente
        setLayout(null); // codigo para ubicar el dando con las coordenadas que quiero

        // El proximo JLabel sera para mostrar el primer dado
        lblDado1 = new JLabel(); // estamos declarando una etiqueta de la clase JLabel y segundo se instancia
        String nombreImagen = "/imagenes/1.jpg"; // acá estamos cargando la imagen
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen)); // declaramos la imagen y despues la  instanciamos
                                                                               
        lblDado1.setIcon(imagen);// acá cargamos la imagen

        // Coordenadas donde la imagen se va a ubicar, ancho y largo
        lblDado1.setBounds(10, 10, imagen.getIconWidth(), imagen.getIconHeight());
        getContentPane().add(lblDado1);

        // creacion del segundo dado
        lblDado2 = new JLabel();
        lblDado2.setIcon(imagen);// acá cargamos la imagen
        lblDado2.setBounds(10 + imagen.getIconWidth(), 10, imagen.getIconWidth(), imagen.getIconHeight()); // defino coordenadas
                                                                                                           
        getContentPane().add(lblDado2); // acá agregamos la imagen

        // etiquietas para los titulos que aparecerán al lado de los dados
        JLabel lblTitulo1 = new JLabel("LANZAMIENTOS");
        lblTitulo1.setBounds(50 + 2 * imagen.getIconWidth(), 10, 100, 25);
        lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitulo1); // agregamos la imagen

        JLabel lblTitulo2 = new JLabel("CENAS");
        lblTitulo2.setBounds(160 + 2 * imagen.getIconWidth(), 10, 100, 25);
        lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitulo2); // agregamos la imagen

        // etiquetas para mostar los contadores que apareceran debajo de los titulos
        lblLanzamientos = new JLabel(); // instanciamos
        lblLanzamientos.setBounds(50 + 2 * imagen.getIconWidth(), 40, 100, 100); // coordenadas de donde quedara
        lblLanzamientos.setBackground(new ColorUIResource(0, 0, 0)); // Fondo negro
        lblLanzamientos.setForeground(new ColorUIResource(51, 255, 0)); // Color verde para el "0"
        lblLanzamientos.setFont(new FontUIResource("Tahoma", 1, 72)); // Cambio de letra
        lblLanzamientos.setText("0"); // escribimos lo que queramos que aparezca
        lblLanzamientos.setHorizontalAlignment(SwingConstants.RIGHT); // el cero lo queremos a la derecha
        lblLanzamientos.setOpaque(true); // codigo para que nos lea el negro
        getContentPane().add(lblLanzamientos); // agregamos el cero

        lblCenas = new JLabel();
        lblCenas.setBounds(160 + 2 * imagen.getIconWidth(), 40, 100, 100);
        lblCenas.setBackground(new ColorUIResource(0, 0, 0));
        lblCenas.setForeground(new ColorUIResource(51, 255, 0));
        lblCenas.setFont(new FontUIResource("Tahoma", 1, 72));
        lblCenas.setText("0");
        lblCenas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCenas.setOpaque(true);
        getContentPane().add(lblCenas);

        // el proximo JButton será para mostrar el boton "Iniciar"
        JButton btnIniciar = new JButton("Iniciar");// inicializamos el boton y despues lo instanciamos
        btnIniciar.setBounds(10, 15 + imagen.getIconHeight(), 100, 25);// Coordenadas
        getContentPane().add(btnIniciar); // agregamos el boton

        // el proximo JButton será para mostrar el boton "Lanzar"
        JButton btnLanzar = new JButton("Lanzar");
        btnLanzar.setBounds(10, 45 + imagen.getIconHeight(), 100, 25);
        getContentPane().add(btnLanzar);

        // evento para el boton iniciar
        btnIniciar.addActionListener(new ActionListener() { // escuchador de eventos

            @Override
            public void actionPerformed(ActionEvent e) {
                iniciar();
            }
        });

        // evento del boton lanzar
        btnLanzar.addActionListener(new ActionListener() { // escuchador de eventos

            @Override
            public void actionPerformed(ActionEvent e) {
                lanzar(); // evento lanzar
            }
        });

        dado1 = new Dado(); // instanciamos dados
        dado2 = new Dado();
        lanzamientos = 0; // instanciamos lanzamientos y cenas
        cenas = 0;

    }
    // creamos toda la logica de nuestro juego en los siguientes metodos

    // creamos metodo para iniciar
    private void iniciar() {
        lanzamientos = 0;
        cenas = 0;
        lblLanzamientos.setText("0");
        lblCenas.setText("0");
    }

    // metodo para lanzar
    private void lanzar() {
        dado1.lanzar(r);
        dado2.lanzar(r); // estos dados fueron los que declaramos arriba y provienen de la clase Dado

        dado1.mostrar(lblDado1);
        dado2.mostrar(lblDado2); // traemos el metodo lblDado

        lanzamientos++; // cuenta e incrementa los lanzamientos
        lblLanzamientos.setText(String.valueOf(lanzamientos)); // value of para que nos lea un numero en un metodo tipo texto
                                                

        // Condicional para las cenas
        if (dado1.getNumero() + dado2.getNumero() >= 11) {
            cenas++; // cada que pasa el condiconal la cena se incrementa
            lblCenas.setText(String.valueOf(cenas));
        }
    }

}
