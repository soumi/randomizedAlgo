import java.util.ArrayList;
import java.util.Random;

public class median{

    public int findSplitter(ArrayList<Integer> arr){
	if (arr.size() == 1)
	    return 0;       
	Random r = new Random();
	
	int position = r.nextInt(arr.size() - 1);
	System.out.println(position);
	return position;
    }

    public int select(ArrayList<Integer> arr, int k){
	ArrayList<Integer> small = new ArrayList<Integer>();
	ArrayList<Integer> big = new ArrayList<Integer>();
	int splitter = -1;

	while (true){// choosing a central splitter
	    small.clear();
	    big.clear();
	    int position = findSplitter(arr);
	    if (position == -1)
		System.exit(0);
	    splitter =arr.get(position);
	    
	    for(int i : arr){//divide the array
		if (i < splitter)
		    small.add(i);
		else if (i > splitter)
		    big.add(i);
	    }
	    if (small.size() >= (arr.size() / 4) && big.size() >= (arr.size() / 4))
		break;
	}
	if (small.size() == k - 1)
	    return splitter;
	else if (small.size() >= k)
	    return select(small, k);
	else if (small.size() < k - 1)
	    return select(big, k - 1 - small.size());
	else return splitter;
    }

    public static void main(String[] args){
	median m = new median();
	ArrayList<Integer> arr = new ArrayList<Integer>();
	arr.add(5);
	arr.add(85);
	arr.add(75);
	arr.add(50);
	arr.add(57);
	arr.add(-5);
	arr.add(35);
	arr.add(45);
	arr.add(25);
	arr.add(15);
	arr.add(65);
	arr.add(105);
	arr.add(705);
	arr.add(405);
	arr.add(55);
	arr.add(-95);
	arr.add(-50);
	arr.add(1005);
	arr.add(205);
	arr.add(58);
	int kthElement = m.select(arr , (arr.size() / 2));
	System.out.println(kthElement);
    }
}