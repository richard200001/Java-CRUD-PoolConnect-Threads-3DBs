package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ClienteVistaGUI extends JFrame {
    private JButton bIngresar, bMostrar, bBorrar, bActu, bfiltro, blimpiar;
    private JLabel lNombre, lCc;
    private JTextField tfNombre, tfCc;
    private JComboBox ListaDesplegable;
    private JTextArea area;
    private JScrollPane barra;
    private JPanel pDatos, pBotones;
    private int contador;
    
    public ClienteVistaGUI()
    {
      super("Programa de pool de conexiones y CRUD"); //Se pone el nombre al frame
      initComponents(); //método que construye todos los componentes del frame
    }

    //metodo llamado desde el constructor para crear el frame
    public void initComponents()
    {
        
        tfNombre = new JTextField(10);
        tfCc = new JTextField(10);
        lNombre = new JLabel("Nombre: ");
        lCc = new JLabel("CC: ");
        pDatos = new JPanel();
        
        pDatos.setLayout(new GridLayout(1,4,2,2)); //grid de 1X4 con separación de 2 horizontal y 2 vertical entre los elementos del grid
        //Se adicionan los campos y las etiquetas al panel de datos
        pDatos.add(lNombre);
        pDatos.add(tfNombre);
        pDatos.add(lCc); 
        pDatos.add(tfCc);
        colocarListasDesplegables();
        pDatos.setBackground(Color.CYAN);
        lCc.setBackground(Color.BLACK);
        lNombre.setBackground(Color.BLACK);
        //se define el tamaño del área de texto y se agrega a la barra.
        area = new JTextArea(20,10);
        area.setEditable(false);
        barra = new JScrollPane(area);
        
        bIngresar = new JButton("Ingresar");
        coloresBtn(bIngresar,'i');
        bMostrar  = new JButton("Mostrar Registros");
        coloresBtn(bMostrar,'m');
        bBorrar   = new JButton("Borrar");
        coloresBtn(bBorrar,'b');
        bActu     = new JButton("Actualizar");
        coloresBtn(bActu,'a');
        bfiltro     = new JButton("Filtrar");
        coloresBtn(bfiltro,'f');
        blimpiar    = new JButton("Limpiar");
        coloresBtn(blimpiar,'l');
        
        //Se adicionan los botones al panel botones
        pBotones = new JPanel();
        pBotones.setLayout(new GridLayout(2,4,2,2)); //grid de 1X4 con separación de 2 horizontal y 2 vertical entre los elementos del grid
        pBotones.add(bIngresar);
        pBotones.add(bActu);
        pBotones.add(bBorrar);
        pBotones.add(bMostrar);
        pBotones.add(bfiltro);
        pBotones.add(blimpiar);
        
        //Al frame se le define una distribución BorderLayout(tiene 5 áreas - una superior - 3 en el centro y una inferior)
        setLayout(new BorderLayout());
        
        //se adicionan los paneles al frame
        add(pDatos,BorderLayout.NORTH);
        add(barra,BorderLayout.CENTER);
        add(pBotones,BorderLayout.SOUTH);
        
        pack();//se ajusta el frame al tamaño de los componentes adicionados
        setVisible(true); //se hace visible el frame
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cuando se cierra la ventana se libera la memoria
    }
    //métodos para acceder a los atributos privados del frame

    public JButton getBfiltro() {
        return bfiltro;
    }

    public JButton getBlimpiar() {
        return blimpiar;
    }
    
    public JButton getbIngresar() {
        return bIngresar;
    }

    public JButton getbMostrar() {
        return bMostrar;
    }

    public JButton getbBorrar() {
        return bBorrar;
    }

    public JButton getbActu() {
        return bActu;
    }
    
    public String getNombre(){
        return tfNombre.getText().trim();//trim - elimina dos espacio al inicio y al final de la cadena
    }
    
    public String getcc(){
        return tfCc.getText().trim();//trim - elimina dos espacio al inicio y al final de la cadena
    }

    public JPanel getpDatos() {
        return pDatos;
    }

    public JPanel getpBotones() {
        return pBotones;
    }

    public JLabel getlNombre() {
        return lNombre;
    }

    public JLabel getlCc() {
        return lCc;
    }
    
    
    
    public void mostrarCampos(List lista){
        contador=0;
        lista.forEach((unRegistro) -> {
            area.append(unRegistro.toString()); //adiciona el nuevo texto al texto ya existente
            
            contador++;
            System.out.println(contador);
            //if(contador%2==0 && contador!=0){
              //  area.append("\n");
            //}
            if(contador==3){
                 area.append("\n");
                 contador=0;
            }
        });
        contador=0;
    }
    
    private void colocarListasDesplegables() {
       String [] colores={"Azul & Negro","Negro & Blanco","Negro & Verde"};
       ListaDesplegable=new JComboBox(colores);
       ListaDesplegable.setSelectedItem("Azul & Negro");
       ListaDesplegable.setBackground(Color.CYAN);
       ListaDesplegable.setForeground(Color.BLACK);//establecemos el color de la letra del botón
       ListaDesplegable.setFont(new Font("arial",Font.BOLD,15));
       pDatos.add(ListaDesplegable);
    }
    
    public void cambiarColorDePanel(JPanel p,JLabel l1, JLabel l2, String d, JButton b1, JButton b2,JButton b3, JButton b4, JButton b5, JButton b6, JComboBox j){
        if(d.equals("Azul & Negro")){
            p.setBackground(Color.CYAN);
            l1.setForeground(Color.BLACK);//establecemos el color de la letra del botón
            l1.setFont(new Font("arial",Font.BOLD,15));
            l2.setForeground(Color.BLACK);//establecemos el color de la letra del botón
            l2.setFont(new Font("arial",Font.BOLD,15));
            coloresBtn1(b1);
            coloresBtn1(b2);
            coloresBtn1(b3);
            coloresBtn1(b4);
            coloresBtn1(b5);
            coloresBtn1(b6);
            j.setBackground(Color.CYAN);
            j.setForeground(Color.BLACK);//establecemos el color de la letra del botón
            j.setFont(new Font("arial",Font.BOLD,15));
        }
        if(d.equals("Negro & Blanco")){
            p.setBackground(Color.BLACK);
            l1.setForeground(Color.WHITE);//establecemos el color de la letra del botón
            l1.setFont(new Font("arial",Font.BOLD,15));
            l2.setForeground(Color.WHITE);//establecemos el color de la letra del botón
            l2.setFont(new Font("arial",Font.BOLD,15));
            coloresBtn2(b1);
            coloresBtn2(b2);
            coloresBtn2(b3);
            coloresBtn2(b4);
            coloresBtn2(b5);
            coloresBtn2(b6);
            j.setBackground(Color.BLACK);
            j.setForeground(Color.WHITE);//establecemos el color de la letra del botón
            j.setFont(new Font("arial",Font.BOLD,15));
        }
        if(d.equals("Negro & Verde")){
            p.setBackground(Color.BLACK);
            l1.setForeground(Color.GREEN);//establecemos el color de la letra del botón
            l1.setFont(new Font("arial",Font.BOLD,15));
            l2.setForeground(Color.GREEN);//establecemos el color de la letra del botón
            l2.setFont(new Font("arial",Font.BOLD,15));
            coloresBtn3(b1);
            coloresBtn3(b2);
            coloresBtn3(b3);
            coloresBtn3(b4);
            coloresBtn3(b5);
            coloresBtn3(b6);
            j.setBackground(Color.BLACK);
            j.setForeground(Color.GREEN);//establecemos el color de la letra del botón
            j.setFont(new Font("arial",Font.BOLD,15));
        }
    }
    
    public void coloresBtn(JButton a, char b){
        a.setMnemonic(b);//establecemos alt + la letra que le coloque y el botón funciona
        a.setBackground(Color.CYAN);
        a.setForeground(Color.BLACK);//establecemos el color de la letra del botón
        a.setFont(new Font("arial",Font.BOLD,15));
    }
    
    public void coloresBtn1(JButton a){
        a.setBackground(Color.CYAN);
        a.setForeground(Color.BLACK);//establecemos el color de la letra del botón
        a.setFont(new Font("arial",Font.BOLD,15));
    }
    
    public void coloresBtn2(JButton a){
        a.setBackground(Color.BLACK);
        a.setForeground(Color.WHITE);//establecemos el color de la letra del botón
        a.setFont(new Font("arial",Font.BOLD,15));
    }
    
    public void coloresBtn3(JButton a){
        a.setBackground(Color.BLACK);
        a.setForeground(Color.GREEN);//establecemos el color de la letra del botón
        a.setFont(new Font("arial",Font.BOLD,15));
    }
    
    public void mostrarSalida1()
    {
        area.setText(""); //Borra lo que hay y le adiciona un nuevo texto
    }
    public void mostrarSalida2( String valor)
    {
        area.setText(valor); //Borra lo que hay y le adiciona un nuevo texto
    }
    
    public void borrar()
    {
        area.setText(""); //Borra lo que hay y le adiciona un nuevo texto
    }
    
    public void filtro(List lista)
    {
        contador=0;
        lista.forEach((unRegistro) -> {
            String s1=String.valueOf(tfCc.getText());
            
            if((unRegistro.toString()).contains(tfNombre.getText()+s1) || (unRegistro.toString().contains(tfNombre.getText()) && unRegistro.toString().contains(s1) )){
                area.append(unRegistro.toString());
                contador++;
                System.out.println(contador);
                //if(contador%2==0 && contador!=0){
                  //  area.append("\n");
               // }
               if(contador==3){
                   area.append("\n");
                   contador=0;
               }
            } 
        });
          contador=0;
    }

    public JComboBox getListaDesplegable() {
        return ListaDesplegable;
    }

    public void setListaDesplegable(JComboBox ListaDesplegable) {
        this.ListaDesplegable = ListaDesplegable;
    }
    
    
    
    public void escuchaCoboBox(ItemListener e){
        ListaDesplegable.addItemListener(e);
    }
    
    // escuchas de acción
    
    public void asignarEscuchas(ActionListener evento){
        bMostrar.addActionListener(evento);
        bIngresar.addActionListener(evento);
        bBorrar.addActionListener(evento);
        bActu.addActionListener(evento);
        bfiltro.addActionListener(evento);
        blimpiar.addActionListener(evento);
        
    }
}
