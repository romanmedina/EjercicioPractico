package pe.com.nttdata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_cliente_persona"))
public class Cliente extends Persona{

	@Column(name = "contrasena", nullable = false, length = 30)
	private String contrasena;
	@Column(name = "estado", nullable = false)
	private Boolean estado;
	
//	public Cliente (Integer id, String nombre, String genero, Integer edad, Integer identificacion, 
//			String direccion, Integer telefono, String contrasena, Boolean estado) {
//		super(id,nombre,genero,edad,identificacion,direccion,telefono);
//		this.contrasena = contrasena;
//		this.estado = estado;
//	}
//
//	public Cliente() {
//		// TODO Auto-generated constructor stub
//	}
//	
}
