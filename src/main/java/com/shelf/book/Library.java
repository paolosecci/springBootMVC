package com.shelf.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    ArrayList<Novel> lib = new ArrayList<Novel>();

    Library(){
        Novel candide = new Novel();
        Novel hamlet = new Novel("Hamlet", "Shakespeare", 5, "What a piece of work is a man! How noble in reason! how infinite in faculty! in form, in moving, how express and admirable! in action how like an angel! in apprehension how like a god! the beauty of the world! the paragon of animals! And yet, to me, what is this quintessence of dust?");
        Novel carried = new Novel("The Things They Carried", "O'Brien", 21, "Together we understood what terror was: you're not human anymore. You're a shadow. You slip out of your own skin, like molting, shedding your own history and your own future, leaving behind everything you ever were or wanted to believed in. You know you're about to die. And it's not a movie and you aren't a hero and all you can do is whimper and wait.");
        Novel antigone = new Novel("Antigone", "Sophocles", 8, "Wonders are many on earth, and the greatest of these is man, who rides the ocean and takes his way through the deeps, through wind – swept valleys of perilous seas that surge and sway.");
        this.lib.add(candide);
        this.lib.add(hamlet);
        this.lib.add(carried);
        this.lib.add(antigone);
    }
    Library(List<Novel> bookList){
        this.lib.addAll(bookList);
    }
    Library(Novel[] bookArr){
        this.lib.addAll(Arrays.asList(bookArr));
    }

    public List<Novel> getLibraryAsList(){
        return this.lib;
    }
}
