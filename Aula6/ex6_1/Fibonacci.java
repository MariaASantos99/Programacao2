import static java.lang.System.*;

public class Fibonacci {

  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("USO: java -ea Fibonacci N [N ...]");
      exit(1);
    }

    // Alguns testes:
    assert fibonacci(0) == 0;
    assert fibonacci(1) == 1;
    assert fibonacci(2) == 1;
    assert fibonacci(5) == 5;

    for(int i = 0; i < args.length; i++) {
      int n = Integer.parseInt(args[i]);
      long time = nanoTime();  // System.nanoTime() gives the time in ns.
      int f = fibonacci(n);
      time = nanoTime() - time;
      out.printf("fibonacci(%d) = %d (%d ns)\n", n, f, time);
    }
    
    for(int i = 0; i < args.length; i++) {
      int n = Integer.parseInt(args[i]);
      long time = nanoTime();  // System.nanoTime() gives the time in ns.
      int f1 = fib(n);
      time = nanoTime() - time;
      out.printf("fibonacci(%d) = %d (%d ns)\n", n, f1, time);
    }
  }

	public static int fibonacci(int n) {
		assert n >= 0;
		int r=0;
		if(n==1)r=1;
		for(int i = 2; i<=n; i++)r = fibonacci(n-1)+fibonacci(n-2);
		return r;
	}
  
	private static int[] arr = new int[50];
	public static int fib(int n) {
		assert n >= 0;
		assert n < arr.length;
		if(n<=1)arr[n]=n;
		else if(arr[n] == 0) arr[n] = fib(n-1) + fib(n-2);
		return arr[n];
	}
  
}
