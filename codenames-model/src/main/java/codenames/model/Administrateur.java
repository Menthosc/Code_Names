package codenames.model;

import javax.persistence.*;

@Entity
@Table(name = "administrateur")
@PrimaryKeyJoinColumn(name = "ADM_ID", referencedColumnName = "UTI_ID")
public class Administrateur extends Utilisateur {

	
	
	
}
