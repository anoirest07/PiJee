package recommendationService;

import javax.ejb.Remote;

@Remote
public interface RecommendationSerRemote {
	void Consommation();
	public String Add(String s );
	public String getAll();
	public String getByUser();
	public int test(String mail);

}
