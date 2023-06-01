package api.constants;

public enum Params {
	
	ID(3222),
	ID1(3101);
	
	private final int value;

	Params(int value) {
        this.value = value;
    }
	
	public int getValue() {
        return value;
    }
			

}
