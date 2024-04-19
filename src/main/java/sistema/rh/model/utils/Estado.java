package sistema.rh.model.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estados")
public class Estado {

	@Id
	@Column(name = "sigla")
	private String sigla;
	
	@Column(name = "nomeEstado")
	private String nomeEstado;
}
