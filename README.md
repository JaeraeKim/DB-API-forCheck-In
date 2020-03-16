# DB-API-forCheck-In

Check-In 프로젝트에 사용할 DAO, DTO 코드입니다.

#

### AgentAccountDAO.java

#### read

```java
public AgentAccountDTO read(AgentAccountDTO dto);
```

dto의 agentID를 key로 갖는 계정 정보를 반환합니다.

반환값

* 일치하는 key가 없는 경우: null
* 일치하는 key가 있는 경우: 계정 정보를 담은 AgentAccoutnDTO 객체

#### insert

```java
public synchronized int insert(AgentAccountDTO dto);
```

새로운 계정 정보를 AgentAccount Table에 추가합니다.

반환값

* key가 중복인 경우: 0
* key가 유일한 경우: 1

#### update

```java
public synchronized int update(AgentAccountDTO dto);
```

AgentAccount Table의 계정 정보를 변경합니다.

반환값

* 일치하는 key가 없거나, 변경 사항이 없는 경우: 0
* 계정 정보에 대한 변경 사항이 있는 경우: 1

#### delete

```java
public void delete(AgentAccountDTO dto);
```

계정 정보를 AgentAccount Table에서 삭제합니다.

#### isKey
```java
public boolean isKey(AgentAccountDTO dto);
```

사용하려는 key가 AgentAccount Table에 존재하는지 확인합니다.

반환값

* 동일한 key가 존재하는 경우: true
* 사용하려는 key가 Table 내에 유일한 경우: false

#
### UserSiteInformationDAO.java

#### read

```java
public UserSiteInformationDTO read(UserSiteInformationDTO dto);
```

dto의 agentID, name를 key로 갖는 웹 사이트 정보를 반환합니다.

반환값

* 일치하는 key가 없는 경우: null
* 일치하는 key가 있는 경우: 웹 사이트 정보를 담은 UserSiteInformationDTO객체

#### readAll

```java
public List<UserSiteInformationDTO> readAll(UserSiteInformationDTO dto);
```

dto의 agentID를 ID 속성 값으로 갖는 웹 사이트 정보를 반환합니다.

반환값

* 일치하는 정보가 없는 경우: null
* 일치하는 정보가 있는 경우: 계정의 웹 사이트 정보를 담은 List\<UserSiteInformationDTO\>객체

#### insert

```java
public synchronized int insert(UserSiteInformationDTO dto);
```

새로운 웹 사이트 정보를 UserSiteInformationTable에 추가합니다.

반환값

* 키 값이 중복인 경우: 0
* 키 값이 유일한 경우: 1

#### update

```java
public synchronized int update(UserSiteInformationDTO dto);
```

UserSiteInformation Table의 웹 사이트 정보를 변경합니다.

반환값

* 일치하는 key가 없거나, 변경 사항이 없는 경우: 0
* 웹 사이트 정보에 대한 변경 사항이 있는 경우: 1

#### delete

```java
public void delete(UserSiteInformationDTO dto);
```

웹 사이트 정보를 UserSiteInformation Table에서 삭제합니다.

#### isKey
```java
public boolean isKey(UserSiteInformationDTO dto);
```

사용하려는 key가 UserSiteInformation Table에 존재하는지 확인합니다.

반환값

* 동일한 key가 존재하는 경우: true
* 사용하려는 key가 Table 내에 유일한 경우: false


### TokenKeyDAO.java

#### read

```java
public TokenKeyDTO read(TokenKeyDTO dto);
```

dto의 agentID를 key로 갖는 token 정보를 반환합니다.

반환값

* 일치하는 key가 없는 경우: null
* 일치하는 key가 있는 경우: token 정보를 담은 TokenKeyDTO 객체

#### insert

```java
public synchronized int insert(TokenKeyDTO dto);
```

새로운 token 정보를 TokenKey Table에 추가합니다.

반환값

* key가 중복인 경우: 0
* key가 유일한 경우: 1

#### delete

```java
public void delete(TokenKeyDTO dto);
```

token 정보를 TokenKey Table에서 삭제합니다.
