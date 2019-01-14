package Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "realisateur")
@SequenceGenerator(name="seqRealisateur", sequenceName = "seq_realisateur", allocationSize = 1, initialValue =1)
public class Realisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqRealisateur")
	private Integer idRealisateur;
	@Column(name = "prenom_realisateur", nullable=false)
	private String prenom;
	@Column(name = "nom_realisateur", nullable=false)
	private String nom;
	
	@OneToMany(mappedBy="associationRealisateurFilmPk.realisateur")
	private Set<AssocationRealisateurFilm> associationRealisateurFilmPk;
	
	// Constructeurs
	
	public Realisateur() {
		super();
	}

	public Realisateur(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

	public Integer getIdRealisateur() {
		return idRealisateur;
	}

	public void setIdRealisateur(Integer idRealisateur) {
		this.idRealisateur = idRealisateur;
	}


	public Set<AssocationRealisateurFilm> getAssociationRealisateurFilmPk() {
		return associationRealisateurFilmPk;
	}

	public void setAssociationRealisateurFilmPk(Set<AssocationRealisateurFilm> associationRealisateurFilmPk) {
		this.associationRealisateurFilmPk = associationRealisateurFilmPk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRealisateur == null) ? 0 : idRealisateur.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Realisateur other = (Realisateur) obj;
		if (idRealisateur == null) {
			if (other.idRealisateur != null)
				return false;
		} else if (!idRealisateur.equals(other.idRealisateur))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

}
