LIBS = .:/usr/share/java/junit.jar:/usr/share/java/hamcrest-core.jar:/usr/share/java/junit4.jar:/usr/share/java/hamcrest-core.jar
sources := $(wildcard *.java)

all: Test.class
	java Test

Test.class: $(sources)
	javac Test.java

test: Test.class
	java -cp $(LIBS) org.junit.runner.JUnitCore \
		$(basename$(wildcard ?Test.java))

create:
	mkdir $(task) && cd $(task) && ln -sr ../Makefile ./ && touch Test.java

clean:
	-find -regex '.*class' | xargs rm -r out/

.PHONY: all test clean
