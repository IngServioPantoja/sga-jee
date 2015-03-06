package test;

import static org.junit.Assert.*;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import mx.com.gm.sga.domain.Grupo;
import mx.com.gm.sga.servicio.GrupoService;
import org.junit.Before;
import org.junit.Test;

public class GrupoServiceTest {

	private GrupoService grupoService;

	@Before
	public void setUp() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		grupoService = (GrupoService) contenedor.getContext().lookup("java:global/classes/GrupoServiceImpl!mx.com.gm.sga.servicio.GrupoService");
	}

	@Test
	public void testEJBGrupoService() {
		System.out.println("Iniciando test EJB GrupoService");
		
		assertTrue(grupoService != null);
		
		//assertEquals(3, grupoService.listarGrupos().size());
		System.out.println("El no. de grupos es igual a:" + grupoService.listarGrupos().size());
		
		this.desplegarGrupos(grupoService.listarGrupos());
		
		System.out.println("Fin test EJB GrupoService");
	}
	
	private void desplegarGrupos(List<Grupo> grupos){
		for (Grupo grupo : grupos) {
			System.out.println(grupo);
		}
	}
}
