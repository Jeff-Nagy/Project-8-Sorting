import java.util.*;

public class HashSetPractice {
	
	private static final int MAX = 80, MIN = 1;
	private static int[] selectionArray;
	private static int[] insertionArray;
	private static final int ARRAY_SIZE = 50;

	public static void main(final String[] args) throws Exception {
		
		selectionArray = new int[ARRAY_SIZE];
		insertionArray = new int[ARRAY_SIZE];
	    final Random random = new Random();
	    
	    final Set<Integer> intSet = new HashSet<>();
	    
	    while (intSet.size() < 50) {
	        intSet.add(random.nextInt(80) + 1);
	    }
	    
	    final int[] ints = new int[intSet.size()];
	   
	    final Iterator<Integer> iter = intSet.iterator();
	    for (int i = 0; iter.hasNext(); ++i) {
	        ints[i] = iter.next();
	    }
	    System.out.println(Arrays.toString(ints));
	    
	    
	    
	    
	    final Set<Integer> uniqueNums = new HashSet<Integer>();						//final Set<Integer> intSet = new HashSet<>();
		
	    while(uniqueNums.size() < 50) {												//while (intSet.size() < 50) {
			uniqueNums.add(random.nextInt(80) + 1);									//intSet.add(random.nextInt(80) + 1);
		}
	    																			//final int[] ints = new int[intSet.size()];
		
		final Iterator<Integer> iterator = uniqueNums.iterator();					//final Iterator<Integer> iter = intSet.iterator();
		for(int i = 0; iterator.hasNext(); ++i) {									//for (int i = 0; iter.hasNext(); ++i) {
			
				ints[i] = iterator.next();
				//insertionArray[i] = iterator.next();								// ints[i] = iter.next();
		}
		
		System.out.println(Arrays.toString(ints));
	}

}
