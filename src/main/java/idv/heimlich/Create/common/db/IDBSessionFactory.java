package idv.heimlich.Create.common.db;

public interface IDBSessionFactory {

	IDBSession getXdaoSession(String conn);

}
