package mx.com.gm.sga.eis;

import java.util.List;

import mx.com.gm.sga.domain.Rol;

public interface RolDao{

	public List<Rol> findAll();

	public Rol findRolById(Rol rol);

	public void insertRol(Rol rol);

	public void updateRol(Rol rol);

	public void deleteRol(Rol rol);
}
