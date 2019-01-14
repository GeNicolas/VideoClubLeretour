package Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="association_realisateur_film")
public class AssocationRealisateurFilm {
	
	@EmbeddedId
	private AssociationRealisateurFilmPk associationRealisateurFilmPk;
	@Column(name="popularite",length=30)
	private String popularite;
	
	// Constructeurs
	
	public AssocationRealisateurFilm() {
		super();
	}

	public AssocationRealisateurFilm(AssociationRealisateurFilmPk associationRealisateurFilmPk, String popularite) {
		super();
		this.associationRealisateurFilmPk = associationRealisateurFilmPk;
		this.popularite = popularite;
	}
	
	// méthodes

	public AssociationRealisateurFilmPk getAssociationRealisateurFilmPk() {
		return associationRealisateurFilmPk;
	}

	public void setAssociationRealisateurFilmPk(AssociationRealisateurFilmPk associationRealisateurFilmPk) {
		this.associationRealisateurFilmPk = associationRealisateurFilmPk;
	}

	public String getPopularite() {
		return popularite;
	}

	public void setPopularite(String popularite) {
		this.popularite = popularite;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((associationRealisateurFilmPk == null) ? 0 : associationRealisateurFilmPk.hashCode());
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
		AssocationRealisateurFilm other = (AssocationRealisateurFilm) obj;
		if (associationRealisateurFilmPk == null) {
			if (other.associationRealisateurFilmPk != null)
				return false;
		} else if (!associationRealisateurFilmPk.equals(other.associationRealisateurFilmPk))
			return false;
		return true;
	}
	
	
	
	
	

}
