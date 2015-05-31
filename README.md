# GachaServer
./gradlew clean build shadowJar && vertx run src/main/java/com/gacha/server/Starter.java -cp build/libs/com.gacha.server~0.0.1-SNAPSHOT-all.jar

# Build
./gradlew clean build shadowJar

# Run
vertx run src/main/java/com/gacha/server/Starter.java -cp build/libs/com.gacha.server~0.0.1-SNAPSHOT-all.jar

# APIs
GET /restaurants
{
  data: [
    {
      "name": "blah",
      "latitude": 10.1234,
      "longitude": 10.1234,
      "score": 5
    },
    { ... }
  ]
}