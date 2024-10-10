# hhplus-concert-server

항해99 벡엔드 플러스 서버 구축 과제

## 🧰 Info

- 시나리오: 콘서트 예약 서비스
  - 대기열을 이용한 시스템 구축
  - 대기열, 좌석 예약, 포인트 이용 등 주요한 기능
- 일자: 2024.10.04 -
- 기술 스택:
  - Java 21
  - Postgresql 16.3
  - Spring Boot 3.3.4

## 🔖 목차

1. [Milestone](https://github.com/nashs789/hhplus-concert-server/tree/step05?tab=readme-ov-file#-milestone-%EB%B0%94%EB%A1%9C%EA%B0%80%EA%B8%B0)
2. [Timeline](https://github.com/nashs789/hhplus-concert-server/tree/step05?tab=readme-ov-file#%EF%B8%8F-timeline-%EB%B0%94%EB%A1%9C%EA%B0%80%EA%B8%B0)
3. [Sequence Diagram](https://github.com/nashs789/hhplus-concert-server/tree/step05?tab=readme-ov-file#-sequence-diagram)
4. [Flow Chart](https://github.com/nashs789/hhplus-concert-server/tree/step05?tab=readme-ov-file#-flow-chart)

---

## 🪧 Milestone [[바로가기]](https://github.com/nashs789/hhplus-concert-server/milestones)
<img width="1215" alt="스크린샷 2024-10-09 오후 6 40 02" src="https://github.com/user-attachments/assets/658a8212-2da8-42f6-8a78-443f004e7ed8">

## ⏲️ Timeline [[바로가기]](https://github.com/users/nashs789/projects/4/views/5)
<img width="1914" alt="스크린샷 2024-10-09 오후 6 40 14" src="https://github.com/user-attachments/assets/f9323f51-3d49-4f60-b2a8-7d2e138ab45d">

## 📕 Sequence Diagram

```mermaid
sequenceDiagram
    actor Client
    participant Concert
    participant Token
    participant Queue
    participant Seat
    participant Ticket
    participant Payment
    participant Point

    activate Client
    Note over Client, Concert: 콘서트 API
    Client ->>+ Concert: 콘서트 가능한 목록 조회
    Concert ->> Concert: 예약 가능 날짜 목록 조회
    Note over Concert, Concert: Concert Schedule 조회
    Concert -->>- Client: 예약 가능한 콘서트 목록 반환
    deactivate Client

    loop Polling
        Note over Client, Token: 대기열 토큰 API
        Client -)+ Token: 토큰 발급 요청
        Token -) Token: 토큰 삭제 스케줄러(10 min)
        Token -) Queue: 토큰 생성 및 대기열 삽입 요청
        
        alt SUCCESS
            Queue --) Token: 토큰 발급 & 리턴
        else EXIST
            Queue --) Token: 기존 토큰 리턴
        else FAIL
            Queue --) Token: 생성 실패
        end

        Token --)- Client: 토큰 발급 응답

        break 성공 반환시 루프 종료
            Token ->+ Client: 다음 예약 진행
        end
    end

    activate Client
    Note over Client, Seat: 좌석 API
    Client ->>+ Seat: 좌석 예약 요청
    Seat ->>- Queue: 대기열 확인
    activate Queue
    Queue -->>+ Seat: 대기열 상태 반환
    deactivate Queue
    Seat ->>- Concert: 예약 가능한 콘서트인지 확인 요청
    activate Concert
    Concert -->> Seat: 예약 가능한 콘서트 확인 응답
    deactivate Concert
    Seat ->>+ Seat: 예약 가능한 좌석인지 조회(Lock)

    alt 예약 가능 좌석
        Seat ->>- Ticket: 결제 미완료 티켓 생성
        activate Ticket
        Ticket ->>+ Payment: 결제 정보 생성
        deactivate Ticket
        Payment -->>- Ticket: 결제 정보 반환
        activate Ticket
        Ticket -->> Client: 결제 정보 반환
        deactivate Ticket
    else 예약 불가능 좌석
        Seat -->> Client: 좌석 예약 불가능 리턴
    end
    
    Note over Client, Point: 포인트 API
    Client ->> Point: 포인트 충전 요청
    activate Point
    Point ->> Point: 유저 포인트 조회(Lock)
    Point ->> Point: 유저 포인트 충전
    Point -->> Client: 충전 결과 반환
    deactivate Point

    Note over Client, Payment: 결제 API
    Client ->>+ Payment: 결제 요청
    Payment ->> Payment: 결제 정보 조회(Lock)
    Payment ->>- Ticket: 티켓 조회 요청
    activate Ticket
    Ticket ->> Ticket: 티켓 조회(Lock)
    Ticket -->>+ Payment: 티켓 리턴
    deactivate Ticket
    Payment ->>- Point: 유저 현재 포인트 조회 요청
    activate Point
    Point ->> Point: 유저 현재 포인트 조회(Lock)
    Point -->>+ Payment: 유저 포인트 반환
    deactivate Point
    Payment ->>- Seat: 좌석 조회 요청
    activate Seat
    Seat ->> Seat: 좌석 조회(Lock)
    Seat -->>+ Payment: 좌석 반환
    deactivate Seat

    alt 보유 포인트 부족
        Payment -->> Client: 결제 실패 응답
    end

    Payment ->> Payment: 결제 성공
    Payment ->>- Point: 유저 현재 포인트 차감 요청
    activate Point
    Point ->> Point: 유저 현재 포인트 차감
    Point -->>+ Payment: 포인트 차감 여부 반환
    deactivate Point

    Payment ->>- Ticket: 티켓 업데이트 요청
    activate Ticket
    Ticket ->> Ticket: 티켓 업데이트
    Ticket -->>+ Payment: 티켓 업데이트 결과 반환
    deactivate Ticket

    Payment ->>- Seat: 좌석 상태 변경 요청
    activate Seat
    Seat ->> Seat: 좌석 상태 변경
    Seat -->>+ Payment: 좌석 상태 변경 결과 반환
    deactivate Seat

    Payment ->>- Token: 토큰 만료 요청
    activate Token
    Token ->> Token: 토큰 만료
    Token -->>+ Payment: 토큰 만료 결과 반환
    deactivate Token
    
    Payment -->>- Client: 결제 결과 반환

    deactivate Client
```

## 📗 Flow Chart

```mermaid
flowchart TD
    start["Start"]
    Q1{"예약가능콘서트조회"}
    Q2{"대기열에 유저 토큰 존재"}
    Q3{"예약 가능한 좌석 조회"}
    Q4{"예약 가능한 콘서트 여부"}
    Q5{"토큰 대기열 유효성 여부"}
    Q6{"포인트가 충분히 보유 여부"}
    Q7{"결제 처리 결과"}
    terminate("End")

    start --> Q1
    Q1 -- 가능 --> A1[가능 결과 반환]
    Q1 -- 불가능 --> A2[불가능 결과 반환]
    
    A1 --> M1[콘서트 예약 요청]
    M1 --> Q2
    Q2 -- 토큰 존재 --> A3
    Q2 -- 토큰 없음 --> A4[토큰 생성]
    A4 --> M2[대기열에 토큰 추가]
    M2 --> A3

    A3[콘서트 이용 가능 좌석 조회]
    A3 --> Q3
    Q3 -- 좌석 존재 --> M3[좌석 예약 진행]
    Q3 -- 좌석 없음 --> M4[좌석 예약 불가능 반환]
    M3 --> Q4
    Q4 -- 예약 가능 --> Q5
    Q4 -- 예약 불가능 --> M5[좌석 예약 실패]
    Q5 -- 유효 토큰 --> M6[결제 정보 생성]
    Q5 -- 무효 토큰 --> M5[좌석 예약 실패]

    M6 --> Q6
    Q6 -- 충분 --> M7[결제 요청]
    Q6 -- 불충분 --> M8[포인트 충전]
    M8 --> M7

    M7 --> M9[결제, 티켓, 포인트, 좌석 조회]
    M9 --> Q7
    Q7 -- 결제 실패 --> M10[결제 실패 반환]
    Q7 -- 결제 성공 --> M11[결제, 티켓, 포인트, 좌석, 대기열 업데이트]
    M11 --> M12[결제 성공 반환]

    M10 --> terminate
    M12 --> terminate

```

## 🗃️ ERD

```mermaid
erDiagram
    USER {
        bigint user_id PK "유저 아이디"
        string name "유저 이름"
        datetime create_at "유저 생성일"
        datetime update_at "유저 수정일"
    }

    QUEUE {
        bigint queue_id PK "uuid"
        bigint user_id FK "유저 아이디"
        string status "토큰 상태(대기/시간 만료/예약 완료)"
        datetime create_at "토큰 생성일"
        datetime update_at "토큰 수정일"
    }

    CONCERT {
        bigint concert_id PK "콘서트 아이디"
        string title "콘서트 이름"
        string singer "가수"
        datetime create_at "콘서트 생성일"
        datetime update_at "콘서트 수정일"
    }

    SCHEDULE {
        bigint schedule_id PK "스케줄 아이디"
        bigint concert_id FK "콘서트 아이디"
        int capacity "콘서트 정원"
        int reservation_count "예약한 인원"
        int price "콘서트 가격"
        datetime start_time "예약 시작 날짜"
        datetime end_time "예약 종료 날짜"
        datetime create_at "스케줄 생성일"
        datetime update_at "스케줄 수정일"
    }

    SEAT {
        bigint seat_id PK "좌석 아이디"
        bigint schedule_id PK, FK "스케줄 아이디"
        bigint user_id PK, FK "유저 아이디"
        string status "좌석 상태(점유/미점유)"
        datetime create_at "좌석 생성일"
        datetime update_at "좌석 수정일"
    }

    TICKET {
        bigint ticket_id PK "티켓 아이디"
        bigint user_id PK, FK "유저 아이디"
        bigint seat_id FK "좌석 아이디"
        string status "티켓 상태(예약/취소/결제 완료)"
        datetime create_at "티켓 생성일"
        datetime update_at "티켓 수정일"
    }

    POINT {
        bigint point_id PK "포인트 아이디"
        bigint user_id PK, FK "유저 아이디"
        bigint point "포인트"
        datetime create_at "포인트 생성일"
        datetime update_at "포인트 수정일"
    }

    POINT_HISTORY {
        bigint point_history_id PK "이력 아이디"
        bigint point_id PK, FK "포인트 아이디"
        bigint type "사용 타입"
        bigint amount "사용 금액"
        bigint after_amount "사용 후 잔액"
        datetime create_at "이력 생성일"
        datetime update_at "이력 수정일"
    }

    PAYMENT {
        bigint payment_id PK "결제 아이디"
        bigint ticket_id PK, FK "티켓 아이디"
        string status "결제 상태(대기, 완료, 취소, 환불)"
        datetime paid_at "결제일"
        datetime create_at "결제 생성일"
        datetime update_at "결제 수정일"
    }

    USER ||--|| POINT: ""
    POINT ||--o{ POINT_HISTORY: ""
    CONCERT ||--o{ SCHEDULE: ""
    SCHEDULE ||--o{ SEAT: ""
    USER ||--o{ TICKET: ""
    USER ||--|| QUEUE: ""
    TICKET ||--|| SEAT: ""
    PAYMENT ||--|| TICKET: ""
```
