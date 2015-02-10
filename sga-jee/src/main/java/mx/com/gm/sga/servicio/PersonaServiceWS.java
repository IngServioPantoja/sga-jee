package mx.com.gm.sga.servicio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import mx.com.gm.sga.domain.Persona;

@WebService
public interface PersonaServiceWS {

	@WebMethod
	public List<Persona> listarPersonas();
	
	@WebMethod
	public List<Persona> listarPersonasWS();
	
	@WebMethod
	public void registrarPersona(Persona persona);
	
	@WebMethod
	public void eliminarPersona(Persona persona);
}
