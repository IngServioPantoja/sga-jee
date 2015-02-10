package mx.com.gm.sga.servicio;

import java.io.Serializable;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.jws.WebService;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.sun.enterprise.security.auth.login.common.LoginException;

import beans.SimpleCallbackHandler;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.eis.PersonaDao;
import mx.com.gm.sga.eis.UsuarioDao;

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
//		Usuario usuario = new Usuario();
//		try {
//			usuario = usuarioDao.iniciarSesion("joseph","admin");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	        
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
	
	public List<Persona> listarPersonasWS() {
		
		MessageContext mctx = wsctx.getMessageContext();
		
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");
 
        String username = "";
        String password = "";
        
        if(userList!=null && passList!=null){
        	username = userList.get(0).toString();
        	password = passList.get(0).toString();
        }
	    Usuario usuario = new Usuario();
	    try {
			usuario = usuarioDao.iniciarSesion(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(usuario.getIdUsuario()!=null){
        	List<Persona> personas = personaDao.findAllPersonas();
        	return personas;
        }else{
			return null;
        }

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
