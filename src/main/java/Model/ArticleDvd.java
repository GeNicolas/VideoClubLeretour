package Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="D")
public class ArticleDvd extends Article {
	
	@Column(name="bonus")
	private boolean bonus;

	public ArticleDvd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleDvd(Integer nbDisques, boolean bonus) {
		super(nbDisques);
		this.bonus = bonus;
		// TODO Auto-generated constructor stub
	}

	public boolean isBonus() {
		return bonus;
	}

	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}
	

}
