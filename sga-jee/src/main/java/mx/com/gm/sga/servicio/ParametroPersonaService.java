package mx.com.gm.sga.servicio;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import mx.com.gm.sga.domain.ParametroPersona;

@Local
public interface ParametroPersonaService extends Serializable {
	
	public List<ParametroPersona> findAll()throws SQLException;
	
	public ParametroPersona findById(ParametroPersona parametroPersona)throws SQLException;
	
	public List<ParametroPersona> findByTipo(Long idTipo)throws SQLException;
	
	public void persist(ParametroPersona parametroPersona)throws SQLException;

	public void merge(ParametroPersona parametroPersona)throws SQLException;

	public void delete(ParametroPersona parametroPersona)throws SQLException;
}
