# 미션 - 자동차 경주 게임

> 우아한테크코스 : 프리코스 2주차 미션 '자동차 경주 게임'을 구현한 프로젝트입니다.

* n대의 자동차 이름 및 이동 시도 회수를 입력하면 자동차 경주를 진행하는 게임 프로그램입니다.
* 각 회차별 주행 상황 및 최종 우승자 명단을 콘솔에 출력합니다.
* 세부 프로그래밍 요구사항은 [java-racingcar-precourse](https://github.com/woowacourse/java-racingcar-precourse) 저장소의 README 파일을 준수했습니다.
* 미션을 진행하면서 고민했던 내용들을 개인적으로 공부해보고 [블로그](https://xlffm3.github.io/java/etc/Woowacourse_precourse_racing/) 에 정리해보았습니다.

<br>

## 구현 기능 목록

* [x] 경주할 자동차 이름을 입력받는다.
    * 입력받을 때 쉼표(,)를 기준으로 구분한다.
    * 각 자동차 이름 문자열 좌우 양 끝의 공백을 제거해준다. (" 박 홍 " -> "박 홍")
    * 다음과 같은 자동차 이름 예외에 해당하는 경우, 에러 메시지를 띄우고 재입력을 받는다.
        * 자동차 이름이 5글자 초과인 경우.
        * 자동차 이름이 1글자 미만인 경우. (빈 문자열)
        * 자동차 이름이 모두 공백(White Space)으로만 이루어진 경우. (ex: " ", "  ", " \t \t")
        * 자동차 이름들 중에 중복이 존재하는 경우.
        * 자동차 이름 입력값에 **연속된 쉼표**가 있는 경우(",,,").
            * 쉼표 사이 자동차 이름이 없는 예외로 인식한다.
* [x] 프로그램은 아래의 테스트 케이스를 모두 "예외"로 인식해야 하지만, 일부를 "정상"으로 인식하는 오류가 있다.
    * split을 사용하면, 입력값의 쉼표 패턴이 잘못됬음에도 정상적인 형태의(예외 검사에 걸리지 않는) 값을 반환하는 경우가 있다.
        * "," -> 크기가 0인 배열 []이 반환되어 예외 인식 실패.
        * "1,2,3," -> ["1", "2"]가 반환되어 예외 인식 실패.
        * "1,2,,,,," -> ["1", "2"]가 반환되어 예외 인식 실패.
        * "1,2,,,,,3" -> ["1", "2", "", "", "", "", "3"]가 반환되어 예외 인식 성공.
        * ",1,2,3" -> ["", "1", "2", "3"]가 반환되어 예외 인식 성공.
* [x] 이동 시도 회수를 입력받는다.
    * 다음과 같은 이동 시도 회수 예외에 해당하는 경우, 에러 메시지를 띄우고 재입력을 받는다.
        * 입력값이 숫자가 아닌 경우.
        * 입력값이 1 미만의 숫자인 경우.
* 이동 시도 회수만큼 반복문을 돌며 다음과 같은 로직을 수행한다.
    * 랜덤값을 활용하여, n대의 자동차 각각에 대해 전진 작업을 요청한다.
        * 0에서 9 사이에서 random 값을 구한 후, random 값이 4 이상일 경우에만 전진한다.
        * 3이하의 값이라면 전진하지 않는다.
    * 현재 회차의 주행 결과를 콘솔에 출력한다.
        * DTO를 활용한다.
* 경주가 종료되면 가장 멀리 움직인 자동차의 거리를 확인한다.
* 해당 거리만큼 이동한 자동차를 모두 우승자로 간주한다.
* 우승자로 간주되는 자동차 명단을 콘솔에 출력한다.
    * 우승자는 1명 혹은 여러 명이 될 수 있다.

<br>

## 🚀 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

<br>

## ✍🏻 입출력 요구사항
### ⌨️ 입력
- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```
pobi,woni,jun
```
- 시도할 회수
```
5
```

### 🖥 출력
- 각 차수별 실행 결과
```
pobi : --
woni : ----
jun : ---
```
- 단독 우승자 안내 문구
```
최종 우승자: pobi
```
- 공동 우승자 안내 문구
```
최종 우승자: pobi, jun
```
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR] 로 시작해야 한다.
```
[ERROR] 시도 횟수는 숫자여야 한다.
```

### 💻 프로그래밍 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자: pobi, jun
```
