# 끝말잇기 게임
## 문제 설명
- n명이 참가하는 끝말잇기 게임.
- 첫 단어는 아버지, 참가자들이 순서대로 단어를 입력함.
- 객체 배열 학습을 위한 프로그램.
  
## 코드 구조
- `Player` 클래스, 퍼블릭 WordGameApp클래스로 구성
- `Player` 클래스
  ```java
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
  ```
  - 필드
    - `String PlayerName`; : 참가자 이름
  - 메소드
    - `getWordFromUser()` : 참가자들에게 단어를 전달 받는 메소드
        - 변수: `nextChar`
        - 반환값: `nextChar`

- `WordGameApp()` 클래스
  - 필드
    - `String word` : 단어, 입력받은 문자에 따라 변환됨
  - 생성자
    - `WordGamdeApp()` : 첫번째 단어를 아버지로 초기화
  - 메소드
    - `run()` : 전반적인 게임을 실행하는 메소드
      - 지역변수:
        - n : 참가 인원 수
        - p : 객체 배열 래퍼런스
        - Success : 반복문을 위한 부울 변수
      - 반환값:
        - 객체 배열 `p`의 `PlayerName`
    - checkSuccess() : 끝말잇기 성공 여부를 판별하는 메소드
        - 지역변수:
          - `lastIndex`: 마지막 문자에 대한 인덱스
          - `lastChar`: 마지막 문자
          - `firstChar`: 다음 입력받은 문자의 첫 번째 문자
        - 반환값:
          - `true` or `flase`
    - 메인 메소드
      - 지역변수:
        - `looser`: 패배자 출력

## 실행 과정
1. 클래스 생성
    1. `WordGamdeApp` 생성자
    2. 필드변수 `word` 초기값을 아버지로 설정
2. `main()` 메소드
    1. `looser` 변수 생성
    2. `run()` 메소드 실행
3. `run()` 메소드
    1. 플레이어 수 n을 입력 받고 n만큼 객체 배열 p생성
    2. 객체 배열 p에 객체 생성 및 입력받은 플레이어 이름을 객체 배열 `p`에 추가
    3. `Success`변수 생성
    4. 게임 진행을 위한 while문 실행, 반복문 내에서 for문이 실행되고 `p[i].getWordFromUser()`의 반환값을 인자로 가지는 `checkSuccess()` 함수의 반환값을 `Success` 변수에 추가함
4. `getWordFromUser()` 메소드
    1. `PlayerName`에 따라 `nextChar` 입력 받고 `nextChar` 반환
5. `checkSuccess()` 메소드
    1. `nextChar`인자를 전달받고 word의 마지막 글자 변수와 `nextChar`의 첫 글자 변수 생성
    2. 두 변수를 비교해서 다르다면 false, 같다면 true 반환
6. `run()` 메소드 내의 while문
    1. `checkSuccess()` 메소드에서 반환된 값을 Success에 추가함
    2. for문 안에 있는 if문에서 `Success`가 참이면 continue, 거짓이면 `p[i].PlayerName` 반환
7. `main()` 메소드
    1. `looser` 변수에 `p[i].PlayerName`을 대입하고 출력함

## 느낀 점
- `Scanner` 객체를 생성할 때, 교수님의 코드에선 필드에서 레퍼런트를 선언하고 생성자에서 객체를 생성하는 방식으로 구현됨, 보기에 깔끔하고 사용도 편리해보임. 다음에 보완해야 할 부분.
- 또한 메인 메소드 부분에서, 내 코드는 `run` 메소드는 패배자를 반환하고 `main`에서 패배자를 출력했지만 교수님의 코드에서 메인 메소드는 `run` 메소드를 실행하는 역할만 함. 어떤 방식이 더 확장성이 있는지는 잘 모르겠음.
- 같은 단어 입력을 제한하기 위해 입력한 단어들을 배열에 저장하고, 입력시 검색을 하여 중복으로 인한 탈락을 구현하려 하였으나, 배열의 크기를 가변적으로 조절하는 방식이 가능한가에 대한 의문으로 구현하지 못하였음.
