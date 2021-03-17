

#### Cookie&Session

- redis(sessionId, userInfo)。

- cookie(SESSION_ID, sessionId)。



#### JsonWebToken

JWT：Header.Payload.Sign

Header：

```
{
  "alg": "HS256",
  "typ": "JWT"
}
```

Payload：

```
iss (issuer)：签发人
exp (expiration time)：过期时间
sub (subject)：主题
aud (audience)：受众
nbf (Not Before)：生效时间
iat (Issued At)：签发时间
jti (JWT ID)：编号
```

Sign：

```
HMACSHA256(base64UrlEncode(header) + "." +base64UrlEncode(payload), secret);
```

Token：

```
Authorization: Bearer <token>
```