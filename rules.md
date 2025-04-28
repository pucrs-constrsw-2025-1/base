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


**POST** `{{base-api-url}}/users` - Criar um novo usuário.

**Headers:**  
- Authorization: Bearer {{access_token}}

**Request body:**  
- Documento JSON representando o novo usuário

**Response body:**  
- Documento JSON representando o novo usuário, incluindo o id gerado automaticamente

**Response code:**  
- 201: Created

**GET** `{{base-api-url}}/users` - Listar todos os usuários.

**Headers:**  
- Authorization: Bearer {{access_token}}

**Request body:**  
- Vazio

**Response body:**  
- Documento JSON representando todos os usuários cadastrados e habilitados

**Lógica:**
Consumir a rota do Keycloak que recupera todos os usuários

**Response code:**  
- 200: OK
- ???

**Nova rota:** 

**GET ** `{{base-api-url}}/users/{{id}}` - recuperação de um usuário.

**Headers:**  
- Authorization: Bearer {{access_token}}

**Request body:**  
- Vazio

**Response body:**  
- Documento JSON representando o usuário

**Response code:**  
- 200: OK
- 404: Not found: o objeto requisitado não foi localizado

**Lógica:**
Consumir a rota do Keycloak que recupera um usuário a partir do seu id