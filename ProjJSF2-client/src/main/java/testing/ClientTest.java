package testing;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.TestRemote;

public class ClientTest {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		InitialContext ctx = new InitialContext();
		Object obj = ctx.lookup("ProjJSF2-ear/ProjJSF2-ejb/Test!services.TestRemote");
		TestRemote tr = (TestRemote) obj;
		tr.Consommation();
	}

}
