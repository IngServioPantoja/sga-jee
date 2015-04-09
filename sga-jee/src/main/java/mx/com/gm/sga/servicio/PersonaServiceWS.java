package mx.com.gm.sga.servicio;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.utils.Account;

@WebService
public interface PersonaServiceWS {

	@WebMethod
	public List<Persona> listarPersonas();
	
	@WebMethod
	public List<Persona> listarPersonasWS(Account cuenta);
	
	@WebMethod
	public void registrarPersona(Persona persona);
	
	@WebMethod
	public void eliminarPersona(Persona persona);
}
