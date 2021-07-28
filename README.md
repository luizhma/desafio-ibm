# Livros API

### Docker

Build image

```
mvn package
```

Run image

```
docker run -p 8080:8080 jairrillo/livros-api:0.0.1-SNAPSHOT
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



