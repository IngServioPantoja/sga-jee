package mx.com.gm.sga.eis;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import mx.com.gm.sga.domain.TipoParametroPersona;


public interface TipoParametroPersonaDao extends Serializable {

	public List<TipoParametroPersona> findAll()throws SQLException;

	public TipoParametroPersona findById(TipoParametroPersona tipoParametroPersona)throws SQLException;

	public void persist(TipoParametroPersona tipoParametroPersona)throws SQLException;

	public void merge(TipoParametroPersona tipoParametroPersona)throws SQLException;

	public void delete(TipoParametroPersona tipoParametroPersona)throws SQLException;
	
}
