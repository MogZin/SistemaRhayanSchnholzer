package bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "rps_produtos",
        catalog = "db_rhayan_schonholzer"
)
public class RpsProdutos implements java.io.Serializable {

    private int rpsIdJogo;
    private String rpsNome;
    private int rpsGenero;
    private int rpsPlataforma;
    private Date rpsAnoLancamento;
    private int rpsQuantEstoque;
    private double rpsValor;

    public RpsProdutos() {
    }

    public RpsProdutos(String rpsNome, Date rpsAnoLancamento) {
        this.rpsNome = rpsNome;
        this.rpsAnoLancamento = rpsAnoLancamento;
    }

    public RpsProdutos(String rpsNome, int rpsGenero, int rpsPlataforma, Date rpsAnoLancamento, int rpsQuantEstoque, double rpsValor) {
        this.rpsNome = rpsNome;
        this.rpsGenero = rpsGenero;
        this.rpsPlataforma = rpsPlataforma;
        this.rpsAnoLancamento = rpsAnoLancamento;
        this.rpsQuantEstoque = rpsQuantEstoque;
        this.rpsValor = rpsValor;
    }

    @Id

    @Column(name = "rps_id_jogo", unique = true, nullable = false)
    public int getRpsIdJogo() {
        return this.rpsIdJogo;
    }

    public void setRpsIdJogo(int rpsIdJogo) {
        this.rpsIdJogo = rpsIdJogo;
    }

    @Column(name = "rps_nome", nullable = false, length = 100)
    public String getRpsNome() {
        return this.rpsNome;
    }

    public void setRpsNome(String rpsNome) {
        this.rpsNome = rpsNome;
    }

    @Column(name = "rps_genero")
    public int getRpsGenero() {
        return this.rpsGenero;
    }

    public void setRpsGenero(int rpsGenero) {
        this.rpsGenero = rpsGenero;
    }

    @Column(name = "rps_plataforma")
    public int getRpsPlataforma() {
        return this.rpsPlataforma;
    }

    public void setRpsPlataforma(int rpsPlataforma) {
        this.rpsPlataforma = rpsPlataforma;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "rps_ano_lancamento", nullable = false, length = 10)
    public Date getRpsAnoLancamento() {
        return this.rpsAnoLancamento;
    }

    public void setRpsAnoLancamento(Date rpsAnoLancamento) {
        this.rpsAnoLancamento = rpsAnoLancamento;
    }

    @Column(name = "rps_quant_estoque")
    public int getRpsQuantEstoque() {
        return this.rpsQuantEstoque;
    }

    public void setRpsQuantEstoque(int rpsQuantEstoque) {
        this.rpsQuantEstoque = rpsQuantEstoque;
    }

    @Column(name = "rps_valor", precision = 10)
    public double getRpsValor() {
        return this.rpsValor;
    }

    public void setRpsValor(double rpsValor) {
        this.rpsValor = rpsValor;
    }

    @Override
    public String toString() {
        return this.rpsIdJogo + " - " + this.rpsNome;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof RpsProdutos) {
            RpsProdutos rpsProdutos = (RpsProdutos) object;
            if (rpsProdutos.getRpsIdJogo() == this.getRpsIdJogo()) {
                return true;
            }
        }
        return false;
    }
}
