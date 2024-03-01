## 대기질 및 건강 데이터 융복합형 사회적 약자 맞춤형 외출 안내 서비스

<div align="center">
<img src="https://github.com/706com/Nalsam/assets/104816530/9be9f2b7-c760-4561-8ddb-4309dac44d26" width=500>
</div>

> **한이음 공모전**  
**개발기간: 2023.03 ~ 2023.10**

## 백엔드 개발팀 소개

|                 이름                 |  역할  |                        담당                         |                                                                                                               
|:----------------------------------:|:----:|:-------------------------------------------------:|
|  [곽동현](https://github.com/706com)  | [BE] | 회원 / 로그인 서비스 구현 / Open API / Spring Security / 배포 |
|  [오정훈](https://github.com/5jeong)  | [BE] |                대기질,날씨 / 챗 봇 서비스 구현                |
| [박성배](https://github.com/bae-0420) | [BE] |              Android 웹앱 개발 / Arduino              |

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
- **Web FrontEnd** : `React` , `HTML/CSS/JS`
- **Versioning** : `Git`, `GitLab(feature branch)`, `Notion(API 명세서)`
- **Infra** : `AWS-Cloud (EC2 - Ubuntu)` , `RDS` , `Nginx`, `SSL`
- **Design Pattern** : `MVC`, `Builder`
---

## 화면 구성 📺
| 메인 페이지  |  소개 페이지   |
| :-------------------------------------------: | :------------: |
|  <img width="329" src="https://user-images.githubusercontent.com/50205887/208036155-a57900f7-c68a-470d-923c-ff3c296ea635.png"/> |  <img width="329" src="https://user-images.githubusercontent.com/50205887/208036645-a76cf400-85bc-4fa2-af72-86d2abf61366.png"/>|  
| 강좌 소개 페이지   |  강의 영상 페이지   |  
| <img width="329" src="https://user-images.githubusercontent.com/50205887/208038737-2b32b7d2-25f4-4949-baf5-83b5c02915a3.png"/>   |  <img width="329" src="https://user-images.githubusercontent.com/50205887/208038965-43a6318a-7b05-44bb-97c8-b08b0495fba7.png"/>     |

---

## 주요 기능 📦

### ⭐️개인별 상태(건강, 나이, 성별등)등을 사회적 약자가 시각적으로 쉽게 볼 수 있도록 형태 분석하여 데이터를 제시하는 기능(이미지, 아이콘 등)

- ~~Scratch, Python 2개 강좌 및 각 강좌마다 10개 가량의 강의 영상 제공~~
- ~~추후 지속적으로 강좌 추가 및 업로드 예정~~

### ⭐️ 개인별 상태를 바탕, 대기질 지수를 융복합하여 사회적 맞춤형 외출 안내 기능

- ~~Disqus를 이용하여 강의 관련 질문이나 단체에 대한 질문 작성 가능~~

### ⭐️ 사용자가 거주하는 지역의 대기질 정보를 제공하고, 해당 지역의 대기질 수준에 따라 외출 가능성을 안내하는 기능

- ~~Cookie 기능을 이용하여 이전에 학습했던 내용 이후부터 바로 학습 가능~~

### ⭐️ 대기질, 건강과 관련된 다양한 정보를 제공하는 챗 봇 기능

- 

## Versioning ✅

### 기능 구현 Ver1.0 
#### [ 2023.03 ~ 2023.10 ]

|                 기능                 |  기간  | 내용  |
|:----------------------------------:|:----:|:---:|
|    |  |     |
|    |  |     |
|  |  |     |

### 기능 구현 Ver2.0 
#### [2024.01 ~ ]

|                 기능                 |  기간  | 내용  |
|:----------------------------------:|:----:|:---:|
|    |  |     |
|    |  |     |
|  |  |     |
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

