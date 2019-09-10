package Hash;

public abstract class AbstractHash<AnyType> {
	protected AnyType HashArray[];
	protected int size;
	
	protected AbstractHash(int inputSize){
		size = inputSize;
		HashArray =  (AnyType[]) new Object [size];
	}
	
	//abstract methods
	
	public abstract void modHash(int key, AnyType value);
	
	public abstract void binningHash(int key, AnyType value);
	
	public abstract void midsquareHash(int key, AnyType value);
	
	public abstract void foldingHash();
	
	public abstract void stringFoldingHash();
	
	public abstract void ResetArray();
	
	public abstract void delete();

}
