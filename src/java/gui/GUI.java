package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI {

    /**
     * classe com componentes da GUI que podem ser reutilizados
     */

    private static GUI instance = null;

    private final JFrame frame;

    private final Container contentPanel;
    protected final JButton criarBtn = new JButton("Criar ficheiro");

    protected final JButton importBtn = new JButton("Importar ficheiro");
    protected final JButton convertBtn = new JButton("Converter ficheiro");
    protected final JButton visualizarBtn = new JButton("Visualizar ficheiro");
    final JButton exportBtn = new JButton("Exportar ficheiro");
    private final JButton backBtn = new JButton("Voltar");

    protected GUI() {
        frame = new JFrame("Gestão de Horários");
        System.out.println(
                "GUI: " + frame.getName() + " " + frame.getSize() + " " + frame.getLocation() + " " + frame.isVisible()
        );
        // Inicializa o painel de conteudo
        contentPanel = frame.getContentPane();
        // Define o tamanho da janela
        frame.setSize(400, 300);

        // Define o comportamento da janela quando fechar
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Define a janela como visível
        frame.setVisible(true);

        setButtons();

    }


    public static GUI getInstance() {
        System.out.println(instance);
        if (instance == null) {
            System.out.println("GUI: Creating new instance");
            instance = new GUI();
        }
        return instance;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Container getContentPanel() {
        return contentPanel;
    }

    private void setButtons() {
        importBtn.addActionListener(new ActionListener() {
            /**
             * Mostra o sub-menu de importar de ficheiros
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                new ImportMenu("Importar calendário");
            }
        });
        criarBtn.addActionListener(new ActionListener() {
            /**
             * Mostra o sub-menu de criar de ficheiros
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                //new CriarMenu();
            }
        });
        convertBtn.addActionListener(new ActionListener() {
            /**
             * Mostra o sub-menu de converter ficheiros
             *
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                new ConverterMenu("Converter ficheiro");
            }
        });
        visualizarBtn.addActionListener(new ActionListener() {
            /**
             * Mostra o sub-menu para visualizar ficheiros
             *
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                new VisualizarMenu("Visualizar calendário");
            }
        });
        /**
         * Exporta dados para um ficheiro selecionado pelo utilizador.
         */
        exportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir um seletor de ficheiros
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Obter o ficheiro selecionado
                    File selectedFile = fileChooser.getSelectedFile();

                    // TODO: Adicionar lógica para exportar para o ficheiro

                }
            }
        });

        //TODO: implementar o botão de voltar
    }

    public void init(){
        System.out.println("GUI: init");
        new Home("home");
    }



}
