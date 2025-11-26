package view;

import bean.RpsUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerUsuarios extends AbstractTableModel {

    private List lstUsuarios;

    public void setList(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public RpsUsuarios getBean(int rowIndex) {
        return (RpsUsuarios) lstUsuarios.get(rowIndex);
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
        RpsUsuarios usuarios = (RpsUsuarios) lstUsuarios.get(rowIndex);
        if (columnIndex == 0) {
            return usuarios.getRpsIdusuarios();
        } else if (columnIndex == 1) {
            return usuarios.getRpsNome();
        } else if (columnIndex == 2) {
            return usuarios.getRpsApelido();
        } else if (columnIndex == 3) {
            return usuarios.getRpsCpf();
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
            return "Apelido";
        } else if (columnIndex == 3) {
            return "Cpf";
        }
        return "";
    }
}
