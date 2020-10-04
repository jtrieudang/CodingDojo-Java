public interface Ringable {

	public default String ring() {
		return "Ring!";
	}
	public default String unlock() {
		return "Unlocked.";
    }
    
}