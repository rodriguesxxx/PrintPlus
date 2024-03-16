/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package printplus;

/**
 *60,179,113
 * @author Juan Pietro
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sessao {
    public Sessao() {
        JFrame frame = new JFrame();
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

        JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.setBackground(new Color(220, 220, 220)); // Fundo cinza claro
        JLabel sessionLabel = new JLabel("Sessão: ABDC", SwingConstants.CENTER);
        sessionLabel.setFont(new Font("Arial", Font.BOLD, 32)); // Título grande
        sessionLabel.setBorder(BorderFactory.createEmptyBorder(90, 0, 20, 0)); // Adicionando espaço vazio acima e abaixo do título
        middlePanel.add(sessionLabel, BorderLayout.NORTH); // Adicionando o título no topo

        // Adicionando o ícone de upload
        ImageIcon uploadIcon = new ImageIcon("upload.png");
        JLabel uploadIconLabel = new JLabel(uploadIcon);
        middlePanel.add(uploadIconLabel, BorderLayout.WEST); // Adicionando o ícone à esquerda do painel

        JLabel importLabel = new JLabel("Enviar Arquivo", SwingConstants.CENTER);
        importLabel.setForeground(new Color(0, 0, 0)); // Preto
        importLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Mudando o cursor
        importLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Coloque o código para a ação do clique aqui
                System.out.println("Clicou em Enviar Arquivo");
            }
        });
        importLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Aumentando o tamanho da fonte
        middlePanel.add(importLabel, BorderLayout.CENTER); // Adicionando o botão "Enviar Arquivo" ao centro
        contentPane.add(middlePanel, BorderLayout.CENTER); // Adicionando o painel central ao painel de conteúdo

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centralizando o botão
        bottomPanel.setBackground(new Color(220, 220, 220)); // Fundo cinza claro
        JButton printButton = new JButton("Imprimir");
        printButton.setBackground(new Color(0, 255, 127)); // Verde escuro
        printButton.setForeground(Color.WHITE); // Cor da fonte branca
        printButton.setFont(new Font("Arial", Font.BOLD, 16)); // Aumentando o tamanho da fonte
        printButton.setPreferredSize(new Dimension(120, 40)); // Ajustando o tamanho do botão
        printButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), // Adiciona um espaçamento ao redor do botão
                new RoundBorder(4) // Define a borda arredondada com raio de 4 pixels
        ));
        bottomPanel.add(printButton);
        contentPane.add(bottomPanel, BorderLayout.SOUTH); // Adicionando o painel inferior ao painel de conteúdo

        frame.setVisible(true);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(Sessao::new);
//    }

    // Classe RoundBorder para criar uma borda arredondada personalizada
    static class RoundBorder implements javax.swing.border.Border {
        private int radius;

        RoundBorder(int radius) {
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}













