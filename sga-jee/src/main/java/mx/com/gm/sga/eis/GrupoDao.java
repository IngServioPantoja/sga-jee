package mx.com.gm.sga.eis;

import java.util.List;

import mx.com.gm.sga.domain.Grupo;

public interface GrupoDao{

	public List<Grupo> findAll();

	public Grupo findGrupoById(Grupo grupo);

	public void insertGrupo(Grupo grupo);

	public void updateGrupo(Grupo grupo);

	public void deleteGrupo(Grupo grupo);
}
