package Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "article")
@SequenceGenerator(name="seqFilm", sequenceName = "seq_film", allocationSize = 1, initialValue =1)
public class Film {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqFilm")
	private Integer id_film;
	@Column(name = "titre_film", length =150,nullable=false)
	private String titre;
	@Column(name = "date_sortie", nullable=true)
	private Date dateSortie;
	@Transient
	private List<Article> articles;
	@Transient
	private Realisateur realisateur;
	
	
	
	// Constructeurs
	public Film() {
		super();
	}

	public Film(String titre) {
		super();
		this.titre = titre;
	}

	public Integer getId_film() {
		return id_film;
	}

	public void setId_film(Integer id_film) {
		this.id_film = id_film;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	
	public void addArticle(Article article) {
		articles.add(article);
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Realisateur getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_film == null) ? 0 : id_film.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		Film other = (Film) obj;
		if (id_film == null) {
			if (other.id_film != null)
				return false;
		} else if (!id_film.equals(other.id_film))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
	

}
