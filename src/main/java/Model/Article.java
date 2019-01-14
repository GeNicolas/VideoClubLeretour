package Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "article")
@SequenceGenerator(name="seqArticle", sequenceName = "seq_article", allocationSize = 1, initialValue =1)
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", length=1)
public abstract class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqArticle")
	private Integer noArticle;
	@Column(name = "nb_disques", nullable=true)
	private Integer nbDisques;
	@ManyToOne
	@JoinColumn(name="adherent_id")
	private Adherent emprunteur;
	@ManyToOne
	@JoinColumn(name="film_id")
	private Film film;
	
	
	// Constructeurs
	
	public Article() {
		super();
	}

	public Article(Integer nbDisques) {
		super();
		
		this.nbDisques = nbDisques;
	}

	// Méthodes
	
	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public Integer getNbDisques() {
		return nbDisques;
	}

	public void setNbDisques(Integer nbDisques) {
		this.nbDisques = nbDisques;
	}

	public Adherent getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Adherent emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noArticle == null) ? 0 : noArticle.hashCode());
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
		Article other = (Article) obj;
		if (noArticle == null) {
			if (other.noArticle != null)
				return false;
		} else if (!noArticle.equals(other.noArticle))
			return false;
		return true;
	}
		

}
