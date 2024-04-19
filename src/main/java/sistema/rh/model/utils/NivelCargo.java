package sistema.rh.model.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "nivelCargo")
public class NivelCargo {

	@Id
	private String codNivelCargo;
	
	@Column
	private String nivelCargo;
}
