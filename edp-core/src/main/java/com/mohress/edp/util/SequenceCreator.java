package com.mohress.edp.util;


import java.util.Date;

/**
 * Created by youtao.wan on 2017/6/5.
 */
public class SequenceCreator {
    private static Sequencer sequencer = new Sequencer();

    private static String getSequenceId(SequenceType sequenceType){
        return sequenceType.name() + DateUtil.toString(new Date(), "yyMMddHHmmss") + sequencer.getSequence();
    }

    public static String getUserId(){
        return getSequenceId(SequenceType.USER);
    }

    public static String getRoleId(){
        return getSequenceId(SequenceType.ROLE);
    }

    public static String getAuthorityId(){
        return getSequenceId(SequenceType.AUTHORITY);
    }

    public static String getResourceId(){
        return getSequenceId(SequenceType.RESOURCE);
    }

    static class Sequencer{
        private int sequence;

        Sequencer() {
            this.sequence = (int) (System.currentTimeMillis() % (1000 * 60));
        }

        synchronized String getSequence(){
            sequence++;
            if(sequence > 999999){
                sequence = sequence - 1000000;
            }
            return LocalMachine.getLocalMachine() + String.format("%06d", sequence);
        }
    }

    enum SequenceType{
        USER,
        ROLE,
        AUTHORITY,
        RESOURCE,
    }
}
