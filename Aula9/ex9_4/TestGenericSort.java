import static java.lang.System.*;
import java.util.Arrays;    // to use Java's array operations

import static p2utils.Sorting.*;

public class TestGenericSort{
	public static void main(String[] args){
		if (args.length < 1) {
			err.println("Test sorting algorithms for an array of size N.");
			err.println("Usage: java -ea TestSorting N ...");
			exit(1);
		}
		
		mergeSort(args, 0, args.length);
		out.println(Arrays.toString(args));
	}
}
