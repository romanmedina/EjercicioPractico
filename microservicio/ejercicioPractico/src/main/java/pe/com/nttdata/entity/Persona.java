package pe.com.nttdata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	@Column(name = "genero", nullable = false, length = 30)
	private String genero;
	@Column(name = "edad", nullable = false, length = 30)
	private Integer edad;
	@Column(name = "identificacion", nullable = false, length = 30)
	private Integer identificacion;
	@Column(name = "direccion", nullable = false, length = 30)
	private String direccion;
	@Column(name = "telefono", nullable = false, length = 30)
	private String telefono;
	
}
