package mx.com.gm.sga.servicio;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.utils.Account;

@Local
public interface PersonaService {

	public List<Persona> listarPersonas();
	
	public List<Persona> listarPersonasWS(Account cuenta);

	public boolean encontrarCedula(String cedula) throws SQLException;
	
	public Persona encontrarPersonaPorId(Persona persona);
	
	public Persona econtrarPersonaPorEmail(Persona persona);

	public void registrarPersona(Persona persona);

	public void modificarPersona(Persona persona);

	public void eliminarPersona(Persona persona)throws SQLException;
}
