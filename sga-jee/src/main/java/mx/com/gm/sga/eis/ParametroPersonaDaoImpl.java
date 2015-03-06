package mx.com.gm.sga.eis;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.ParametroPersona;

public class ParametroPersonaDaoImpl implements ParametroPersonaDao,
		Serializable {

	private static final long serialVersionUID = -438777477023653218L;
	
	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<ParametroPersona> findAll()throws SQLException {
		List<ParametroPersona> lstParametrosPersona = em.createNamedQuery("ParametroPersona.findAll").getResultList();  
		return lstParametrosPersona;
	}

	public ParametroPersona findById(
			ParametroPersona parametroPersona)throws SQLException {
		return em.find(ParametroPersona.class, parametroPersona.getId());
	}

	public void persist(ParametroPersona parametroPersona)throws SQLException {
		em.persist(parametroPersona);
	}

	public void merge(ParametroPersona parametroPersona)throws SQLException {
		em.merge(parametroPersona);
	}

	public void delete(ParametroPersona parametroPersona)throws SQLException {
		em.merge(parametroPersona);
		em.remove(parametroPersona);
	}
}
