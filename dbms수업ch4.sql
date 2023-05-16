/* 속성명, 테이블명, DB명 등은 `(백틱) 으로 묶어서 쓰는게 일반적 */

create table `sample_tbl2`(
	`id` varchar(20) primary key,
    `password` varchar(60)
);

create table `주문`(
	주문번호 int not null,
    주문자정보 varchar(20) not null,
    주문일 datetime default NOW(),
    primary key(주문번호, 주문자정보)
);

show tables;
show table status;
desc 주문;
describe 주문;

create table buy_tbl(
	`num` int not null auto_increment primary key,
    `userID` char(8) not null,
    `prodname` char(6) not null,
    `groupName` char(4),
    `price` int unsigned not null,
    `amount` smallint not null,
    foreign key (`userID`) references `user_tbl`(`userID`),
    check(`price`<= 10000000)
);

create table `고객`(
	userID varchar(8) primary key,
    name varchar(6) not null,
    age int,
    ranking varchar(4) not null,
    job varchar(4),
    point int unsigned default 0
);

create table `제품`(
	prodnum int primary key,
    prodname varchar(30),
    amount int ,
    price int,
    manufacture varchar(45),
    check(`amount` >=0 and `amount`<= 10000)
);


create table `주문`(
	ordernum int primary key,
    customer varchar(8),
    product int,
    amount int,
    destination varchar(8),
    orderdate varchar(3),
    foreign key (`customer`) references `고객`(`userID`)
    on update cascade on delete no action,
    foreign key (`product`) references `제품`(`prodnum`)
    on update cascade on delete no action    
);
desc 고객;
#속성 추가
alter table `고객` add `주소` varchar(100) not null default '대구';
#속성 삭제
alter table `고객` drop `주소`;
#속성 변경(이름, 데이터 형식)
#Alter table `테이블명` change column `기존속성명` `변경할 속성명` 데이터타입;
alter table `고객` change column `주소` `위치` varchar(12);
# 제약조건의 추가/수정/삭제
alter table `테이블명` add constraint `FK이름`
foreign key (`속성명`) references `참조테이블명`(`참조테이블속성명`);
alter table `테이블명` drop foreign key `FK이름`;
# 제약조건의 수정 => 제약조건 삭제 후 재생성
# PK 추가
alter table `테이블명` add primary key(`속성명`);
alter table `테이블명` drop primary key;

# 속성이름 변경시 (NULL, KEY속성, 제약조건 추가로 설정 가능 - 옵션)
alter table `테이블명` rename column `기존소겅명` to `바꿀속성명` [NULL] [KEY속성] [제약조건]
# 속성구조 변경
ALTER TABLE `테이블명` MODIFY COLUMN `속성명` 데이터타입 [NULL] [KEY 속성] [제약조건];

# 현재 MYSQL의 전체 DB의 CONSTRAINT(제약조건) 확인 시
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
# 확인하고 싶은 테이블의 CONSTRAINT(제약조건) 확인 시
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE `TABLE_NAME` = `확인하고 싶은 테이블 명`;









