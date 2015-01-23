package mx.com.gm.sga.servicio;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.jws.WebService;

import java.util.Map;
 





import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import beans.SimpleCallbackHandler;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.eis.PersonaDao;

@Stateless
@WebService(endpointInterface="mx.com.gm.sga.servicio.PersonaServiceWS")
@DeclareRoles({ "ROLE_ADMIN", "ROLE_USER","ROLE_GUEST" }) 
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService, PersonaServiceWS, Serializable{
	
	private static final long serialVersionUID = 7143324113539318787L;

	@Resource
	private SessionContext contexto;
	
	@Resource
    WebServiceContext wsctx;
	
	@EJB
	private PersonaDao personaDao;


	public List<Persona> listarPersonas() {
		
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
//	        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
//	        List userList = (List) http_headers.get("Username");
//	        List passList = (List) http_headers.get("Password");
//	 
//	        String username = "";
//	        String password = "";
//	 
//	        if(userList!=null){
//	        	//get username
//	        	username = userList.get(0).toString();
//	        }
//	 
//	        if(passList!=null){
//	        	//get password
//	        	password = passList.get(0).toString();
//	        }
//	        
//	        try {
//				LoginContext lc = new LoginContext("Sample",new SimpleCallbackHandler("joseph","admin"));
//				lc.login();
//			} catch (LoginException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//	        
//	        FacesContext context = FacesContext.getCurrentInstance();
//	        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
//			try {
//				request.login(username, password);
//			} catch (ServletException e) {
//				return null;
//			}
//		 
	        
	        
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
		return new ArrayList<Persona>();

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
