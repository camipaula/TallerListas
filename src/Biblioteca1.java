import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Biblioteca1 extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField textFieldNombre;
    private JTextField textField2;
    private JButton AGREGARButton;
    private JTextField textField3;
    private JButton eliminarPorIdButton;
    private JButton eliminarPorNombreButton;
    private JTextField textField4;
    private JButton buscarPorIDButton;
    private JButton buscarPorNombreButton;
    private JButton mostararCantidadDePaginasButton;
    private JTextArea textArea1;
    private JButton agregarLibrosPredeterminadosButton;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private Bibliotecaa b;
    private Libro l;
    public Biblioteca1(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        b=new Bibliotecaa();

        AGREGARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            b.agregarLibro(new Libro(Integer.parseInt(textField2.getText()),textFieldNombre.getText()));
            JOptionPane.showMessageDialog(null, "Libro agregado");
                textArea2.setText(b.toString());
            }
        });


        agregarLibrosPredeterminadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.datosQuemados();
                JOptionPane.showMessageDialog(null, "Datos quemados");
                agregarLibrosPredeterminadosButton.setEnabled(false);
            }
        });


        eliminarPorNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Libro libro1=b.removeLibroPorNombre(textField3.getText());
                if(libro1!=null){
                    textArea3.setText("Libro encontrado "+libro1.toString());
                }else {
                    textArea3.setText("Libro no encontrado");
                }

            }
        });
        eliminarPorIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Libro libro1=b.removeLibroPorId(Integer.parseInt(textField3.getText()));
                if(libro1!=null){
                    textArea3.setText("Libro encontrado "+libro1.toString());
                }else {
                    textArea3.setText("Libro no encontrado");
                }
            }
        });
        buscarPorIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Libro libro1=b.busquedaBinario(Integer.parseInt(textField4.getText()));
                if(libro1!=null){
                    textArea4.setText("Libro encontrado "+libro1.toString());
                }else {
                    textArea4.setText("Libro no encontrado");
                }

            }
        });
        buscarPorNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Libro libro1=b.busquedaLibro(textField4.getText());
                if(libro1!=null){
                    textArea4.setText("Libro encontrado "+libro1.toString());
                }else {
                    textArea4.setText("Libro no encontrado");
                }
            }
        });
        mostararCantidadDePaginasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice=b.getLibros().size()-1;
                textArea1.setText("Suma paginas totales: "+b.sumaPaginas(b.getLibros(),indice));

            }
        });
    }




}
