package solidprinciple;

 abstract class OnboardingProcess {
    
    public final void onboard() {
        verifyDocuments();   
        createProfile(); 
        setupMenu();          
        sendWelcomeEmail();  
    }

    private void verifyDocuments() {
        System.out.println("Verifying documents... (shared logic)");
    }

    private void setupMenu() {
        System.out.println("Setting up menu... (shared logic)");
    }

    protected abstract void createProfile();
    protected abstract void sendWelcomeEmail();
}
  class RestaurantOnboarding extends OnboardingProcess {
	    @Override
	    protected void createProfile() {
	        System.out.println("Creating restaurant profile with dine-in details");
	    }

	    @Override
	    protected void sendWelcomeEmail() {
	        System.out.println("Sending restaurant welcome email template");
	    }
	}

	 class CloudKitchenOnboarding extends OnboardingProcess {
	    @Override
	    protected void createProfile() {
	        System.out.println("Creating cloud kitchen profile with delivery-only details");
	    }

	    @Override
	    protected void sendWelcomeEmail() {
	        System.out.println("Sending cloud kitchen welcome email template");
	    }
	}
public class SwiggyAppTemplateMethod {
public static void main(String[] args) {
	OnboardingProcess restaurant = new RestaurantOnboarding();
    restaurant.onboard();
    System.out.println("---");

    OnboardingProcess cloudKitchen = new CloudKitchenOnboarding();
    cloudKitchen.onboard();
}
}
