
public class DataTypeTest {

	public static void main(String[] args) {
		
		boolean flag = true;
		char ch = 'a';
		int i = 10;		// 정수 상수는 기본이 int
		long j = 10L; 	 
		double d = 3.45; // 실수 상수는 기본이 double
		
		System.out.println(flag);
		System.out.println(ch);
		System.out.println(i);
		System.out.println(d);
		
		// 정수: byte<short<int<long
		// 실수: float<double
		// 정수<실수: byte<short<int<long<float<double
		float f = j; // float = long, 묵시적 형변환
		System.out.println(f);
		
		int d2 = (int)d; // int = double, 명시적 형변환
		System.out.println(d2);

	}

}
