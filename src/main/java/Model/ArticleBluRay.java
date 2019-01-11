package Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="B")
public class ArticleBluRay extends Article{
	
	private boolean trois_d;

	public ArticleBluRay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleBluRay(Integer noArticle, Integer nbDisques, boolean trois_d) {
		super(noArticle, nbDisques);
		this.trois_d = trois_d;
		// TODO Auto-generated constructor stub
	}

	public boolean isTrois_d() {
		return trois_d;
	}

	public void setTrois_d(boolean trois_d) {
		this.trois_d = trois_d;
	}
	
	
	
	
	

}
