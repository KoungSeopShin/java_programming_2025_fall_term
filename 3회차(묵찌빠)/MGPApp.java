import java.util.Random;
import java.util.Scanner;

// 사람과 컴퓨터의 공통 행동 추상클래스
abstract class Player{
    protected Scanner scanner;

    protected String bet[] = {"묵", "찌", "빠"}; 
    protected String name; 
    protected String lastbet = null; 
 
    protected Player(String name){this.name = name;};

    abstract public String next();
}

//사람
class Human extends Player{
    public Human(String name) {
        super(name);
        scanner = new Scanner(System.in);
    }
    @Override
    public String next(){
        System.out.print(name + ">> ");
        lastbet = scanner.nextLine();
        while (!lastbet.equals("묵") && !lastbet.equals("찌") && !lastbet.equals("빠")) {
            System.out.println("묵, 찌, 빠 중에서 다시 입력하세요.");
            System.out.print(name + ">> ");
            lastbet = scanner.nextLine();
        }
        return lastbet;
    }
}
//컴퓨터
class Computer extends Player{
    private Random random;
    public Computer(String name) {
        super(name);
        scanner = new Scanner(System.in);
        random = new Random();
    }
    @Override
    public String next(){
        int r = random.nextInt(3);
        switch (r){
            case 0:
                lastbet = "묵";
                break;
            case 1:
                lastbet = "찌";
                break;
            case 2:
                lastbet = "빠";
                break;
        }
        System.out.println(name + ">> 결정하였습니다");
        return lastbet;
    }
}

class Game{
    //필드
    private Scanner scanner;
    Player [] players = new Player[2];
    String owner = null;

    //생성자
    public Game(){
        scanner = new Scanner(System.in);
    }

    //사용자, 컴퓨터 생성
    public void createPlayer(){        
        System.out.print("선수 이름 입력 >> ");
        String PlayerName = scanner.nextLine();
        players[0] = new Human(PlayerName);

        //첫 시작은 사람
        owner = players[0].name;

        System.out.print("컴퓨터 이름 입력 >>");
        PlayerName = scanner.nextLine();
        players[1] = new Computer(PlayerName);

        System.out.println("2명의 선수를 생성 완료했습니다.");
    }

    //실행
    public void run(){
        System.out.println("* * * * * 묵 찌 빠 게 임 을 시 작 합 니 다 . * * * * * ");

        createPlayer();
        while(true){
            if (players[0].next().equals(players[1].next())) {
                System.out.println(players[0].name + ":" + players[0].lastbet + "," + players[1].name + ":" + players[1].lastbet);
                System.out.println(owner + "이(가) 이겼습니다.");
                System.out.println("게임을 종료합니다.");  
                break;
            } else if (players[0].lastbet.equals("묵")) {
                if (players[1].lastbet.equals("찌")){
                    System.out.println(players[0].name + ":" + players[0].lastbet + "," + players[1].name + ":" + players[1].lastbet);
                    owner = players[0].name;
                    System.out.println("오너가 " + owner + "(으)로 변경되었습니다.");
                } else {
                    System.out.println(players[0].name + ":" + players[0].lastbet + "," + players[1].name + ":" + players[1].lastbet);
                    owner = players[1].name;
                    System.out.println("오너가 " + owner + "(으)로 변경되었습니다.");
                }
            } else if (players[0].lastbet.equals("찌")) {
                if (players[1].lastbet.equals("빠")){
                    System.out.println(players[0].name + ":" + players[0].lastbet + "," + players[1].name + ":" + players[1].lastbet);
                    owner = players[0].name;
                    System.out.println("오너가 " + owner + "(으)로 변경되었습니다.");
                } else {
                    System.out.println(players[0].name + ":" + players[0].lastbet + "," + players[1].name + ":" + players[1].lastbet);
                    owner = players[1].name;
                    System.out.println("오너가 " + owner + "(으)로 변경되었습니다.");
                }
            } else if (players[0].lastbet.equals("빠")) {
                if (players[1].lastbet.equals("묵")){
                    System.out.println(players[0].name + ":" + players[0].lastbet + "," + players[1].name + ":" + players[1].lastbet);
                    owner = players[0].name;
                    System.out.println("오너가 " + owner + "(으)로 변경되었습니다.");
                } else {
                    System.out.println(players[0].name + ":" + players[0].lastbet + "," + players[1].name + ":" + players[1].lastbet);
                    owner = players[1].name;
                    System.out.println("오너가 " + owner + "(으)로 변경되었습니다.");                    
                }
            }
        }
    }
}

public class MGPApp{
    //메인함수는 실행만 시킴
    public static void main(String[] args){
        new Game().run();
    }
}
