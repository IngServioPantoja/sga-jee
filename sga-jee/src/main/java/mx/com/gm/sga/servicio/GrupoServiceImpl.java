package mx.com.gm.sga.servicio;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mx.com.gm.sga.domain.Grupo;
import mx.com.gm.sga.eis.GrupoDao;

@Stateless
public class GrupoServiceImpl implements GrupoService, Serializable {

	private static final long serialVersionUID = 8638893934358266592L;

	@EJB
	private GrupoDao grupoDao;

	public List<Grupo> listarGrupos() {
		return grupoDao.findAll();
	}

	public Grupo encontrarGrupoPorId(Grupo grupo) {
		return grupoDao.findGrupoById(grupo);
	}

	public void registrarGrupo(Grupo grupo) {
		grupoDao.insertGrupo(grupo);
	}

	public void modificarGrupo(Grupo grupo) {
		grupoDao.updateGrupo(grupo);
	}

	public void eliminarGrupo(Grupo grupo) {
		grupoDao.deleteGrupo(grupo);
	}

}
