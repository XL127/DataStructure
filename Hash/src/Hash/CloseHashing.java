package Hash;

public class CloseHashing<AnyType> extends AbstractHash<AnyType> {

	/*
	 * protected AnyType HashArray[];
	protected int size;
	 */
	private int Bit;
	
    protected CloseHashing(int inputSize) {
		super(inputSize);
	}
	
    @Override 
	public void ResetArray(){
    	HashArray =  (AnyType[]) new Object [size];
    }
	
    @Override
	public void modHash(int index, AnyType value){
		int key = index % size;
		HashArray[key] = value;
	}
	
    @Override
	public void binningHash(int index, AnyType value){
		int key = index / size;
		HashArray[key] = value;
	}
	
    @Override
	public void midsquareHash(int index, AnyType value){
    	/* int key;
		 int square = index * index;
		 if(size <= 10){
			 key =  square % 10;
		 }
		 else if(size <= 100){
			 key = square & 100;
		 }
		 else if(size <= 999){
			 key = square & 100;
		 }
		 else if(size <= 9999){
			 key = square % 1000 % 10;
		 }
		 else if(size <= 999999) {
			 key = square % 10000;
		 }*/
    }
	
    @Override 
	public void foldingHash(){
		
	}
	
	public void stringFoldingHash(){
		
	}
	
	public int BitCalculate(){
		switch(size){
		case 10: Bit = 1; 
		case 100: Bit = 2;
		case 1000: Bit = 3; 
		case 10000: Bit = 4; 
		case 100000: Bit = 5; 
		case 1000000: Bit = 6;
		case 10000000: Bit = 7; 
		case 100000000: Bit = 8;
		case 1000000000: Bit = 9; 
		}
		return Bit;
	}
	
	public void delete(){
		
	}
}
