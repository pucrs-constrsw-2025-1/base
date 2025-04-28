# Principais rotas da REST API do Keycloak

## POST Token

**URL:**  
`http://localhost:8080/auth/realms/{nome-realm}/protocol/openid-connect/token`

**Headers:**  
- `Content-Type: application/x-www-form-urlencoded`

**Request body (x-www-form-urlencoded):**
- `client_id: {cliente_id}`
- `client_secret: {client_secret}`
- `username: {username}`
- `password: {password}`
- `grant_type: password`

**Response body:**
```json
{
    "access_token": "...",
    "expires_in": ...,
    "refresh_expires_in": ...,
    "refresh_token": "...",
    "token_type": "Bearer",
    "not-before-policy": 0,
    "session_state": "...",
    "scope": "profile email"
}
```

**Response code:**  
`200: OK`

---

## GET User Info

**URL:**  
`http://localhost:8080/auth/realms/{realm}/protocol/openid-connect/userinfo`

**Headers:**  
- `Authorization: Bearer {access_token}`

**Response body:**
```json
{
    "sub": "...",
    "email_verified": true,
    "name": "...",
    "preferred_username": "...",
    "given_name": "...",
    "family_name": "...",
    "email": "...",
    ...
}
```

**Response code:**  
`200: OK`

---

# O que precisa ser feito

## Implementar no Spring

**Nova rota:**  

**POST** `{{base-api-url}}/login`

**Headers:**  
- Vazio

**Request body:**  
- Form-data incluindo:
  - `client_id`
  - `username`
  - `password`
  - `grant_type: password`

**Response body:**  
- Documento JSON incluindo:
  - `token_type`
  - `access_token`
  - `expires_in`
  - `refresh_token`
  - `referesh_expires_in`

---

**Lógica:**
- Consumir a rota **POST** `{{base-keycloak-url}}/auth/realms/{{realm}}/protocol/openid-connect/token` da REST API do Keycloak para autenticação do usuário.
- Gerar o `access_token` e o `refresh_token` a partir dos dados: `client_id`, `client_secret`, `username`, `password`, e `grant_type: password`.

> A REST API deverá capturar o evento de expiração do `access_token`, gerando novos `access_token` e `refresh_token` utilizando o `refresh_token` anterior. Para isso **pode ser necessária uma nova rota na API**. Resolver seguindo o mesmo fluxo proposto pelo Keycloak.
