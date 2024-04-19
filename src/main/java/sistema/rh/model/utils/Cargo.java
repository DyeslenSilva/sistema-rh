package sistema.rh.model.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cargo")
public class Cargo {

	@Id
	private int codCargo;
	
	@Column(name = "nomeCargo")
	private String nomeCargo;
	
}
