package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioService;

import org.junit.Before;
import org.junit.Test;

public class UsuarioServiceTest {

	private UsuarioService usuarioService;

	@Before
	public void setUp() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		usuarioService = (UsuarioService) contenedor.getContext().lookup("java:global/classes/UsuarioServiceImpl!mx.com.gm.sga.servicio.UsuarioService");
	}

	@Test
	public void testEJBUsuarioService() {
		System.out.println("Iniciando test EJB UsuarioService");
		
		assertTrue(usuarioService != null);
		
		//assertEquals(3, usuarioService.listarUsuarios().size());
		try {
			System.out.println("El no. de usuarios es igual a:" + usuarioService.listarUsuarios().size());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			this.desplegarUsuarios(usuarioService.listarUsuarios());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fin test EJB UsuarioService");
	}
	
	private void desplegarUsuarios(List<Usuario> usuarios){
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}
}
