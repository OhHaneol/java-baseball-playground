## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

# 📍단위 테스트 실습

## 0. 학습테스트 실습

### String 클래스에 대한 학습 테스트

- assertThatThrownBy()

  - [[Java] AssertJ 기본](https://velog.io/@j3beom/Java-AssertJ-%EA%B8%B0%EB%B3%B8)

### Set Collection에 대한 학습 테스트

- `@ParameterizedTest`를 이용한 중복 코드 제거

  - `@ValueSource`

    - 테스트 메서드에 필요한 파라미터의 개수가 **한 개**일 때 사용한다.

    - [Junit - Parameterized Test (변수 테스트)](https://tommykim.tistory.com/19)

  - `@CsvSource`

    - 테스트 메서드에 필요한 파라미터의 개수가 **두 개 이상**일 때 사용한다.

  - `@ParameterizedTest`의 `name` 속성

    - name 속성에 대해 `{파라미터 인덱스}` 를 사용하여 테스트 케이스별 설명을 추가한다.

    - [[JUnit5] 중복되는 테스트 코드 줄이기](https://yeonyeon.tistory.com/198)

## 1. 문자열 계산기

- JUnit 테스트 내부에서 사용자 입력 받기

  - [[Java] JUnit으로 System.in, System.out 테스트하기 deep dive](https://steadyjay.tistory.com/10)

## 2. 숫자 야구 게임 구현

### 기능 명세

- main 함수
  - do-while 문 내부
    - 먼저 `numberBaseballGame` 을 호출한다.
    - 이후 새로 시작할지를 입력하라는 메시지를 출력하고, 사용자의 입력을 받는다.
  - do-while 문 조건
    - 게임을 새로 시작하는 1일 경우에만 진행한다.
  
- `numberBaseballGame` 함수를 만든다.
  - 컴퓨터가 세 자리의 난수 `random` 을 생성한다.
  - do-while 문 내부
    - 세 자리 숫자 `guessNum` 을 입력받는다.
    - 힌트 함수를 모두 호출한다.
    - `isStrike` 함수의 반환값을 `is3strike` 변수에 저장한다.
  - do-while 문 조건
    - `is3strike` 가 false일 경우에만 진행한다.
    
- 힌트 함수
  - 스트라이크, 볼, 낫싱에 대한 힌트 문자열을 return 하는 함수를 각각 구현한다.
    - `isStrike` 함수
      - `n스트라이크`를 출력한다.
      - 3스트라이크에 해당할 경우, true 를 반환한다.
    - `isBall` 함수
      - `n볼`을 출력한다.
      - 기본적으로 void 를 반환한다.
    - `isNothing`
      - `낫싱`을 출력한다.
      - 기본적으로 void 를 반환한다.