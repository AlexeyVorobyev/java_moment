```bash
javac -sourcepath src -d classes src/applepack/Apple.java
javac -sourcepath src -d classes src/testpack/Test.java
```

```bash
# from classes subdirectory
cd classes
java -classpath . testpack.Test
```

```bash
jar cfe Test.jar testpack.Test testpack/Test.class applepack/Apple.class
```

```bash
java -jar Test.jar
```