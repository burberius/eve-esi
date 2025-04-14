[![Maven Central](https://img.shields.io/maven-central/v/net.troja.eve/eve-esi.svg?maxAge=86400)](http://mvnrepository.com/artifact/net.troja.eve/eve-esi)
[![Build Status](https://jenkins.vyor.de/buildStatus/icon?job=eve-esi)](https://jenkins.vyor.de/job/eve-esi/)

# EVE-ESI
A Java client library for the EVE Swagger Interface (ESI)

## Version 6.0.0 changes

We regenerated the classes with the latest openAPI generator (currently 7.12.0) and try to keep it uptodate now.
Theoretically there should be any breaking changes.

## Version 4.0.0 changes

Enum changes no longer require a version bump in ESI, therefor eve-esi will return `null` for unknown enum values.
You can get the string value of the unknown enum with `get[VariableName]String()`

We don't check for changes regularly, so please, make an issue (or even better a PR with the changes) if you need
the enum values updated.

## Version 3.0.0 changes
After several years with many changes to ESI it is now quite stable, so
we decided to move to a (hopefully) better and especially threadsafe http library: **okhttp**

This version also changes how the *ApiClient* is initialized, it now uses a
builder *ApiClientBuilder* to create the *ApiClient* the right way. Here are two examples:

```java
ApiClient client = new ApiClientBuilder().clientID(clientId).accessToken("some-access-token").build();

ApiClient client = new ApiClientBuilder().clientID(clientId).refreshToken("some-refresh-token").build();
```

For more, please have a look in the tests.

## Maven integration
Just add the following to your *pom.xml*:
```xml
<dependency>
    <groupId>net.troja.eve</groupId>
    <artifactId>eve-esi</artifactId>
    <version>4.1.0</version>
</dependency>
```

## Versioning (Major.Minor.Patch)

- Major
  - Major breaking changes to the entire library
  - May also contain endpoint promotions and bug fixes
- Minor
  - Endpoint promotions ([breaking changes](https://github.com/esi/esi-docs/blob/master/docs/breaking_changes.md) announced in the [esi changelog](https://github.com/esi/esi-issues/blob/master/changelog.md))
  - May also contain bug fixes
- Patch
  - Bug fixes without any breaking changes

## SSO usage
The usage of the SSO can be seen in the *main* method within the test class
*net/troja/eve/esi/api/auth/SsoAuthTest.java*.

**Note:** The state should be some secret to prevent XRSF, please read:
http://www.thread-safe.com/2014/05/the-correct-use-of-state-parameter-in.html

## ApiException: Bad Gateway
The exception *net.troja.eve.esi.ApiException: Bad Gateway* happens in the ESI on occasion,
there's not much you can do on the client side except be prepared to handle it (e.g. retry).
Some endpoints are more notorious for this than others. For example, the corporate contracts
API regularly has this issue.

On a typical day in EveKit, one of my sync nodes makes about 500K requests across various API
endpoints. About 2000 of those calls result in errors, and about a third of those errors are
502 (bad gateway). It's just something you have to be prepared to deal with.

## Tests with authorization
To run the tests that use authorization you need to have some environment variables set,
this information should not be published:
* SSO_CLIENT_ID
* SSO_REFRESH_TOKEN

Client id can be created on the following page: https://developers.eveonline.com/
You should use http://localhost as redirect url as that is the value used in the test and it also
makes it easier after the redirect.

### Create a refresh token for the tests
To create a refresh token, you have to start the class *net/troja/eve/esi/api/auth/SsoAuthTest.java*
with your client id as the argument or set the environment variables `SSO_CLIENT_ID`.

The url will open in your browser, login with your account and authorize the access. This will redirect you
to an url on localhost, something like:
```
http://localhost/?code=7z524J_PQZ1YjacS35d8JRkOVwNl-jCvn814xCrgeSm3Acc981lZWW0&state=somesecret
```

Copy the *code* part to console and press enter. As result you will get a refresh token, that can be
used to run the tests.

Example output:
```shell
Authorization URL: https://login.eveonline.com/oauth/authorize?scope=esi-clones.read_clones.v1&response_type=code&state=somesecret&redirect_uri=http%3A%2F%2Flocalhost&client_id=352ef22ca74e33c78c11779ab3saffe
Code from Answer: 7z524J_PQZ1YjacS35d8JRkOVwNl-jCvn814xCrgeSm3Acc981lZWW0
Refresh Token: 0tr5SQ-piuKvqjFdDa765DESObTzWKUj5v63KjaL4cTAx041
```
## Tipps 'n' Tricks

### Paging
If you wonder how the paging with esi works, please have a look at the test
*[src/test/java/net/troja/eve/esi/api/MarketApiTest.java](https://github.com/burberius/eve-esi/blob/master/src/test/java/net/troja/eve/esi/api/MarketApiTest.java#L234)* there is a method *pagingExample* showing it.

## Development on windows

### Setup
1) Download Cygwin from: https://www.cygwin.com
2) Install Cygwin with the default options
3) Run the Cygwin installer again and add: wget (web), git (devel), jq (text)
4) Download maven from: http://maven.apache.org/download.cgi (if you don't have it installed already)
5) Unpack and add the "bin" directory to windows environment variable "path"
6) Download and install Java SE JDK: http://www.oracle.com/technetwork/java/javase/downloads/index.html (if you don't have it installed already)

### Generate new source
1) Start the Cygwin Terminal
2) ``cd`` to the source
2) run ``./generate.sh``

## Links
* [EVE Swagger Interface](https://esi.evetech.net/)
* [Eve Online SSO](https://github.com/esi/esi-docs#sso---read-this-notice-first)
