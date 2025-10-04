import java.util.Random;
import java.util.Scanner;

public class Minesweeper{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //n, m 값 입력
        System.out.println("2차원 배열의 크기를 입력하세요(n행, m열): ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //k값 입력
        System.out.println("지뢰의 개수를 입력하세요: ");
        int k = scanner.nextInt();
        if (k < 0 || k > n * m) {
            System.out.println("지뢰 개수가 범위를 벗어났습니다.");
            return;
        }

        //-1 무작위 배치
        int	intArray [][] = new int[n][m];
        Random random = new Random();
        int l = 1;
        while (l <= k){
            int r = random.nextInt(n);
            int d = random.nextInt(m);

            if (intArray[r][d] != -1) {
                intArray[r][d] = -1;
                l++;
            }
        }

        //주변 숫자 바꾸기
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {
                if (intArray[i][j] == -1) {
                    // 왼쪽 3칸
                    if (i > 0) {
                        if (j > 0 && intArray[i-1][j-1] != -1) intArray[i-1][j-1] += 1;
                        if (intArray[i-1][j] != -1) intArray[i-1][j] += 1;
                        if (j < m-1 && intArray[i-1][j+1] != -1) intArray[i-1][j+1] += 1;
                    }
                    // 같은 열 상/하
                    if (j > 0 && intArray[i][j-1] != -1) intArray[i][j-1] += 1;
                    if (j < m-1 && intArray[i][j+1] != -1) intArray[i][j+1] += 1;

                    // 오른쪽 3칸
                    if (i < n-1) {
                        if (j > 0 && intArray[i+1][j-1] != -1) intArray[i+1][j-1] += 1;
                        if (intArray[i+1][j] != -1) intArray[i+1][j] += 1;
                        if (j < m-1 && intArray[i+1][j+1] != -1) intArray[i+1][j+1] += 1;
                    }
                }
            }
        }

        //배열 출력
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray[i].length; j++)
				if (intArray[i][j] == -1){
                    System.out.print(" " + intArray[i][j]);
                } else {
                    System.out.print("  " + intArray[i][j]);
                }
			System.out.println();
		}
    }
}
