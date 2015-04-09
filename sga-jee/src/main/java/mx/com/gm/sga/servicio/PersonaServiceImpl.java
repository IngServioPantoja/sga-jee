package mx.com.gm.sga.servicio;

import java.io.Serializable;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.eis.PersonaDao;
import mx.com.gm.sga.eis.UsuarioDao;
import mx.com.gm.sga.utils.Account;

@Stateless
@WebService(endpointInterface="mx.com.gm.sga.servicio.PersonaServiceWS")
@DeclareRoles({ "ROLE_ADMIN", "ROLE_USER","ROLE_GUEST","ANONYMOUS" }) 
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService, PersonaServiceWS, Serializable{
	
	private static final long serialVersionUID = 7143324113539318787L;

	@Resource
	private SessionContext contexto;
	
	@Resource
    WebServiceContext wsctx;
	
	@EJB
	private PersonaDao personaDao;
	
	@EJB
	private UsuarioDao usuarioDao;

	@RolesAllowed("ROLE_ADMIN")
	public List<Persona> listarPersonas() {
    
    Principal principal = contexto.getCallerPrincipal();
	System.out.println(principal.getName());
	if(contexto.isCallerInRole("ROLE_ADMIN")){
		System.out.println("ROL DE ADMIN");
		List<Persona> personas = personaDao.findAllPersonas();
		return personas;
	}else{

			try {
				throw new SecurityException("No cuenta con permisos para ejecutar este metodo");
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}
	return null;

	}
	
	public List<Persona> listarPersonasWS(Account cuenta) {
		
	    Usuario usuario = new Usuario();
	    try {
			usuario = usuarioDao.iniciarSesion(cuenta.getUsername(),cuenta.getPassword());
		} catch (SQLException e) {

			e.printStackTrace();
		}
        if(usuario.getIdUsuario()!=null){
        	List<Persona> personas = personaDao.findAllPersonas();
        	return personas;
        }else{
			return null;
        }

	}
	
	public boolean encontrarCedula(String cedula)throws SQLException{
		return personaDao.encontrarCedula(cedula);
	}

	public Persona encontrarPersonaPorId(Persona persona) {
		return personaDao.findPersonaById(persona);
	}

	public Persona econtrarPersonaPorEmail(Persona persona) {
		return personaDao.findPersonaByEmail(persona);
	}

	public void registrarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

	public void modificarPersona(Persona persona) {
		try{
			personaDao.updatePersona(persona);
		}catch(Throwable t){
			contexto.setRollbackOnly();
		}	
	}
	
	@RolesAllowed("ROLE_ADMIN")
	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}

}
