# Super-linter summary

| Language | Validation result |
| -------- | ----------------- |
| JAVA     | Fail ❌           |

Super-linter detected linting errors

For more information, see the [GitHub Actions workflow run](https://github.com/Ryan-Strong01/COM410-CW2/actions/runs/43881085286)

Powered by [Super-linter](https://github.com/super-linter/super-linter)\
Super-linter revision: `2da136927bd4a73596db63044b504547c62cb854`\
Super-linter version: `9.0.0`

<details>

<summary>JAVA</summary>

```text
Starting audit...
[ERROR] /github/workspace/src/main/java/models/Card.java:1: Missing package-info.java file. [JavadocPackage]
[ERROR] /github/workspace/src/main/java/models/Card.java:6:5: Missing a Javadoc comment for 'Type'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/Card.java:6:11: 'private' modifier out of order with the JLS suggestions. [ModifierOrder]
[ERROR] /github/workspace/src/main/java/models/Card.java:6:28: Name 'Type' must match pattern '^[a-z][a-zA-Z0-9]*$'. [MemberName]
[ERROR] /github/workspace/src/main/java/models/Card.java:7:5: Missing a Javadoc comment for 'Number'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/Card.java:7:11: 'private' modifier out of order with the JLS suggestions. [ModifierOrder]
[ERROR] /github/workspace/src/main/java/models/Card.java:7:30: Name 'Number' must match pattern '^[a-z][a-zA-Z0-9]*$'. [MemberName]
[ERROR] /github/workspace/src/main/java/models/Card.java:9:5: Missing a Javadoc comment for 'Card'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/main/java/models/Card.java:9:17: Parameter type should be final. [FinalParameters]
[ERROR] /github/workspace/src/main/java/models/Card.java:9:32: Parameter number should be final. [FinalParameters]
[ERROR] /github/workspace/src/main/java/models/Card.java:14:5: Class 'Card' looks like designed for extension (can be subclassed), but the method 'getType' does not have javadoc that explains how to do that safely. If class is not designed for extension consider making the class 'Card' final or making the method 'getType' static/final/abstract/empty, or adding allowed annotation for the method. [DesignForExtension]
[ERROR] /github/workspace/src/main/java/models/Card.java:14:5: Missing a Javadoc comment for 'getType'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/main/java/models/Card.java:18:5: Class 'Card' looks like designed for extension (can be subclassed), but the method 'getNumber' does not have javadoc that explains how to do that safely. If class is not designed for extension consider making the class 'Card' final or making the method 'getNumber' static/final/abstract/empty, or adding allowed annotation for the method. [DesignForExtension]
[ERROR] /github/workspace/src/main/java/models/Card.java:18:5: Missing a Javadoc comment for 'getNumber'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/main/java/models/Card.java:22:5: Class 'Card' looks like designed for extension (can be subclassed), but the method 'toString' does not have javadoc that explains how to do that safely. If class is not designed for extension consider making the class 'Card' final or making the method 'toString' static/final/abstract/empty, or adding allowed annotation for the method. [DesignForExtension]
[ERROR] /github/workspace/src/main/java/models/Card.java:27:5: Definition of 'equals()' without corresponding definition of 'hashCode()'. [EqualsHashCode]
[ERROR] /github/workspace/src/main/java/models/Card.java:27:5: Class 'Card' looks like designed for extension (can be subclassed), but the method 'equals' does not have javadoc that explains how to do that safely. If class is not designed for extension consider making the class 'Card' final or making the method 'equals' static/final/abstract/empty, or adding allowed annotation for the method. [DesignForExtension]
[ERROR] /github/workspace/src/main/java/models/Card.java:28:27: Parameter obj should be final. [FinalParameters]
[ERROR] /github/workspace/src/main/java/models/Card.java:33:60: '&&' should be on a new line. [OperatorWrap]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:5: Missing a Javadoc comment for 'ACE'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:10: Missing a Javadoc comment for 'TWO'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:15: Missing a Javadoc comment for 'THREE'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:22: Missing a Javadoc comment for 'FOUR'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:28: Missing a Javadoc comment for 'FIVE'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:34: Missing a Javadoc comment for 'SIX'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:39: Missing a Javadoc comment for 'SEVEN'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:46: Missing a Javadoc comment for 'EIGHT'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:53: Missing a Javadoc comment for 'NINE'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:59: Missing a Javadoc comment for 'TEN'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:64: Missing a Javadoc comment for 'JACK'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:70: Missing a Javadoc comment for 'QUEEN'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardNumber.java:4:77: Missing a Javadoc comment for 'KING'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardType.java:4:5: Missing a Javadoc comment for 'HEARTS'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardType.java:4:13: Missing a Javadoc comment for 'DIAMONDS'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardType.java:4:23: Missing a Javadoc comment for 'CLUBS'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/CardType.java:4:30: Missing a Javadoc comment for 'SPADES'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/Deck.java:2:17: Using the '.*' form of import should be avoided - java.util.*. [AvoidStarImport]
[ERROR] /github/workspace/src/main/java/models/Deck.java:5:5: Missing a Javadoc comment for 'cards'. [JavadocVariable]
[ERROR] /github/workspace/src/main/java/models/Deck.java:7:5: Missing a Javadoc comment for 'Deck'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/main/java/models/Deck.java:20:5: Class 'Deck' looks like designed for extension (can be subclassed), but the method 'shuffleDeck' does not have javadoc that explains how to do that safely. If class is not designed for extension consider making the class 'Deck' final or making the method 'shuffleDeck' static/final/abstract/empty, or adding allowed annotation for the method. [DesignForExtension]
[ERROR] /github/workspace/src/main/java/models/Deck.java:20:5: Missing a Javadoc comment for 'shuffleDeck'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/main/java/models/Deck.java:24:5: Class 'Deck' looks like designed for extension (can be subclassed), but the method 'shuffleDeck' does not have javadoc that explains how to do that safely. If class is not designed for extension consider making the class 'Deck' final or making the method 'shuffleDeck' static/final/abstract/empty, or adding allowed annotation for the method. [DesignForExtension]
[ERROR] /github/workspace/src/main/java/models/Deck.java:24:5: Missing a Javadoc comment for 'shuffleDeck'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/main/java/models/Deck.java:24:29: Parameter seed should be final. [FinalParameters]
[ERROR] /github/workspace/src/main/java/models/Deck.java:27: Line is longer than 80 characters (found 89). [LineLength]
[ERROR] /github/workspace/src/main/java/models/Deck.java:30:5: Class 'Deck' looks like designed for extension (can be subclassed), but the method 'drawCard' does not have javadoc that explains how to do that safely. If class is not designed for extension consider making the class 'Deck' final or making the method 'drawCard' static/final/abstract/empty, or adding allowed annotation for the method. [DesignForExtension]
[ERROR] /github/workspace/src/main/java/models/Deck.java:30:5: Missing a Javadoc comment for 'drawCard'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/main/java/models/Deck.java:38:5: Class 'Deck' looks like designed for extension (can be subclassed), but the method 'getLength' does not have javadoc that explains how to do that safely. If class is not designed for extension consider making the class 'Deck' final or making the method 'getLength' static/final/abstract/empty, or adding allowed annotation for the method. [DesignForExtension]
[ERROR] /github/workspace/src/main/java/models/Deck.java:38:5: Missing a Javadoc comment for 'getLength'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/main/java/models/Deck.java:42:5: Class 'Deck' looks like designed for extension (can be subclassed), but the method 'getCards' does not have javadoc that explains how to do that safely. If class is not designed for extension consider making the class 'Deck' final or making the method 'getCards' static/final/abstract/empty, or adding allowed annotation for the method. [DesignForExtension]
[ERROR] /github/workspace/src/main/java/models/Deck.java:42:5: Missing a Javadoc comment for 'getCards'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/main/java/models/Deck.java:46:5: Class 'Deck' looks like designed for extension (can be subclassed), but the method 'toString' does not have javadoc that explains how to do that safely. If class is not designed for extension consider making the class 'Deck' final or making the method 'toString' static/final/abstract/empty, or adding allowed annotation for the method. [DesignForExtension]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:1: Missing package-info.java file. [JavadocPackage]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:6:47: Using the '.*' form of import should be avoided - org.junit.jupiter.api.Assertions.*. [AvoidStarImport]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:10:5: Missing a Javadoc comment for 'canInitialiseCard'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:16:5: Missing a Javadoc comment for 'initialisingCardWithNullThrowsException'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:28:5: Missing a Javadoc comment for 'getMethodsShouldReturnExpectedOutput'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:32:23: '{' at column 23 should have line break after. [LeftCurly]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:32:23: '{' is not followed by whitespace. [WhitespaceAround]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:32:69: ';' is not followed by whitespace. [WhitespaceAfter]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:32:70: '}' is not preceded with whitespace. [WhitespaceAround]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:33:23: '{' at column 23 should have line break after. [LeftCurly]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:33:23: '{' is not followed by whitespace. [WhitespaceAround]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:33:70: ';' is not followed by whitespace. [WhitespaceAfter]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:33:71: '}' is not preceded with whitespace. [WhitespaceAround]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:37:5: Missing a Javadoc comment for 'cardEqualsShouldReturnTrueIfCardsMatch'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:44:23: '{' at column 23 should have line break after. [LeftCurly]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:44:23: '{' is not followed by whitespace. [WhitespaceAround]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:44:49: ';' is not followed by whitespace. [WhitespaceAfter]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:44:50: '}' is not preceded with whitespace. [WhitespaceAround]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:45:23: '{' at column 23 should have line break after. [LeftCurly]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:45:23: '{' is not followed by whitespace. [WhitespaceAround]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:45:50: ';' is not followed by whitespace. [WhitespaceAfter]
[ERROR] /github/workspace/src/test/java/models/CardTest.java:45:51: '}' is not preceded with whitespace. [WhitespaceAround]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:9:47: Using the '.*' form of import should be avoided - org.junit.jupiter.api.Assertions.*. [AvoidStarImport]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:13:5: Missing a Javadoc comment for 'canInitialiseDeck'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:19:5: Missing a Javadoc comment for 'deckHasFiftyTwoCards'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:22:22: '52' is a magic number. [MagicNumber]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:25:5: Missing a Javadoc comment for 'canDrawOnlyFiftyTwoCards'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:28:30: '53' is a magic number. [MagicNumber]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:29:22: '52' is a magic number. [MagicNumber]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:37:5: Missing a Javadoc comment for 'shuffleShouldChangeDeckOrder'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:42:39: ',' is not followed by whitespace. [WhitespaceAfter]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:46: Line is longer than 80 characters (found 93). [LineLength]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:47: Line is longer than 80 characters (found 87). [LineLength]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:48: Line is longer than 80 characters (found 102). [LineLength]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:51:5: Missing a Javadoc comment for 'shuffleShouldRandomlySortDecks'. [MissingJavadocMethod]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:57:35: '32' is a magic number. [MagicNumber]
[ERROR] /github/workspace/src/test/java/models/DeckTest.java:60:35: '45' is a magic number. [MagicNumber]
Audit done.Checkstyle ends with 89 errors.
```

</details>
