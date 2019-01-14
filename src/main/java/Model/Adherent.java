package Model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "adherent")
@SequenceGenerator(name="seqAdherent", sequenceName = "seq_adherent", allocationSize = 1, initialValue =1)
public class Adherent {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAdherent")
	private Integer noAdherent;
	@Column(name = "civilite", length =4,nullable=true)
	private String civilite;
	@Column(name = "nom_adherent", length =20,nullable=false)
	private String nom;
	@Column(name = "prenom_adherent", length =20,nullable=false)
	private String prenom;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "numero", column =@Column(name="number")),
		@AttributeOverride(name = "rue", column =@Column(name="street", length=90)),
		@AttributeOverride(name = "ville", column =@Column(name="city", length=90)),
		@AttributeOverride(name = "codePostal", column =@Column(name="zipcode", length=90))
	})
	Adresse adresses;
	
	@OneToMany(mappedBy="emprunteur")
	List<Article> articles;
	
	// Constructeurs

	public Adherent() {
		super();
	}

	public Adherent(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	//Methodes
	
	public Integer getNoAdherent() {
		return noAdherent;
	}

	public void setNoAdherent(Integer noAdherent) {
		this.noAdherent = noAdherent;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresses() {
		return adresses;
	}

	public void setAdresses(Adresse adresses) {
		this.adresses = adresses;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noAdherent == null) ? 0 : noAdherent.hashCode());
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
		Adherent other = (Adherent) obj;
		if (noAdherent == null) {
			if (other.noAdherent != null)
				return false;
		} else if (!noAdherent.equals(other.noAdherent))
			return false;
		return true;
	}
	
	
	

}
