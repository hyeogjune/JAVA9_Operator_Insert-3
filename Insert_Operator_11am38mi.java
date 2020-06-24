import java.util.*;
public class Insert_Operator {
	//Using DFS by using index
	static int max_N = -100000000;
	static int min_N = 100000000; 
	static int N;
	static int[] arr;
	static int[] arr_arith;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		//첫째 줄, 2부터 10 사이의 원하는 숫자 N의 개수 입력
		System.out.print("수의 개수 입력: ");
		N = sc.nextInt();		
		N_range(N); //범위가 2부터 10까지일 조건함수
		
		//둘째 줄, 1부터 100사이 원하는 숫자 N개 입력
		System.out.print("숫자 N개 입력: ");
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arr_range(arr, N); //범위가 1부터 100까지일 조건함수
		
		//셋째 줄, 합이 N-1인 4개의 부호(+,-,*,/)
		System.out.print("+, -, *, / 각각의 개수: ");
		arr_arith = new int[4];
		for(int i = 0; i<arr_arith.length; i++) {
			arr_arith[i] = sc.nextInt();
		}
		Arith(arr_arith, N); //합이 N-1일 조건함수
		
		Dfs(1, 0, 0, 0, 0, arr[0]);
		System.out.println(max_N);
		System.out.print(min_N);
		
	}
	
	public static void Dfs(int index, int plus, int sub, int multi, int divi, int total) {
		if(N == index) {
			max_N = Math.max(max_N, total);
			min_N = Math.min(min_N, total);
			return;
		}
		if(arr_arith[0] > plus) {
			Dfs(index + 1, plus + 1, sub, multi, divi, total+arr[index]);
		}
		if(arr_arith[1] > sub) {
			Dfs(index + 1, plus, sub + 1, multi, divi, total-arr[index]);
		}
		if(arr_arith[2] > multi) {
			Dfs(index + 1, plus, sub, multi + 1, divi, total*arr[index]);
		}
		if(arr_arith[3] > divi) {
			Dfs(index + 1, plus, sub, multi, divi + 1, total/arr[index]);
		}
		
		
	}
	
	
	public static void N_range(int n) {		
		if(2<= n && n<=10) {
			return;
		}
		else {
			System.out.print("재입력");
		}
	}
	
	
	public static void Arr_range(int[] arrr, int NN) {
		for(int i = 0; i<arrr.length; i++) {
			if(1<=arrr[i] && arrr[i]<=100) {
				return;
			}
			else {
				System.out.print("재입력");
			}
		}
	}
	
	
	public static void Arith(int[] arrr_arith, int NN) {
		if(arrr_arith[0] + arrr_arith[1] + arrr_arith[2] + arrr_arith[3] == NN-1) {
			return;
		}
		else {
			System.out.print("재입력");
		}
	}
	
}
	
	

