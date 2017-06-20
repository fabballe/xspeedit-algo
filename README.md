# xspeedit-algo

This project is an answer to this problem: https://github.com/voyages-sncf-technologies/xspeedit

## How to compile

```
mvn clean package
```

or if you don't have maven on your computer

```
./mvnw clean package
```

## How to launch

In order to use this algorithm you need Java 1.8

```
java -jar xspeedit-algo-0.0.1-SNAPSHOT.jar inputArticle nbMaxWeigthPerBox
```

## Some example

```
java -jar xspeedit-algo-0.0.1-SNAPSHOT.jar 163841689525773 10
result = 91/82/81/73/73/64/6/55
```

```
java -jar xspeedit-algo-0.0.1-SNAPSHOT.jar 33344 10
result = 44/333
```
