package Dao;

public class DaoAdherentFactory {
	
public static DaoAdherentJpaImpl singleton=null;
	
	public static DaoAdherentJpaImpl getAdherentFactory() {
		if (singleton == null)
			singleton = new DaoAdherentJpaImpl();
		
		return singleton;
	}

}
