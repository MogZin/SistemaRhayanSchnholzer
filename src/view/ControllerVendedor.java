package view;

import bean.RpsVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerVendedor extends AbstractTableModel {

    private List lstVendedor;

    public void setList(List lstVendedor) {
        this.lstVendedor = lstVendedor;
    }

    public RpsVendedor getBean(int rowIndex) {
        return (RpsVendedor) lstVendedor.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendedor.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RpsVendedor vendedor = (RpsVendedor) lstVendedor.get(rowIndex);
        if (columnIndex == 0) {
            return vendedor.getRpsIdvendedor();
        } else if (columnIndex == 1) {
            return vendedor.getRpsNome();
        } else if (columnIndex == 2) {
            return vendedor.getRpsTelefone();
        } else if (columnIndex == 3) {
            return vendedor.getRpsCpf();
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
            return "Telefone";
        } else if (columnIndex == 3) {
            return "Cpf";
        }
        return "";
    }
}
