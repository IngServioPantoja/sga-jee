package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametro_persona database table.
 * 
 */
@Entity
@Table(name="parametro_persona")
@NamedQuery(name="ParametroPersona.findAll", query="SELECT p FROM ParametroPersona p")
public class ParametroPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_parametro_persona", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=1)
	private String activo;

	@Column(nullable=false, length=200)
	private String descripcion;

	@Column(nullable=false, length=1)
	private String editable;

	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_parametro_persona", nullable=false)
	private TipoParametroPersona tipoParametroPersona;

	public ParametroPersona() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEditable() {
		return this.editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public TipoParametroPersona getTipoParametroPersona() {
		return this.tipoParametroPersona;
	}

	public void setTipoParametroPersona(TipoParametroPersona tipoParametroPersona) {
		this.tipoParametroPersona = tipoParametroPersona;
	}

}