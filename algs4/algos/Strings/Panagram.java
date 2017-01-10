char[] cline = line.toCharArray();
Bitsets cbits = new Bitset(26);
for (char ch: cline){
    if character.isLetter(ch){
        if character.isUpperCase(ch)
            ch = Character.toLowerCase(ch);
        cbigs.set(ch-'a');
        if cbits.ordinality()==26
        {
            system.out.println("PANAGRAM");
        }
        else{
            System.out.println();
        }
    }
}
