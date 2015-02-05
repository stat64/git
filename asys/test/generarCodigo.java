import models.Usuario;
import models.UsuarioProfesor;

import org.junit.Test;

import play.test.UnitTest;

public class generarCodigo extends UnitTest {

	@Test
	public void generacionCodigo() throws Throwable {

		Usuario usuario = Usuario.connect("alex", "alex");
		
		assertNotNull(usuario);
		
		//verifico si el usuario es estudiante		
		assertTrue("Es estudiante???:",usuario.esEstudiante());

		/*
		 * si es estudiante
		 * usuario.generarCodigo();
		 * dentro del generar codigo necesitarè otros metodos
		 */


	}
}
