package idv.heimlich.Create;

import org.slf4j.Logger;

import idv.heimlich.Create.common.db.IDBSession;
import idv.heimlich.Create.common.db.IDBSessionFactory;
import idv.heimlich.Create.common.db.impl.DBSessionFactoryImpl;
import idv.heimlich.Create.common.log.LogFactory;

public class Test {
	
	private static Logger LOGGER = LogFactory.getInstance();
	
	public static void main(String[] args) {
		LOGGER.debug("Test Start");
		IDBSessionFactory sessionFactory = new DBSessionFactoryImpl();
		IDBSession session = sessionFactory.getXdaoSession("");
		
	}

}
