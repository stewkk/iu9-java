LIBS = .:/usr/share/java/junit.jar:/usr/share/java/hamcrest-core.jar

.PHONY: all test clean
all: Test.class
	java Test

Test.class: Test.java Universe.java Particle.java
	javac Test.java

# Universe.class: Universe.java
# 	javac -cp $(LIBS) DominoesTest.java

# Particle.class: Particle.java


clean:
	-rm -r out/ *.class
