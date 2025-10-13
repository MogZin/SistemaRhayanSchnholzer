/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author u1845853
 */
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

        // Remove R$, espaços, pontos e substitui vírgula por ponto
        valor = valor.replace("R$", "")
                .replace(" ", "")
                .replace(".", "")
                .replace(",", ".");

        try {
            return Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valor para double: " + valor);
            return 0.0;
        }
    }

    public static String doubleToStr(double num) {
        return String.valueOf(num);
    }

    public static Date strToDate(String data) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.parse(data);
    }

    public static String dateToStr(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }

}
