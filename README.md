## 자바 객체지향 기초 - 축구게임

### 참조
쓰세요
1. 객체를 생성하고 초기화 하는 법
2. 메서드 생성과 객체에 메시지를 보내는 법
3. 추상클래스
4. 상속과 다형성
5. 캡슐화와 추상화

https://wikidocs.net/280

선택하세요
1. VO - https://jacobhboy66.tistory.com/19
2. 일급 컬렉션 - https://jojoldu.tistory.com/412

### 기능 요구사항
- 기본적으로 선수들은 이름을 가지고 있다.
- 공격수는 슛을 2개 찰 수 있다. 2개중 하나만 들어가도 골이다.
- 미드필더는 슛을 1개 찰 수 있다.
    - 공격수와 미드필더가 공을 찰 수 있는 범위는 0 ~ 10  이다.
      공격수의 이름은 이창보, 하현재이고 콤마로 구분해서 입력한다. 미드필더의 이름은 김호현, 김석진이다.
- 골키퍼는 슛 3 ~ 7 까지의 수 중 3개의 슛을 막을 수 있다.
    - 골키퍼의 이름은 오예스다.
- 매치포인트(어떤 선수가 이 점수에 다달았을 때 경기는 종료된다)를 입력받는다.
- 공격수가 골을 넣는 조건은 골키퍼와 겹치지 않는 값의 공을 차는 것이다. 0, 1, 9, 10은 공이 골대 밖으로 나간 것으로 이또한 골이 아니다.
- 매 턴마다 누가 골을 얼마나 넣었는지를 출력한다.
  - 모든 슈팅과 골키퍼가 막는 곳은 랜덤이다.
- 승자의 이름을 출력하고 프로그램은 종료된다.

### 콘솔

```java
공격수의 이름을 입력하세요: 이창보, 하현재
미드필더의 이름을 입력하세요: 김호현, 김석진
골키퍼의 이름을 입력하세요: 오예스
매치포인트를 입력하세요: 5

1번째 슈팅결과
이창보: -
하현재: -
김호현: -
김석진:

2번째 슈팅결과
이창보: -
하현재: —
김호현: —
김석진: - 

3번째 슈팅결과
이창보: -
하현재: —-
김호현: —
김석진: - 

4번째 슈팅결과
이창보: -
하현재: —-
김호현: —
김석진: - 

5번째 슈팅결과
이창보: —
하현재: ——
김호현: —
김석진: — 

6번째 슈팅결과
이창보: —
하현재: ——
김호현: —
김석진: —-

7번째 슈팅결과
이창보: —
하현재: ——-
김호현: —
김석진: —-

승리자는 하현재 입니다.
```
### 프로그래밍 요구사항

Indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
* 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
* 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.

else 예약어를 쓰지 않는다.
* 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
* switch/case도 허용하지 않는다.

### 기능 목록 및 commit 요구사항

* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    * 참고문서: AngularJS Commit Message Conventions
      AngularJS Commit Message Conventions 중
* commit message 종류를 다음과 같이 구분
```
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```

### 미션을 진행하는 법
1. Repository를 fork한다.
2. 자신의 깃허브 이름으로 branch를 생성한다.
3. 기능 요구사항을 보고, 기능을 구현할 때 마크다운에 체크를 한다.
4. 모두 구현한 후 pull request를 요청한다.
5. 코드리뷰 후 개선한다.
