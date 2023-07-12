-- member
create table member2 (
    mno     int             auto_increment,
    userid  varchar(18)     unique,
    passwd  varchar(18)     not null,
    name    varchar(10)     not null,
    email   varchar(50)     unique,
    zipcode char(7)         not null,
    addr1   varchar(100)    not null,
    addr2   varchar(100)    not null,
    phone   char(13)        not null,
    regdate datetime        default current_timestamp,
    primary key (mno)
);

insert into member2
(userid, passwd, name, email, zipcode, addr1, addr2, phone)
values ('abc123','987xyz','zzyzzy','zzyzzy@abc123.co.kr',
        '123-456','서울 관악구','블라블라','123-4567-8912');

select * from member2;

-- board
create table board2 (
    bno         int             auto_increment,
    title       varchar(100)    not null,
    userid      varchar(18)     not null,
    regdate     datetime        default current_timestamp,
    thumbs      int             default 0,
    views       int             default 0,
    contents    text            not null,
    ipaddr      varchar(15)     not null,
    primary key (bno)
    -- ,foreign key (userid) references member2(userid)
);

alter table board2
    add constraint fkuid
        foreign key (userid) references member2 (userid);


insert into board2 (userid, title, contents, ipaddr)
values ('abc123', 'AWS, 한국에 초대형 데이터센터 구축 착수하나?',
    '글로벌 클라우드 기업 아마존웹서비스(이하 AWS)가 인천에 초대형 자체 데이터센터를 지을 것으로 보여 주목된다.

11일 관련 업계에 따르면 AWS는 자체 데이터센터 설계를 위해 국내 한 건축사무소와 계약을 체결해 설계 작업이 마무리 단계에 접어들었다고 알려지고 있다.

AWS는 지난해 말부터 부지 및 설계사 선정 등을 진행한 것으로 전해진다. 내년 인천 지역 내 자체 데이터센터 착공을 목표로 하고 있다는 관측이다. 규모는 96메가와트급(이하 MW)이다. 이는 국내 플랫폼 기업 네이버가 2013년 강원도 춘천에 지은 데이터센터 ''각 춘천''이 쓰는 40MW보다 2배 이상 큰 규모다. 각 춘천은 축구장 7개 크기로 12만대가량 서버를 보관할 수 있다.', '127.0.0.1');

insert into board2 (userid, title, contents, ipaddr)
values ('987xyz', '구글, 사람처럼 진찰하는 "의료 AI 챗봇" 테스트',
    '구글이 의료용 인공지능(AI) 챗봇을 테스트 중이다.

월스트리트저널(WSJ) 등 주요 외신은 구글이 의료 AI 챗봇 ''메드-팜2''를 올해 4월부터 테스트에 본격 돌입했다고 10일 보도했다. 현재 미국 메이요 클리닉에서 해당 챗봇을 실험 중이다. 메이요 클리닉은 비영리 학술 의료 센터다.

메드-팜2는 채팅 형태로 환자를 진찰하는 챗봇이다. 환자가 특정 상태를 문자로 입력하면, 메드-팜2는 이를 분석해 병명을 진단하거나 의학적 소견을 제시한다. 보도에 따르면 현재 메드-팜2는 소견을 제시할 때 이에 맞는 근거를 제공한다. 병명을 결정할 때도 마찬가지다. 인간 의료진도 납득할 수 있는 진찰을 할 수 있다.', '192.168.0.2');

insert into board2 (userid, title, contents, ipaddr)
values ('zzyzzy', '[공식발표] 파리생제르맹 이강인 영입. 28년 까지 계약',
    'Born in Incheon in South Korea in 2001, Lee Kang-In moved to Spain to play for Valencia CF in 2011 when he was 10 years old. Seven years later, in 2018, he made his first team debut at 17 years old.

After three seasons, 62 matches and 3 goals scored in the Valencia colours, he signed for RCD Mallorca in 2021. Predominantly playing as a winger, but equally effective through the middle, Lee Kang-In has just had a very successful season. He took part in 39 matches in all competitions, scoring 6 goals and picking up 6 assists.',
    '115.92.164.155');

select
    count(userid) cnt, ceil(count(userid) / 25) pages
from board2;



