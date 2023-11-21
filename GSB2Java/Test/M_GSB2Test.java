import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modele.M_GSB2;

class M_GSB2Test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConnectionUtilisateur() {
		Assert.assertTrue("Pas connecter",M_GSB2.ConnectionUtilisateur("Test01","Test01"));
	}
	
	@Test
	void testgetEmploiUtilisateurr() {
		Assert.assertEquals("Pas connecter","Secrétaire",M_GSB2.getEmploiUtilisateur("Test01","Test01"));
	}
	@Test
	void testgetEmploiUtilisateurr02() {
		Assert.assertEquals("Pas connecter","Responsable",M_GSB2.getEmploiUtilisateur("Test01","Test01"));
	}


}
