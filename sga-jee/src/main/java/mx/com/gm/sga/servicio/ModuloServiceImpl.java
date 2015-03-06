package mx.com.gm.sga.servicio;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mx.com.gm.sga.domain.Modulo;
import mx.com.gm.sga.eis.ModuloDao;

@Stateless
public class ModuloServiceImpl implements Serializable, ModuloService {

	private static final long serialVersionUID = 6400612977269447353L;

	@EJB
	private ModuloDao moduloDao;
	
	public List<Modulo> findAll() {
		return moduloDao.findAll();
	}

	public Modulo findById(Modulo modulo) {
		return moduloDao.findById(modulo);
	}
	
	public List<Modulo> findByPadre(Modulo modulo) {
		return moduloDao.findByPadre(modulo);
	}

	public void persist(Modulo modulo) {
		moduloDao.persist(modulo);
	}

	public void merge(Modulo modulo) {
		moduloDao.merge(modulo);
	}

	public void delete(Modulo modulo) {
		moduloDao.delete(modulo);
	}

}
