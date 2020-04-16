package java_adv_4th_exper;
import java.math.*;

public class Main {
	public static class MatrixGenerator{
		int m;
		int n;
		Double[][] Matrix;
		public Double[][] getMatrix(int m, int n){
			this.m = m;
			this.n = n;
			Matrix = new Double[m][];
			for(int i = 0;i < m;i++) {
				Matrix[i] = new Double[n];
				for(int j = 0;j < n;j++) {
					Matrix[i][j] = Math.random()*10000;
				}
			}
			return Matrix;
		}
	
	
		
		public void display(Double[][] a, int m, int n) {
			for(int i = 0;i < m;i++) {
				for(int j = 0;j < n;j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	static class MultiplyPart implements Runnable{
		Double[][] a,b,c;
		int i, o;
		int n;
		MultiplyPart(Double[][] a, Double[][] b, Double[][] c, int i, int o, int n){
			this.a = a;
			this.b = b;
			this.c = c;
			this.i = i;
			this.o = o;
			this.n = n;
		}
		@Override
		public void run() {
			c[i] = new Double[o];
			for(int j=0;j<o;j++) {
				c[i][j] = 0.0;
				for(int k=0;k<n;k++) {
					c[i][j] += a[i][k]*b[k][j];
				}
			}
		}
	}
	
	static public Double[][] serialMatrixMultiply(Double[][] a, Double[][] b,int m, int n, int o) {
		Double[][] result = new Double[m][];
		for(int i = 0;i < m;i++) {
			result[i] = new Double[o];
			for(int j = 0;j < o;j++) {
				result[i][j] = 0.0;
				for(int k=0;k<n;k++) {
					result[i][j] += a[i][k]*b[k][j];
				}
			}
		}
		return result;
	}
	
	static public Double[][] parallelMatrixMultiply(Double[][] a, Double[][] b,int m, int n, int o) {
		Double[][] result = new Double[m][];
		Thread[] threads = new Thread[m];
		for(int i=0;i<m;i++) {
			Runnable s = new MultiplyPart(a, b, result, i, o, n);
			Thread t = new Thread(s);
			t.start();
			threads[i] = t;
		}
		for(int i = 0;i < threads.length;i++) {
			try {
				threads[i].join();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	static public void main(String[] avgs) {
		MatrixGenerator matrixGenerator = new MatrixGenerator();
		int m=800,n=1000,o=600;
		Double[][] a = matrixGenerator.getMatrix(m, n);
		Double[][] b = matrixGenerator.getMatrix(n, o);
		Long startTime;
		
		startTime=System.currentTimeMillis();
		Double[][] result1 = serialMatrixMultiply(a,b,m,n,o);
		System.out.println("串行计算花费时间为:" + (System.currentTimeMillis()-startTime));
		
		startTime = System.currentTimeMillis();
		Double[][] result2 = parallelMatrixMultiply(a,b,m,n,o);
		System.out.println("并行计算花费时间为:" + (System.currentTimeMillis()-startTime));
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<o;j++) {
				if(Math.abs(result1[i][j]-result2[i][j])>0.00001) {
					System.out.println("计算有误");
					break;
				}
			}
		}
	}
}
