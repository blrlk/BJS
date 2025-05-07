package hw;
import java.util.*;

// 변수, 연산자, 제어문, 배열, 클래스
public class hw01 {

	public static void main(String[] args) {
		System.out.println("== 숫자 야구 시작 ==\n<   중복 제외   >");
		Scanner sc = new Scanner(System.in);

		int[] answer = new int[3]; // 정답
		Random rd = new Random();

		// 랜덤 수 생성
		for (int i = 0; i < answer.length; i++) {
			int num = rd.nextInt(10);

			boolean isused = false; // 중복 여부

			for (int j = 0; j < i; j++) {
				if (answer[j] == num) {
					isused = true;
					break;
				}
			}

			if (isused) {
				i--;
			} else {
				answer[i] = num;
			}
		}

		System.out.print("answer: ");
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
		}
		System.out.println();

		int[] userInput = new int[3]; // 사용자 입력

		int strike, ball, cnt = 0;

		while (true) {
			strike = 0; ball = 0;
			cnt++;

			System.out.print("세 자리 숫자 입력 ");
			int num = sc.nextInt();			

			// 각각의 숫자 배열 안에 넣기
			String str = String.valueOf(num);	//num을 문자열로 변경 -> 각 자리수 배열에 넣기 위함

			for (int i = 0; i < answer.length; i++) {
				userInput[i] = str.charAt(i) - '0';	//문자열의 i번째 문자에서 문자 '0'을 빼면 i번째 문자가 정수가 됨
			}
			
			// 사용자 입력 숫자 중복 여부 검사
			boolean isused = false;
			for(int i=0;i<userInput.length;i++) {
				for(int j=0;j<userInput.length;j++) {
					if(userInput[i] == userInput[j]) {
						if(i!=j) {
							isused = true;
							break;
						}
					}
				}
			}
			
			if(isused) {
				System.out.println("중복은 제외하고 입력해주세요");
				continue;
			}

			// game start
			// 값 비교
			for (int i = 0; i < answer.length; i++) {
				for (int j = 0; j < answer.length; j++) {
					if (answer[i] == userInput[j]) {
						if (i == j) {
							strike++;
						} else {
							ball++;
						}
					}
				}
			}

			// 결과 print
			if (strike == 0 && ball == 0) {
				System.out.println("out");
			} else {
				if (strike == 3 && ball == 0) {
					System.out.printf("~ 정답입니다 ~\n%d번 만에 성공", cnt);
					break;
				} else {
					System.out.printf("%d strike, %d ball\n", strike, ball);
				}

			}

		}

	}

}