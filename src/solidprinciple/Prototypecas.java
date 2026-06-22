package solidprinciple;

import java.util.*;

class CreditReport implements Cloneable{
	private String userId;
	private String creditScore;
    private List<Transaction> transactions;
    private PersonalInfo personalInfo;
    public CreditReport(String userID) {
    	this.userId=userId;
        this.creditScore = fetchFromDB();        // DB call
        this.transactions = fetchTransactions(); // API call
        this.personalInfo = fetchPersonalInfo(); // API call
        System.out.println("Expensive object created!");
    }
    private String fetchFromDB() {
		// TODO Auto-generated method stub
		return null;
	}
	private List<Transaction> fetchTransactions() {
		// TODO Auto-generated method stub
		return null;
	}
	private PersonalInfo fetchPersonalInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // transactions list SHARED!
    }
    
    public CreditReport deepClone() {
        CreditReport copy = new CreditReport();// private no-arg constructor
        copy.userId = this.userId;
        copy.creditScore = this.creditScore;
        
        // New list — copy each transaction
        copy.transactions = new ArrayList<>();
        for (Transaction t : this.transactions) {
            copy.transactions.add(new Transaction(t)); // copy constructor
        }
        
        // New personalInfo object
        copy.personalInfo = new PersonalInfo(this.personalInfo);
        
        return copy;
    }
    private CreditReport() {}
	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}

 class Transaction {
    private String id;
    private double amount;
    private String type;

    // Copy constructor — for deep clone
    public Transaction(Transaction other) {
        this.id = other.id;
        this.amount = other.amount;
        this.type = other.type;
    }

	public Transaction(String string, int i, String string2) {
		// TODO Auto-generated constructor stub
	}
}


//Cache — store base prototypes here
 class CreditReportRegistry {
  private Map<String, CreditReport> cache = new HashMap<>();

  // Pre-load expensive base report
  public void loadCache(String userId) {
      CreditReport report = new CreditReport(userId); // expensive once!
      cache.put(userId, report);
  }

  // Clone from cache — fast!
  public CreditReport getReport(String userId) {
      CreditReport cached = cache.get(userId);
      return cached.deepClone(); // 2ms instead of 2000ms!
  }
}
 
 
 
public class Prototypecas {
	public static void main(String[] args) {
CreditReportRegistry registry = new CreditReportRegistry();
        
        // Load once — expensive (2 seconds)
        registry.loadCache("user123");
        System.out.println("Base report cached!");

        // Clone 1000 times — fast! (2ms each)
        CreditReport report1 = registry.getReport("user123");
        CreditReport report2 = registry.getReport("user123");

//         Modify report1 — report2 unaffected!
        report1.getTransactions().add(new Transaction("TX999", 500, "DEBIT"));

        System.out.println(report1.getTransactions().size()); // 11
	}

}
