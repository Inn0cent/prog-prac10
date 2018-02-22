import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class Blues here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blues
{
    
    private static final Random rand = new Random();
    
    private String[] locs = {"the highway", "a jailhouse", "an empty bed", "a bottom of a whiskey glass"};
    private String[] rig = {"I'm older than dirt", "I'm blind", "I shot a man in Memphis", "I can't be satisfied"};
    private String[] dri = {"wine", "whiskey", "bourbon", "muddy water", "black coffee", "gasoline when I asked for water"};
    private String[] tra = {"Chevy", "Cadillac", "Greyhound bus", "feet"};
       
    public static void main(String[] args){
        Blues song = new Blues();
        song.sing(args);
    }
    
    public Blues()
    {
        
    }
    
    public void sing(String[] args){
        int numVerses = 3;
        if(args.length == 0){
            for(int i = 0; i < numVerses; i++){
                printVerse(generateVerse(new String[0]));
            }
        } else if (args[0].equals("prompt")) {
            String[] newArgs = new String[args.length-1];
            System.arraycopy(args, 1, newArgs,0,args.length-1);
            printVerse(generateVerse(newArgs));
            for(int i = 0; i < numVerses-1; i++){
                printVerse(generateVerse(new String[0]));
            }
        } else {
            if(checkIfBlues(args)){
                ArrayList<String> userLines = new ArrayList<String>();
                String st = "";
                for(String s : args){
                    if(s.equals("/n")){
                        userLines.add(st);
                        st = "";
                    } else {
                        st += s + " ";
                    }
                }
                userLines.add(st);
                printUserVerse(userLines, generateVerse(new String[0]));
                for(int i = 0; i < numVerses-1; i++){
                    printVerse(generateVerse(new String[0]));
                }
            }else{
                System.out.println("It's not the blues");
            }
        }
    }

    private boolean checkIfBlues(String[] args){
        boolean blues = false;
        for(String s : args){
            for(String l : locs){
                if(s.equals(l)){
                    blues = true;
                }
            }
            for(String r : rig){
                if(s.equals(r)){
                    blues = true;
                }
            }
            for(String d : dri){
                if(s.equals(d)){
                    blues = true;
                }
            }
            for(String t : tra){
                if(s.equals(t)){
                    blues = true;
                }
            }
        }
        return blues;
    }
    
    private void printVerse(String[] st){
        System.out.println(st[0]);
        System.out.println(st[1]);
        System.out.println(st[0]);
        System.out.println(st[1]);
        System.out.println(st[2]);
        System.out.println(st[3]);
        System.out.println("");
    }
    
    private void printUserVerse(ArrayList<String> user, String[] st){
        for(String s : user){
            System.out.println(s);
        }
        for(int i = 0; i < st.length - user.size() + 2; i++){
            System.out.println(st[i % st.length]);
        }
        System.out.println("");
    }
    
    private String[] generateVerse(String[] args){
        String[] verse = {"", "", "", ""};
        if(args.length == 0){
            verse = verseNoArgs(verse);
        }else{
            verse = verseNoArgs(verse);
            verse = verseArgs(args, verse);
        }
        return verse;
    }
    
    private String[] verseArgs(String[] args, String[] verse){
        for(int i = 0; i < Math.min(verse.length,args.length); i += 2){
            switch (args[i]){
                case "place": verse[i] = place(args[i+1]); break;
                case "right": verse[i] = right(args[i+1]); break;
                case "drink": verse[i] = drink(args[i+1]); break;
                case "transport": verse[i] = transport(args[i+1]); break;
                case "person": verse[i] = person(args[i+1]); break;
                default: verse[i] = "Got a good woman - with the meanest face in town";
            }
        }
        return verse;
    }
    
    private String[] verseNoArgs(String[] verse){
        for(int i = 0; i < verse.length; i++){
            switch (rand.nextInt(6)){
                case 0: verse[i] = place(null); break;
                case 1: verse[i] = right(null); break;
                case 2: verse[i] = drink(null); break;
                case 3: verse[i] = transport(null); break;
                case 4: verse[i] = person(null); break;
                default: verse[i] = "Got a good woman - with the meanest face in town";
            }
        }
        return verse;
    }
    
    private String place(String phrase){
        if (phrase == null){
            return "I'm singing this song from " + locs[rand.nextInt(locs.length)];
        }else{
            return "I'm singing this song from " + phrase;
        }
        
    }
    
    private String right(String phrase){
        if (phrase == null){
            return rig[rand.nextInt(rig.length)];
        }else{
            return phrase;
        }
        
    }
    
    private String drink(String phrase){
        if (phrase == null){
            return "I'm sitting here drinking " + dri[rand.nextInt(dri.length)];
        }else{
            return "I'm sitting here drinking " + phrase;
        }
        
    }
    
    private String transport(String phrase){
        if (phrase == null){
            return "Getting there with my " + tra[rand.nextInt(tra.length)];
        }else{
            return "Getting there with my " + phrase;
        }
        
    }
    
    private String person(String phrase){
        if (phrase == null){
            return "Here with " + generateName();
        }else{
            return "Here with " + phrase;
        }
        
    }
    
    public String generateName(){
        String[] infirmity = {"Blind", "Cripple", "Lame"};
        String[] fName = {"Joe", "Willie", "Little Willie", "Big Willie", "Lemon", "Lime", "Sadie", "Big Mama", "Bessie", "Fat River Dumpling"};
        String[] sName = {"Jefferson", "Johnson", "Fillmore"};
        return infirmity[rand.nextInt(infirmity.length)] + " " + fName[rand.nextInt(fName.length)] + " " + sName[rand.nextInt(sName.length)];
    }
}
