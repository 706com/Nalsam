# 대기질 및 건강 데이터 융복합형  사회적 약자 맞춤형 외출 안내 서비스

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

사회적 약자(기저 질환자)의 건강(질병, 나이, 성별, 산소포화도)를 바탕으로 사용자
거주 동네의 지역별 대기질, 날씨 등의 데이터를 융복합 분석하여 개인 맞춤형
외출 안내를 해주는 서비스입니다.

### 개발 배경 및 필요성

▪ 대기오염이 사회적 약자(노인, 천식, 비염, 폐렴 등의 호흡기 질환자)와 같은 취약계층을 중심으로 심각한 건강상의 결과를 초래할 수 있다는 점에 뿌리를 두고 있음.
▪ 현재 미세먼지는 안전한 도시 생활을 함에 있어서 누구에게나 대중적으로 중요하게 생각되는 위험 인자로 인식되고 있지만, 미세먼지와 초미세먼지 이외에 아황산가스, 오존, 이산화질소 등과 같은 오염물질은 대부분 위험인자로 인식하고 있지는 않음.

### 기대 효과

- 사회적 약자(고령자, 호흡기질환자)에게 효과적이면서 개인 맞춤형인 외출 안내 서비스를 제공.
- 사용자에게 대기 오염의 노출을 최소화하고 관련 건강 문제의 위험성을 줄여줌으로써 삶의 질 향상을 기대.
- 녹색 환경에 주의를 기울이는 현 시대에서 건강한 삶을 위해 대중들이 관심을 가지는 사회 분위기 조성. 

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

---
## Architecture

### 디렉토리 구조
```bash
├── README.md
├── package-lock.json
├── package.json
├── strapi-backend : 
│   ├── README.md
│   ├── api : db model, api 관련 정보 폴더
│   │   ├── about
│   │   ├── course
│   │   └── lecture
│   ├── config : 서버, 데이터베이스 관련 정보 폴더
│   │   ├── database.js
│   │   ├── env : 배포 환경(NODE_ENV = production) 일 때 설정 정보 폴더
│   │   ├── functions : 프로젝트에서 실행되는 함수 관련 정보 폴더
│   │   └── server.js
│   ├── extensions
│   │   └── users-permissions : 권한 정보
│   ├── favicon.ico
│   ├── package-lock.json
│   ├── package.json
│   └── public
│       ├── robots.txt
│       └── uploads : 강의 별 사진
└── voluntain-app : 프론트엔드
    ├── README.md
    ├── components
    │   ├── CourseCard.js
    │   ├── Footer.js
    │   ├── LectureCards.js
    │   ├── MainBanner.js : 메인 페이지에 있는 남색 배너 컴포넌트, 커뮤니티 이름과 슬로건을 포함.
    │   ├── MainCard.js
    │   ├── MainCookieCard.js
    │   ├── NavigationBar.js : 네비게이션 바 컴포넌트, _app.js에서 공통으로 전체 페이지에 포함됨.
    │   ├── RecentLecture.js
    │   └── useWindowSize.js
    ├── config
    │   └── next.config.js
    ├── lib
    │   ├── context.js
    │   └── ga
    ├── next.config.js
    ├── package-lock.json
    ├── package.json
    ├── pages
    │   ├── _app.js
    │   ├── _document.js
    │   ├── about.js
    │   ├── course
    │   ├── index.js
    │   ├── lecture
    │   ├── newcourse
    │   ├── question.js
    │   └── setting.js
    ├── public
    │   ├── favicon.ico
    │   └── logo_about.png
    └── styles
        └── Home.module.css

```

