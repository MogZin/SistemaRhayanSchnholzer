package bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "rps_vendas",
        catalog = "db_rhayan_schonholzer"
)
public class RpsVendas implements java.io.Serializable {

    private int rpsIdVendas;
    private RpsClientes rpsClientes;
    private RpsVendedor rpsVendedor;
    private Date rpsDataVenda;
    private double rpsTotal;
    private int rpsFormaPagamento;
    private double rpsDesconto;

    public RpsVendas() {
    }

    public RpsVendas(Date rpsDataVenda) {
        this.rpsDataVenda = rpsDataVenda;
    }

    public RpsVendas(RpsClientes rpsClientes, RpsVendedor rpsVendedor, Date rpsDataVenda, double rpsTotal, int rpsFormaPagamento, double rpsDesconto) {
        this.rpsClientes = rpsClientes;
        this.rpsVendedor = rpsVendedor;
        this.rpsDataVenda = rpsDataVenda;
        this.rpsTotal = rpsTotal;
        this.rpsFormaPagamento = rpsFormaPagamento;
        this.rpsDesconto = rpsDesconto;
    }

    @Id

    @Column(name = "rps_idVendas", unique = true, nullable = false)
    public int getRpsIdVendas() {
        return this.rpsIdVendas;
    }

    public void setRpsIdVendas(int rpsIdVendas) {
        this.rpsIdVendas = rpsIdVendas;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rps_cliente")
    public RpsClientes getRpsClientes() {
        return this.rpsClientes;
    }

    public void setRpsClientes(RpsClientes rpsClientes) {
        this.rpsClientes = rpsClientes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rps_vendedor")
    public RpsVendedor getRpsVendedor() {
        return this.rpsVendedor;
    }

    public void setRpsVendedor(RpsVendedor rpsVendedor) {
        this.rpsVendedor = rpsVendedor;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "rps_dataVenda", nullable = false, length = 10)
    public Date getRpsDataVenda() {
        return this.rpsDataVenda;
    }

    public void setRpsDataVenda(Date rpsDataVenda) {
        this.rpsDataVenda = rpsDataVenda;
    }

    @Column(name = "rps_total", precision = 10)
    public double getRpsTotal() {
        return this.rpsTotal;
    }

    public void setRpsTotal(double rpsTotal) {
        this.rpsTotal = rpsTotal;
    }

    @Column(name = "rps_forma_pagamento", length = 50)
    public int getRpsFormaPagamento() {
        return this.rpsFormaPagamento;
    }

    public void setRpsFormaPagamento(int rpsFormaPagamento) {
        this.rpsFormaPagamento = rpsFormaPagamento;
    }

    @Column(name = "rps_desconto", precision = 10)
    public double getRpsDesconto() {
        return this.rpsDesconto;
    }

    public void setRpsDesconto(double rpsDesconto) {
        this.rpsDesconto = rpsDesconto;
    }

}
