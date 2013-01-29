import java.util.Random;

public class quickSort{

     public int findSplitter(int size){
	if (size == 1)
	    return 0;       
	Random r = new Random();
	int position = r.nextInt(size - 1);
	return position;
    }

    public int partition(int arr[], int start, int end){
	int down = start, up = end, pivot = 0;
	while (true){// loop for getting good splitter
	    down = start; up = end;
	    int position = findSplitter(end - start + 1);	
	    position += start;
	    pivot = arr[position];

	    int temp = arr[position];// swap pivot with left most element
	    arr[position] = arr[start];
	    arr[start] = temp;

	    while (up > down){
		while (arr[down] <= pivot && up > down) down++;
		while (arr[up] > pivot) up--;
		if (down < up){
		    temp = arr[down];
		    arr[down] = arr[up];
		    arr[up] = temp;
		}
	    } 
	    int size = end - start + 1;
	    if ((up - start) >= size / 4 && (end - up) >= size / 4 )
		break;
	}
	//arr[up] = arr[start];
	arr[start] = arr[up];
	arr[up] = pivot;
	return up;
    }

    public void sort(int[] arr, int start, int end){
	if (start >= end)
	    return;
	int position = partition (arr, start, end);
	sort (arr, start, position - 1);
	sort (arr, position + 1, end);
    }

    public static void main(String[] args){
	quickSort m = new quickSort();
	int []arr = {5,85,75,50,57,-5,35,45,25,15,65,105,705,405,55,-95,-50,1005,205,58};
	m.sort(arr , 0, arr.length - 1);
	for (int i :  arr)
	    System.out.print(i + " ");
	System.out.println();
    }
}