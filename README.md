# docker-springboot
### 도커를 사용하여 SPRINGBOOT + MYSQL 서버구축



**도커를 활용하여 컨테이너(DB 컨테이너,스프링부트 컨테이너)끼리 연동인지 **

**컨테이너와 로컬의 DB연결인지,**

**잘 이해하지 못하여 두가지를 시도해보았습니다.**

**두번째 방법은 하단 부 끝에 작성해놓았습니다.**



#### 사용한 패키지

- IntelliJ, WSL2 , DockerDesktop, Maven, Mysql 5.7(image), Springboot, Mysql 8.0.31(로컬에 설치)

#### Project

- Maven

- Spring Boot 3.0.1

- Java 17

#### Dependency

- Spring Web
- MySQL Connector
- Mybatis
- Lombok



### 셋팅법

- 윈도우환경에서 도커를 설치하여 작업하였습니다.
- 깃허브 주소 https://github.com/kkk125504/docker-springboot
- 해당 주소를 통해 git clone 후 인텔리제이를 사용하여 해당 프로젝트를 불러옵니다.
- 해당 프로젝트에서 터미널을 통해 docker-compose up명령어 를 통해 실행시킵니다.
- docker-compose.yml 파일은 해당 프로젝트 안에 있습니다.
- docker-compose를 통해 mysql 5.7버전 이미지 pull, 스프링부트 이미지는 저의 Dockerhub에서 pull
- 도커로 스프링부트컨테이너과 mysql컨테이너까진 연결 하였으나 DB에 테이블이 생성이 안된 상황입니다.
- docker-compse를 통해 구동된 mysql컨테이너에 직접 접속하여
- 테스트 쿼리문을 실행시켜 데이터베이스 생성, 테이블 생성 , 데이터삽입 후
- 웹브라우저로 요청시 데이터베이스에 저장되있는 데이터를 조회하게 하였습니다.
- 테스트 쿼리문은 하단에 작성하였습니다.



### api

구매자 조회 : localhost:8080/getBuyerList

등록업체 조회 : localhost:8080/getCompanyList

상품정보 조회 : localhost:8080/getProductList

구매정보 조회 : localhost:8080/getPurchaseInformationList



### 테스트 쿼리문

**test 데이터베이스 생성**

```mysql
DROP DATABASE test;
CREATE DATABASE test;
USE test;
```



**상품 테이블 생성**

```mysql
CREATE TABLE product(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT ,
	itemName VARCHAR(20) NOT NULL,
	price INT(10) NOT NULL,
	register_date DATETIME NOT NULL,
	companyId INT(10) UNSIGNED NOT NULL
);
```



**상품 테이블에 데이터 추가**

```mysql
INSERT INTO product SET
	itemName = 'product1',
	price = 20000,
	register_date = '2021-11-20',
	companyId = 1;

INSERT INTO product SET
	itemName = 'product2',
	price = 10000,
	register_date = '2023-01-01',
	companyId = 2;
```



**구매자 테이블 생성**

```mysql
CREATE TABLE buyer(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT ,
	buyerName VARCHAR(20) NOT NULL,
	phoneNumber CHAR(20) NOT NULL
);
```



**구매자 데이터 추가**

```mysql
INSERT INTO buyer SET
	buyerName = 'buyer1',
	phoneNumber = '010-1111-1111';

INSERT INTO buyer SET
	buyerName = 'buyer2',
	phoneNumber = '010-2222-2222';
```



**구매정보 테이블 생성**

```mysql
CREATE TABLE purchaseInformation(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT ,
	productId INT(10) NOT NULL,
	buyerId INT(10) NOT NULL,
	purchaseDate DATETIME NOT NULL
);
```



**구매정보 데이터 추가**

```mysql
INSERT INTO purchaseInformation SET
productId = 1,
buyerId =1,
purchaseDate = NOW();

INSERT INTO purchaseInformation SET
productId = 2,
buyerId =2,
purchase_date = NOW();
```



**등록업체 테이블 추가**

```mysql
CREATE TABLE company(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT ,
	companyName VARCHAR(20) NOT NULL,
    ceoName VARCHAR(20) NOT NULL,
	phoneNumber CHAR(20) NOT NULL
);
```



**등록업체 데이터 추가**

```mysql
INSERT INTO company SET
	companyName = 'company1',
	ceoName ='ceo1',
	phoneNumber = '010-3333-3333';

INSERT INTO company SET
	companyName = 'company2',
	ceoName ='ceo2',
	phoneNumber = '010-4444-4444';
```



### 테스트 결과

![테스트결과](C:\Users\김정현\Desktop\테스트결과.png)

### 두번째 도커 컨테이너와 로컬 DB연동

- 두번째 시도중에 제출기한이 다되어 구현중입니다.

 ### applycation.yml파일

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://host.docker.internal:3306/test?useSSL=false
    username: root
    password: ****
```

- 로컬 호스트의 3306포트로 연결하는 코드로 변경

### docker-compose.yml

```yaml
version: "3.7"

services:
  test-app:
    image: kginyc4012/docker-springboot-test:02v
    ports:
      - 8080:8080
    networks:
      - springboot-mysql-net

networks:
  springboot-mysql-net:
    driver: bridge
```

- 도커허브에 두번째 이미지를 올리지 못하여 image 임시로 작성
- 첫번째방법의 도커컴포즈파일과 다른점은 Mysql이미지를 pull하지 않음

