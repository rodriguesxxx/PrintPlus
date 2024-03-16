/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printplus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swinmg.SwingUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author rodriguesxxx
 */
public class TabelaSessao {
    
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btInserir;
    private JButton btExcluir;
    private JButton btEditar;
    private DefaultTableModel modelo = new DefaultTableModel();
    public JFrame frame;
    
    public TabelaSessao() {
        buildTabela();
        buildJanela();
        SessaoRepository sR = new SessaoRepository();
        java.util.List dados = sR.selectAll();
    }
    
    private void buildJanela() {
        frame = new JFrame();
        frame.setTitle("PrintPlus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); // Aumentando o tamanho da janela

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(new Color(220, 220, 220)); // Fundo cinza claro
        frame.setContentPane(contentPane); // Definindo o painel de conteúdo da janela

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(60, 179, 113)); // Verde escuro
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60)); // Aumentando o tamanho da barra superior
        topPanel.setLayout(new BorderLayout()); // Layout de borda para alinhar o título ao centro
        JLabel titleLabel = new JLabel("PrintPlus", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE); // Cor da fonte branca
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Aumentando o tamanho da fonte
        topPanel.add(titleLabel, BorderLayout.CENTER); // Adicionando o título ao centro da barra superior
        contentPane.add(topPanel, BorderLayout.NORTH); // Adicionando a barra superior ao painel de conteúdo
        
        btInserir = new JButton("Nova sessão");
        btEditar = new JButton("Editar");
        btExcluir = new JButton("Excluir");
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        painelBotoes.add(btInserir);
        painelBotoes.add(btEditar);
        painelBotoes.add(btExcluir);
        painelFundo.add(BorderLayout.SOUTH, painelBotoes);

        contentPane.add(painelFundo);
        btInserir.addActionListener(new BtInserirListener());
        btEditar.addActionListener(new BtEditarListener());
        btExcluir.addActionListener(new BtExcluirListener());
        frame.setVisible(true);
    }
    
    private void buildTabela() {
        tabela = new JTable(modelo);
        modelo.addColumn("Sessão");
        modelo.addColumn("Data");
        modelo.addColumn("Qtd. Arquivos");
        tabela.getColumnModel().getColumn(0)
        .setPreferredWidth(30);
        tabela.getColumnModel().getColumn(1)
        .setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1)
        .setPreferredWidth(80);
        modelo.addRow(new Object[]{"AVCD", "17/02/2021", "2"});        
        modelo.addRow(new Object[]{"AVCD", "17/02/2021", "2"});

    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TabelaSessao::new);
    }
    
    
    
    private class BtEditarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = -1;
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
//                        int idContato = (int) tabela.getValueAt(linhaSelecionada, 0);
                    System.out.println("BTN EDIT");
                } else {
                        JOptionPane.showMessageDialog(null,
                        "É necesário selecionar uma linha.");
                }
        }
    }
    
    private class BtExcluirListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = -1;
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
//                        int idContato = (int) tabela.getValueAt(linhaSelecionada, 0);
                    modelo.removeRow(linhaSelecionada);
                    System.out.println("BTN EXCLUIR");
                } else {
                        JOptionPane.showMessageDialog(null,
                        "É necesário selecionar uma linha.");
                }
        }
    }
    
     
    private class BtInserirListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            new Sessao();
        }
    }
    
}

