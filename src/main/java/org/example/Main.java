package org.example;

import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        final UsersRepository repository = new UsersRepository();

        banner("Listing all users");
        repository.select(null, null);

        banner("Listing users with age > 5 sorted by name");
        // TODO once using anonymous objects
        banner("using anonymous objects");
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age > 5;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        banner("Using lambda expressions");
        //Using lambda expressions
        repository.select(user -> user.age > 5 , Comparator.comparing(user -> user.name));
        ////////////////////////////////////////////////////////////////////////////////////////////
        banner("Listing users with age < 10 sorted by age");
        // TODO once using anonymous objects
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age < 10;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });
        //   once using lambda expressions
        repository.select(user -> user.age <10,Comparator.comparing(user -> user.age));

        //////////////////////////////////////////////////////////////////////////////////////////////

        banner("Listing active users sorted by name");
        // TODO once using anonymous objects
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.active;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        //  and once using lambda expressions
        repository.select(user -> user.active,Comparator.comparing(user -> user.name));

        //////////////////////////////////////////////////////////////////////////////////////////////////
        banner("Listing active users with age > 8 sorted by name");
        // TODO once using anonymous objects
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age > 8 && user.active;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        //  and once using lambda expressions

        repository.select(user -> user.age>8 &&user.active,Comparator.comparing(user -> user.name));
    }
    private static void banner(final String m) {
        System.out.println("#### " + m + " ####");
    }
}