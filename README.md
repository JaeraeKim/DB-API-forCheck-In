# DB-API-forCheck-In

Check-In 프로젝트에 사용하는 DAO, DTO 코드입니다.



## 목차

1. [AgentAccountDAOImpl.java](#agentaccountdaoimpl.java)
2. [AgentAccountLogDAOImpl.java](#agentaccountlogdaoimpl.java)
3. [UserSiteInformationDAOImpl.java](#usersiteinformationdaoimpl.java)
4. [TokenKeyDAOImpl.java](#tokenkeydaoimpl.java)
5. [RemoteDeviceDAOImpl.java](#remotedevicedaoimpl.java)
6. [DeviceTokenKeyDAOImpl.java](#devicetokenkeydaoimpl.java)

#

### AgentAccountDAOImpl.java

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

* 동일한 key가 존재하는 경우 : true
* 사용하려는 key가 아직 Table에 존재하지 않는 경우 : false

#

### AgentAccountLogDAOImpl.java

#### readAll

``` cpp
public List<AgentAccountLogDTO> readAll(AgentAccountLogDTO dto);
```

dto의 agentID를 ID 속성 값으로 갖는 로그 정보를 반환합니다.

반환값

* 일치하는 정보가 없는 경우: null
* 일치하는 정보가 있는 경우: 계정의 로그 정보를 담은 List\<AgentAccountLogDTO>객체

#### insert

```cpp
public synchronized int insert(AgentAccountLogDTO dto);
```

새로운 로그 정보를 AgentAccountLog Table에 추가합니다.

반환값

* 정상 작동한 경우 : 1

#### delete

```cpp
public void delete(AgentAccountLogDTO dto);
```

계정의 모든 로그 정보를 AgentAccountLog Table에서 삭제합니다.

#

### UserSiteInformationDAOImpl.java

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

새로운 웹 사이트 정보를 UserSiteInformation Table에 추가합니다.

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

* 동일한 key가 존재하는 경우 : true
* 사용하려는 key가 아직 Table에 존재하지 않는 경우 : false

#


### TokenKeyDAOImpl.java

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

#### isKey

``` cpp
public boolean isKey(TokenKeyDTO dto);
```

사용하려는 key가 TokenKey Table에 있는지 확인합니다.

반환값

* 동일한 key가 존재하는 경우 : true
* 사용하려는 key가 아직 Table에 존재하지 않는 경우 : false

#

### RemoteDeviceDAOImpl.java

#### read

```cpp
public RemoteDeviceDTO read(RemoteDeviceDTO dto);
```

dto의 agentID, deviceID를 key로 갖는 휴대 장치 정보를 반환합니다.

반환값

* 일치하는 key가 없는 경우: null
* 일치하는 key가 있는 경우: 휴대 장치 정보를 담은 RemoteDeviceDTO객체

#### readAll

```java
public List<RemoteDeviceDTO> readAll(RemoteDeviceDTO dto);
```

dto의 agentID를 ID 속성 값으로 갖는 휴대 장치 정보를 반환합니다.

반환값

* 일치하는 정보가 없는 경우: null
* 일치하는 정보가 있는 경우: 계정의 휴대 장치 정보를 담은 List\<RemoteDeviceDTO\>객체

#### insert

```java
public synchronized int insert(RemoteDeviceDTO dto);
```

새로운 휴대 장치 정보를 RemoteDevice Table에 추가합니다.

반환값

* 키 값이 중복인 경우: 0
* 키 값이 유일한 경우: 1

#### update

```java
public synchronized int update(RemoteDeviceDTO dto);
```

RemoteDevice Table의 휴대 장치 정보를 변경합니다.

반환값

* 일치하는 key가 없거나, 변경 사항이 없는 경우: 0
* 휴대 장치 정보에 대한 변경 사항이 있는 경우: 1

#### delete

```java
public void delete(RemoteDeviceDTO dto);
```

휴대 장치 정보를 RemoteDevice Table에서 삭제합니다.

#### isKey

```java
public boolean isKey(RemoteDeviceDTO dto);
```

사용하려는 key가 RemoteDevice Table에 존재하는지 확인합니다.

반환값

* 동일한 key가 존재하는 경우 : true
* 사용하려는 key가 아직 Table에 존재하지 않는 경우 : false

#

### DeviceTokenKeyDAOImpl.java

#### read

```cpp
public DeviceTokenKeyDTO read(DeviceTokenKeyDTO dto);
```

dto의 agentID를 key로 갖는 휴대 장치 token 정보를 반환합니다.

반환값

* 일치하는 key가 없는 경우: null
* 일치하는 key가 있는 경우: 휴대 장치 token 정보를 담은 DeviceTokenKeyDTO객체

#### insert

```cpp
public synchronized int insert(DeviceTokenKeyDTO dto);
```

새로운 휴대 장치 token 정보를 DeviceTokenKey Table에 추가합니다.

반환값

* key가 중복인 경우: 0
* key가 유일한 경우: 1

#### delete

```cpp
public void delete(DeviceTokenKeyDTO dto);
```

계정의 휴대 장치 token 정보를 삭제합니다.

#### isKey

```cpp
public boolean isKey(DeviceTokenKeyDTO dto);
```

사용하려는 key가 DeviceTokenKey Table에 있는지 확인합니다.

반환값

* 동일한 key가 존재하는 경우 : true
* 사용하려는 key가 아직 Table에 존재하지 않는 경우 : false