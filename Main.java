import java.util.ArrayList;
import java.util.List;

class Game {
    private List<User> users;
    private List<Badge> badges;
    private List<Token> tokens;
    private List<Quest> quests;

    public Game() {
        this.users = new ArrayList<>();
        this.badges = new ArrayList<>();
        this.tokens = new ArrayList<>();
        this.quests = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addBadge(Badge badge) {
        this.badges.add(badge);
    }

    public void addTokens(Token token) {
        this.tokens.add(token);
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public List<User> getUsers() {
        return this.users;
    }

    public List<Quest> getQuests() {
        return this.quests;
    }


    public void completeQuest(User user, Quest quest) {
        user.addTokens(quest.getTokens());
        user.addBadge(quest.getBadge());
    }
}

class User {
    private String name;
    private int tokens;
    private List<Badge> badges;

    public User(String name) {
        this.name = name;
        this.tokens = 0;
        this.badges = new ArrayList<>();
    }
    public String getName() {
        return this.name;
    }

    public void addTokens(int tokens) {
        this.tokens += tokens;
    }

    public void addBadge(Badge badge) {
        this.badges.add(badge);
    }

    public int getTokens() {
        return this.tokens;
    }

    public List<Badge> getBadges() {
        return this.badges;
    }
}

class Badge {
    private String name;

    public Badge(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}

class Token {
    private int value;

    public Token(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

class Quest {
    private String name;
    private int tokens;
    private Badge badge;

    public Quest(String name, int tokens, Badge badge) {
        this.name = name;
        this.tokens = tokens;
        this.badge = badge;
    }

    public int getTokens() {
        return this.tokens;
    }

    public Badge getBadge() {
        return this.badge;
    }

    public String getName() {
        return this.name;
    }
}


public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        User user1 = new User("John");
        User user2 = new User("Jane");

        Badge badge1 = new Badge("Beginner");
        Badge badge2 = new Badge("Intermediate");
        Badge badge3 = new Badge("Expert");

        Token token1 = new Token(10);
        Token token2 = new Token(20);
        Token token3 = new Token(30);

        Quest quest1 = new Quest("Primul quest", 10, badge1);
        Quest quest2 = new Quest("Al doilea quest", 20, badge2);
        Quest quest3 = new Quest("Al treilea quest", 30, badge3);

        game.addUser(user1);
        game.addUser(user2);

        game.addBadge(badge1);
        game.addBadge(badge2);
        game.addBadge(badge3);

        game.addTokens(token1);
        game.addTokens(token2);
        game.addTokens(token3);

        game.addQuest(quest1);
        game.addQuest(quest2);
        game.addQuest(quest3);

        user1.addTokens(token1.getValue());
        user1.addBadge(badge1);

        game.completeQuest(user1, quest1);
        game.completeQuest(user1, quest2);

        user2.addTokens(token2.getValue());
        user2.addBadge(badge2);

        game.completeQuest(user2, quest2);
        game.completeQuest(user2, quest3);

        // afișează informații despre utilizatori și quest-uri
        System.out.println("Utilizatori:");
        for (User user : game.getUsers()) {
            System.out.println(user.getName() + " - tokens: " + user.getTokens() + ", badges: " + user.getBadges());
        }

        System.out.println("Quest-uri:");
        for (Quest quest : game.getQuests()) {
            System.out.println(quest.getName() + " - tokens: " + quest.getTokens() + ", badge: " + quest.getBadge().getName());
        }
    }
}


