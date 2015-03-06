package mx.com.gm.sga.eis;

import java.sql.SQLException;
import java.util.List;

import mx.com.gm.sga.domain.ModuloOpcion;
import mx.com.gm.sga.domain.Rol;

public interface ModuloOpcionDao{

	public List<ModuloOpcion> findAll()throws SQLException;

	public ModuloOpcion findById(ModuloOpcion moduloOpcion)throws SQLException;

	public List<ModuloOpcion> findByRol(Rol rol)throws SQLException;

	public void persist(ModuloOpcion moduloOpcion)throws SQLException;

	public void merge(ModuloOpcion moduloOpcion)throws SQLException;

	public void delete(ModuloOpcion moduloOpcion)throws SQLException;
}
