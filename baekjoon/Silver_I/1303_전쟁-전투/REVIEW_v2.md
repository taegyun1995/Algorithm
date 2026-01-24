# 백준 1303번: 전쟁 - 전투 리뷰 (v2)

| 구분 | 내용 |
|:---:|:---|
| 파일 | P1303_v2.java |
| 날짜 | 2026-01-24 |
| 알고리즘 | `DFS (스택 기반)` |
| 자료구조 | `2차원 배열`, `Stack` |
| 시간복잡도 | O(N×M) |
| 공간복잡도 | O(N×M) |

**개선된 점**
- `s.charAt(j)` 수정 ✅
- power 초기값 0으로 수정 ✅
- `else if` 사용 ✅

**결과: 정답 코드**

로직상 문제 없음. 제출 가능.

**선택적 개선 (코드 스타일)**

1. **power 파라미터 제거 가능**
   - dfs 내부에서 지역 변수로 선언해도 됨
   - 현재: `dfs(row, col, target, 0)` → `int power = 0;` 후 리턴

2. **target 파라미터 제거 가능**
   - `BOARD[row][col]`로 시작점 색상 알 수 있음
   - dfs 내부에서 `char target = BOARD[row][col];` 사용

3. **b_power * b_power**
   - `Math.pow()` 대신 직접 곱셈이 더 빠름
   - `(int) Math.pow(b_power, 2)` → `b_power * b_power`

위 사항들은 선택적이며 현재 코드로도 정답 처리됨.
