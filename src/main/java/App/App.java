package App;

import Dao.DaoAdherent;
import Dao.DaoAdherentFactory;
import Dao.DaoArticle;
import Dao.DaoArticleFactory;
import Dao.DaoAssociationRealisateurFilm;
import Dao.DaoAssociationRealisateurFilmFactory;
import Dao.DaoFilm;
import Dao.DaoFilmFactory;
import Dao.DaoRealisateur;
import Dao.DaoRealisateurFactory;
import Model.Adherent;
import Model.Adresse;
import Model.Article;
import Model.ArticleDvd;
import Model.AssocationRealisateurFilm;
import Model.AssociationRealisateurFilmPk;
import Model.Film;
import Model.Realisateur;
import util.Context;

public class App {

	public static void main(String[] args) {

		
		// Adherent
		//Context.getContext();
		Adherent adherent = new Adherent("murloc", "murloc");
		adherent.setAdresses(new Adresse(1, "street", "NYC", "007"));
		DaoAdherent adherentfac = new DaoAdherentFactory().getAdherentFactory();
		adherentfac.insert(adherent);
		
		adherent = new Adherent("hurlorage", "illidan");
		adherent.setAdresses(new Adresse(2, "route_de_Kalimdor", "darnassus", "007"));
		adherentfac.insert(adherent);
		
		// Film
		
		Film film = new Film("Wait whaat"); 
		DaoFilm filmfac = DaoFilmFactory.getFilmFactory(); 
		filmfac.insert(film);
		
		
		/// Article
		
		Article article = new ArticleDvd(5, true); 
		DaoArticle test =DaoArticleFactory.getArticleFactory();
		System.out.println("-----------insertion adherent-----------");
		article.setEmprunteur(adherent);
		System.out.println("-----------insertion film---------------");
		article.setFilm(film);
		System.out.println("-----------insertion article------------");
		test.insert(article);
		
		/// Realisateur
	
		Realisateur real = new Realisateur("yoda", "maitre"); 
		DaoRealisateur realfac= new DaoRealisateurFactory().getRealisateurFactory(); 
		realfac.insert(real);
		
		//Association Real et film
		
		AssocationRealisateurFilm asso = new AssocationRealisateurFilm(new AssociationRealisateurFilmPk(film, real), "moaui");
		DaoAssociationRealisateurFilm daoasso = DaoAssociationRealisateurFilmFactory.getAssociatioRealisateurFilmFactory();
		daoasso.insert(asso);
		
		// Fermeture context

		Context.close();

	}

}
