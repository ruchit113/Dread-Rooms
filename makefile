JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Direction.java \
	Place.java \
	Game.java \
	gameTester.java \
	Artifact.java \
	Character.java \
	CleanLineScanner.java \
	Move.java \
	NPC.java \
	Player.java \
	PlayerInterface.java \
	DecisionMaker.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class