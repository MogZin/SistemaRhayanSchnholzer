package view;

import bean.RpsClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerClientes extends AbstractTableModel {

    private List lstUsuarios;

    public void setList(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public RpsClientes getBean(int rowIndex) {
        return (RpsClientes) lstUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstUsuarios.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RpsClientes clientes = (RpsClientes) lstUsuarios.get(rowIndex);
        if (columnIndex == 0) {
            return clientes.getRpsIdclientes();
        } else if (columnIndex == 1) {
            return clientes.getRpsNome();
        } else if (columnIndex == 2) {
            return clientes.getRpsSaldoConta();
        } else if (columnIndex == 3) {
            return clientes.getRpsCpf();
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
            return "Saldo";
        } else if (columnIndex == 3) {
            return "Cpf";
        }
        return "";
    }
}
