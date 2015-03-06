package mx.com.gm.sga.eis;

import java.io.Serializable;
import java.util.List;

import mx.com.gm.sga.domain.Modulo;

public interface ModuloDao extends Serializable {
	
	public List<Modulo> findAll();

	public Modulo findById(Modulo modulo);

	public List<Modulo> findByPadre(Modulo modulo);

	public void persist(Modulo modulo);

	public void merge(Modulo modulo);

	public void delete(Modulo modulo);
}
