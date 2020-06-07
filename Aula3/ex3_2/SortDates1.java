import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class SortDates1 {
	public static void main(String[] args)throws IOException{
		int N = 1000;
		Data[] datas = new Data[N];
		int n = loadFile(new File(args[0]), datas);
		
		/* Uncomment next line to test sorting...    */
		sort(datas, n);
		

		printArray(datas, n);
	}

	public static void printArray(Data[] datas, int n) {
		for (int i = 0; i < n; i++) {
		  out.printf("%s\n", datas[i]);
		}
	}

  /** Load dates from a text file.
  * @param f  the name of the file
  * @param datas an array where dates are stored
  * @return the number of dates actually read
  */
	public static int loadFile(File f, Data[] datas) throws IOException {
		Scanner scf = new Scanner(f);
		int n = 0;  // number of lines read
		while (scf.hasNextLine() && n<datas.length) {
		  String line = scf.nextLine();
		  datas[n] = new Data(line);
		  n++;
		}
		scf.close();
		return n;
	}

	public static void sort(Data[] datas, int n) {
		for(int j=0; j<n-1;j++ ){
			
			for (int i = j+1; i < n; i++){
				Data tmp = datas[j];
				int r=tmp.compareTo(datas[i]);
				if(r>0){
					tmp=datas[i];
					datas[i]=datas[j];
					datas[j]=tmp;
				}
			}
		}
	}
}

