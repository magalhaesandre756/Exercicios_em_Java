package br.ceub.fatecs.engsof.exercicio.swing.atividade3;

import javax.swing.*;
import java.awt.*;

public class Lanchonete extends JFrame {

    private JTextField txtCliente;
    private JComboBox<Produto> cmbProdutos;
    private JTextField txtQuantidade;
    private JButton btnAdicionar;
    private JButton btnFinalizar;
    private JTextArea txtPedido;
    private JLabel lblTotal;
    private double totalPedido;
    private int quantidadeItem;
    private JRadioButton rbDinheiro;
    private JRadioButton rbPix;
    private JRadioButton rbCartao;

    public Lanchonete() {
        setTitle("Lanchonete");
        setSize(600, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblCliente = new JLabel("Nome do Cliente: ");
        txtCliente = new JTextField();

        cmbProdutos = new JComboBox<>();
        cmbProdutos.addItem(new Produto("Hambúrguer", 22.00));
        cmbProdutos.addItem(new Produto("X-Salada", 28.00));
        cmbProdutos.addItem(new Produto("Batata Frita", 15.00));
        cmbProdutos.addItem(new Produto("Refrigerante", 8.00));
        cmbProdutos.addItem(new Produto("Suco", 10.00));

        JLabel lblQuantidade = new JLabel("Quantidade: ");
        txtQuantidade = new JTextField();

        rbDinheiro = new JRadioButton("Dinheiro");
        rbPix = new JRadioButton("Pix");
        rbCartao = new JRadioButton("Cartão");

        ButtonGroup grupoPagamento = new ButtonGroup();
        grupoPagamento.add(rbDinheiro);
        grupoPagamento.add(rbPix);
        grupoPagamento.add(rbCartao);

        btnAdicionar = new JButton("Adicionar");
        btnFinalizar = new JButton("Finalizar");

        txtPedido = new JTextArea();
        txtPedido.setEditable(false);

        lblTotal = new JLabel("Total do Pedido: R$ 0,00");

        JPanel painelPagamento = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelPagamento.add(rbDinheiro);
        painelPagamento.add(rbPix);
        painelPagamento.add(rbCartao);

        JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));

        painel.add(lblCliente);
        painel.add(txtCliente);

        painel.add(new JLabel("Produto: "));
        painel.add(cmbProdutos);

        painel.add(lblQuantidade);
        painel.add(txtQuantidade);

        painel.add(new JLabel("Pagamento: "));
        painel.add(painelPagamento);

        painel.add(new JLabel(""));
        painel.add(btnAdicionar);

        JPanel painelInferior = new JPanel(new GridLayout(1, 2, 10, 10));
        painelInferior.add(lblTotal);
        painelInferior.add(btnFinalizar);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        painelPrincipal.add(painel, BorderLayout.NORTH);
        painelPrincipal.add(new JScrollPane(txtPedido), BorderLayout.CENTER);
        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        add(painelPrincipal);

        btnAdicionar.addActionListener(e -> adiciona());
        btnFinalizar.addActionListener(e -> finalizar());

        setVisible(true);
    }

    private void adiciona() {
        try {
            Produto produtoSelecionado = (Produto) cmbProdutos.getSelectedItem();

            int quantidade = Integer.parseInt(txtQuantidade.getText().trim());
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.");
                return;
            }

            double subTotal = produtoSelecionado.getPreco() * quantidade;
            totalPedido += subTotal;
            quantidadeItem += quantidade;

            lblTotal.setText(String.format("Total do Pedido: R$ %.2f", totalPedido));

            txtPedido.append(String.format("%d x %s = R$ %.2f%n", quantidade, produtoSelecionado.getNome(), subTotal));

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Digite valores numéricos válidos para quantidade.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void finalizar() {
        String cliente = txtCliente.getText().trim();

        if (cliente.isEmpty() || quantidadeItem == 0) {
            JOptionPane.showMessageDialog(this, "Informe o cliente e adicione pelo menos um item.");
            return;
        }

        if (!rbDinheiro.isSelected() && !rbPix.isSelected() && !rbCartao.isSelected()) {
            JOptionPane.showMessageDialog(this, "Selecione a forma de pagamento.");
            return;
        }

        String pagamento;
        if (rbDinheiro.isSelected()) {
            pagamento = "Dinheiro";
        } else if (rbPix.isSelected()) {
            pagamento = "Pix";
        } else {
            pagamento = "Cartão";
        }

        double percentual;
        if (totalPedido >= 100) {
            percentual = 0.10;
        } else if (totalPedido >= 50) {
            percentual = 0.05;
        } else {
            percentual = 0;
        }

        double desconto = totalPedido * percentual;
        double totalFinal = totalPedido - desconto;

        JOptionPane.showMessageDialog(this, String.format("Pedido finalizado!%n%n" + "Cliente: %s%n" + "Pagamento: %s%n%n" + "Subtotal: R$ %.2f%n" + "Desconto (%.0f%%): R$ %.2f%n" + "Total final: R$ %.2f", cliente, pagamento, totalPedido, percentual * 100, desconto, totalFinal));
    }

    public static void main(String[] args) {
         SwingUtilities.invokeLater(Lanchonete::new);
    }
}