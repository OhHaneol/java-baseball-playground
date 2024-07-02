# [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 📍 학습 효과를 높이기 위해 추천하는 미션 진행 방법

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

---

## 📍 설계 방법 선택

### 1. 도메인 지식이 있는 경우

1. 요구사항 분석을 통한 대략적인 설계
    - 객체를 추출한다.
2. UI, DB 등과 의존관계를 가지지 않는 핵심 도메인 영역을 집중 설계
   - 일차적으로, MVC 기반에서 Model 에 해당하는 도메인 로직에 대한 단위 테스트에 집중한다.

### 2. 초보자의 경우

- 구현할 기능 목록을 작성한 후에 TDD로 도전한다.

## 📍 설계 시작

### 기능 목록

- 1~9의 숫자 중 랜덤으로 3개의 숫자를 구한다 
- 사용자로부터 입력 받는 3개 숫자 예외 처리
  - 1~9의 숫자인가?
  - 중복 값이 있는가?
  - 3자리인가? 
- 위치와 숫자 값이 같은 경우 - 스트라이크 
- 위치는 다른데 숫자 값이 같은 경우 - 볼 
- 숫자 값이 다른 경우 - 낫싱 
- 사용자가 입력한 값에 대한 실행 결과를 구한다
