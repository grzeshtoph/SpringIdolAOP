package com.springinaction.springidol.performers;

/**
 * Additional interface with option to receive an award.
 */
public interface Contestant {
    String AWARD_FOR_JUGGLER = "Juggler's tomboy!";
    String AWARD_FOR_FAULTY_JUGGLER = "No award!";

    void receiveAward();
}
