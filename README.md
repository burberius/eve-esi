# EVE-ESI
A Java client library for the new EVE Swagger Interface (ESI)

## SSO usage
The usage of the SSO can be seen in the *main* method within the test class
*net/troja/eve/esi/api/auth/SsoAuthTest.java*.

**Note:** The state should be some secret to prevent XRSF, please read:
http://www.thread-safe.com/2014/05/the-correct-use-of-state-parameter-in.html

## Tests with authorization
To run the tests that use authorization you need to have some environment variables set,
this information should not be published:
* SSO_CLIENT_ID
* SSO_CLIENT_SECRET
* SSO_REFRESH_TOKEN

Client id and secret can be created on the following page: https://developers.eveonline.com/
You should use http://localhost as redirect url as that is the value used in the test and it also
makes it easier after the redirect.

### Create a refresh token for the tests
To create a refresh token, you have to start the class *net/troja/eve/esi/api/auth/SsoAuthTest.java*
with your client id as first and the secret as second argument. Then it shows you the url on console.

Open the url in your browser, login with your account and authorize the access. This will redirect you
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

## Links
* [EVE Swagger Interface](https://esi.tech.ccp.is/latest/)
* [Eve Online SSO](http://eveonline-third-party-documentation.readthedocs.io/en/latest/sso/index.html)
