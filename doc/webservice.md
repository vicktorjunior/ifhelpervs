# WEBSERVICES

Projeto usado na disciplina Tópicos II - Desenvolvimento para dispositivos móveis.

Os webservices permitem comunicarmos aplicações distintas desenvolvidas em linguagens distintas possibilitando ao usuário uma experiência rica e com diversos recursos.



## Entendendo WebServices

Para testarmos recomendo o programa Postman ou o plugin do firefox httpRequester.

Vamos consumir alguns webservices a partir da aula de hoje.

login: https://moodle.canoas.ifrs.edu.br/login/token.php?username=USUARIO&password=SENHA&service=moodle_mobile_app

Com o Token para fazer requisições podemos fazer mais requisições use os dois links para aprender a consumir os webservices do moodle:
- https://docs.moodle.org/dev/Web_service_API_functions
- API Documentada - http://www.refineddata.com/api/
- API Documentada pelo Bigolin - 

Você vai precisar das [ async_task.md | async Tasks ]

## Android

Em android iremos precisar de uma tarefa assíncrona, com isso enquanto nosso aplicativo requisita coisas o mesmo não trava.

E das seguintes permissões.

```xml
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```

Lembre-se da documentação oficial e da lib de terceiro para JSON.
