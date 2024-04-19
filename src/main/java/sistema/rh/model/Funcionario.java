package sistema.rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "funcionario")
@Entity
public class Funcionario {

	@Id
	@Column
	private String cepf;
	
	@Column
	private String cpf;
	
	@Column
	private String nomeFuncionario;
	
	@Column
	private String cargo;
	
	@Column
	private String nivel;
	
	@Column
	private int ddd;
	
	@Column(name = "telCel", length = 9 , nullable = false)
	private String telCel;
	
	@Column
	private String endereco;

	@Column
	private int nCasa;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
}
