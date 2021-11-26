package models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name = " modelo", nullable = false, length = 60)
    private String nome;
    private String marca;
    @Temporal(TemporalType.DATE)
    @Column(name = "ano_fabricacao")
    private Date anoFabricacao;

    public Veiculo() {
    }

    public Veiculo(Integer id, String nome, String marca, Date anoFabricacao) {
        super();
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Date anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculo)) return false;
        Veiculo veiculo = (Veiculo) o;
        return getId().equals(veiculo.getId()) && getNome().equals(veiculo.getNome()) && getMarca().equals(veiculo.getMarca()) && getAnoFabricacao().equals(veiculo.getAnoFabricacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getMarca(), getAnoFabricacao());
    }
}
