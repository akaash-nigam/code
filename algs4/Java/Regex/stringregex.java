—————————————————————————————————————————————————————————————————————————
Class Pattern
- A complied representation of regular expression.
- A regular expression, specified by a string first must be compiled as instance of this class. 
- Typical invocation sequence is thus
    - Pattern p = Pattern.compile(“a*b”);
    - Matcher m = p.matcher(“aaaaab);
    - boolean b = m.matches();
    - boolean b = Pattern.matches(“a*b”,”aaaab”);

Regular Expression Constructs
    * Characters
    * Character Classes
    * Predefined Character class
    * POSIX character classes. 
    * java.lang.Character classes. 
    * Classes for Unicode scripts, block, categories, and binary properties. 
    * Boundary matchers. 
    * Greedy Quantifiers. 
    * Reluctant Quantifiers. 
    * Possessive Quantifiers
    * Logical Operators. 
    * Back References
    * Quotation. 
    * Special Constructs. 


* Matching for the characters
    * x
    * \\
    * \0n
    * \0nn
    * \xhh
    * \uhhhh
    * \x{h..h}
    * \t
    * \n
    * \f
    * \a
    * \e
    * \cx
* Character Classes.
    * [abc]
    * [^abc]
    * [a-zA-Z]
    * [a-d[m-p]]
    * [a-z&&[def]])
    * [a-z&&]^bc]]
    * [a-z&&[^m-p]]
* Predefined Character Classes
    * .
    * \d
    * \D
    * \s
    * \S
    * \w
    * \W
* POSIX character Classes
    * \p{Lower}
    * \p{Upper}
    * \p{AScII}
    * \p{Digit}
    * \Alnum}
    * \p{Punct}
    * \P{Graph}
    * \p{Print}
    * \p{Blank}
* java.lang.Character Classes.
    * \p {javaLowerCase}
    * \p {javaUpperCase}
    * \p {javaWhitespace}
    * \p {javaMirrord}
* Classes for Unicode, script, block, categories, and binary properties. 
    * \p{IsLatin}
    * \p{IsGreek}
    * \p{Lu}
    * \p{Sc}
    * \p{InGreek}
    * [p{J)&&[p{Lu}]]
* Boundary matchers.
    * >
    * $
    * \b
    * \A
    * \G
    * \Z
    * \z
* Greedy Quantifiers 
    * X?
    * X*
    * X+
    * X{n}
    * X{n,}
    * X{n,m}
* Reluctant Quantifiers
    * X??
    * X*?
    * X{n}?
    * X{n,}?
    * X{n,m}?
* Possessive Quantifiers
* Logical Operators. 
* Back References. 
* Quotations. 
* Special Constructs. 
    * (?<name>X)
    * (?:X)
    * (?idmsuxU-idmsuxU)
    * (?idmsu 
    * (?=X)
    * (?<=X)
    * (?<!X)
    * (?>X)
—————- —————- —————- —————- —————- - —————- —————- - —————- —————- 
Class Matcher. 
public class final class Matcher. 
Methods
- appendReplacement
- appentTail
- end()
- end(int group)
- find()
- find (int start)
- group()
- groupCount()
- hasAnchoringBounds()
- hasTransparentBounds()
- hitEnd()
- lookingAt()
- matches()
- pattern()
- quoteReplacement
- reqiresewnd
- region
- regionEnd()
- reset
- start()
- toMatchResult()
- toString()
- useAnchoringBound
- usePattern
- useTransparanetBound


———— 
    * 
* Directories
* Closable and Flushable 
* Stream Classes
* ByteStreams
    * InputStream
    * OutputStream
    * FileinputStream
    * FlileOutputStream
    * ByteArrayinputstream
* CharacterStreams
    * Reader
    * Writer
    * FileReader
    * FileWriter

=========================================================================================== 
