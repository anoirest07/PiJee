package PostService;

import javax.ejb.Remote;

@Remote
public interface PostSerRemote {
	void Consommation();
	public String Add(String s );
	public String getAll();
	public String getTopPost();
	}
