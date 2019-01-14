package Dao;

public class DaoRealisateurFactory {
	
public static DaoRealisateurJpaImpl singleton=null;
	
	public static DaoRealisateurJpaImpl getRealisateurFactory() {
		if (singleton == null)
			singleton = new DaoRealisateurJpaImpl();
		
		return singleton;
	}

}
