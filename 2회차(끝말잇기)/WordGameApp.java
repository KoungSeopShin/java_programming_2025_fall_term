import java.util.Scanner;

class Player{
    //참가자 이름 필드
    String PlayerName;

    //플레이어들한테 단어를 입력받는 메소드임
    public String getWordFromUser(){
        Scanner scanner = new Scanner(System.in);

        System.out.print(PlayerName + ">>");
        String nextChar = scanner.nextLine();
        return nextChar;
    }
}

public class WordGameApp{
    //필드
    String word;

    //생성자임
	public WordGameApp() { 
        word = "아버지";
	}

    //게임을 전체적으로 진행하는 메소드
	public String run(){
        Scanner scanner = new Scanner(System.in);

        //플레이어 수만큼 객체 배열 생성
        System.out.println("게임에 참가하는 인원은 몇 명입니까 >>");
        int n = scanner.nextInt(); 
        
        Player[] p = new Player[n];

        //객체 배열에 객체 생성 및 플레이어 이름 객체 배열에 입력
        scanner.nextLine();
		for(int i = 0 ; i < p.length ; i++) {
			System.out.print("참가자의 이름을 입력하세요 >>");
			String PlayerName = scanner.nextLine();

            p[i] = new Player();
            p[i].PlayerName = PlayerName;
		}
        System.out.println("시작하는 단어는 " + word + "입니다");

        //게임 진행 반복문
        boolean Success = true;
        while(true){
            int i = 0;
	    	for(i = 0 ; i < p.length ; i++) {
                Success = checkSuccess(p[i].getWordFromUser());
                if (Success){
                    continue;
                } else {
                    return p[i].PlayerName;
                }
            }
        }
    }

    //끝말잇기 성공 여부를 판별하는 메소드
    public boolean checkSuccess(String nextChar){
        int lastIndex = word.length() - 1;        // 마지막 문자에 대한 인덱스
        char lastChar = word.charAt(lastIndex);   // 마지막 문자
        char firstChar = nextChar.charAt(0);          // 다음 입력받은 문자의 첫 번째 문자

        if (lastChar != firstChar) {
            return false;
        } else {
            word = nextChar;
            return true;
        }
    }

    public static void main(String[] args) { 
        WordGameApp app = new WordGameApp();
        String looser;

        looser = app.run();
        System.out.println(looser + "이(가) 졌습니다.");
    }
}
