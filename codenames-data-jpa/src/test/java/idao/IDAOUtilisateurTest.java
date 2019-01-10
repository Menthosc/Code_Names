package idao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import codenames.model.Utilisateur;
import configuration.JpaConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaConfig.class })
public class IDAOUtilisateurTest {

	// Rédiger un test pour vérifier qu’un bean « IDAOUtilisateur » existe bien
	@Autowired(required = false)
	private IDAOUtilisateur daoUtilisateur;

	@Before
	public void afficherMessageDebut() {
		System.out.println("-----------------");
		System.out.println("DEMARRAGE DU TEST");
		System.out.println();
	}

	@Test
	public void exists() {
		assertNotNull("la DAO n'existe pas", daoUtilisateur);
	}

	@Test
	public void findById() {
		Optional<Utilisateur> myOptionalUtilisateur = daoUtilisateur.findById(3);
		assertTrue("l'utilisateur n'a pas été trouvé", myOptionalUtilisateur.isPresent());
		assertNotNull("l'utilisateur est nul", myOptionalUtilisateur.get());
		assertNotNull("Infos non remontées", myOptionalUtilisateur.get().getNom());
	}

	@After
	public void afficherMessageFin() {

		System.out.println();
		System.out.println("FIN DU TEST");
		System.out.println("-----------------");
	}

}
