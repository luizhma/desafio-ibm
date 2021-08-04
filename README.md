# Livros API

### Docker

Build image

```
mvn package
```

Run image

```
docker run -p 8080:8080 jairrillo/livros-api:0.0.2-SNAPSHOT
```

Deploy do docker hub

```
mvn dockerfile:push
```

Deploy no k8s

```
kubectl delete -f k8s-deployment.yml
kubectl apply -f k8s-deployemnt.yml
```

Atualizar Imagem

```
kubectl set image deployment/livros-api livros-api=docker.io/jairrillo/livros-api:0.0.2-SNAPSHOT
```



