package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Grupo;

@Local
public interface GrupoService {

	public List<Grupo> listarGrupos();
	
	public Grupo encontrarGrupoPorId(Grupo grupo);

	public void registrarGrupo(Grupo grupo);

	public void modificarGrupo(Grupo grupo);

	public void eliminarGrupo(Grupo grupo);
}
