/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.RpsProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ControllerProdutos extends AbstractTableModel {

    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
    }

    public RpsProdutos getBean(int rowIndex) {
        return (RpsProdutos) lstProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProdutos.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RpsProdutos produtos = (RpsProdutos) lstProdutos.get(rowIndex);
        if (columnIndex == 0) {
            return produtos.getRpsIdJogo();
        } else if (columnIndex == 1) {
            return produtos.getRpsNome();
        } else if (columnIndex == 2) {
            return produtos.getRpsValor();
        } else if (columnIndex == 3) {
            return produtos.getRpsAnoLancamento();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Nome";
        } else if (columnIndex == 2) {
            return "Valor";
        } else if (columnIndex == 3) {
            return "Ano de Lançamento";
        }
        return "";
    }
}
