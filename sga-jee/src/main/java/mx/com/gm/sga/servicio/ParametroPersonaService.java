package mx.com.gm.sga.servicio;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import mx.com.gm.sga.domain.Modulo;

@Local
public interface ParametroPersonaService extends Serializable {
	
	public List<Modulo> findAll();
	
	public Modulo findById(Modulo modulo);
	
	public List<Modulo> findByPadre(Modulo modulo);

	public void persist(Modulo modulo);

	public void merge(Modulo modulo);

	public void delete(Modulo modulo);
}
