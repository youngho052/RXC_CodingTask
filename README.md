# RXC_CodingTask

## 과제

아래의 요구사항을 적용한 상품 위시리스트 페이지를 Design Guide에 맞추어 구현합니다.

**요구사항**

- Compose가 아닌 **Android View**로 화면 구성
- 상품 이미지 : 1:1 비율로 노출
- 한 줄에 상품 2개씩 노출
- 상품명이 길어질 경우, ...으로 노출
- 좋아요 영역 : 설정 / 해제 기능 구현

## • API

상품 목록 조회

```json
[
    {
        "brandName" : "온호프",
        "discountRate" : 0,
        "consumerPrice" : 47000,
        "name" : "바디케어 2종 쏘 컴포트 (리퀴드솝,바디로션)",
        "price" : 47000,
        "thumbnailUrl" : "https:\/\/cdn-image.prizm.co.kr\/goods\/20220401\/73c5e0b1-d61f-43ef-a992-7c5f9a818393.jpeg"
    },
...
]
```
