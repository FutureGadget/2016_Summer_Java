# 2016_Summer_Java_and_Web_study
###Network / Thread / Web programming (servlet / jsp) / MVC pattern
<hr>
<h1>1. 방 하나짜리 채팅방 (java thread / network programming)</h1>
<h2>== Server Side ==</h2>
<ol>
    <li>ConnectionServer
        Client로 부터의 연결을 기다리는 서버.
        연결시 반환되는 소켓 정보를 가지고 ChatServerThread를 생성한다.
    </li>
    <li>ChatServerThread
        1:1로 Client를 담당하는 쓰레드.
        Client가 Connection Server로 접속 요청 시 생성된다. Client 의 main thread에 대해 inputStream을 열어 입력을 받는다.
    </li>
    <li>SharedChatData
        쓰레드간 공유메모리.
        자신 외의 다른 Client(Socket)들에게도 메시지를 Broadcast하기 위해서 필요하다.
        연결된 모든 Client들에 대해 Output Stream을 갖도록 한다.
    </li>
</ol>

<h2>== Client Side ==</h2>
<ol>
    <li>Client
        서버로 연결요청 및 표준입력을 받아서 ChatServerThread와 1:1로 통신.(outputStream)
    </li>
    <li>ClientInputThread
        다른 Client가 보낸 메시지를 (ChatServerThread 가 브로드캐스트 한 메시지) 실시간으로
        받을 수 있어야 하므로 필요. ChatServerThread와 1:1로 통신.(inputStream)
    </li>
</ol>

<h2><<방1개짜리 만들 때 포인트!>></h2>
<p>
1. Server Thread를 위한 클래스는 몇개 필요하고 Client Thread를 위한 클래스는 몇 개 필요한가?
각각 하는일은?
</p>
<p>
답 : Server는 연결요청을 받는 Thread 1개, 각각의 클라이언트를 담당(클라이언트와 1:1 소켓통신을 하는)
하는 Thread class 1개로 총 2개 필요.

Client Thread를 위한 클래스
답 : Server와 연결하는 Thread class 1개, 연결 후 ChatServerThread 로부터 입력을 대기하는 thread 를 위한 class 1개 필요.

*소켓통신이란? 1:1 Stream을 생성하여 input/output 을 하는 것을 의미.
</p>


<h2>** 추가 Detail Question</h2>
<ol>
    <li>사용자로 부터 닉네임은 어디서 입력받을것인가?</li>
    <li>입력받은 닉네임을 어느 객체에 저장해야 할까? (Hint : 클라이언트 1개당 서버 Thread 1개가 담당)</li>
    <li>다른 클라이언트로 broadcast하는 함수는 어디다 작성? 또 어떻게 작성해야 할까?</li>
</ol>

<h2>** I/O tip</h2>
<ul>
    <li>스트림으로부터 입력받기 : BufferedReader br = new BufferedReader(new InputStreamReader(스트림객체));
        스트림객체의 예 : System.in (표준입력스트림-키보드입력), socket.getInputStream() 연결된 소켓으로부터 inputStream 객체 가져오는 메소드
    </li>
    <li>스트림으로 내보내기 : PrintWriter w = new PrintWriter(스트림객체);
        스트림객체의 예 : System.out (표준출력스트림-모니터), socket.getOutputStream() 소켓으로부터 outputStream 객체 가져오는 메소드
    </li>
</ul>
<hr>
#Jquery Mobile 101
##1. jquery mobile 기본 페이지구성
  1. cdn 추가
  2. 모바일 환경을 위한 meta tag설정
  3. jquery mobile의 어트리뷰트들 소개
  4. home page 구성

##2. 새로운 페이지 만들기
  1. 링크
  2. 뒤로가기
  3. 페이지 전환 특성(data-transition)

##3. 테마
  1. ThemeRoller사용

##4. 버튼
  1. content에 버튼 추가
  2. 버튼 크기
  3. 버튼아이콘
  4. 아이콘 위치
  5. 사용자 정의 아이콘 사용(css이용)
  6. 컨트롤그룹(버튼 그룹 예시)

##5. 툴바
  1. 툴바는 여러개 넣을 수 있음.
  2. data-position="fixed" 어트리뷰트 설명
  3. 툴바의 종류 : header/footer/navbar

##6. 리스트뷰
  1. 리스트 만들기
  2. 리스트 항목을 버튼처럼 사용하기
  3. 리스트에 thumbnail 심기
  4. 리스트에 split button 넣기
  5. 리스트에 p,h태그 넣기