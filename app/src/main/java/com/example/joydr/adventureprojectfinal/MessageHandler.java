package com.example.joydr.adventureprojectfinal;

public final class MessageHandler
{
    private static final String UNIQUE_KEY = "$FINALPROJAG$";
    private static final String DELIMITER = ",,,";

    private static final String INVITE = "INVITE";
    private static final String ACCEPT = "ACCEPT";
    private static final String DENY = "DENY";

    private static final String MOVE = "MOVE";

    //Player Attack
    private static final String PLAYERATTACKNAME = "PLAYERATTACKNAME";
    private static final String PLAYERATTACKDAMAGE = "PLAYERATTACKDAMAGE";
    private static final String PLAYERATTACKSPEED = "PLAYERATTACKSPEED";

    //Enemy Attack
    private static final String ENEMYATTACKNAME = "ENEMYATTACKNAME";
    private static final String ENEMYTTACKDAMAGE = "ENEMYATTACKDAMAGE";
    private static final String ENEMYATTSPEED = "ENEMYATTACKSPEED";

    // Attack
    private static final String ATTACKNAME = "ATTACKNAME";
    private static final String ATTACKDAMAGE = "ATTACKDAMAGE";
    private static final String ATTACKSPEED = "ATTACKSPEED";

    //Spell
    private static final String SPELLNAME = "SPELLNAME";
    private static final String SPELLDAMAGE = "SPELLDAMAGE";

    //iTEM
    private static final String ITEMNAME = "ITEMNAME";
    private static final String ITEMVALUE = "ITEMVALUE";

    private static final String GAMEOVER = "GAMEOVER";

    //attack
    public static String isAttack(String attackName, String attackDamage, String attackSpeed)
    {
        return UNIQUE_KEY + DELIMITER + attackName + DELIMITER + attackDamage+  DELIMITER + attackSpeed +  DELIMITER;
    }

    //Spell
    public static String isSpell(String spellName, String spellDamage)
    {
        return UNIQUE_KEY + DELIMITER +  spellName + DELIMITER +  spellDamage ;
    }

    //Spell
    public static String isItem(String itemName, double itemVaule)
    {
        return UNIQUE_KEY + DELIMITER + itemName + DELIMITER + itemVaule ;
    }

    public static String getInviteMessage()
    {
        return UNIQUE_KEY + DELIMITER + INVITE;
    }

    public static String getAcceptMessage()
    {
        return UNIQUE_KEY + DELIMITER + ACCEPT;
    }

    public static String getDenyMessage()
    {
        return UNIQUE_KEY + DELIMITER + DENY;
    }

    public static String getMessageMove(int pos, String symbol)
    {
        return UNIQUE_KEY + DELIMITER + MOVE + DELIMITER+ pos + DELIMITER + symbol;
    }

    public static String getNameMessage()
    {
        //System.err.println("Meow:getNameMessage");

        return UNIQUE_KEY + "NAME" + DELIMITER;
    }

    public static boolean isMessageInvite(String text)
    {
        return getInviteMessage().equals(text);
    }

    public static boolean isMessageAccept(String text)
    {
        return getAcceptMessage().equals(text);
    }

    public static boolean isMessageDeny(String text)
    {
        return getDenyMessage().equals(text);
    }

    public static boolean isMessageMove(String text)
    {
        return text.startsWith(UNIQUE_KEY + DELIMITER + MOVE + DELIMITER);
    }

    public static boolean isNameMessage(String text)
    {
        //String tmp = text.substring(0, 19);
        //System.err.println("Meow:isNameMessage " + tmp);
        return getNameMessage().equals(text.substring(0, 20));
    }

    public static boolean isGameOverMessage(String text)
    {
        return getGameOverMessage().equals(text);
    }

    public static String getSymbol(String text)
    {
        String[] pieces = text.split(DELIMITER);

        return pieces[3];
    }

    public static int getPosition(String text)
    {
        String[] pieces = text.split(DELIMITER);

        return Integer.valueOf(pieces[2]);
    }

    public static String getGameOverMessage()
    {
        return UNIQUE_KEY + DELIMITER + GAMEOVER;
    }

    //get attack name
    public static int getAttackName(String text)
    {
        String[] pieces = text.split(DELIMITER);

        return Integer.valueOf(pieces[1]);
    }

    public static int getAttackDamage(String text)
    {
        String[] pieces = text.split(DELIMITER);

        return Integer.valueOf(pieces[2]);
    }

    public static int getAttackSpeed(String text)
    {
        String[] pieces = text.split(DELIMITER);

        return Integer.valueOf(pieces[3]);
    }

    //get attack name
    public static int getSpellName(String text)
    {
        String[] pieces = text.split(DELIMITER);

        return Integer.valueOf(pieces[1]);
    }

    public static int getSpellkDamage(String text)
    {
        String[] pieces = text.split(DELIMITER);

        return Integer.valueOf(pieces[2]);
    }

    public static int getItemName(String text)
    {
        String[] pieces = text.split(DELIMITER);

        return Integer.valueOf(pieces[1]);
    }

    public static int getItemValue(String text)
    {
        String[] pieces = text.split(DELIMITER);

        return Integer.valueOf(pieces[2]);
    }
}