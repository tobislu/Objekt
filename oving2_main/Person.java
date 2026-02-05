package oving2;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Person {
    private String ePost;
    private Date birth;
    private String name;
    private char sex;

    private List<String> countryList = Arrays.asList("ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as",
            "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo",
            "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm",
            "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg",
            "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi",
            "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id",
            "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km",
            "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma",
            "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv",
            "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa",
            "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru",
            "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st",
            "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv",
            "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye",
            "yt", "za", "zm", "zw");

    
    public void setName(String name){
        if ( name == null){
            throw new IllegalArgumentException("FEil navn");
        }
        if (this.ePost != null){
            throw new IllegalStateException("Email allerede satt");
        }
        String[] nameParts = name.split(" ");
        if (nameParts.length != 2){
            throw new IllegalArgumentException("FEil navn");
        }
        String firstN = nameParts[0];
        String lastN = nameParts[1];
        String regex = "[a-zA-Z]{2,}";
        if (!(firstN.matches(regex) && lastN.matches(regex))){
            throw new IllegalArgumentException("Feil navn");
        }
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        if(email == null){
            throw new IllegalArgumentException("Feil navn");
        }
        if (name == null){
            throw new IllegalStateException("Navn må bli satt først");
        }
        String[] emailParts = email.split("@");
        if (emailParts.length != 2){
            throw new IllegalArgumentException("Feil format på email");
        }
        String firstPart = emailParts[0];
        String lastPart = emailParts[1];
        String[] nameParts = firstPart.split("\\.");
        if (nameParts.length != 2){
            throw new IllegalArgumentException("FEil navn");
        }
        String firstN = nameParts[0];
        String lastN = nameParts[1];
        String regex = "[a-zA-Z]{2,}";
        if (!(firstN.matches(regex) && lastN.matches(regex))){
            throw new IllegalArgumentException("Feil navn");
        }
        String[] sjekkNavn = this.name.split(" ");
        if (!(sjekkNavn[0].equalsIgnoreCase(firstN) && sjekkNavn[1].equalsIgnoreCase(lastN))){
            throw new IllegalArgumentException("Feil navn");
        }
        String[] domeneParts = lastPart.split("\\.");
        if (domeneParts.length != 2){
            throw new IllegalArgumentException("FEil navn");
        }
        if (!domeneParts[0].matches("[a-z0-9]{1,63}")) { // Hva skjer her?
            throw new IllegalArgumentException("Feil domene"); 
        }
        if (!(countryList.contains(domeneParts[1]))){
            throw new IllegalArgumentException("Feil land");
        }


        this.ePost = email;
    }
    
    public String getEmail(){
        return this.ePost;
    }

    public void setBirthday(Date birthDate){
        if (birthDate == null){
            throw new IllegalArgumentException("Feil dato");
        }
        if (!birthDate.before(new Date())){
            throw new IllegalArgumentException("Feil dato");
        }
        this.birth = birthDate; 
    }

    public Date getBirthday(){
        return this.birth;
    }

    public void setGender(char gender){
        if (!(gender == 'F' ||gender == 'M' ||gender == '\0')){
            throw new IllegalArgumentException("Feil kjønn");
        }
        this.sex = gender;
    }

    public char getGender(){
        return this.sex;
    }
}

// Navn kan kapsles inn ved å dele det i fornavn og etternavn i stedet for én streng.

// Koblet tilstand (navn og e-post) kan håndteres enten ved å sette og validere begge
// samtidig (atomisk), eller ved å dekoble dem, f.eks. ved å validere e-post uavhengig
// av navn eller ved å generere e-post fra navnet.