package br.ceub.fatecs.engsof.exercicio.swing.atividade1;

import javax.swing.*;
import java.awt.*;

public class ContaRestaurante extends JFrame {
    /*
    1-O JFrame é a janela principal do programa.
    Ele tem barra de título, botões de minimizar, maximizar e fechar, e é dentro dele que os painéis e componentes são colocados.
    Na atividade, a classe herda de JFrame (extends JFrame), então ela própria é a janela e pode chamar diretamente métodos como setTitle, setSize e setVisible.
    2-O JTextField é um campo de texto de uma linha onde o usuário digita informações.
    No programa, ele recebe o valor do consumo e o número de pessoas. O conteúdo digitado é lido com getText() e pode ser alterado ou apagado com setText().
    3-Porque o getText() sempre devolve uma String, ou seja, texto, mesmo que o usuário tenha digitado um número.
    Não é possível fazer contas com texto. O Double.parseDouble() converte o texto em número decimal (double), usado no consumo, que pode ter centavos.
    O Integer.parseInt() converte em número inteiro (int), usado no número de pessoas, que não pode ser fracionado.
    4- Pelo método isSelected() do JCheckBox, que devolve true quando a caixa está marcada e false quando não está.
       Na solução do material, o resultado é usado num operador ternário para decidir se cobra os 10%.
    5-O try/catch trata erros que podem acontecer durante a execução sem deixar o programa quebrar.
    O código que pode falhar fica dentro do try. Se o usuário digitar algo que não é número, como abc, o parseDouble ou o parseInt lança uma NumberFormatException,
    e a execução pula para o catch, que mostra uma mensagem de erro amigável em vez de encerrar com erro no console
     */
    private JTextField txtConsumo;
    private JTextField txtPessoas;
    private JComboBox<String> cmbServico;
    private String[] opcoesServico = {"Sem serviço", "5%", "10%", "15%"};
    private double[] taxas = {0.0, 0.05, 0.10, 0.15};
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
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        painel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblConsumo = new JLabel("Valor do consumo:");
        txtConsumo = new JTextField();

        JLabel lblPessoas = new JLabel("Número de pessoas:");
        txtPessoas = new JTextField();

        cmbServico = new JComboBox<>(opcoesServico);

        btnCalcular = new JButton("Calcular");
        btnLimpar = new JButton("Limpar");

        lblTotal = new JLabel("Total: R$ 0,00");
        lblPorPessoa = new JLabel("Por pessoa: R$ 0,00");

        painel.add(lblConsumo);
        painel.add(txtConsumo);

        painel.add(lblPessoas);
        painel.add(txtPessoas);

        painel.add(new JLabel("Serviço:"));
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
            double consumo = Double.parseDouble(
                    txtConsumo.getText().trim().replace(",", "."));
            int pessoas = Integer.parseInt(txtPessoas.getText().trim());

            if (consumo < 0) {
                JOptionPane.showMessageDialog(this,
                        "O consumo não pode ser negativo.");
                return;
            }

            if (pessoas <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Informe pelo menos uma pessoa.");
                return;
            }

            int indice = cmbServico.getSelectedIndex();
            double taxa = taxas[indice];
            double servico = consumo * taxa;

            double total = consumo + servico;
            double porPessoa = total / pessoas;

            lblTotal.setText(String.format("Total: R$ %.2f", total));
            lblPorPessoa.setText(String.format("Por pessoa: R$ %.2f", porPessoa));

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this,
                    "Digite valores numéricos válidos.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
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
        SwingUtilities.invokeLater(ContaRestaurante::new);
    }
}
