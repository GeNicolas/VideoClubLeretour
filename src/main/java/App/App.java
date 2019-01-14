package App;

import Dao.DaoAdherent;
import Dao.DaoAdherentFactory;
import Dao.DaoArticle;
import Dao.DaoArticleFactory;
import Dao.DaoFilm;
import Dao.DaoFilmFactory;
import Dao.DaoRealisateur;
import Dao.DaoRealisateurFactory;
import Model.Adherent;
import Model.Adresse;
import Model.Article;
import Model.ArticleDvd;
import Model.Film;
import Model.Realisateur;
import util.Context;

public class App {

	public static void main(String[] args) {

		/// Article
		/*
		 * Article article = new ArticleDvd(5, true); DaoArticle test =
		 * DaoArticleFactory.getArticleFactory(); test.insert(article);
		 */
		/// Realisateur
		/*
		 * Realisateur real = new Realisateur("yoda", "maitre"); DaoRealisateur realfac=
		 * new DaoRealisateurFactory().getRealisateurFactory(); realfac.insert(real);
		 */

		// Film
		/*
		 * Film film = new Film("Wait whaat"); DaoFilm filmfac =
		 * DaoFilmFactory.getFilmFactory(); filmfac.insert(film);
		 */

		// Adherent
		Context.getContext();
//		Adherent adherent = new Adherent("murloc", "murloc");
//		adherent.setAdresses(new Adresse(1, "street", "NYC", "007"));
//		DaoAdherent adherentfac = new DaoAdherentFactory().getAdherentFactory();
		// adherentfac.insert(adherent);

		Context.close();

	}

}
