package Dao;

public class DaoArticleFactory {
	
public static DaoArticleJpaImpl singleton=null;
	
	public static DaoArticleJpaImpl getCompetenceFactory() {
		if (singleton == null)
			singleton = new DaoArticleJpaImpl();
		
		return singleton;
	}

}
