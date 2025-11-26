package view;

import bean.RpsVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerVendasProdutos extends AbstractTableModel {

    private List lstVendasProdutos;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        this.fireTableDataChanged();
    }

    public RpsVendasProdutos getBean(int rowIndex) {
        return (RpsVendasProdutos) lstVendasProdutos.get(rowIndex);
    }

    public void addBean(RpsVendasProdutos rpsVendasProdutos) {
        lstVendasProdutos.add(rpsVendasProdutos);
        this.fireTableDataChanged();
    }

    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RpsVendasProdutos rpsVendasProdutos = (RpsVendasProdutos) lstVendasProdutos.get(rowIndex);
        if (columnIndex == 0) {
            return rpsVendasProdutos.getRpsProdutos().getRpsIdJogo();
        } else if (columnIndex == 1) {
            return rpsVendasProdutos.getRpsProdutos().getRpsNome();
        } else if (columnIndex == 2) {
            return rpsVendasProdutos.getRpsQuantidade();
        } else if (columnIndex == 3) {
            return rpsVendasProdutos.getRpsValorUnitario();
        } else if (columnIndex == 4) {
            return rpsVendasProdutos.getRpsValorUnitario() * rpsVendasProdutos.getRpsQuantidade();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Produto";
        } else if (columnIndex == 2) {
            return "Quantidade";
        } else if (columnIndex == 3) {
            return "Valor Unitário";
        } else if (columnIndex == 4) {
            return "Total";
        }
        return "";
    }
}
