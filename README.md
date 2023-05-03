# Kurly 과제


## 과제 내용

### 사전 과제
사용자가 입력한 검색어를 이용하여 GitHub 에서 리포지토리를 검색하고, 결과를 목록으로 표시해야 합니다.

### 요구 사항
#### 작업 방식
- GitHub 의 Issues 를 이용하여 이슈 기반으로 작업을 진행해야 합니다. (이슈 작성, 커밋 관리 등)

#### 개발
- 리포지토리 검색 시, GitHub 의 Search API (https://developer.github.com/v3/search/) 를 이용해야 합니다.
- Swift (iOS) 또는 Kotlin (Android) 으로 작성해야 합니다.
- 화면 구성 시 편한 방법을 사용해주세요.
- 라이브러리 사용을 권장합니다.

---

## 개발 요약

### 아키텍처 구조
- MVVM + Clean Architecture

### 주요 사용 기술
- [Okhttp](https://square.github.io/okhttp/) + [Retrofit](https://square.github.io/retrofit/)
- [Serialization](https://kotlinlang.org/docs/serialization.html)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=ko)
- [Coil](https://coil-kt.github.io/coil/)
- [Compose](https://developer.android.com/jetpack/compose?hl=ko)

### 모듈
- app
- data
- domain
- features
- designsystem

### 브랜치 전략
- Git-Flow

### 자동화
- github action
  - build check
  - auto release tag
