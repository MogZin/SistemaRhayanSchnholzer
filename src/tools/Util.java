package tools;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);

        }
    }

    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            }

            if (componentes[i] instanceof JComboBox) {
                ((JComboBox) componentes[i]).setSelectedIndex(-1);
            }

            if (componentes[i] instanceof JCheckBox) {
                ((JCheckBox) componentes[i]).setSelected(false);
            }
        }

    }

    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);
    }

    public static boolean pergunta(String cad) {
        int opcao = JOptionPane.showConfirmDialog(
                null,
                cad,
                "EXCLUSÃO",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        return opcao == JOptionPane.YES_OPTION;
    }

    public static int strToInt(String num) {
        return Integer.parseInt(num);
    }

    public static String intToStr(int num) {
        return String.valueOf(num);

    }

    public static double strToDouble(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return 0.0;
        }

        try {
            // Remove R$, espaços
            String valorLimpo = valor.replace("R$", "")
                    .replace(" ", "")
                    .trim();

            // Verifica se está vazio após limpeza
            if (valorLimpo.isEmpty()) {
                return 0.0;
            }

            // Se não tem vírgula, é um número inteiro
            if (!valorLimpo.contains(",")) {
                return Double.parseDouble(valorLimpo);
            }

            // Se tem vírgula, separa parte inteira e decimal
            String[] partes = valorLimpo.split(",");

            // Parte inteira - remove pontos (separadores de milhar)
            String parteInteira = partes[0].replace(".", "");

            // Parte decimal - pega até 2 dígitos
            String parteDecimal = partes[1].length() >= 2 ? partes[1].substring(0, 2) : partes[1];

            // Se a parte decimal tem apenas 1 dígito, multiplica por 10
            // Se tem 2 dígitos, está correto
            double valorDouble = Double.parseDouble(parteInteira + "." + parteDecimal);

            return valorDouble;

        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valor para double: '" + valor + "' - " + e.getMessage());
            return 0.0;
        } catch (Exception e) {
            System.err.println("Erro inesperado ao converter: '" + valor + "' - " + e.getMessage());
            return 0.0;
        }
    }

    public static String doubleToStr(double num) {
        try {
            // Garante que o número tenha duas casas decimais
            DecimalFormat df = new DecimalFormat("0.00");
            String numeroFormatado = df.format(num);

            // Separa parte inteira e decimal
            String[] partes = numeroFormatado.split("\\.");
            String parteInteira = partes[0];
            String parteDecimal = partes[1];

            // Formata parte inteira com separadores de milhar
            StringBuilder inteiraFormatada = new StringBuilder();
            int contador = 0;
            for (int i = parteInteira.length() - 1; i >= 0; i--) {
                if (contador == 3) {
                    inteiraFormatada.insert(0, ".");
                    contador = 0;
                }
                inteiraFormatada.insert(0, parteInteira.charAt(i));
                contador++;
            }

            return "R$ " + inteiraFormatada.toString() + "," + parteDecimal;

        } catch (Exception e) {
            System.err.println("Erro ao formatar double para string: " + e.getMessage());
            return "R$ 0,00";
        }
    }

    public static Date strToDate(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formato.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String dateToStr(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }

}
