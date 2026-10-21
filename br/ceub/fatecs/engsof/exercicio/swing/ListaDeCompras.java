package br.ceub.fatecs.engsof.exercicio.swing;

import javax.swing.*;
import java.awt.*;

public class ListaDeCompras extends JFrame {
    private JTextField txtProduto;
    private JTextField txtQuantidade;
    private JTextField txtPreco;
    private JButton btnAdicionar;
    private JButton btnLimpar;
    private JTextArea txtLista;
    private JLabel lblTotal;
    private double totalCompra = 0;
    private JLabel lblProduto;
    private JLabel lblQuantidade;
    private JLabel lblPreco;

    public ListaDeCompras() {
        setTitle("Lista de compras");
        setSize(550, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblProduto = new JLabel("Adicione um Produto");
        txtProduto = new JTextField();

        JLabel lblQuantidade = new JLabel("Digite a quantidade");
        txtQuantidade = new JTextField();

        JLabel lblPreco = new JLabel("Digite o preço do produto");
        txtPreco = new JTextField();

        lblTotal = new JLabel("Total da compra: R$ 0,00");

        btnAdicionar = new JButton("Adicionar");
        btnLimpar = new JButton("Limpar");

        txtLista = new JTextArea(10, 30);
        txtLista.setEditable(false);

        painel.add(lblProduto);
        painel.add(txtProduto);

        painel.add(lblQuantidade);
        painel.add(txtQuantidade);

        painel.add(lblPreco);
        painel.add(txtPreco);

        painel.add(btnAdicionar);
        painel.add(btnLimpar);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        painelPrincipal.add(painel, BorderLayout.NORTH);
        painelPrincipal.add(new JScrollPane(txtLista), BorderLayout.CENTER);
        painelPrincipal.add(lblTotal, BorderLayout.SOUTH);

        add(painelPrincipal);

        btnAdicionar.addActionListener(e -> adiciona());
        btnLimpar.addActionListener(e -> limpa());

        setVisible(true);

    }

    private void adiciona() {
        try {
            String produto = txtProduto.getText().trim();

            if (produto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informe o nome do produto.");
                return;
            }

            int quantidade = Integer.parseInt(txtQuantidade.getText().trim());
            double preco = Double.parseDouble(txtPreco.getText().trim().replace(",", "."));

            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.");
                return;
            }

            if (preco < 0) {
                JOptionPane.showMessageDialog(this, "O preço não pode ser negativo.");
                return;
            }

            double subTotal = quantidade * preco;
            totalCompra += subTotal;

            lblTotal.setText(String.format(
                    "Total da compra: R$ %.2f", totalCompra));

            txtLista.append(String.format(
                    "%s - %d x R$ %.2f = R$ %.2f%n",
                    produto, quantidade, preco, subTotal));

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this,
                    "Digite valores numéricos válidos para quantidade e preço.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpa() {
        txtProduto.setText("");
        txtQuantidade.setText("");
        txtPreco.setText("");
        txtProduto.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListaDeCompras::new);
    }

}
