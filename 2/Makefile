LIBS = .:/usr/share/java/junit.jar:/usr/share/java/hamcrest-core.jar

.PHONY: all test clean
all: Test.class
	java Test

Test.class: Test.java DominoTile.java Dominoes.java DominoesException.java
	javac Test.java

test: DominoesTest.class
	java -cp $(LIBS) org.junit.runner.JUnitCore DominoesTest

DominoesTest.class: DominoesTest.java DominoTile.java Dominoes.java DominoesException.java
	javac -cp $(LIBS) DominoesTest.java

clean:
	-rm -r out/ *.class
