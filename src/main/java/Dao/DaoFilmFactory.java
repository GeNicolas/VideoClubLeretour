package Dao;

public class DaoFilmFactory {
	
public static DaoFilmJpaImpl singleton=null;
	
	public static DaoFilmJpaImpl getFilmFactory() {
		if (singleton == null)
			singleton = new DaoFilmJpaImpl();
		
		return singleton;
	}

}
