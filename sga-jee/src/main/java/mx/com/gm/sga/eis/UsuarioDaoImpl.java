package mx.com.gm.sga.eis;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.com.gm.sga.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao, Serializable {


	private static final long serialVersionUID = -3367343963076410688L;

	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuarios() {  
		List<Usuario> lstUsuarios = em.createNamedQuery("Usuario.findAll").getResultList();  
		for (int i = 0; i < lstUsuarios.size(); i++) {
			
			if(lstUsuarios.get(i).getPersona()!=null){
				System.out.println(lstUsuarios.get(i).getPersona().getNombre()+lstUsuarios.get(i).getPersona().getApeMaterno());
			}
		}
		return lstUsuarios;
	}

	public Usuario findUsuarioById(Usuario usuario) {
		return em.find(Usuario.class, usuario.getIdUsuario());
	}

	public void insertUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	public void updateUsuario(Usuario usuario) {
		em.merge( usuario );
	}

	public void deleteUsuario(Usuario usuario) {
		em.merge(usuario);
		em.remove( usuario );
	}

}
