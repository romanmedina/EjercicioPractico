package pe.com.nttdata.entity;

import java.time.LocalDateTime;
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
@Table(name = "movimientos")
public class Movimientos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMovimiento;
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	@Column(name = "tipo_movimiento", nullable = false, length = 30)
	private String tipoMovimiento;
	@Column(name = "valor", nullable = false)
	private Double valor;
	@Column(name = "saldo", nullable = false)
	private Double saldo;
	@ManyToOne
	@JoinColumn(name = "idCuenta", nullable = false, foreignKey = @ForeignKey(name = "fk_movimiento_cuenta"))
	private Cuenta cuenta;

}
