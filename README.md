## 대기질 및 건강 데이터 융복합형 사회적 약자 맞춤형 외출 안내 서비스

<div align="center">
<img src="https://github.com/706com/Nalsam/assets/104816530/9be9f2b7-c760-4561-8ddb-4309dac44d26" width=500>
</div>

> **한이음 공모전**  
**개발기간: 2023.03 ~ 2023.10**

## 백엔드 개발팀 소개

|                 이름                 |  역할  |                                담당                                |                                                                                                               
|:----------------------------------:|:----:|:----------------------------------------------------------------:|
|  [곽동현](https://github.com/706com)  | [BE] |    회원 / 로그인 서비스 / 대기질,날씨 제공 서비스 / JWT - Spring Security / 배포     |
|  [오정훈](https://github.com/5jeong)  | [BE] |                       대기질,날씨 서비스 / 챗 봇 서비스                       |
| [박성배](https://github.com/bae-0420) | [BE] |             Android 웹앱 개발 / Arduino / 대기질,날씨 제공 서비스              |

### 프로젝트 소개

사회적 약자(기저 질환자)의 건강(질병, 나이, 성별, 산소포화도)를 바탕으로 사용자 거주 동네의   
지역별 대기질, 날씨 등의 데이터를 융복합 분석하여 개인 맞춤형 외출 안내를 해주는 서비스

### 개발 배경 및 필요성

▪ 대기오염이 사회적 약자(노인, 천식, 비염, 폐렴 등의 호흡기 질환자)와 같은 취약계층을 중심으로 심각한 건강상의 결과를 초래할 수 있다는 점에 뿌리를 두고 있음.
▪ 현재 미세먼지는 안전한 도시 생활을 함에 있어서 누구에게나 대중적으로 중요하게 생각되는 위험 인자로 인식되고 있지만, 미세먼지와 초미세먼지 이외에 아황산가스, 오존, 이산화질소 등과 같은 오염물질은 대부분 위험인자로 인식하고 있지는 않음.

### 기대 효과

- 사회적 약자(고령자, 호흡기질환자)에게 효과적이면서 개인 맞춤형인 외출 안내 서비스를 제공
- 사용자에게 대기 오염의 노출을 최소화하고 관련 건강 문제의 위험성을 줄여줌으로써 삶의 질 향상을 기대
- 녹색 환경에 주의를 기울이는 현 시대에서 건강한 삶을 위해 대중들이 관심을 가지는 사회 분위기 조성

---

## Technical Stacks 🐈

### Environment
- **Web BackEnd** : `Java 11`, `Spring Boot 2.7.6`, `JPA`, `MySql`
- **Web FrontEnd** : `React` , `HTML/CSS/JS` , `Node.JS`
- **Versioning** : `Git`, `GitLab(feature branch)`, `Notion(API 명세서)`
- **Infra** : `AWS-Cloud (EC2 - Ubuntu)` , `RDS` , `Nginx`, `SSL`
- **Design Pattern** : `MVC`, `Builder`
---

## 화면 구성 📺
|                                                          메인 페이지                                                          |                                                         외출 안내 기능                                                         |
|:------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------:|
| <img width="329" src="https://github.com/706com/Algorithm_Study/assets/104816530/8ce9e466-dda8-4343-a5d6-a2eff1056efb"/> | <img width="329" src="https://github.com/706com/Algorithm_Study/assets/104816530/9169c084-3277-4448-bf65-a6a541ba977d"/> |  
|   실시간 날씨(예보) / 대기질 정보 제공 기능 |  챗 봇 기능  |  
| <img width="329" src="https://github.com/706com/Algorithm_Study/assets/104816530/1fff3dd3-896a-4c3c-99e8-19f3c25b3e8c"/> | <img width="329" src="https://github.com/706com/Algorithm_Study/assets/104816530/710b6ddf-0b47-4f51-9838-0ba577967b10"/> |

---

## 주요 기능 📦

### ⭐️ 개인별 상태를 바탕, 대기질 지수를 융복합하여 사회적 맞춤형 외출 안내 기능

- 사용자 데이터 (개인정보,건강,위치) / 실기간 데이터(대기질, 날씨) 등의 종합 데이터를 고려하여 개인 맞춤형 외출 안내 시스템 제공
- 신호등 디자인을 채택하여 시각적 편의성 제공
- 융복합 알고리즘 개발 및 적용
- 사용자 데이터 중 체내 산소포화도/심박수 데이터는 블루투스 모듈(HM-10)과 산소포화도 모듈(MAX-30102)를 탑재하여 데이터 추출.

### ⭐️ 사용자가 거주하는 지역의 대기질 정보를 제공하고, 해당 지역의 대기질 수준에 따라 외출 가능성을 안내하는 기능

- 사용자로부터 실시간 위치 데이터를 받아 가장 가까운 측정소의 데이터 제공
- 대기질 수치(좋음,보통,나쁨,매우나쁨)에 따른 색상/표정 디자인으로 시각적 편의성 제공

### ⭐️ 대기질, 건강과 관련된 다양한 정보를 제공하는 챗 봇 기능

- Chat GPT API를 활용한 질문에 따른 답변 제공 
- 사전 질문 버튼리스트를 제공하여, 질문 및 답변 속도/정확성 최적화 

## Versioning ✅

### 기능 구현 Ver1.0 
#### [ 2023.03 ~ 2023.10 ]

|            기능            |            기간             |            내용            |
|:------------------------:|:-------------------------:|:------------------------:|
|         로컬 서버 구축         |        [ 2023-04 ]        |                          |
|      대기질 API 기능 개발       |        [ 2023-05 ]        |   실시간 대기질 Open API 활용    |
|         회원 기능 구현         |        [ 2023-05 ]        |       User CRUD 적용       |
|     실시간 날씨 API 기능 개발     |        [ 2023-06 ]        |    실시간 날씨 Open API 활용    |
|       웹 서버 배포 및 연동       | [ 2023-06 ] ~ [ 2023-07 ] |                          |
|     아두이노 연결 및 API 구현     |        [ 2023-07 ]        |  체내 산소포화도,심박수 측정 데이터 추출  |
|       로그인 세션 기능 구현       |        [ 2023-07 ]        |         HTTP 서블렛         |
|    배포 CI/CD 파이프라인 구축     |        [ 2023-08 ]        |                          |
| JWT / Spring Security 적용 | [ 2023-07 ] ~ [ 2023-08 ] | Session -> Token 방식으로 변경 |
|       날씨 예보 API 구현       |        [ 2023-09 ]        |                          |
|    대기질,날씨 API 캐시기능 구현    |        [ 2023-09 ]        |                          |
|      챗 봇 API 기능 구현       |        [ 2023-09 ]        |       GPT 성능 업그레이드       |
|      융복합 데이터 API 구현      | [ 2023-06 ] ~ [ 2023-10 ] |                          |
|         프로젝트 종료          | [ 2023-03 ] ~ [ 2023-10 ] |                          |

### 기능 구현 Ver2.0 
#### [2024.01 ~ ]

|       기능        |               기간                |         내용         |
|:---------------:|:-------------------------------:|:------------------:|
| 프로젝트 KPT 회고 시작  | [ 2024-01-13 ] ~  |    |
| RESTful API로 변경 | [ 2024-02-14 ] ~ [ 2024-02-15 ] |  REST API 학습 및 적용  |
| Builder 패턴 리팩토링 | [ 2024-02-14 ] ~ [ 2024-02-15 ] | 무분별한 Builder 패턴 삭제 |
|                 |                                 |                    |
---
## Architecture

### 디렉토리 구조

```bash
├─main
│  ├─generated
│  ├─java
│  │  └─com
│  │      └─example
│  │          └─nalsam
│  │              │  NalsamApplication.java
│  │              │  
│  │              ├─airquality
│  │              │  ├─api
│  │              │  │      AirQualityApi.java
│  │              │  │      AirQualityApiCaller.java
│  │              │  │      AirQualityData.java
│  │              │  │      
│  │              │  ├─controller
│  │              │  │      AirQualityController.java
│  │              │  │      
│  │              │  ├─domain
│  │              │  │      StationLocation.java
│  │              │  │      
│  │              │  ├─dto
│  │              │  │      AirQualityInfo.java
│  │              │  │      
│  │              │  ├─repository
│  │              │  │      StationLocationRepository.java
│  │              │  │      
│  │              │  ├─service
│  │              │  │      AirQualityService.java
│  │              │  │      StationLocationService.java
│  │              │  │      
│  │              │  └─util
│  │              │          AirQualityGrade.java
│  │              │          AirQualityGradeUtil.java
│  │              │          DateUtil.java
│  │              │          
│  │              ├─arduino
│  │              │  ├─controller
│  │              │  │      ArduinoController.java
│  │              │  │      
│  │              │  ├─domain
│  │              │  │      Arduino.java
│  │              │  │      HealthData.java
│  │              │  │      
│  │              │  ├─repository
│  │              │  │      ArduinoRepository.java
│  │              │  │      
│  │              │  └─service
│  │              │          ArduinoService.java
│  │              │          
│  │              ├─chatbot
│  │              │  ├─controller
│  │              │  │      ChatController.java
│  │              │  │      
│  │              │  ├─domain
│  │              │  │      Choice.java
│  │              │  │      Message.java
│  │              │  │      Usage.java
│  │              │  │      
│  │              │  ├─dto
│  │              │  │  ├─request
│  │              │  │  │      AirQualityRequest.java
│  │              │  │  │      ChatRequest.java
│  │              │  │  │      HealthRequest.java
│  │              │  │  │      PlaceRecommend.java
│  │              │  │  │      QuestionRequest.java
│  │              │  │  │      SymtomCaution.java
│  │              │  │  │      
│  │              │  │  └─response
│  │              │  │          ChatResponse.java
│  │              │  │          
│  │              │  ├─infrastructure
│  │              │  │      ChatCompletionClient.java
│  │              │  │      
│  │              │  └─service
│  │              │          ChatCompletionService.java
│  │              │          ChatService.java
│  │              │          
│  │              ├─config
│  │              │      WebMvcConfig.java
│  │              │      WebSecurityConfig.java
│  │              │      
│  │              ├─convergence
│  │              │  ├─controller
│  │              │  │      ConvergenceController.java
│  │              │  │      
│  │              │  ├─domain
│  │              │  │      Convergence.java
│  │              │  │      
│  │              │  ├─dto
│  │              │  │      ConvergenceData.java
│  │              │  │      ConvergenceRequest.java
│  │              │  │      ConvergenceResponse.java
│  │              │  │      
│  │              │  ├─repository
│  │              │  │      ConvergenceRepository.java
│  │              │  │      
│  │              │  └─service
│  │              │          AirQualityScore.java
│  │              │          ConvergenceService.java
│  │              │          HealthScore.java
│  │              │          StatusScore.java
│  │              │          WeatherScore.java
│  │              │          
│  │              ├─exception
│  │              │      GlobalExceptionHandler.java
│  │              │      
│  │              ├─user
│  │              │  ├─controller
│  │              │  │      UserController.java
│  │              │  │      
│  │              │  ├─domain
│  │              │  │      Users.java
│  │              │  │      
│  │              │  ├─dto
│  │              │  │  │  SessionConst.java
│  │              │  │  │  
│  │              │  │  ├─request
│  │              │  │  │      LoginRequest.java
│  │              │  │  │      UserDeletionRequest.java
│  │              │  │  │      UserPasswordRequest.java
│  │              │  │  │      UserRequest.java
│  │              │  │  │      
│  │              │  │  └─response
│  │              │  │          UserResponse.java
│  │              │  │          
│  │              │  ├─exception
│  │              │  │      PasswordNotCorrectException.java
│  │              │  │      UserAlreadyExistException.java
│  │              │  │      UserNotFoundException.java
│  │              │  │      
│  │              │  ├─jwt
│  │              │  │      CustomUserDetailService.java
│  │              │  │      JwtAuthenticationFilter.java
│  │              │  │      JwtTokenProvider.java
│  │              │  │      LoginController.java
│  │              │  │      LoginService.java
│  │              │  │      Token.java
│  │              │  │      
│  │              │  ├─repository
│  │              │  │      UserRepository.java
│  │              │  │      
│  │              │  └─service
│  │              │          UserService.java
│  │              │          
│  │              └─weather
│  │                  ├─api
│  │                  │      CurrentWeatherApi.java
│  │                  │      CurrentWeatherApiCaller.java
│  │                  │      CurrentWeatherData.java
│  │                  │      WeatherForecastApi.java
│  │                  │      WeatherForecastApiCaller.java
│  │                  │      WeatherForecastData.java
│  │                  │      
│  │                  ├─controller
│  │                  │      WeatherController.java
│  │                  │      
│  │                  ├─domain
│  │                  │      LocationInfo.java
│  │                  │      
│  │                  ├─dto
│  │                  │      WeatherDto.java
│  │                  │      WeatherForecastDto.java
│  │                  │      
│  │                  ├─repository
│  │                  │      LocaionInfoRepository.java
│  │                  │      
│  │                  ├─service
│  │                  │      LocationInfoService.java
│  │                  │      WeatherService.java
│  │                  │      
│  │                  └─util
│  │                          WeatherCategory.java
│  │                          WeatherCategoryUtil.java
│  │                          
│  └─resources
│      │  application-API-KEY.properties
│      │  application.properties
│      │  
│      └─static
└─test
    └─java
        └─com
            └─example
                └─nalsam
                        NalsamApplicationTests.java
                        

```

