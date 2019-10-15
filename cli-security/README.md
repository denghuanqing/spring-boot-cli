采用授权码模式

1. http://localhost:8088/oauth/authorize?client_id=client&response_type=code
授权后会带着code重定向到指定的url (https://www.***.com/?code=Vn7g9m)

2. ``curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=authorization_code&code=Vn7g9m' "http://client:secret@localhost:8088/oauth/token"
    ``
    ```
    {
        "access_token": "2e50cf72-b35a-4904-911d-2d60d01c700a",
        "token_type": "bearer",
        "expires_in": 43199,
        "scope": "app"
    }
    ```
3. 
