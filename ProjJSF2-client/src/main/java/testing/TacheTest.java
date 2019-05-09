package testing;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.TacheServiceRemote;


public class TacheTest {

	public static void main(String[] args)  throws NamingException{
		// TODO Auto-generated method stub
		InitialContext ctx = new InitialContext();
		Object obj = ctx.lookup("ProjJSF2-ear/ProjJSF2-ejb/TacheService!services.TacheServiceRemote");
		TacheServiceRemote tr = (TacheServiceRemote) obj;
		tr.getById(1);
	}

}
