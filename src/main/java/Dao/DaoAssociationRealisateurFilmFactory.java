package Dao;

public class DaoAssociationRealisateurFilmFactory {

	public static DaoAssociationRealisateurFilmJpaImpl singleton=null;
	
	public static DaoAssociationRealisateurFilmJpaImpl getAssociatioRealisateurFilmFactory() {
		if (singleton == null)
			singleton = new DaoAssociationRealisateurFilmJpaImpl();
		
		return singleton;
	}

}
