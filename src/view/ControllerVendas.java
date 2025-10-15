/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.RpsVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcos
 */
public class ControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
    }

    public RpsVendas getBean(int rowIndex) {
        return (RpsVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RpsVendas vendas = (RpsVendas) lstVendas.get(rowIndex);
        if (columnIndex == 0) {
            return vendas.getRpsIdVendas();
        } else if (columnIndex == 1) {
            return vendas.getRpsTotal();
        } else if (columnIndex == 2) {
            return vendas.getRpsFormaPagamento();
        } else if (columnIndex == 3) {
            return vendas.getRpsDataVenda();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Total";
        } else if (columnIndex == 2) {
            return "Forma de Pagamento";
        } else if (columnIndex == 3) {
            return "Data da venda";
        }
        return "";
    }
}
