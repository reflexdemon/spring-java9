# spring-java9

[![Build Status][travis-image]][travis-url]

## Run the application

```
> vagrant up
> vagrant ssh
> ./gradlew clean bootRun
```

## Testing

Navigate to http://localhost:2020/hello to seee the output

## Testing REPL endpoint

```bash
❯ curl --silent -H "Content-Type: application/json; charset=UTF-8" -X POST -d '{"command":"44+55"}' http://localhost:2020/repl                               
[{"status":"VALID","value":"99","exception":null,"snippet":"Snippet:VariableKey($2)#3-44+55"}]
```

[travis-image]: https://travis-ci.org/reflexdemon/spring-java9.svg?branch=master
[travis-url]: https://travis-ci.org/reflexdemon/spring-java9