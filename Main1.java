import java.util.Scanner;

class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of elements: ");
		int count = scanner.nextInt();
		int[] numbers = new int[count];

		System.out.println("Enter the elements:");
		for (int index = 0; index < count; index++) {
			numbers[index] = scanner.nextInt();
		}

		System.out.print("Enter the window size: ");
		int windowSize = scanner.nextInt();

		if (windowSize <= 0 || windowSize > count) {
			System.out.println("Window size must be between 1 and the number of elements.");
			return;
		}

		int windowSum = 0;
		for (int index = 0; index < windowSize; index++) {
			windowSum += numbers[index];
		}

		int maximumSum = windowSum;
		for (int index = windowSize; index < numbers.length; index++) {
			windowSum = windowSum + numbers[index] - numbers[index - windowSize];
			if (windowSum > maximumSum) {
				maximumSum = windowSum;
			}
		}

		System.out.println("Maximum sum of " + windowSize + " consecutive elements: " + maximumSum);
	}
}
