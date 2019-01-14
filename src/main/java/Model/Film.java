package Model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "film")
@SequenceGenerator(name="seqFilm", sequenceName = "seq_film", allocationSize = 1, initialValue =1)
public class Film {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqFilm")
	private Integer idFilm;
	@Column(name = "titre_film", length =150,nullable=false)
	private String titre;
	@Column(name = "date_sortie", nullable=true)
	private Date dateSortie;
	@OneToMany(mappedBy="film")
	private List<Article> articles;
	
	@OneToMany(mappedBy="associationRealisateurFilmPk,realisateur")
	private Set<AssocationRealisateurFilm> realisateurs;
	
	
	
	// Constructeurs
	public Film() {
		super();
	}

	public Film(String titre) {
		super();
		this.titre = titre;
	}

	public Integer getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(Integer idFilm) {
		this.idFilm = idFilm;
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

	

	public Set<AssocationRealisateurFilm> getRealisateurs() {
		return realisateurs;
	}

	public void setRealisateurs(Set<AssocationRealisateurFilm> realisateurs) {
		this.realisateurs = realisateurs;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFilm == null) ? 0 : idFilm.hashCode());
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
		if (idFilm == null) {
			if (other.idFilm != null)
				return false;
		} else if (!idFilm.equals(other.idFilm))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
	

}
