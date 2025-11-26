package bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "rps_clientes",
        catalog = "db_rhayan_schonholzer",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "rps_cpf")
            , @UniqueConstraint(columnNames = "rps_email")}
)
public class RpsClientes implements java.io.Serializable {

    private int rpsIdclientes;
    private String rpsNome;
    private String rpsCpf;
    private String rpsTelefone;
    private Date rpsDataNascimento;
    private String rpsBairro;
    private String rpsCidade;
    private String rpsCep;
    private String rpsSenha;
    private String rpsEmail;
    private Date rpsDataCadastro;
    private int rpsGenero;
    private int rpsTipoCliente;
    private double rpsSaldoConta;
    private int rpsEstado;
    private String rpsAtivo;

    public RpsClientes() {
    }

    public RpsClientes(String rpsNome, String rpsCpf, Date rpsDataNascimento, String rpsSenha, String rpsEmail, Date rpsDataCadastro) {
        this.rpsNome = rpsNome;
        this.rpsCpf = rpsCpf;
        this.rpsDataNascimento = rpsDataNascimento;
        this.rpsSenha = rpsSenha;
        this.rpsEmail = rpsEmail;
        this.rpsDataCadastro = rpsDataCadastro;
    }

    public RpsClientes(String rpsNome, String rpsCpf, String rpsTelefone, Date rpsDataNascimento, String rpsBairro, String rpsCidade, String rpsCep, String rpsSenha, String rpsEmail, Date rpsDataCadastro, int rpsGenero, int rpsTipoCliente, double rpsSaldoConta, int rpsEstado, String rpsAtivo) {
        this.rpsNome = rpsNome;
        this.rpsCpf = rpsCpf;
        this.rpsTelefone = rpsTelefone;
        this.rpsDataNascimento = rpsDataNascimento;
        this.rpsBairro = rpsBairro;
        this.rpsCidade = rpsCidade;
        this.rpsCep = rpsCep;
        this.rpsSenha = rpsSenha;
        this.rpsEmail = rpsEmail;
        this.rpsDataCadastro = rpsDataCadastro;
        this.rpsGenero = rpsGenero;
        this.rpsTipoCliente = rpsTipoCliente;
        this.rpsSaldoConta = rpsSaldoConta;
        this.rpsEstado = rpsEstado;
        this.rpsAtivo = rpsAtivo;
    }

    @Id

    @Column(name = "rps_idclientes", unique = true, nullable = false)
    public int getRpsIdclientes() {
        return this.rpsIdclientes;
    }

    public void setRpsIdclientes(int rpsIdclientes) {
        this.rpsIdclientes = rpsIdclientes;
    }

    @Column(name = "rps_nome", nullable = false, length = 100)
    public String getRpsNome() {
        return this.rpsNome;
    }

    public void setRpsNome(String rpsNome) {
        this.rpsNome = rpsNome;
    }

    @Column(name = "rps_cpf", unique = true, nullable = false, length = 14)
    public String getRpsCpf() {
        return this.rpsCpf;
    }

    public void setRpsCpf(String rpsCpf) {
        this.rpsCpf = rpsCpf;
    }

    @Column(name = "rps_telefone", length = 20)
    public String getRpsTelefone() {
        return this.rpsTelefone;
    }

    public void setRpsTelefone(String rpsTelefone) {
        this.rpsTelefone = rpsTelefone;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "rps_data_nascimento", nullable = false, length = 10)
    public Date getRpsDataNascimento() {
        return this.rpsDataNascimento;
    }

    public void setRpsDataNascimento(Date rpsDataNascimento) {
        this.rpsDataNascimento = rpsDataNascimento;
    }

    @Column(name = "rps_bairro", length = 100)
    public String getRpsBairro() {
        return this.rpsBairro;
    }

    public void setRpsBairro(String rpsBairro) {
        this.rpsBairro = rpsBairro;
    }

    @Column(name = "rps_cidade", length = 100)
    public String getRpsCidade() {
        return this.rpsCidade;
    }

    public void setRpsCidade(String rpsCidade) {
        this.rpsCidade = rpsCidade;
    }

    @Column(name = "rps_cep", length = 10)
    public String getRpsCep() {
        return this.rpsCep;
    }

    public void setRpsCep(String rpsCep) {
        this.rpsCep = rpsCep;
    }

    @Column(name = "rps_senha", nullable = false)
    public String getRpsSenha() {
        return this.rpsSenha;
    }

    public void setRpsSenha(String rpsSenha) {
        this.rpsSenha = rpsSenha;
    }

    @Column(name = "rps_email", unique = true, nullable = false, length = 100)
    public String getRpsEmail() {
        return this.rpsEmail;
    }

    public void setRpsEmail(String rpsEmail) {
        this.rpsEmail = rpsEmail;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "rps_data_cadastro", nullable = false, length = 10)
    public Date getRpsDataCadastro() {
        return this.rpsDataCadastro;
    }

    public void setRpsDataCadastro(Date rpsDataCadastro) {
        this.rpsDataCadastro = rpsDataCadastro;
    }

    @Column(name = "rps_genero")
    public int getRpsGenero() {
        return this.rpsGenero;
    }

    public void setRpsGenero(int rpsGenero) {
        this.rpsGenero = rpsGenero;
    }

    @Column(name = "rps_tipo_cliente")
    public int getRpsTipoCliente() {
        return this.rpsTipoCliente;
    }

    public void setRpsTipoCliente(int rpsTipoCliente) {
        this.rpsTipoCliente = rpsTipoCliente;
    }

    @Column(name = "rps_saldo_conta", precision = 10)
    public double getRpsSaldoConta() {
        return this.rpsSaldoConta;
    }

    public void setRpsSaldoConta(double rpsSaldoConta) {
        this.rpsSaldoConta = rpsSaldoConta;
    }

    @Column(name = "rps_estado")
    public int getRpsEstado() {
        return this.rpsEstado;
    }

    public void setRpsEstado(int rpsEstado) {
        this.rpsEstado = rpsEstado;
    }

    @Column(name = "rps_ativo", length = 1)
    public String getRpsAtivo() {
        return this.rpsAtivo;
    }

    public void setRpsAtivo(String rpsAtivo) {
        this.rpsAtivo = rpsAtivo;
    }

    @Override
    public String toString() {
        return this.rpsIdclientes + " - " + this.rpsNome;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof RpsClientes) {
            RpsClientes rpsClientes = (RpsClientes) object;
            if (rpsClientes.getRpsIdclientes() == this.getRpsIdclientes()) {
                return true;
            }
        }
        return false;
    }
}
