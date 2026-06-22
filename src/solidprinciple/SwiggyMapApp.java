package solidprinciple;


import java.util.*;

class BikeIcon{
	private final byte[] iconImage;
	private final String iconType;
	
	public BikeIcon(String iconType) {
		this.iconType=iconType;
        System.out.println("Loading 2MB image for: " + iconType);
        this.iconImage=loadImageFromDisk(iconType);
	}
	
	private byte[] loadImageFromDisk(String type) {
        return new byte[2_000_000]; // simulate 2MB load
    }
	public void render(int x,int y) {
        System.out.println("Rendering " + iconType + " at (" + x + "," + y + ")");
	}
}
class BikeIconFactory {
    private static final Map<String, BikeIcon> cache = new HashMap<>();
    public static BikeIcon getIcon(String iconType) {
    	BikeIcon icon=cache.get(iconType);
    	if(icon==null) {
    		icon=new BikeIcon(iconType);
    		cache.put(iconType, icon);
    	}
    	return icon;
    }

}
public class SwiggyMapApp {
    public static void main(String[] args) {
        List<int[]> bikePositions = generateMillionPositions(); // (x, y) pairs

        for (int[] pos : bikePositions) {
            // Same BikeIcon object reused — NOT recreated!
            BikeIcon icon = BikeIconFactory.getIcon("RED_BIKE");
            icon.render(pos[0], pos[1]); // extrinsic state passed each time
        }

        // Memory check:
        // WITHOUT Flyweight: 1,000,000 × 2MB = 2,000,000 MB 💥
        // WITH Flyweight:    1 × 2MB = 2MB ✅ (only x,y stored per bike — few bytes!)
    }

    private static List<int[]> generateMillionPositions() {
        List<int[]> positions = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            positions.add(new int[]{i, i * 2});
        }
        return positions;
    }
}