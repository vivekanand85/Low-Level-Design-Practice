package solidprinciple;


 class DatabaseConnectionPool {
	 
//	 public DatabaseConnectionPool getInstance() {
//		 if(instance==null) {
//			 synchronized (DatabaseConnectionPool.class) {
//				if(instance==null) {
//					 instance=new DatabaseConnectionPool();
//				}
//			}
//			
//		 }
//		 return instance;
//	 }
	 static class Holder{
		 public static DatabaseConnectionPool instance=new DatabaseConnectionPool();
	 }
	 public DatabaseConnectionPool getInstance() {
		 return Holder.instance;
	 }
}
public class SingletonExa {

}
