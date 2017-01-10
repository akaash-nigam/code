
Special Topics 1: RegEx
1. Matching Specific String
2. Matching Anything but NewLine.
3. Matching Digits and Non-Digits Characters
4. Matching WhiteSpace and NonWhiteSpace Characters
5. Matching Word and Character. 
6. Matching Start and End. 

Characters
1. Specific Characters
2. Excluding Specific Characters
3. Matching Character Ranges

Repetitions
Grouping and Capturing. 
BackReferences
Assertions
Applications. 
- Detect HTML links. 
- Detect HTML tags. 
- Find a substring. 
- Alien UserName. 
- IP Address Validation.
- Find a word
- Detect a Email address. 
- Detect a domain name.
- Build a smart IDE.
- Detect Valid Latitude and longitude paris. 



/********************************************************/

// Matching String Specifics. 
public class Solution {    
    public static void main(String[] args) {   
        Regex_Test tester = new Regex_Test();
        tester.checker(Regex_Pattern = "hackerrank"); 
    }
}
class Regex_Test {
    public void checker(String Regex_Pattern){
        Scanner Input = new Scanner(System.in);
        String Test_String = Input.nextLine();
        Pattern p = Pattern.compile(Regex_Pattern);
        Matcher m = p.matcher(Test_String);
        int Count = 0;
        while(m.find()){
            Count += 1;
        }
        System.out.format("Number of matches : %d",Count);
    }   
    
}

// Matching Anything but New Line. 
// Matching Digits and Non Digits Character
// Matching Whitespace and Non whitespace characters.
// Matching Word and Non Word characters. 
// Matching Start and End. 
/********************************************************/

// Matching Specific Characters
Regex_Pattern = '^[123][120][xs0][30Aa][xsu][.,]$'

// Excluding Specific Characters. 
Regex_Pattern = '^[^\d][^aeiou][^bcDF]\S[^AEIOU][^.,]$'

// Matching Digits and Non Digit Characters. 
// Matching Character Ranges. 

We write the following RegEx pattern: ^[a-z][1-9][^a-z][^A-Z][A-Z]. 
Now lets walk through each sequential component of our RegEx:
^[a-z]: This matches the first character of the string to any character in the inclusive range between lowercase  and lowercase .
[1-9]: This matches the second character of the string to any character in the inclusive range between  and . Recall that we do not consider  to be a positive integer.
[^a-z]: This matches the third character of the string to any character that is not in the inclusive range between lowercase  and lowercase .
[^A-Z]: This matches the fourth character of the string to any character that is not in the inclusive range between uppercase  and uppercase .
[A-Z]: This matches the fifth character of the string against any character in the inclusive range between uppercase  and uppercase .""

/********************************************************/
// Matching {X Repetitions}
w{3} : It will match the character w exactly  times. 
[xyz]{5} : It will match the string of length  consisting of characters {x, y, z}. For example it will match xxxxx, xxxyy and xyxyz. 
\d{4} : It will match any digit exactly  times.

// Matching {X,Y Repetitions}
w{3,5} : It will match the character w ,  or  times. 
[xyz]{5,} : It will match the character x, y or z  or more times. 
\d{1, 4} : It will match any digits , , , or  times.

// Matching zero or non zero repetitions. 
w* : It will match the character w  or more times. 
[xyz]* : It will match the characters x, y or z  or more times. 
\d* : It will match any digit  or more times.

// Alternate Matching.

The $ boundary matcher matches an occurrence of a character/character class/group at the end of a line.
/********************************************************/
// Matching Same Text Again and Again
// BackReferences to the Fail Group
// Branch Reset Group
// Forward References. 
/********************************************************/
//Positive Lookaheads.
//Negative Lookaheads.
//Positive Lookbehinds.
//Negative Lookbehinds.
/********************************************************/
//Detect HTML Links
//Detect HTML Tags
// Find a sub word
// Alien Username
// IP Address Validation. 
// find a word
// Detect email address. 
// Detect Domain name.
// Detect Valid Latitute/Longitude pairs. 
// Hackerrank Tweets
// Stack Exchange Scraper. 
// Detecting HTML Attributes.
// Split the Phone no. 
// The British and American Style of spelling. 

Characters
x           The character x
\\          The backslash character
\0n         The character with octal value 0n (0 <= n <= 7)
\0nn        The character with octal value 0nn (0 <= n <= 7)
\0mnn       The character with octal value 0mnn (0 <= m <= 3, 0 <= n <= 7)
\xhh        The character with hexadecimal value 0xhh
\uhhhh      The character with hexadecimal value 0xhhhh
\x{h...h}   The character with hexadecimal value 0xh...h (Character.MIN_CODE_POINT  <= 0xh...h <=  Character.MAX_CODE_POINT)
\t          The tab character ('\u0009')
\n          The newline (line feed) character ('\u000A')
\r          The carriage-return character ('\u000D')
\f          The form-feed character ('\u000C')
\a          The alert (bell) character ('\u0007')
\e          The escape character ('\u001B')
\cx         The control character corresponding to x

Character classes
[abc]           a, b, or c (simple class)
[^abc]          Any character except a, b, or c (negation)
[a-zA-Z]        a through z or A through Z, inclusive (range)
[a-d[m-p]]      a through d, or m through p: [a-dm-p] (union)
[a-z&&[def]]    d, e, or f (intersection)
[a-z&&[^bc]]    a through z, except for b and c: [ad-z] (subtraction)
[a-z&&[^m-p]]   a through z, and not m through p: [a-lq-z](subtraction)

PredefinedCharacterClassses Any character (may or may not match line terminators)
\d  A digit: [0-9]
\D  A non-digit: [^0-9]
\s  A whitespace character: [ \t\n\x0B\f\r]
\S  A non-whitespace character: [^\s]
\w  A word character: [a-zA-Z_0-9]
\W  A non-word character: [^\w]




