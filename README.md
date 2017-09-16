# Adapter

Bom para que diabos serve um adapter ![alt text](https://www.google.com.br/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjOoqvkjorWAhUowlQKHc4zADoQjRwIBw&url=https%3A%2F%2Fwww.amazon.com%2FCkitze-Flat-Europe-Asia-Adapter%2Fdp%2FB002TZBW74&psig=AFQjCNFAJU3jDJT2pu7Q3Sa-6R4gZVXslA&ust=1504565854054738)

## Entendendo WebServices

Para testarmos recomendo o programa Postman ou o plugin do firefox httpRequester.

Vamos consumir alguns webservices a partir da aula de hoje.

login: https://moodle.canoas.ifrs.edu.br/login/token.php?username=USUARIO&password=SENHA&service=moodle_mobile_app


Com o Token para fazer requisições podemos fazer mais requisições use os dois links para aprender a consumir os webservices do moodle:
- https://docs.moodle.org/dev/Web_service_API_functions
- API Documentada - http://www.refineddata.com/api/

## Android

Em android iremos precisar de uma tarefa assíncrona, com isso enquanto nosso aplicativo requisita coisas o mesmo não trava.

E das seguintes permissões.

```xml
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```

Lembre-se da documentação oficial e da lib de terceiro para JSON.
