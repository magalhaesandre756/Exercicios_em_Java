package br.ceub.fatecs.engsof.exercicio.swing;

import javax.swing.*;
import java.awt.*;

public class ContaRestaurante extends JFrame {

    private JTextField txtConsumo;
    private JTextField txtPessoas;
    private JComboBox<Double> cmbServico;
    private Double[] taxas = {0.0, 0.05, 0.10, 0.15};

    private JLabel lblTotal;
    private JLabel lblPorPessoa;

    private JButton btnCalcular;
    private JButton btnLimpar;

    public ContaRestaurante() {

        setTitle("Conta do Restaurante");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        painel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblConsumo = new JLabel("Valor do consumo:");
        txtConsumo = new JTextField();

        JLabel lblPessoas = new JLabel("Número de pessoas:");
        txtPessoas = new JTextField();

        cmbServico = new JComboBox<>(taxas);


        btnCalcular = new JButton("Calcular");
        btnLimpar = new JButton("Limpar");

        lblTotal = new JLabel("Total: R$ 0,00");
        lblPorPessoa = new JLabel("Por pessoa: R$ 0,00");

        painel.add(lblConsumo);
        painel.add(txtConsumo);

        painel.add(lblPessoas);
        painel.add(txtPessoas);

        painel.add(new JLabel("Serviço: "));
        painel.add(cmbServico);

        painel.add(btnCalcular);
        painel.add(btnLimpar);

        painel.add(lblTotal);
        painel.add(lblPorPessoa);

        add(painel);

        btnCalcular.addActionListener(e -> calcularConta());

        btnLimpar.addActionListener(e -> limpar());

        setVisible(true);
    }

    private void calcularConta() {

        try {

            double consumo =
                    Double.parseDouble(txtConsumo.getText().replace(",", "."));

            int pessoas =
                    Integer.parseInt(txtPessoas.getText());

            if (consumo < 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "O consumo não pode ser negativo."
                );
                return;
            }

            if (pessoas <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe pelo menos uma pessoa."
                );
                return;
            }

            double taxa = (Double) cmbServico.getSelectedItem();
            double servico = consumo * taxa;

            double total = consumo + servico;
            double porPessoa = total / pessoas;

            lblTotal.setText(
                    String.format("Total: R$ %.2f", total)
            );

            lblPorPessoa.setText(
                    String.format(
                            "Por pessoa: R$ %.2f",
                            porPessoa
                    )
            );

        } catch (NumberFormatException erro) {

            JOptionPane.showMessageDialog(
                    this,
                    "Digite valores válidos.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        }
    }

    private void limpar() {

        txtConsumo.setText("");
        txtPessoas.setText("");

        cmbServico.setSelectedIndex(0);


        lblTotal.setText("Total: R$ 0,00");
        lblPorPessoa.setText("Por pessoa: R$ 0,00");

        txtConsumo.requestFocus();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new ContaRestaurante()
        );
    }
}