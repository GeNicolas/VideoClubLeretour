package Dao;

public class DaoAdherentFactory {
	
public static DaoAdherentJpaImpl singleton=null;
	
	public static DaoAdherentJpaImpl getCompetenceFactory() {
		if (singleton == null)
			singleton = new DaoAdherentJpaImpl();
		
		return singleton;
	}

}
