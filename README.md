# Face-Recognition   
==================================================================   
얼굴인식을 통한 학교 홈페이지 자동 로그인   
By, SangWon Seon   

URL : https://seonsangwon.dev/face [진행예정]
------------------------------------------------------------------

IDE : Eclipse, Spring Tool Suite 3.9.12.RELEASE   
Database : MySQL 5.7.29   

2020.02.27
 - Spring <-> Python REST API 를 통해 사용자의 얼굴인식 결과 값을 전송
 - Python 의 Beautifulsoup Library 를 통한 파싱 보류 

2020.03.06
 - Spring <-> Java GUI Application <-> Python REST API 방식을 통해 진행
 
2020.03.09
 - Java GUI Application.exe 파일 배포 완료
 - Spring <-> Java GUI Application <-> Python REST API 연동 완료
 - Python 사용자 얼굴인식 구현 완료
 - 사이트 (메인 / 회원가입 / 로그인 / 관리자[일부]) 구현 완료
 - 로컬 PC 테스트 진행 : 완료

Windows10 -> Ubuntu 마이그레이션을 진행하며 문제사항 
 - Python 얼굴인식의 라이브러리 중 하나인 dlib 설치 에러
 - Python REST API 24시 가동 [AWS Lamda 를 이용하면 가능하다고 함]

2020.03.10
 - AWS -> Naver Cloud Platform 변경 예정
 - Ubuntu -> CentOS 변경 예정
 
2020.03.11
 - 도메인 추가 예정
 
2020.03.26
 - CentOS 에서 MySQL Root 문제로 인해 Ubuntu 사용
 - Lamda 의 경우 유료 서비스이므로 사용X [서버를 항시 켜둬야할 것으로 보임]
 
2020.03.31
 - Python REST API 를 백그라운드로 실행 예정

관리자
 - 로그인 페이지를 통해 관리자 전용 페이지로 이동한다.
 - 관리자 전용 페이지에서 GUI Appication EXE 파일을 등록/수정/삭제 할 수 있다.
 - 회원 전체목록 팝업을 통해 회원들의 전체 목록을 확인할 수 있다.

회원가입
 - 웹에서 회원가입을 진행한다.
 - 학교 사이트에 등록된 학번, ID, PW, 이름, 전화번호를 입력받는다.
 - 비밀번호는 암호화 처리한다.
 - 회원가입 버튼을 클릭하면 웹 파싱을 통해 해당 ID와 PW가 유효한지 세션 값으로 확인한다.
 - ID와 PW가 유효할 경우 데이터베이스에 데이터를 저장하며, 유효하지 않을 경우
   ID 또는 PW가 틀렸다는 에러 메시지를 출력한다.

얼굴등록
 - 회원가입 후, 얼굴등록 버튼을 눌러서 진행한다.
 - Python 으로 웹캠을 활성화 시킨 후, OpenCV 라이브러리를 이용해서 사용자의 얼굴을 인식하고 등록한다.
 - OpenCV 라이브러리를 이용해 인식된 얼굴 부위만 잘라 200x200 해상도로 만들어 100장을 저장한다.
 - 100장의 사진을 학습시킨 후, 학습 모델을 생성한다.
 - 각각의 학습을 위한 사진은 C:\face\회원학번 으로 저장하여 중복을 방지한다.
 - 학습 모델 파일은 C:\face 경로에 저장한다.

로그인
 - 웹에서 로그인 버튼을 누르면 로그인 화면으로 이동한다.
 - ID 와 PW 를 입력하고 유효할 경우 회원전용 화면으로 이동한다.
 - ID 와 PW 가 유효하지 않을 경우 ID 또는 PW가 틀렸다는 에러 메시지를 출력한다.

회원전용 화면
 - GUI Application 모듈로 생성된 EXE 파일을 다운로드 받을 수 있다.
 - EXE 파일은 오직 admin 권한을 가진 관리자만 등록/수정/삭제 할 수 있다.

GUI Application.EXE
 - 프로그램을 실행하면 로그인 버튼이 활성화된다.
 - 로그인 버튼을 클릭하면 사용자의 웹캠이 활성화된다.
 - C:\face 경로에 있는 학습 모델들을 통해 사용자의 얼굴을 인식하며 일치하면 웹 파싱을 통해
   해당 회원의 ID 와 PW 를 학교 사이트에 대입해 세션이 유효한 학교 페이지를 활성화시킨다.
 - 얼굴 인식에 실패 했을 경우 에러 메시지를 출력한다.
