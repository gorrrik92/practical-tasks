package com.walking.lesson17_enum.task1;

public enum Phrase {
    HI("Hi","Hello"), BYE("Bye","Good bye"), HOW_ARE_YOU("How are you","How are your doing");
    String name;
    String fullPhrase;

    Phrase(String name, String fullPhrase) {
        this.name = name;
        this.fullPhrase = fullPhrase;
    }

    public String getName(){
        return name;
    }
    public String geFulltPhrase(){
        return fullPhrase;
    }

}
