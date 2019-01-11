package Dao;

public class DaoFilmFactory {
	
public static DaoFilmJpaImpl singleton=null;
	
	public static DaoFilmJpaImpl getCompetenceFactory() {
		if (singleton == null)
			singleton = new DaoFilmJpaImpl();
		
		return singleton;
	}

}
