package ifdminterfaces;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Tela extends JFrame {
    
    Process process = new Process();

    private JLabel txtUf;
    private JComboBox<String> ufComboBox;
    private JPanel ufJPanel;

    private JLabel txtUfSaude;
    private JTextField saudeUfJtf;
    private JLabel txtUfEdu;
    private JTextField eduUfJtf;
    private JLabel txtUfRenda;
    private JTextField rendaUfJtf;
    private JLabel txtUfIfdm;
    private JTextField ifdmUfJtf;

    private JLabel txtCid;
    private JComboBox<String> cidComboBox;
    private JPanel cidJPanel;

    private JLabel txtCidSaude;
    private JTextField saudeCidJtf;
    private JLabel txtCidEdu;
    private JTextField eduCidJtf;
    private JLabel txtCidRenda;
    private JTextField rendaCidJtf;
    private JLabel txtIfdmRenda;
    private JTextField ifdmCidJtf;
    private JLabel txtCidRankNac;
    private JTextField rankNacCidJtf;
    private JLabel txtCidRankEstadual;
    private JTextField rankEstCidJtf;

    public JComboBox<String> getUfComboBox() {
    return ufComboBox;
    }
    
    public JComboBox<String> getcidComboBox() {
    return cidComboBox;
    }
    
    public Tela() {
        setTitle("Índice IFDM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        // Painel UF e ComboBox
        ufJPanel = new JPanel();
        ufJPanel.setLayout(null);
        ufJPanel.setBounds(20, 50, 250, 250);
        ufJPanel.setBorder(BorderFactory.createTitledBorder("Média por UF"));
        add(ufJPanel);

        txtUf = new JLabel("UF:");
        txtUf.setBounds(10, 20, 50, 25);
        ufJPanel.add(txtUf);

        ufComboBox = new JComboBox<>();
        ufComboBox.setBounds(60, 20, 150, 25);
        ufJPanel.add(ufComboBox);

        // Campos de média por UF
        txtUfSaude = new JLabel("Saúde:");
        txtUfSaude.setBounds(10, 60, 100, 20);
        ufJPanel.add(txtUfSaude);

        saudeUfJtf = new JTextField();
        saudeUfJtf.setBounds(110, 60, 120, 20);
        ufJPanel.add(saudeUfJtf);

        txtUfEdu = new JLabel("Educação:");
        txtUfEdu.setBounds(10, 90, 100, 20);
        ufJPanel.add(txtUfEdu);

        eduUfJtf = new JTextField();
        eduUfJtf.setBounds(110, 90, 120, 20);
        ufJPanel.add(eduUfJtf);

        txtUfRenda = new JLabel("Renda:");
        txtUfRenda.setBounds(10, 120, 100, 20);
        ufJPanel.add(txtUfRenda);

        rendaUfJtf = new JTextField();
        rendaUfJtf.setBounds(110, 120, 120, 20);
        ufJPanel.add(rendaUfJtf);

        txtUfIfdm = new JLabel("IFDM:");
        txtUfIfdm.setBounds(10, 150, 100, 20);
        ufJPanel.add(txtUfIfdm);

        ifdmUfJtf = new JTextField();
        ifdmUfJtf.setBounds(110, 150, 120, 20);
        ufJPanel.add(ifdmUfJtf);

        // Painel Cidade e ComboBox
        cidJPanel = new JPanel();
        cidJPanel.setLayout(null);
        cidJPanel.setBounds(350, 50, 300, 250);
        cidJPanel.setBorder(BorderFactory.createTitledBorder("Médias da cidade selecionada"));
        add(cidJPanel);

        txtCid = new JLabel("Cidade:");
        txtCid.setBounds(10, 20, 60, 25);
        cidJPanel.add(txtCid);

        cidComboBox = new JComboBox<>();
        cidComboBox.setBounds(70, 20, 200, 25);
        cidJPanel.add(cidComboBox);
        
        cidComboBox.addActionListener(e -> {
        String cidadeSelecionada = (String) cidComboBox.getSelectedItem();{
                 process.carregarDadoCidade(cidadeSelecionada, saudeCidJtf);
                 process.carregarDadoEducacaoCid(cidadeSelecionada, eduCidJtf);
                 process.carregarDadoRendaCid(cidadeSelecionada, rendaCidJtf);
                 process.carregarDadoIFDMCid(cidadeSelecionada, ifdmCidJtf);
                 process.carregarDadoRankNac(cidadeSelecionada, rankNacCidJtf);
                 process.carregarDadoRankEsta(cidadeSelecionada, rankEstCidJtf);
            }
           
        });
        
        ufComboBox.addActionListener(e -> {
        String estadoSelecionado = (String) ufComboBox.getSelectedItem();
            if (estadoSelecionado != null) {
                 process.carregarMunic(estadoSelecionado, cidComboBox);
                 process.carregarDadoSaudeUF(estadoSelecionado, saudeUfJtf);
                 process.carregarDadoEducacaoUF(estadoSelecionado, eduUfJtf);
                 process.carregarDadoRendaUF(estadoSelecionado, rendaUfJtf);
                 process.carregarDadoIfdmUF(estadoSelecionado, ifdmUfJtf);
            }
           
        });

        // Campos de média da cidade
        txtCidSaude = new JLabel("Saúde:");
        txtCidSaude.setBounds(10, 60, 100, 20);
        cidJPanel.add(txtCidSaude);

        saudeCidJtf = new JTextField();
        saudeCidJtf.setBounds(120, 60, 150, 20);
        cidJPanel.add(saudeCidJtf);

        txtCidEdu = new JLabel("Educação:");
        txtCidEdu.setBounds(10, 90, 100, 20);
        cidJPanel.add(txtCidEdu);

        eduCidJtf = new JTextField();
        eduCidJtf.setBounds(120, 90, 150, 20);
        cidJPanel.add(eduCidJtf);

        txtCidRenda = new JLabel("Renda:");
        txtCidRenda.setBounds(10, 120, 100, 20);
        cidJPanel.add(txtCidRenda);

        rendaCidJtf = new JTextField();
        rendaCidJtf.setBounds(120, 120, 150, 20);
        cidJPanel.add(rendaCidJtf);

        txtIfdmRenda = new JLabel("IFDM:");
        txtIfdmRenda.setBounds(10, 150, 100, 20);
        cidJPanel.add(txtIfdmRenda);

        ifdmCidJtf = new JTextField();
        ifdmCidJtf.setBounds(120, 150, 150, 20);
        cidJPanel.add(ifdmCidJtf);

        txtCidRankNac = new JLabel("Ranking Nacional:");
        txtCidRankNac.setBounds(10, 180, 120, 20);
        cidJPanel.add(txtCidRankNac);

        rankNacCidJtf = new JTextField();
        rankNacCidJtf.setBounds(140, 180, 130, 20);
        cidJPanel.add(rankNacCidJtf);

        txtCidRankEstadual = new JLabel("Ranking Estadual:");
        txtCidRankEstadual.setBounds(10, 210, 120, 20);
        cidJPanel.add(txtCidRankEstadual);

        rankEstCidJtf = new JTextField();
        rankEstCidJtf.setBounds(140, 210, 130, 20);
        cidJPanel.add(rankEstCidJtf);
    }
    

}
