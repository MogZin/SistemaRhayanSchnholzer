package view;

import bean.RpsVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

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
        RpsVendas rpsVendas = (RpsVendas) lstVendas.get(rowIndex);
        if (columnIndex == 0) {
            return rpsVendas.getRpsIdVendas();
        } else if (columnIndex == 1) {
            return rpsVendas.getRpsTotal();
        } else if (columnIndex == 2) {
            return rpsVendas.getRpsDataVenda();
        } else if (columnIndex == 3) {
            return rpsVendas.getRpsClientes().getRpsNome();
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
            return "Data da Venda";
        } else if (columnIndex == 3) {
            return "Cliente";
        }
        return "";
    }
}
