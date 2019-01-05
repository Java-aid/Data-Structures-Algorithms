/**
 * @author Kanahaiya Gupta
 *
 */
public class MissingNumber {

	public static int getMissingNumber(int numbers[], int n) {
		int expectedSum = n * (n + 1) / 2;
		int actualSum = 0;

		for (int number : numbers) {
			actualSum = actualSum + number;
		}
		int missingNo = expectedSum - actualSum;
		return missingNo;
	}

	public static void main(String[] args) {
		int numbers1[] = { 6, 3, 2, 4, 1, 7, 5, 10, 8 };
		int n1 = 10;
		int missingNumber1 = getMissingNumber(numbers1, n1);
		System.out.println("Output 1: "+missingNumber1);
		
		int numbers2[] = { 2, 3, 1, 5 };
		int n2 = 5;
		int missingNumber2 = getMissingNumber(numbers2, n2);
		System.out.println("Output 2: "+missingNumber2);
	}
}