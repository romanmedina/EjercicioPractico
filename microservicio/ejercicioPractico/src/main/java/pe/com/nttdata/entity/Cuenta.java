package pe.com.nttdata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cuenta")
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCuenta;
	@Column(name = "numero_cuenta", nullable = false, length = 30)
	private String numeroCuenta;
	@Column(name = "tipo_cuenta", nullable = false, length = 30)
	private String tipoCuenta;
	@Column(name="saldo_inicial", nullable = false)
	private Double saldoInicial;
	@Column(name="estado", nullable = false)
	private Boolean estado;
	@ManyToOne
	@JoinColumn(name = "idCliente", nullable = false, foreignKey = @ForeignKey (name = "fk_cliente_cuenta"))
	private Cliente cliente;

}
