package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "realisateur")
@SequenceGenerator(name="seqRealisateur", sequenceName = "seq_realisateur", allocationSize = 1, initialValue =1)
public class Realisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqRealisateur")
	private Integer id_realisateur;
	@Column(name = "prenom_realisateur", nullable=false)
	private String prenom;
	@Column(name = "nom_realisateur", nullable=false)
	private String nom;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_realisateur == null) ? 0 : id_realisateur.hashCode());
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
		if (id_realisateur == null) {
			if (other.id_realisateur != null)
				return false;
		} else if (!id_realisateur.equals(other.id_realisateur))
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
